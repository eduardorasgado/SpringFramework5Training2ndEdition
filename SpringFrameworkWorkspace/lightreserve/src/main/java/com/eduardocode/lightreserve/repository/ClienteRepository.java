/**
 * 
 */
package com.eduardocode.lightreserve.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eduardocode.lightreserve.model.Cliente;

/**
 * Interfaz que define las operaciones de base de datos relacionadas con el
 * cliente
 * @author cheetos
 *
 */
public interface ClienteRepository extends JpaRepository<Cliente, String>{
	
	/**
	 * Definicion de metodo para buscar los clientes por su apellido
	 * @param apellidoCli
	 * @return
	 */
	public List<Cliente> findByApellidoCli(String apellidoCli);
	
	/**
	 * Consulta basada en el namedquery descrito o definido en el modelo de
	 * Cliente
	 * @param identificacionCli
	 * @return
	 */
	public Cliente ClientefindByIdentificacionCli(String identificacionCli);
}
