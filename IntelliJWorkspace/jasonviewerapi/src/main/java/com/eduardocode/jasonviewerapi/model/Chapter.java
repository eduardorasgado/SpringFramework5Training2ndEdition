package com.eduardocode.jasonviewerapi.model;

import java.util.Date;

/**
 * <h1>Chapter</h1>
 * Representa un capitulo dentro de la aplicacion. Hereda de Watchable.
 * <p>
 * Una serie posee varios o una lista de capitulos
 *
 * @author Eduardo Rasgado Ruiz
 * @see com.eduardocode.jasonviewerapi.model.Watchable
 * @see com.eduardocode.jasonviewerapi.model.Serie
 * @version 1.0
 * @since april/2019
 */
public class Chapter extends Watchable {
    private int duration;
    private Date startWatching;
    private Date stopWatching;
}
