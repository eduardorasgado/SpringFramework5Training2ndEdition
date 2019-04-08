/**
 * 
 */
package com.eduardocode.lightreserve.resources;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eduardocode.lightreserve.model.Cliente;
import com.eduardocode.lightreserve.resources.vo.ClienteVO;
import com.eduardocode.lightreserve.services.ClienteService;

/**
 * Resources package -> capa de vista de la aplicacion
 * 
 * Clase que representa el servicio web de cliente
 * @author cheetos
 *
 */
@RestController
@RequestMapping("/api/cliente")
public class ClienteResource {
	private final ClienteService clienteService;
	
	// constructor
	public ClienteResource(ClienteService clienteService) {
		this.clienteService = clienteService;
	}
	
	/**
	 * Documentacion del servicio de respuesta del servicio de creacion de
	 * un cliente
	 * 
	 * Este metodo toma una clase virtual de tipo clienteVo definida en el 
	 * paquete vo: virtual objects
	 * 
	 * @param clienteVo
	 * @return
	 */
	@PostMapping
	public ResponseEntity<Cliente> createCliente(@RequestBody ClienteVO clienteVo) {
		// tomamos el cliente deseado y le mapeamos el cliente basado en un VO
		Cliente cliente = new Cliente();
		cliente.setNombreCli(clienteVo.getNombreCli());
		cliente.setApellidoCli(clienteVo.getApellidoCli());
		cliente.setIdentificacionCli(clienteVo.getIdentificacionCli());
		cliente.setDireccionCli(clienteVo.getDireccionCli());
		cliente.setTelefonoCli(clienteVo.getTelefonoCli());
		cliente.setEmailCli(clienteVo.getEmailCli());
		// retornamos la creacion del objeto + el estatus de creado
		return new ResponseEntity<>(this.clienteService.create(cliente),
				HttpStatus.CREATED);
	}
	
}
