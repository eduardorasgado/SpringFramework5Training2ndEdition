package com.eduardocode.jasonviewerapi.resources.vo;

import lombok.Data;

/**
 * Clase virtual de objeto watchable o mirable, para la creacion hereditaria de pojos
 *
 * @author Eduardo Rasgado Ruiz
 * @version 1.0
 * @since april/2019
 */
@Data
public class WatchableVO {
    private String title;
    private String genre;
    private Integer productionYear;
    private boolean view;
}
