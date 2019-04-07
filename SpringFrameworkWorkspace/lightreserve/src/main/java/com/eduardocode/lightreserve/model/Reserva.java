/**
 * 
 */
package com.eduardocode.lightreserve.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

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
	private Date fechaIngresoRes;
	private Date fechaSalidaRes;
}
