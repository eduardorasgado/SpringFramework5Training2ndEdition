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
        // la session se prepara aqui, se cierra con el metodo closeSessionHandler
        // en los DAO
        this.beginSession();
	}

	/**
	 * Metodo mediante el cual se obtiene la session de hibernate
	 * @return
	 */
	public Session getSession() {
        return session;
	}
	
	/**
	 * Metodo que prepara la session para realizar transacciones
	 */
	public void beginSession() {
		session.beginTransaction();
	}
	
	/**
	 * Metodo que debe llamarse una vez termine de efectuarse una consulta o
	 * transaccion con hibernate a la db
	 */
	public void closeSession() {
		session.close();
	}
	
	/**
	 * Metodo que ejecuta una transaccion deseada por la clase que requiere
	 * dicha transaccion
	 */
	public void commitTransaction() {
        session.getTransaction().commit();
	}

}
