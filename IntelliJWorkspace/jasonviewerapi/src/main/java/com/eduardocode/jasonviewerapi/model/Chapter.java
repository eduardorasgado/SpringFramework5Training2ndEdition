package com.eduardocode.jasonviewerapi.model;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
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
@Data
@Entity
@Table(name="chapter")
public class Chapter extends Watchable {
    @Id
    // generadores de hibernate
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid2")
    private String id;
    private int duration;
    @Temporal(TemporalType.DATE)
    private Date startWatching;
    @Temporal(TemporalType.DATE)
    private Date stopWatching;

    @ManyToOne
    @JoinColumn(name = "idSerie")
    private Serie serie;
}
