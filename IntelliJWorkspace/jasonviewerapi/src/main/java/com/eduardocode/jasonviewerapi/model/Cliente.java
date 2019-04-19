package com.eduardocode.jasonviewerapi.model;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * <h1>Cliente</h1>
 * Clase que representa la tabla de cliente
 *
 * @author Eduardo Rasgado Ruiz
 * @version 1.0
 * @since april/2019
 */
@Data
@Entity
@Table(name ="cliente")
public class Cliente {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    private String id;
    private String nombre;
    private String apellido;
    private String identificacion;
    private String direccio;
    private String telefono;
    private String email;
}
