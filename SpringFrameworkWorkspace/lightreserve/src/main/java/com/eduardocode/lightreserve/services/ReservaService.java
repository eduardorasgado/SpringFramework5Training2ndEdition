package com.eduardocode.lightreserve.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.eduardocode.lightreserve.repository.ReservaRepository;

@Service
@Transactional(readOnly=true)
public class ReservaService {
	private final ReservaRepository reservaRepository;
	
	public ReservaService(ReservaRepository reservaRepository) {
		this.reservaRepository = reservaRepository;
	}
}
