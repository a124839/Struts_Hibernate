package db;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HSessionFactory {
	
	private static SessionFactory sessionFactory;
	//构造方法私有话，保证单例模式?
	private HSessionFactory(){
		
	}
	
	public static SessionFactory getSessionFactory() {
//		if (sessionFactory==null) {
//			Configuration configuration = new Configuration().configure();
//			ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
//					.applySettings(configuration.getImports()).build();
//			sessionFactory  = configuration.buildSessionFactory(serviceRegistry);
//			return sessionFactory;
//		}else {
//			return sessionFactory;
//		}
		
		try {
			Configuration configuration = new Configuration().configure();
			ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
					.applySettings(configuration.getProperties()).build();
			sessionFactory  = configuration.buildSessionFactory(serviceRegistry);
			return sessionFactory;
		} catch (Exception e) {
			System.err.println("Initial SessionFactory creation failed." + e);
			throw new ExceptionInInitializerError(e);
		}
	}
}
