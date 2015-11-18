package jp.co.fitec.traning.project.typing.dao.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class HibernateUtils {

	private static SessionFactory sessionFactory;
	private static Session session;
	
	static {
		Configuration configuration = new Configuration().configure();
		ServiceRegistryBuilder srb = new ServiceRegistryBuilder();
	    ServiceRegistry sr = srb.applySettings(configuration.getProperties()).buildServiceRegistry();        
	    sessionFactory = configuration.buildSessionFactory(sr);
	    session = sessionFactory.openSession();
	}
	
	public static Session getSession() {
		
		if(!session.isOpen()) {
			session = sessionFactory.openSession();
		}
	
		return session;
	}
	
	public static Session getCurrentSession() {
		session = sessionFactory.getCurrentSession();
		return session;
	}
	
	
}
