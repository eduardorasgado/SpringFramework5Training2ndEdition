/**
 * 
 */
package com.eduardocode.hiberReview.dao;

import java.util.List;

import org.hibernate.query.Query;

import com.eduardocode.hiberReview.model.Teacher;

/**
 * <h1>TeacherDaoImpl</h1>
 * Implementacion del CRUD de la interfaz {@link TeacherDao}
 * 
 * @author cheetos
 */
public class TeacherDaoImpl implements TeacherDao {
	
	private SessionHandler sessionHandler;
	
	public TeacherDaoImpl() {
		sessionHandler = new SessionHandler();
	}
	
	/**
	 * Metodo que cierra  la session terminadose de usar la implementacion de
	 * teacher dao
	 */
	public void closeSessionHandler() {
		sessionHandler.closeSession();
	}

	/* (non-Javadoc)
	 * @see com.eduardocode.hiberReview.dao.TeacherDao#create(com.eduardocode.hiberReview.model.Teacher)
	 */
	public void create(Teacher teacher) {
		sessionHandler.getSession().save(teacher);
		sessionHandler.commitTransaction();
	}

	/* (non-Javadoc)
	 * @see com.eduardocode.hiberReview.dao.TeacherDao#update(com.eduardocode.hiberReview.model.Teacher)
	 */
	public void update(Teacher teacher) {
		sessionHandler.getSession().update(teacher);
		sessionHandler.commitTransaction();
	}

	/* (non-Javadoc)
	 * @see com.eduardocode.hiberReview.dao.TeacherDao#delete(java.lang.Long)
	 */
	public void delete(Long idTeacher) {
		Teacher teacher = this.findById(idTeacher);
		if(teacher != null) {
			System.out.println("Teacher deleted");
			sessionHandler.getSession().delete(teacher);
			sessionHandler.commitTransaction();
		}
	}

	/* (non-Javadoc)
	 * @see com.eduardocode.hiberReview.dao.TeacherDao#getAll()
	 */
	public List<Teacher> getAll() {
		// Hibernate usa HQL:: hibernate Query language
		List<Teacher> teachers = sessionHandler.getSession()
				.createQuery("from Teacher").list();
		
		return teachers;
	}

	/* (non-Javadoc)
	 * @see com.eduardocode.hiberReview.dao.TeacherDao#findById(java.lang.Long)
	 */
	public Teacher findById(Long idTeacher) {
		Teacher teacher = sessionHandler.getSession()
				.find(Teacher.class, idTeacher);
		
		if(teacher != null) {
			return teacher;
		}
		return null;
	}

	/* (non-Javadoc)
	 * @see com.eduardocode.hiberReview.dao.TeacherDao#findByName(java.lang.String)
	 */
	public Teacher findByName(String name) {
		Query<Teacher> result = sessionHandler.getSession()
				.createQuery("select teacher from Teacher as teacher where teacher.name like '"
						+name+"'");
		
		Teacher teacher = result.getSingleResult();
		
		//System.out.println("id is: "+teacherEntity);
		if(teacher != null) return teacher;
		return null;
	}

}
