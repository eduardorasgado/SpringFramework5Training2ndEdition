package com.eduardocode.lightreserve.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.eduardocode.lightreserve.model.Reserva;

public interface ReservaRepository extends JpaRepository<Reserva, String> {
	
	/**
	 * 3) Metodo basado en consultas de tipo jpql multi campos
	 * @param fechaInicio
	 * @param fechaSalida
	 * @return
	 */
	@Query("Select r from Reserva r where r.fechaIngresoRes =:fechaInicio and"
			+ "r.fechaSalidaRes :=fechaSalida")
	public List<Reserva> find(@Param("fechaInicio") Date fechaInicio,
							   @Param("fechaSalida") Date fechaSalida);
}
