package jp.co.fitec.traning.project.typing.dao;

import jp.co.fitec.traning.project.typing.entity.UserAccount;

public interface UserAccountDao {

	public boolean register(UserAccount userAccount)  throws DAOException;
	public UserAccount login(String name,String password)  throws DAOException;
	public boolean deleteAccount(UserAccount userAccount)  throws DAOException;
	public UserAccount getUserAccount(String name)  throws DAOException;
	
}
