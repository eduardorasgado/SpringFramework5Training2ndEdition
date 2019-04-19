package com.eduardocode.jasonviewerapi.model;

import lombok.Data;

import javax.persistence.MappedSuperclass;
import java.util.Date;

/**
 * <h1>Watchable</h1>
 * Clase padre  para los recursos que son visualizables en formato de video
 * <p>
 * Clase abstracta que representa tres clases hijas: serie, cahpter y movie
 * @author Eduardo Rasgado Ruiz
 * @version 1.0
 * @since april/2019
 *
 */
@Data
@MappedSuperclass
public class Watchable {
    private String title;
    private String genre;
    private short productionYear;
    private boolean view;

}
