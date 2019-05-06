/**
 * 
 */
package com.eduardocode.hiberReview.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

/**
 * <h1>Teacher</h1>
 * Clase que representa a la entidad Teacher en la base de datos
 * @author cheetos
 *
 */
@Data
@Entity
@Table(name="teacher")
public class Teacher implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_teacher")
	private Long idTeacher;
	private String name;
	private String avatar;
	
	// el nombre del campo que contiene la entidad Teacher en el modelo Course
	// fetch define que cada que consultemos en teacher, se traiga todos los cursos
	@OneToMany(mappedBy="teacher", fetch=FetchType.EAGER) 
	private Set<Course> courses;
	
	@OneToMany(mappedBy="teacher", fetch=FetchType.EAGER)
	private Set<TeacherSocialMedia> teacherSocialMedias;
	
	public Teacher(String name, String avatar) {
		super();
		this.name = name;
		this.avatar = avatar;
	}

	public Teacher() {
		super();
	}
	
}
