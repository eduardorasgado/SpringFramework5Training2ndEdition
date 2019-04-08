package com.eduardocode.lightreserve.services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.eduardocode.lightreserve.model.Cliente;
import com.eduardocode.lightreserve.repository.ClienteRepository;

/**
 * Clase para definir los servicios de cliente Consume los metodos creados en el
 * repositorio de cliente y los expone a traves de un servicio para poder ser
 * utilizado en el frontend CRUD
 * 
 * @author cheetos
 *
 */
@Service
/**
 * Transaccion: es el conjunto de operaciones que se ejecutan en bloque todas o
 * ninguna. Ejemplo: se hacen 5 consultas, si falla una entonces ninguna se
 * habra terminado. O se hace un commit en caso de realizarse todas con exito, o
 * se hace un rollback en caso en que una o varias fallaron y entonces todas las
 * demas operaciones se revierten.
 * 
 * En el tema de queries no se deberia establecer una transaccion sin embargo,
 * en spring jpa las transacciones son de solo lectura para queries
 * 
 * @author cheetos
 *
 */
@Transactional(readOnly = true)
public class ClienteService {
	private final ClienteRepository clienteRepository;

	public ClienteService(ClienteRepository clienteRepository) {
		this.clienteRepository = clienteRepository;
	}

	/**
	 * Metodo para realizar la operacion de guardar un cliente
	 * 
	 * @param cliente
	 * @return
	 */
	// importado de springframework, no de javax
	@Transactional
	public Cliente create(Cliente cliente) {
		return this.clienteRepository.save(cliente);
	}

	/**
	 * Metodo para realizar la operacion de actualizar un cliente
	 * 
	 * @param cliente
	 * @return
	 */
	@Transactional
	public Cliente update(Cliente cliente) {
		return this.clienteRepository.save(cliente);
	}

	/**
	 * Metodo para realizar la operacion de eliminar un cliente
	 * 
	 * @param cliente
	 */
	@Transactional
	public void delete(Cliente cliente) {
		this.clienteRepository.delete(cliente);
	}

	/**
	 * Metodo para poder acceder a un cliente dada su identificacion
	 * 
	 * @param identificacionCli
	 * @return
	 */
	// aqui no hay transactional anotation debido a que ya se
	public Cliente findByIdentificacion(String identificacionCli) {
		return this.clienteRepository.findByIdentificacion(identificacionCli);
	}
	
	/**
	 * Metodo para acceder a un grupo de clientes dado un apellido en concreto
	 * @param apellidoCli
	 * @return
	 */
	public List<Cliente> findByApellido(String apellidoCli) {
		return this.clienteRepository.findByApellidoCli(apellidoCli);
	}
	
	/**
	 * Devuelve todos los clientes que se encuentren registrados en la db
	 * @return
	 */
	public List<Cliente> findAll() {
		return clienteRepository.findAll();
	}
}
