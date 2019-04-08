package com.eduardocode.lightreserve.resources.vo;

import java.util.Date;

import lombok.Data;

@Data
public class ReservaVO {
	private String idRes;
	private Date fechaIngresoRes;
	private Date fechaSalidaRes;
	private int cantidadPersonasRes;
	private String descripcionRes;
}
