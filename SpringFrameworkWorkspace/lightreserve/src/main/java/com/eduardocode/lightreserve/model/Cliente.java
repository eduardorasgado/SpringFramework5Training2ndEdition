/**
 * 
 */
package com.eduardocode.lightreserve.model;

import java.util.Date;

import lombok.Data;

/**
 * Clase que esta representando la tabla cliente de la db
 * @author cheetos
 *
 */

// anotacion propia de lombok para creacion automatica de getters and setters
@Data
public class Cliente {
	private String nombreCliente;
	private String apellidosCliente;
	private Date created_at;
	
	public Cliente() {
		//
	}
}
