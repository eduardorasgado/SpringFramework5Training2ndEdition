package com.eduardocode.jasonviewerapi.model;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
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
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    private String id;
    private String director;
    private int duration;
    private int timeViewed;

    @Temporal(TemporalType.DATE)
    private Date startWatching;
    @Temporal(TemporalType.DATE)
    private Date stopWatching;
}
