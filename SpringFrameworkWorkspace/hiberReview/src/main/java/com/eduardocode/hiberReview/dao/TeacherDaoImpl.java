/**
 * 
 */
package com.eduardocode.hiberReview.dao;

import java.util.List;

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
		
	}

	/* (non-Javadoc)
	 * @see com.eduardocode.hiberReview.dao.TeacherDao#delete(java.lang.Long)
	 */
	public void delete(Long idTeacher) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see com.eduardocode.hiberReview.dao.TeacherDao#getAll()
	 */
	public List<Teacher> getAll() {
		// TODO Auto-generated method stub
		return null;
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
		// TODO Auto-generated method stub
		return null;
	}

}
