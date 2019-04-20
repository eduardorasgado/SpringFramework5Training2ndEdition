package com.eduardocode.jasonviewerapi.services;

import com.eduardocode.jasonviewerapi.model.Chapter;

import java.util.List;

/**
 * <h1>IChapterService</h1>
 * Interfaz que permite la implementacion del servicio para la transaccion de capitulos en la
 * aplicacion
 * @author Eduardo Rasgado Ruiz
 * @version 1.0
 * @since april/2019
 */
public interface IChapterService {

    /**
     * Metodo que permite la creacion de un capitulo nuevo
     * @param chapter capitulo a crear
     * @return Capitulo creado
     */
    Chapter create(Chapter chapter);

    /**
     * Metodo para actualizar un capitulo ya existente
     * @param chapter Capitulo a actualizar
     * @return Capitulo ya actualizado
     */
    Chapter update(Chapter chapter);

    /**
     * Metodo para eliminar un capitulo a partir de una instancia de este
     * @param chapter capitulo a eliminar
     * @return booleano que representa si ya se ha eliminado o no el capitulo
     */
    boolean delete(Chapter chapter);

    /**
     * Metodo para devolver todos los capitulos existentes en la aplicacion
     * @return Devuelve una lista de capitulos {@code List<Chapter>}
     */
    List<Chapter> getAll();

    /**
     * Metodo para buscar y devolver un capitulo dado su id
     * @param id string con el id del capitulo deseado
     * @return Un capitulo de una serie
     */
    Chapter findById(String id);
}
