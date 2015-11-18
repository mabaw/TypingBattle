package jp.co.fitec.traning.project.typing.dao;

import jp.co.fitec.traning.project.typing.dao.hibernate.HibernateDaoFactory;


public abstract class DAOFactory {
	public static DAOFactory getInstance() throws DAOException{
		return new HibernateDaoFactory();
	}
	
	public abstract QuestionDao getQuestionDao()  throws DAOException;	
	public abstract ResultDao getResultDao()  throws DAOException;	
	public abstract UserAccountDao getUserAccountDao()  throws DAOException;
	public abstract LocationDao getLocationDao() throws DAOException;
	 
}
