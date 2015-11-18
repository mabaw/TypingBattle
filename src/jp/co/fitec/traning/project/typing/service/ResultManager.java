package jp.co.fitec.traning.project.typing.service;

import java.util.List;

import jp.co.fitec.traning.project.typing.dao.DAOException;
import jp.co.fitec.traning.project.typing.dao.DAOFactory;
import jp.co.fitec.traning.project.typing.dao.ResultDao;
import jp.co.fitec.traning.project.typing.entity.Result;
import jp.co.fitec.traning.project.typing.entity.UserAccount;
import jp.co.fitec.traning.project.typing.gamedata.GameSetting;

public class ResultManager {
	
	private static ResultDao resultDao;
	static {
		DAOFactory factory;
		try {
			factory = DAOFactory.getInstance();
			resultDao = factory.getResultDao();
		} catch (DAOException e) {		
			e.printStackTrace();			
		}		
	}
	
	public static List<Result> getOneWeekResult(UserAccount user) throws GameServiceException{
		try {
			return resultDao.getOneWeekResult(user);
		} catch (DAOException e) {			
			e.printStackTrace();
			throw new GameServiceException();
		}
	}
	
	public static Result getLatestResult(UserAccount user) throws GameServiceException{
		try {
			return resultDao.getLatestResult(user);
		} catch (DAOException e) {			
			e.printStackTrace();
			throw new GameServiceException();
		}
	}
	
	public static List<Result> getWorldWideRanking(GameSetting gameSetting,int size) throws GameServiceException{
		try {
			return resultDao.getWorldWideRanking(gameSetting, size);
		} catch (DAOException e) {			
			e.printStackTrace();
			throw new GameServiceException();
		}
	}
	
	public static List<Result> getFriendRanking(GameSetting gameSetting,int size) throws GameServiceException{
		try {
			return resultDao.getFriendRanking(gameSetting, size);
		} catch (DAOException e) {			
			e.printStackTrace();
			throw new GameServiceException();
		}
	}
	
	public static boolean saveGameResult(UserAccount player,int score,
			int correct,int incorrect,GameSetting setting) 
					throws GameServiceException
	{
		try {
			resultDao.saveGameResult(player, score, correct, incorrect, setting);
		} catch (DAOException e) {

			e.printStackTrace();
			throw new GameServiceException();
		}
		return false;
	}
}
