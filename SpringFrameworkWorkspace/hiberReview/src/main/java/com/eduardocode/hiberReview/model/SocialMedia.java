/**
 * 
 */
package com.eduardocode.hiberReview.model;

import java.io.Serializable;
import java.util.List;

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
 * <h1>SocialMedia</h1>
 * Clase que representa un modelo para la tabla SocialMedia
 * 
 * @author Eduardo Rasgado Ruiz
 *
 */
@Data
@Entity
@Table(name="social_media")
public class SocialMedia implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_social_media")
	private Long idSocialMedia;
	private String name;
	private String icon;
	
	// eager indica que jalara las relaciones cada vez que se haga una consulta 
	// de esta tabla
	@OneToMany(mappedBy="socialMedia", fetch=FetchType.EAGER)
	private List<TeacherSocialMedia> teacherSocialMedias;
	
	public SocialMedia(String name, String icon) {
		this.name = name;
		this.icon = icon;
	}

	public SocialMedia() {
		super();
	}
}
