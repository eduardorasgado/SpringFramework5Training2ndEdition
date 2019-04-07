package com.eduardocode.lightreserve.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eduardocode.lightreserve.model.Reserva;

public interface ReservaRepository extends JpaRepository<Reserva, String> {
	
}
