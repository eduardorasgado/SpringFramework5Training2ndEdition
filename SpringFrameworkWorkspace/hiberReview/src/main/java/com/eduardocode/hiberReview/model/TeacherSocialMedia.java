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
 * <h1>TeacherSocialMedia</h1>
 * Clase que representa una relacion entre una entidad de Teacher y
 * una Entidad de Social Media, pero se agrega el campo nickname
 * que es el url de la red social del teacher.
 * @author cheetos
 *
 */
@Data
@Entity
@Table(name="teacher_social_media")
public class TeacherSocialMedia implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_teacher_social_media")
	private Long idTeacherSocialMedia;
	
	/**
	 * Un teacher puede tener muchas redes sociales
	 */
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="id_teacher")
	private Teacher teacher;
	
	/**
	 * Muchas redes sociales pueden pertenecer a un teacher
	 */
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="id_social_media")
	private SocialMedia socialMedia;
	
	private String nickname;
	
	public TeacherSocialMedia() {
		
	}

	public TeacherSocialMedia(Teacher teacher, SocialMedia socialMedia, String nickname) {
		super();
		this.teacher = teacher;
		this.socialMedia = socialMedia;
		this.nickname = nickname;
	}
	
}
