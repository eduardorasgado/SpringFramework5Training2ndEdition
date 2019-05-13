package com.eduardocode.hiberReview;

import java.util.TimeZone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.eduardocode.hiberReview.model.Teacher;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	TimeZone.setDefault(TimeZone.getTimeZone("America/Mexico_City"));
    	
    	// Configuracion de una session para agregar elementos a la db
        SessionFactory sessionFactory;
        
        Configuration configuration = new Configuration();
        configuration.configure();
        sessionFactory = configuration.buildSessionFactory();
        
        Session session = sessionFactory.openSession();
        
        Teacher teacher = new Teacher("Tadeo", "Avatar de Tadeo");
        
        // insersion del elemento
        session.beginTransaction();
        session.save(teacher);
        session.getTransaction().commit();
        session.close();
    }
}
