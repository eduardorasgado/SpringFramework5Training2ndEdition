package com.eduardocode.lightreserve.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.eduardocode.lightreserve.model.Reserva;
import com.eduardocode.lightreserve.repository.ReservaRepository;

/**
 * Clase que describe una interfaz para acceder a las operaciones crud con
 * respecto del repositorio de Reserva. Consume el repositorio de la clase 
 * Reserva
 * 
 * @author cheetos
 *
 */
@Service
@Transactional(readOnly=true)
public class ReservaService {
	private final ReservaRepository reservaRepository;
	
	public ReservaService(ReservaRepository reservaRepository) {
		this.reservaRepository = reservaRepository;
	}
	
	/**
	 * Crea una nueva reserva y la almacena en la db, la reserva ya viene
	 * con la entidad del cliente a la que pertenece
	 * @param cliente
	 * @return
	 */
	public Reserva create(Reserva reserva) {
		return this.reservaRepository.save(reserva);
	}
	
	/**
	 * Realiza una actualizacion con nuevos datos de una reserva ya existente
	 * @param reserva
	 * @return
	 */
	public Reserva update(Reserva reserva) {
		return this.reservaRepository.save(reserva);
	}
	
	/**
	 * Metodo que elimina una reserva de la base de datos dada la entidad de la
	 * reserva a ser eliminada
	 * @param reserva
	 */
	public void delete(Reserva reserva) {
		this.reservaRepository.delete(reserva);
	}
}
