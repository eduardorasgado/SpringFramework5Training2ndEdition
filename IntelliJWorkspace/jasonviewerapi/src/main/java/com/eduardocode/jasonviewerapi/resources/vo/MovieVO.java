package com.eduardocode.jasonviewerapi.resources.vo;

import lombok.Data;

import java.util.Date;

/**
 * <h1>MovieVO</h1>
 * Clase para la creacion de objeto virtual de pelicula
 *
 * @author Eduardo Rasgado Ruiz
 * @version 1.0
 * @since april/2019
 */
@Data
public class MovieVO extends WatchableVO {
    private String director;
    private Integer duration;
    private Integer timeViewed;
    private Date startWatching;
    private Date stopWatching;
}
