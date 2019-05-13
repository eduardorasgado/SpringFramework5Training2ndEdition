package com.eduardocode.hiberReview;

import java.util.TimeZone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.eduardocode.hiberReview.model.Course;
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
        
        //Teacher teacher = new Teacher("Tadeo", "Avatar de Tadeo");
        
        Course course = new Course("Programación Avanzada", "clase 1, clase 2, clase 3",
        		"Vision por computador");
        
        /*
        // insersion del elemento
        session.beginTransaction();
        session.save(course);
        session.getTransaction().commit();
        session.close();
        */
    }
}
