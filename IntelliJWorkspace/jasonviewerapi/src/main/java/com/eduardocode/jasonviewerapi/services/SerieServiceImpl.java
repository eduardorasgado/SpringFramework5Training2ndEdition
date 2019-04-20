package com.eduardocode.jasonviewerapi.services;


import com.eduardocode.jasonviewerapi.model.Serie;

import java.util.List;

/**
 * <h1>SerieServiceImpl</h1>
 * Implementacion de la interfaz de servicio para las series
 * <p>
 * Desarrolla la interaccion y transacciones en la capa de servicio con los
 * repositorios de la serie
 *
 * @author Eduardo Rasgado Ruiz
 * @version 1.0
 * @since april/2019
 */
public class SerieServiceImpl implements ISerieService {
    /**
     * Metodo para crear series
     *
     * @param serie Una instancia de serie con los datos de la creacion
     *              de la serie nueva
     * @return la serie creada
     */
    @Override
    public Serie create(Serie serie) {
        return null;
    }

    /**
     * Metodo para actualizar una serie existente
     *
     * @param serie Una serie con los datos nuevos a ser actualizados
     * @return la serie que fue actualizada
     */
    @Override
    public Serie update(Serie serie) {
        return null;
    }

    /**
     * Metodo para eliminar una serie
     *
     * @param serie La instancia de la serie a ser eliminada
     * @return un bookeano que identifica si fue o no eliminada la serie
     */
    @Override
    public boolean delete(Serie serie) {
        return false;
    }

    /**
     * Meotodo para conseguir todas las series del reporsitorio
     *
     * @return Una lista con todas las series existentes en la aplicacion
     */
    @Override
    public List<Serie> getAll() {
        return null;
    }

    /**
     * Metodo para conseguir una serie existente a partir de su id
     *
     * @param id el id de la serie que se busca
     * @return la serie que se buscaba
     */
    @Override
    public Serie findById(String id) {
        return null;
    }
}
