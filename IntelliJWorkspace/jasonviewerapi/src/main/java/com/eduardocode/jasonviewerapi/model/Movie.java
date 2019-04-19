package com.eduardocode.jasonviewerapi.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * <h1>Movie</h1>
 * Clase que hereda de Watchable. Representa una pelicula en la aplicacion.
 *
 * @author Eduardo Rasgado Ruiz
 * @version 1.0
 * @since april/2019
 */
@Data
@Entity
@Table(name="movie")
public class Movie extends Watchable{
    @Id
    private String id;
    private String director;
    private int duration;
    private int timeViewed;
    private Date startWatching;
    private Date stopWatching;
}
