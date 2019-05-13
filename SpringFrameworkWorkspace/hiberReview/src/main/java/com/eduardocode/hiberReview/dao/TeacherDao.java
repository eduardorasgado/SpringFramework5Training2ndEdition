/**
 * 
 */
package com.eduardocode.hiberReview.dao;

import java.util.List;

import com.eduardocode.hiberReview.model.Teacher;

/**
 * <h1>TeacherDao</h1>
 * Interface de transaccion con el patron de diseño DAO,
 * con el modelo Teacher hacia la db.
 * 
 * @author cheetos
 *
 */
public interface TeacherDao {
	
	/**
	 * Crea un nuevo teacher y lo agrega a la db
	 * @param teacher
	 */
	public void create(Teacher teacher);
	
	/**
	 * Actualiza un Teacher ya existente en la db
	 * @param teacher
	 */
	void update(Teacher teacher);
	
	/**
	 * Elimina un determinado teacher existente en la db en base a su id
	 * @param idTeacher
	 */
	void delete(Long idTeacher);
	
	/**
	 * Obtiene todos los teachers que existen en la db sin filtro alguno
	 * @return
	 */
	List<Teacher> getAll();
	
	/**
	 * Encuentra y devuelve un teacher en la db dado su id
	 * @param idTeacher
	 * @return
	 */
	Teacher findById(Long idTeacher);
	
	/**
	 * Encuentra y devuelve un teacher en la db dado su nombre completo
	 * @param name
	 * @return
	 */
	Teacher findByName(String name);

}
