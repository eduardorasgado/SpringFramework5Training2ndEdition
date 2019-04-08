/**
 * Virtual Object Package: 
 * 
 * Es un paquete que representa clases libres de cualquier tecno
 * logia mas que Java, con la cual podremos mapear todos los atributos de la
 * misma clase de un modelo sin todas las anotaciones y relaciones que este 
 * conlleva
 */
package com.eduardocode.lightreserve.resources.vo;

import lombok.Data;

/**
 * Clase que esta representando la tabla cliente de la db
 * 
 * @author cheetos
 *
 */

// anotacion propia de lombok para creacion automatica de getters and setters

@Data
public class ClienteVO {
	private String idCli;
	private String nombreCli;
	private String apellidoCli;
	private String identificacionCli;
	private String direccionCli;
	private String telefonoCli;
	private String emailCli;
}
