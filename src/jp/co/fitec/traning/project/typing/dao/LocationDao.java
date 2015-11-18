/**
 * 
 */
package jp.co.fitec.traning.project.typing.dao;

import java.util.List;

import jp.co.fitec.traning.project.typing.entity.Location;


/**
 * @author R.Miyachi
 *
 */
public interface LocationDao {

	public List<Location> getAll() throws DAOException;
	public Location findByCode(String code) throws DAOException;
	public void insert(Location location) throws DAOException;
	public void update(Location location) throws DAOException;
	public void delete(Location location) throws DAOException;
}
