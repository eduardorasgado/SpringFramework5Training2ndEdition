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
    public static void main( String[] args ) throws InterruptedException
    {
    	TimeZone.setDefault(TimeZone.getTimeZone("America/Mexico_City"));
        
    	Long idTeacher = new Long(2);
        Teacher teacher = new Teacher("Micky Gonzales", "Avatar de micky");
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
        
        // imprimiendo todos los teachers de la db
        System.out.println("");
        System.out.println("All teachers:");
        teacherDaoImpl.getAll().forEach(actualTeacher -> 
        			{System.out.println(actualTeacher.getName());});
        System.out.println("");
        
        //Thread.sleep(5000);
        
        // esperar 5 segundos para elimminar a micky
        Long idMick = teacherDaoImpl.findByName("Micky Gonzales").getIdTeacher();
        System.out.println("mickys id: "+idMick);
        //teacherDaoImpl.delete(idMick);
        
        idTeacher = new Long(1);
        Teacher tUpdate = teacherDaoImpl.findById(idTeacher);
        tUpdate.setAvatar("avatar actualizado");
        teacherDaoImpl.update(tUpdate);
        
        
        teacherDaoImpl.closeSessionHandler();
    }
}
