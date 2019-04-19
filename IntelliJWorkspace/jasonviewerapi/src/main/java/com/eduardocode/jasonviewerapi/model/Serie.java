package com.eduardocode.jasonviewerapi.model;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;


import javax.persistence.*;
import java.util.List;

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
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    private String id;
    private int seasonNumber;
    private String director;
    // el mismo nombre del objeto instanciado en la clase Chapter
    @OneToMany(mappedBy = "serie")
    // el contenedor debe de ser una coleccion de java, como un set o un list o queue
    private List<Chapter> chapters;
}
