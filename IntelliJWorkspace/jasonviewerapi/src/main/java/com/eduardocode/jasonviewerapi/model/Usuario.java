package com.eduardocode.jasonviewerapi.model;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * <h1>Usuario</h1>
 * Modelo que representa a los usuarios admministradores de la api
 *
 * <p>
 *     Observar que este metodo no posee una relacion explicita con el modelo role.
 *     Esto se debe a que esa relacion ya la define spring security
 *
 * @author Eduardo Rasgado Ruiz
 * @version 1.0
 * @since april/2019
 */
@Data
@Entity
@Table(name = "usuario")
public class Usuario {
    @Id
    @GeneratedValue( generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    private String id;
    private String username;
    private String nombre;
    private String apellido;
    private String password;
    // representa el enable en spring security
    private boolean status;
}
