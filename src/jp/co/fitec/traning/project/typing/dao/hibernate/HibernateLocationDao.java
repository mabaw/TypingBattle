/**
 * 
 */
package jp.co.fitec.traning.project.typing.dao.hibernate;

import java.util.List;

import jp.co.fitec.traning.project.typing.dao.DAOException;
import jp.co.fitec.traning.project.typing.dao.LocationDao;
import jp.co.fitec.traning.project.typing.entity.Location;

import org.hibernate.Session;
import org.hibernate.criterion.Order;

/**
 * @author R.Miyachi
 *
 */
public class HibernateLocationDao implements LocationDao {

	/* (non-Javadoc)
	 * @see jp.co.fitec.traning.project.typing.dao.LocationDao#getAll()
	 */
	@Override
	public List<Location> getAll() throws DAOException {

			
		Session session = HibernateUtils.getSession();
		List<Location> locationList = session.createCriteria(Location.class)
			.addOrder(Order.asc("code"))
			.list();
		closeSession(session);
		
		return locationList;
		
		
	}

	@Override
	public Location findByCode(String code) throws DAOException {
		Session session = HibernateUtils.getSession();
		Location location = (Location)session.get(Location.class, code);
		closeSession(session);
		
		return location;
	}
	
	/* (non-Javadoc)
	 * @see jp.co.fitec.traning.project.typing.dao.LocationDao#insert(jp.co.fitec.traning.project.typing.entity.Location)
	 */
	@Override
	public void insert(Location location) throws DAOException {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see jp.co.fitec.traning.project.typing.dao.LocationDao#update(jp.co.fitec.traning.project.typing.entity.Location)
	 */
	@Override
	public void update(Location location) throws DAOException {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see jp.co.fitec.traning.project.typing.dao.LocationDao#delete(jp.co.fitec.traning.project.typing.entity.Location)
	 */
	@Override
	public void delete(Location location) throws DAOException {
		// TODO Auto-generated method stub

	}

	private void closeSession(Session session) {
		if(session != null && session.isConnected()) {
			session.close();
		}
	}
	
}
