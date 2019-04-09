package com.eduardocode.lightreserve.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.eduardocode.lightreserve.model.Cliente;
import com.eduardocode.lightreserve.model.Reserva;

/**
 * Repositorio JPA de la clase Reserva: define las operaciones con la base de 
 * datos relacionadas con las reservas.
 * 
 * @author cheetos
 *
 */
@Repository
public interface ReservaRepository extends JpaRepository<Reserva, String> {
	/**
	 * Devuelve una lista de reservas dada un cliente
	 * @param cliente
	 * @return
	 */
	public List<Reserva> findByCliente(Cliente cliente);
	
	/**
	 * 3) Metodo basado en consultas de tipo jpql multi campos
	 * @param fechaInicio
	 * @param fechaSalida
	 * @return
	 */
	@Query("Select r from Reserva r where r.fechaIngresoRes =:fechaInicio and r.fechaSalidaRes =:fechaSalida")
	public List<Reserva> find(@Param("fechaInicio") Date fechaInicio,
							   @Param("fechaSalida") Date fechaSalida);
}
