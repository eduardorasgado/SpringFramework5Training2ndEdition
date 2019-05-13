/**
 * 
 */
package com.eduardocode.hiberReview.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * <h1>SessionHandler</h1>
 * Clase que maneja la inicializacion, transaccion y termino de la sesion de
 * hibernate
 * @author cheetos
 *
 */
public class SessionHandler {
	
	private SessionFactory sessionFactory;
	private Configuration configuration;
	private Session session;
	
	public SessionHandler() {
		// Configuracion de una session para agregar elementos a la db
		configuration = new Configuration();
		configuration.configure();
        sessionFactory = configuration.buildSessionFactory();
        
        session = sessionFactory.openSession();
        
	}

	public Session getSession() {
        return session;
	}

}
