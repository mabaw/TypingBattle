package jp.co.fitec.traning.project.typing.dao.hibernate;

import jp.co.fitec.traning.project.typing.dao.DAOFactory;
import jp.co.fitec.traning.project.typing.dao.LocationDao;
import jp.co.fitec.traning.project.typing.dao.QuestionDao;
import jp.co.fitec.traning.project.typing.dao.ResultDao;
import jp.co.fitec.traning.project.typing.dao.UserAccountDao;

public class HibernateDaoFactory extends DAOFactory {

	@Override
	public QuestionDao getQuestionDao() {
		
		return new HibernateQuestionDao();
	}

	@Override
	public ResultDao getResultDao() {
		
		return new HibernateResultDao();
	}

	@Override
	public UserAccountDao getUserAccountDao() {

		return new HibernateUserAccountDao();
	}
	
	@Override
	public LocationDao getLocationDao(){
		
		return new HibernateLocationDao();
	}

}
