/**
 * 
 */
package com.eduardocode.lightreserve.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eduardocode.lightreserve.model.Cliente;

/**
 * Interfaz que define las operaciones de base de datos relacionadas con el
 * cliente
 * 
 * @author cheetos
 *
 */
@Repository
public interface ClienteRepository extends JpaRepository<Cliente, String> {
	
	/**
	 * Metodo que devuelve un cliente dado un id determinado
	 * @param idCli
	 * @return
	 */
	public Optional<Cliente> findByIdCli(String idCli);

	/**
	 * Definicion de metodo para buscar los clientes por su apellido 1) metodo
	 * basado en nombres
	 * 
	 * @param apellidoCli
	 * @return
	 */
	public List<Cliente> findByApellidoCli(String apellidoCli);

	/**
	 * 2)Metodo basado en namedqueries: usando jpql Consulta basada en el namedquery
	 * descrito o definido en el modelo de Cliente
	 * 
	 * @param identificacionCli
	 * @return
	 */
	public Cliente findByIdentificacion(String identificacionCli);
}
