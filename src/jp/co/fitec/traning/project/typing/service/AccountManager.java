package jp.co.fitec.traning.project.typing.service;

import jp.co.fitec.traning.project.typing.dao.DAOException;
import jp.co.fitec.traning.project.typing.dao.DAOFactory;
import jp.co.fitec.traning.project.typing.dao.UserAccountDao;
import jp.co.fitec.traning.project.typing.entity.UserAccount;

public class AccountManager {
	private static UserAccountDao userAccountDao;
	static {
		DAOFactory factory;
		try {
			factory = DAOFactory.getInstance();
			userAccountDao = factory.getUserAccountDao();
		} catch (DAOException e) {		
			e.printStackTrace();			
		}		
	}
	
	
	public static boolean register(UserAccount userAccount)  throws GameServiceException	{
		try {
			return userAccountDao.register(userAccount);
		} catch (DAOException e) {
			e.printStackTrace();
			throw new GameServiceException();
		}		
	}
	
	public static UserAccount login(String name,String password)  throws GameServiceException{
		try {
			return userAccountDao.login(name, password);
		} catch (DAOException e) {
			e.printStackTrace();
			throw new GameServiceException();
		}		
		
	}
		
	public static boolean deleteAccount(UserAccount userAccount)  throws GameServiceException	{
		try {
			return userAccountDao.deleteAccount(userAccount);
		} catch (DAOException e) {
			e.printStackTrace();
			throw new GameServiceException();
		}		
		
	}
	
	public static UserAccount getUserAccount(String name)  throws GameServiceException{
		try {
			return userAccountDao.getUserAccount(name);
		} catch (DAOException e) {
			e.printStackTrace();
			throw new GameServiceException();
		}	
	}
}
