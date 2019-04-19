package com.eduardocode.jasonviewerapi.model;

import lombok.Data;

/**
 * <h1>Book</h1>
 * Representa un objeto de libro que puede ser consultado y accedido por un usuario de la aplicacion
 *
 * @author Eduardo Rasgado Ruiz
 * @version 1.0
 * @since april/2019
 */
@Data
public class Book extends Readable {
    private String id;
    private boolean read;
    /**
     * timeRead:
     * tiempo que toma leerlo
     */
    private int timeRead;
}
