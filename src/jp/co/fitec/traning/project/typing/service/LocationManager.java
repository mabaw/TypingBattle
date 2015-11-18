/**
 * 
 */
package jp.co.fitec.traning.project.typing.service;

import java.util.List;
import java.util.Set;

import jp.co.fitec.traning.project.typing.dao.DAOException;
import jp.co.fitec.traning.project.typing.dao.DAOFactory;
import jp.co.fitec.traning.project.typing.dao.LocationDao;
import jp.co.fitec.traning.project.typing.dao.QuestionDao;
import jp.co.fitec.traning.project.typing.entity.Location;
import jp.co.fitec.traning.project.typing.gamedata.Level;

/**
 * @author R.Miyachi
 *
 */
public class LocationManager {

	private static LocationDao locationDao;
	static {
		DAOFactory factory;
		try {
			factory = DAOFactory.getInstance();
			locationDao = factory.getLocationDao();
		} catch (DAOException e) {		
			e.printStackTrace();			
		}		
	}
	
	public static List<Location> getAll() throws GameServiceException{
		
		try {
			return locationDao.getAll();
		} catch (DAOException e) {
			throw new GameServiceException();
		}
	}
	
	public static Location findByCode(String code) throws GameServiceException{
		try {
			return locationDao.findByCode(code);
		} catch (DAOException e) {
			throw new GameServiceException();
		}
	}
	
}
