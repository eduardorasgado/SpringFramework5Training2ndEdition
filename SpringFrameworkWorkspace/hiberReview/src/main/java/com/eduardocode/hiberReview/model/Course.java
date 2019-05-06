/**
 * 
 */
package com.eduardocode.hiberReview.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

/**
 * @author cheetos
 *
 */
@Data
@Entity
@Table(name="course")
public class Course implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_course")
	private Long idCourse;
	private String name;
	private String syllabus;
	private String project;
	@ManyToOne(optional=true, fetch=FetchType.EAGER)
	@JoinColumn(name="id_teacher") // en la tabla course habrea una columna llamada asi
	private Teacher teacher;
	
	
	
	public Course(String name, String syllabus, String project, 
			Teacher teacher) {
		super();
		this.name = name;
		this.syllabus = syllabus;
		this.project = project;
		this.teacher = teacher;
	}

	public Course() {
		super();
	}
		
}
