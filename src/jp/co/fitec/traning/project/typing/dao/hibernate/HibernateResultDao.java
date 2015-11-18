package jp.co.fitec.traning.project.typing.dao.hibernate;

import java.util.ArrayList;
import java.util.List;
import java.util.Calendar;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.TransactionException;


import jp.co.fitec.training.project.typing.util.GameUtils;
import jp.co.fitec.traning.project.typing.dao.DAOException;
import jp.co.fitec.traning.project.typing.dao.ResultDao;
import jp.co.fitec.traning.project.typing.entity.Location;
import jp.co.fitec.traning.project.typing.entity.Result;
import jp.co.fitec.traning.project.typing.entity.UserAccount;
import jp.co.fitec.traning.project.typing.entity.hibernate.HibernateResult;
import jp.co.fitec.traning.project.typing.gamedata.GameSetting;
import jp.co.fitec.traning.project.typing.gamedata.Level;
import jp.co.fitec.traning.project.typing.gamedata.Mode;

public class HibernateResultDao implements ResultDao {


	@Override
	public int getTopScore(UserAccount player, Mode mode) throws DAOException {
		Session session = HibernateUtils.getSession();
		int modeInt = GameUtils.modeToInt(mode);
		List<Result> resultList = session.getNamedQuery("getUserTopScoreFromMode")					// マッピング・ファイル(book.hbm.xml)に記述したHQLを使用する場合
				.setParameter("name",  player.getName() )
				.setParameter("mode",  modeInt)
				.setMaxResults(1)
				.list();	
			
		return 0;
	}
	
	@Override
	public List<Result> getOneWeekResult(UserAccount user) throws DAOException {
		Session session = HibernateUtils.getSession();
		List<HibernateResult> hresultList = session.getNamedQuery("loadOneWeekResult")	
			   	.setParameter("name",  user.getName() )
				.list();	
		List<Result> resultList = new ArrayList<>();
		for (HibernateResult hresult : hresultList) {
			Mode m = GameUtils.IntToMode(hresult.getMode());
			Level l = GameUtils.IntToLevel(hresult.getLevel());
			Result r = new Result(hresult.getPlayDate(), hresult.getPlayer(), 
					hresult.getScore(), hresult.getCorrectType(), 
					hresult.getIncorrectType(), new GameSetting(m,l));
			resultList.add(r);
		}
		
		return resultList;
	}
	@Override
	public Result getLatestResult(UserAccount user) throws DAOException {
		// TODO Auto-generated method stub
		GameSetting gm = new GameSetting();
		gm.setLevel(Level.EASY);
		gm.setMode(Mode.TIME_LIMIT_MODE);
		Result r = new Result(Calendar.getInstance().getTime(),user,10,25,2,gm);
		return r;
	}

	@Override
	public List<Result> getWorldWideRanking(GameSetting gameSetting, int size){
		Session session = HibernateUtils.getSession();
		List<Result> resultList = session.getNamedQuery("loadWorldWideRanking")					// マッピング・ファイル(book.hbm.xml)に記述したHQLを使用する場合		    	
				.setParameter("mode",  GameUtils.modeToInt(gameSetting.getMode()) )
				.setParameter("level", GameUtils.levelToInt(gameSetting.getLevel()) )
				.setMaxResults(size)
				.list();	
			return resultList;
	}

	@Override
	public List<Result> getFriendRanking(GameSetting gameSetting, int size){
	// TODO Auto-generated method stub
		UserAccount user = new UserAccount("mockuser","mockphoto",new Location(),"1234");
			GameSetting gm = new GameSetting();
			gm.setLevel(Level.EASY);
			gm.setMode(Mode.TIME_LIMIT_MODE);
			Result r = new Result(Calendar.getInstance().getTime(),user,10,25,2,gm);
			List<Result> list = new ArrayList<>();
			list.add(r);
			list.add(r);
			list.add(r);
			return list;
	}
	/**
	 *  mode : 1 = time limit 2 = life 3 = battle
	 *  level : 1 = easy 2 = normal 3 = difficult
	 */
	@Override
	public boolean saveGameResult(UserAccount player, int score, int correct,
			int incorrect, GameSetting setting) throws DAOException {
		
	
		HibernateResult result = new HibernateResult(player,
				Calendar.getInstance().getTime(),
				score,
				correct,
				incorrect,
				GameUtils.modeToInt(setting.getMode()),
				GameUtils.levelToInt(setting.getLevel()));
		
		Session session = null;
		Transaction tx = null;
		
		session = HibernateUtils.getCurrentSession();
		tx = session.beginTransaction();		
		try {		
			session.save(result);				
			tx.commit();
			
		} catch(HibernateException e) {
			tx.rollback();
			throw new DAOException(e);
		} 
		
		return true;
	}


	private void closeSession(Session session) {
		if(session != null && session.isConnected()) {
			session.close();
		}
	}
	

}
