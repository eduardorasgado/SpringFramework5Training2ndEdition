package com.eduardocode.jasonviewerapi.model;

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
public class Serie extends Watchable {
    private String id;
    private int seasonNumber;
    private String director;
    private ArrayList<Chapter> chapters;
}
