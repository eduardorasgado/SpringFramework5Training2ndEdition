/**
 * 
 */
package com.eduardocode.lightreserve.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;

/**
 * Clase que representa la tabla reserva
 * @author cheetos
 *
 */

// anotacion para la generacion automatica de getters y setters
@Data
@Entity
@Table(name="reserva")
public class Reserva {
	@Id
	@GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="systenm-uuid", strategy="uuid2")
	private String idRes;
	
	// anotacion temporal de javax persistence
	// de especificacion exacta de tipo de fecha para la db
	@Temporal(TemporalType.DATE)
	private Date fechaIngresoRes;
	
	@Temporal(TemporalType.DATE)
	private Date fechaSalidaRes;
	private int cantidadPersonasRes;
	private String descripcionRes;
	
	@ManyToOne
	@JoinColumn(name="idCli") // en tabla reserva habla una columna llamada idCli
	private Cliente cliente;
}
