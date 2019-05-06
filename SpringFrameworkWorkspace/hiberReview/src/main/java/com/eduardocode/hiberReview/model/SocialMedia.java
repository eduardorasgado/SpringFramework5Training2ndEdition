/**
 * 
 */
package com.eduardocode.hiberReview.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
	
	public SocialMedia(String name, String icon) {
		this.name = name;
		this.icon = icon;
	}

	public SocialMedia() {
		super();
	}
}
