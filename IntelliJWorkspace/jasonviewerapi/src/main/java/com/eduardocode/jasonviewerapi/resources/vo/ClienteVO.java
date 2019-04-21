package com.eduardocode.jasonviewerapi.resources.vo;

import lombok.Data;

/**
 * <h1>ClienteVO</h1>
 * Objeto virtual de la clase Cliente que permite obtener un objeto del frontend,
 * con los datos de la clase cliente
 */
@Data
public class ClienteVO {
    private String nombre;
    private String apellido;
    private String identificacion;
    private String direccion;
    private String telefono;
    private String email;
    private String password;
    private boolean activeAccount;
}
