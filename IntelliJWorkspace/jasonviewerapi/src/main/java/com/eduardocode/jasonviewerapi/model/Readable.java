package com.eduardocode.jasonviewerapi.model;

import lombok.Data;

import javax.persistence.MappedSuperclass;
import java.util.ArrayList;
import java.util.Date;

/**
 * <h1>Readable</h1>
 * Clase padre que representa un recurso visualizable en formato de lectura
 *
 * @author Eduardo Rasgado Ruiz
 * @version 1.0
 * @since april/2019
 */
@Data
@MappedSuperclass
public class Readable {
    private String title;
    private Date editionDate;
    private String genre;
    private String editorial;
    private ArrayList<String> authors;
}
