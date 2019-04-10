package com.eduardocode.lightreserve.resources;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.eduardocode.lightreserve.model.Reserva;
import com.eduardocode.lightreserve.resources.vo.ReservaVO;
import com.eduardocode.lightreserve.services.ClienteService;
import com.eduardocode.lightreserve.services.ReservaService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * Clase que interactua con las peticiones del frontend que consuma la presente
 * api respecto de la clase Reserva
 * @author cheetos
 *
 */
@RestController
@RequestMapping("/api/reserva")
@Api(tags="reserva")
public class ReservaResource {
	@Autowired
	private final ClienteService clienteService;
	
	@Autowired
	private final ReservaService reservaService;
	
	public ReservaResource(ReservaService reservaService,
			ClienteService clienteService) {
		this.reservaService = reservaService;
		this.clienteService = clienteService;
	}
	
	/**
	 * Metodo que llama al servicio de reserva, para Crear una nueva Reserva  
	 * crea una clase virtual de reserva con los datos que vienen del frontend,
	 * y los mapea a una clase de Reserva de modelo,
	 *  
	 * @param reservaVo
	 * @return
	 */
	@PostMapping
	//----------------DOCUMENTACION UI---------------------------
	@ApiOperation(value="Crear reserva", notes="Servicio para crear una reserva, "
			+ "esta debe pertenecer a un cliente")
	@ApiResponses(value= {
			@ApiResponse(code=201, message="Se ha creado un cliente correctamente"),
			@ApiResponse(code=400, message="Solicitud de creacion invalida")
	})
	//-----------------------------------------------------------
	public ResponseEntity<Reserva> createReserva(@RequestBody ReservaVO reservaVo) {
		Reserva reserva = new Reserva();
		reserva = this.mappingReserva(reserva, reservaVo);
		reserva = this.mappingClienteToReserva(reserva, reservaVo);
		
		Reserva reservaSaved = this.reservaService.create(reserva);
		// guardamos la reserva que se guardó en el cliente al que le pertenece
		this.mappingReservaToCliente(reservaSaved, reservaVo);
		
		ResponseEntity<Reserva> rEntity = new ResponseEntity<>(reservaSaved,
				HttpStatus.CREATED);
		return rEntity;
	}
	
	/**
	 * Actualiza una reserva dada en la base de datos, sin cambiar el cliente
	 * al que le pertenece
	 * 
	 * @param idReserva
	 * @param reservaVo
	 * @return
	 */
	@PutMapping("/{idReserva}")
	//----------------DOCUMENTACION UI---------------------------
	@ApiOperation(value="Actualizar reserva", notes="Se actualiza una reserva dada su id")
	@ApiResponses(value= {
			@ApiResponse(code=201, message="Reserva actualizada de forma correcta"),
			@ApiResponse(code=404, message="Reserva no encontrada")
	})
	//-----------------------------------------------------------
	public ResponseEntity<Reserva> updateReserva(
			@PathVariable("idReserva") String idReserva,
			ReservaVO reservaVo) {
		Reserva reserva = this.reservaService.findById(idReserva);
		if(reserva == null) {
			return new ResponseEntity<Reserva>(HttpStatus.NOT_FOUND);
		} else {
			// el cliente de la reserva no cambiara sobre ningun caso
			// por ello solo modificamos los atributos basicos
			reserva = this.mappingReserva(reserva, reservaVo);
		}
		
		//return ResponseEntity<>(this.clienteService)
		return new ResponseEntity<Reserva>(this.reservaService.update(reserva),
				HttpStatus.OK);
	}
	
	/**
	 * Eliminar una reserva determinada, necesita el id del cliente para saber
	 * que el dueno de la reserva es quien la elimina
	 * @param idReserva
	 */
	@DeleteMapping("/{idCliente}/{idReserva}")
	//----------------DOCUMENTACION UI---------------------------
	@ApiOperation(value="Eliminar reserva", notes="Servicio para eliminar una reserva dado"
			+ "el id del cliente y el id de la reserva")
	@ApiResponses(value= {
			@ApiResponse(code=200, message="La reserva ha sido eliminada exitosamente"),
			@ApiResponse(code=404, message="Reserva no encontrada")
	})
	//-----------------------------------------------------------
	public ResponseEntity<Reserva> removeReserva(@PathVariable("idReserva") String idReserva,
			@PathVariable("idCliente") String idCliente) {
		Reserva reserva = this.reservaService.findById(idReserva);
		
		// solamente un cliente puede eliminar sus propias reservas
		// y si esta reserva existe
		if(reserva != null && idCliente.equals(reserva.getCliente().getIdCli())) {
			this.reservaService.delete(reserva);
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		// TODO: Comprobar si al eliminar una reserva se elimina de su cliente: SI
	}
	
	/**
	 * Devuelve una lista de todas las reservas con las que un cliente cuenta
	 * @param idCliente
	 * @return
	 */
	@GetMapping("/{idCliente}")
	//----------------DOCUMENTACION UI---------------------------
	@ApiOperation(value="Encontrar todas las reservas por cliente", 
		notes="Servicio para obtener todas las reservas que le pertenecen a un"
				+ "determinado cliente")
	@ApiResponses(value= {
			@ApiResponse(code=200, message="Reservas encontradas de forma exitosa"),
			@ApiResponse(code=404, message="Cliente no existe, por tanto así mismo sus"
					+ "reservas")
	})
	//-----------------------------------------------------------
	
	public ResponseEntity<List<Reserva>> findAllByCliente(
			@PathVariable("idCliente") String idCliente) {
		Cliente cliente = clienteService.findById(idCliente);
		if (cliente != null) {
			return ResponseEntity.ok(this.reservaService.findByCliente(cliente));
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
	}
	
	/**
	 * Seccion de utilidades para la clase de reserva resource
	 * @param
	 * @param
	 * @return
	 */
	
	/**
	 * Metodo que mapea los atributos del objeto virtual reservaVo y los 
	 * transfiere al objeto reserva de la clase Reserva
	 * @param reserva
	 * @param reservaVo
	 * @return
	 */
	public Reserva mappingReserva(Reserva reserva, ReservaVO reservaVo) {
		
		reserva.setFechaIngresoRes(reservaVo.getFechaIngresoRes());
		reserva.setFechaSalidaRes(reservaVo.getFechaSalidaRes());
		reserva.setCantidadPersonasRes(reservaVo.getCantidadPersonasRes());
		reserva.setDescripcionRes(reservaVo.getDescripcionRes());
		
		return reserva;
	}
	
	/**
	 * Metodo para buscar el cliente con un determinado id y lo inclumos en la reserva
	 * @param reserva
	 * @param reservaVo
	 * @return
	 */
	public Reserva mappingClienteToReserva(Reserva reserva, ReservaVO reservaVo) {
		Cliente cliente = this.clienteService.findById(reservaVo.getIdRes());
		reserva.setCliente(cliente);
		
		return reserva;
	}
	
	/**
	 * Metodo que guarda la reserva que se guardó en la lista de reservas del 
	 * cliente al que le pertenece
	 * @param reserva
	 * @param reservaVo
	 */
	public void mappingReservaToCliente(Reserva reserva, ReservaVO reservaVo) {
		Cliente cliente = this.clienteService.findById(reservaVo.getIdCliente());
		// conseguimos las reservas del cliente, agregamos la nueva y guardamos
		// la nueva lista de reservas
		Set<Reserva> reservas = cliente.getReservas();
		reservas.add(reserva);
		cliente.setReservas(reservas);
	}
}
