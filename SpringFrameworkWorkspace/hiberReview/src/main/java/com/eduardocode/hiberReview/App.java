package com.eduardocode.hiberReview;

import java.util.TimeZone;

import com.eduardocode.hiberReview.dao.TeacherDaoImpl;
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
        
    	Long idTeacher = new Long(2);
        Teacher teacher = new Teacher("Jason Valenzuela", "Avatar de Jason");
        teacher.setIdTeacher(idTeacher);
        
        Course course = new Course("Programación Avanzada", "clase 1, clase 2, clase 3",
        		"Vision por computador");
        
        TeacherDaoImpl teacherDaoImpl = new TeacherDaoImpl();
        
        // insertar un teacher
        //teacherDaoImpl.create(teacher);
        
        // encontrando el teacher con id 2
        Teacher t = teacherDaoImpl.findById(idTeacher);
        System.out.println(t);
        
        Teacher t2 = teacherDaoImpl.findByName("Jason Valenzuela");
        System.out.println(t2);
        
        teacherDaoImpl.closeSessionHandler();
    }
}
