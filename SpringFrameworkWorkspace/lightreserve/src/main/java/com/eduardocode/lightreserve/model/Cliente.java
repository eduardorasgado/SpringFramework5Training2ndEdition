/**
 * 
 */
package com.eduardocode.lightreserve.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;

/**
 * Clase que esta representando la tabla cliente de la db
 * 
 * @author cheetos
 *
 */

// anotacion propia de lombok para creacion automatica de getters and setters
@Data
@Entity
@Table(name = "cliente")
// queries nombradas: se hacen directamente en el pojo
// usando jpql -> lenguaje de postgres
@NamedQuery(name = "Cliente.findByIdentificacion", 
			query = "Select c from Cliente c where c.identificacionCli = ?1")
public class Cliente {
	@Id
	@GeneratedValue(generator = "system-uuid")
	// notacion propia de hibernate
	// generar una cadena para id
	@GenericGenerator(name = "system-uuid", strategy = "uuid2")
	private String idCli;
	private String nombreCli;
	private String apellidoCli;
	private String identificacionCli;
	private String direccionCli;
	private String telefonoCli;
	private String emailCli;

	@OneToMany(mappedBy = "cliente") // en el modelo de reserva hay un atributo
										// llamado cliente
	private Set<Reserva> reservas;
}
