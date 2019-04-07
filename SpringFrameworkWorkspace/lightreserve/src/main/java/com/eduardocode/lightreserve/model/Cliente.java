/**
 * 
 */
package com.eduardocode.lightreserve.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;

/**
 * Clase que esta representando la tabla cliente de la db
 * @author cheetos
 *
 */

// anotacion propia de lombok para creacion automatica de getters and setters
@Data
@Entity
@Table(name="cliente")
public class Cliente {
	@Id
	@GeneratedValue(generator="system-uuid")
	// notacion propia de hibernate
	@GenericGenerator(name="system-uuid", strategy="uuid2") // generar una cadena para id
	private String idCli;
	private String nombreCli;
	private String apellidosCli;
	private String identificationCli;
	private String direccionCli;
	private String telefonoCli;
	private String emailCli;
	
	@OneToMany(mappedBy="cliente")
	private Set<Reserva> reservas;
	
	public Cliente() {
		//
	}
}
