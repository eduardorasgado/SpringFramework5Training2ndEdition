package com.eduardocode.lightreserve.services;

import org.springframework.stereotype.Service;

import com.eduardocode.lightreserve.model.Cliente;
import com.eduardocode.lightreserve.repository.ClienteRepository;

/**
 * Clase para definir los servicios de cliente
 * Consume los metodos creados en el repositorio de cliente y los expone
 * a traves de un servicio para poder ser utilizado en el frontend
 * CRUD
 * @author cheetos
 *
 */
@Service
public class ClienteService {
	private final ClienteRepository clienteRepository;
	
	public ClienteService(ClienteRepository clienteRepository) {
		this.clienteRepository = clienteRepository;
	}
	
	/**
	 * Metodo para realizar la operacion de guardar un cliente
	 * @param cliente
	 * @return
	 */
	public Cliente create(Cliente cliente) {
		return this.clienteRepository.save(cliente);
	}
	
	/**
	 * Metodo para realizar la operacion de actualizar un cliente
	 * @param cliente
	 * @return
	 */
	public Cliente update(Cliente cliente) {
		return this.clienteRepository.save(cliente);
	}
	
	/**
	 * Metodo para realizar la operacion de eliminar un cliente
	 * @param cliente
	 */
	public void delete(Cliente cliente) {
		this.clienteRepository.delete(cliente);
	}
	
	/**
	 * Metodo para poder acceder a un cliente dada su identificacion
	 * @param identificacionCli
	 * @return
	 */
	public Cliente findByIdentificacion(String identificacionCli) {
		return this.clienteRepository.findByIdentificacion(identificacionCli);
	}
}
