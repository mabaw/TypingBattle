package jp.co.fitec.traning.project.typing.dao;

import java.util.List;

import jp.co.fitec.traning.project.typing.entity.Result;
import jp.co.fitec.traning.project.typing.entity.UserAccount;
import jp.co.fitec.traning.project.typing.gamedata.GameSetting;
import jp.co.fitec.traning.project.typing.gamedata.Mode;

public interface ResultDao {

	public List<Result> getOneWeekResult(UserAccount user) throws DAOException;
	public Result getLatestResult(UserAccount user) throws DAOException;
	public List<Result> getWorldWideRanking(GameSetting gameSetting,int size) throws DAOException;
	public List<Result> getFriendRanking(GameSetting gameSetting,int size) throws DAOException;
	
	public boolean saveGameResult(UserAccount player,int score,
			int correct,int incorrect,GameSetting setting)
			throws DAOException;
	
	public int getTopScore(UserAccount player,Mode mode)throws DAOException;
}
