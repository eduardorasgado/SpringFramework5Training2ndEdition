package com.eduardocode.jasonviewerapi.services;

import com.eduardocode.jasonviewerapi.model.Serie;

import java.util.List;

/**
 *<h1>ISerieService</h1>
 * Interfaz para implementar la transaccionalidad entre el repositorio de series
 * y el rest controller
 *
 * @author Eduardo Rasgado Ruiz
 * @version 1.0
 * @since april/2019
 */
public interface ISerieService {

    /**
     * Metodo para crear series
     *
     * @param serie Una instancia de serie con los datos de la creacion
     *              de la serie nueva
     * @return la serie creada
     */
    public Serie create(Serie serie);

    /**
     * Metodo para actualizar una serie existente
     *
     * @param serie Una serie con los datos nuevos a ser actualizados
     * @return la serie que fue actualizada
     */
    public Serie update(Serie serie);

    /**
     * Metodo para eliminar una serie
     *
     * @param serie La instancia de la serie a ser eliminada
     * @return un bookeano que identifica si fue o no eliminada la serie
     */
    public boolean delete(Serie serie);

    /**
     * Meotodo para conseguir todas las series del reporsitorio
     * @return Una lista con todas las series existentes en la aplicacion
     */
    public List<Serie> getAll();

    /**
     * Metodo para conseguir una serie existente a partir de su id
     *
     * @param id el id de la serie que se busca
     * @return la serie que se buscaba
     */
    public Serie findById(String id);
}
