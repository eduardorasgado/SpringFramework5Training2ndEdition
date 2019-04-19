package com.eduardocode.jasonviewerapi.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.ArrayList;

/**
 * <h1>Serie</h1>
 * Una serie hereda de Watchable, y representa una serie en la aplicacion con sus respectivos capitulos
 *
 * @author Eduardo Rasgado Ruiz
 * @see com.eduardocode.jasonviewerapi.model.Watchable
 * @version 1.0
 * @since april/2019
 */
@Data
@Entity
@Table(name="serie")
public class Serie extends Watchable {
    @Id
    private String id;
    private int seasonNumber;
    private String director;
    private ArrayList<Chapter> chapters;
}
