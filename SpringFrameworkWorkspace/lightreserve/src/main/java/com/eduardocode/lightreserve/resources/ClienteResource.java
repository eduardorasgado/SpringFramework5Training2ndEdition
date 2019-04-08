/**
 * 
 */
package com.eduardocode.lightreserve.resources;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
		cliente = this.mappingClienteUtil(cliente, clienteVo);
		
		// retornamos la creacion del objeto + el estatus de creado
		return new ResponseEntity<>(this.clienteService.create(cliente),
				HttpStatus.CREATED);
	}
	
	/**
	 * Metodo que interactua con las peticiones externas para dar funcionalidad
	 * a la actualizacion de un objeto de cliente existente en la base de datos
	 * 
	 * @param clienteVo
	 * @return
	 */
	@PutMapping("/{identificacion}")
	public ResponseEntity<Cliente> updateCliente(
			@PathVariable("identificacion") String identificacion,
			// aqui se va a mapear lo que venga del frontend, en clase pura,
			// es decir sin anotaciones ni dependencias de spring
			ClienteVO clienteVo) {
		
		Cliente cliente = this.clienteService.findByIdentificacion(identificacion);
		
		if(cliente == null) {
			// en caso en el que no exista el usuario a actualizar
			return new ResponseEntity<Cliente>(HttpStatus.NOT_FOUND);
		} else {
			cliente = this.mappingClienteUtil(cliente, clienteVo);
		}
		
		return new ResponseEntity<>(this.clienteService.update(cliente),
				HttpStatus.OK);
	}
	
	/**
	 * Metodo que recibe una identificacion, busca a un cliente con dicha 
	 * identificacion y elimina al cliente que se ha encontrado
	 * @param identificacion
	 */
	@DeleteMapping("/{identificacion}")
	public void removeCliente(@PathVariable("identificacion") String identificacion) {
		
		Cliente cliente = clienteService.findByIdentificacion(identificacion);
		if(cliente != null) {
			clienteService.delete(cliente);
		}
	}
	
	/**
	 * Responde con una lista de todos los clientes del negocio
	 * @return
	 */
	@GetMapping
	public ResponseEntity<List<Cliente>> findAll() {
		return ResponseEntity.ok(this.clienteService.findAll());
	}
	
	/**
	 * Seccion de utilidades para el resource de cliente
	 * @param cliente
	 * @param clienteVo
	 * @return
	 */
	
	/**
	 * Metodo de cliente resource que toma todos los valores de un objeto virtual
	 * vo y los transfiere a un objeto de clase Cliente con anotacion Entity
	 * @param cliente
	 * @param clienteVo
	 * @return
	 */
	private Cliente mappingClienteUtil(Cliente cliente, ClienteVO clienteVo) {
		cliente.setNombreCli(clienteVo.getNombreCli());
		cliente.setApellidoCli(clienteVo.getApellidoCli());
		cliente.setIdentificacionCli(clienteVo.getIdentificacionCli());
		cliente.setDireccionCli(clienteVo.getDireccionCli());
		cliente.setTelefonoCli(clienteVo.getTelefonoCli());
		cliente.setEmailCli(clienteVo.getEmailCli());
		
		return cliente;
	}
	
}
