/**
 * 
 */
package com.eduardocode.hiberReview.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * @author cheetos
 *
 */
public class SessionHandler {
	
	public Session getSession() {
		// Configuracion de una session para agregar elementos a la db
        SessionFactory sessionFactory;
        
		Configuration configuration = new Configuration();
        configuration.configure();
        sessionFactory = configuration.buildSessionFactory();
        
        Session session = sessionFactory.openSession();
        
        return session;
	}

}
