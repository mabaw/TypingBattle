package jp.co.fitec.traning.project.typing.dao.hibernate;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import jp.co.fitec.traning.project.typing.dao.DAOException;
import jp.co.fitec.traning.project.typing.dao.UserAccountDao;
import jp.co.fitec.traning.project.typing.entity.UserAccount;

public class HibernateUserAccountDao implements UserAccountDao {

	// 更新処理の種類を表す列挙型
	private enum UpdateType {REGISTER, DELETE};
	
	
	@Override
	public boolean register(UserAccount userAccount) throws DAOException {
		update(userAccount, UpdateType.REGISTER);
		return true;
	}

	@Override
	public UserAccount login(String name, String password) throws DAOException {

		UserAccount userAccount = getUserAccount(name);
		if(userAccount != null){
			String correctPass = userAccount.getPassword();
			if(password.equals(correctPass)){
				return  userAccount;		
			} else {
				return null;
			}
		} 
		return userAccount;
	}


	@Override
	public UserAccount getUserAccount(String name) throws DAOException {
		
			Session session = HibernateUtils.getSession();
			UserAccount userAccount = (UserAccount)session.get(UserAccount.class , name);
			
			closeSession(session);
			return userAccount;	
	}

	@Override
	public boolean deleteAccount(UserAccount userAccount) throws DAOException {
		update(userAccount, UpdateType.DELETE);
		return true;
	}

	private void update(UserAccount userAccount, UpdateType updateType) throws DAOException {
		
		Session session = HibernateUtils.getSession();
		Transaction tx = session.beginTransaction();
						
		try {
			
			switch(updateType) {
			
				case REGISTER :
					session.save(userAccount);
					break;
					
				case DELETE :
					session.delete(userAccount);
					break;
			}
			
			tx.commit();
			
		} catch(HibernateException e) {
			tx.rollback();
			throw new DAOException(e);
		} finally {	
			closeSession(session);
		}
	}
	
	private void closeSession(Session session) {
		if(session != null && session.isConnected()) {
			session.close();
		}
	}

}
