package com.eduardocode.jasonviewerapi.model;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * <h1>Cliente</h1>
 * Clase que representa la tabla de cliente dentro de la aplicacion
 *
 * @author Eduardo Rasgado Ruiz
 * @version 1.0
 * @since april/2019
 */
@Data
@Entity
@Table(name ="cliente")
@NamedQuery(name="Cliente.findByIdentificacion",
        query="Select c from Cliente c where c.identificacion = ?1")
public class Cliente {
    @Id
    // generadores de hibernate
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    private String id;
    private String nombre;
    private String apellido;
    private String identificacion;
    private String direccion;
    private String telefono;
    private String email;
    private String password;
    private boolean activeAccount;
}
