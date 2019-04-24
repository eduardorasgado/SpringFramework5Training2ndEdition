package com.eduardocode.jasonviewerapi.model;

import lombok.Data;

/**
 * <h1>Usuario</h1>
 * Modelo que representa a los usuarios admministradores de la api
 *
 * @author Eduardo Rasgado Ruiz
 * @version 1.0
 * @since april/2019
 */
@Data
public class Usuario {
    private String id;
    private String username;
    private String password;
    private boolean enable;
}
