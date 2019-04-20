package com.eduardocode.jasonviewerapi.services;


import com.eduardocode.jasonviewerapi.model.Serie;
import com.eduardocode.jasonviewerapi.repository.SerieRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

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
@Service
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class SerieServiceImpl implements ISerieService {

    private SerieRepository serieRepository;

    public SerieServiceImpl(SerieRepository serieRepository) {
        this.serieRepository = serieRepository;
    }
    /**
     * Metodo para crear series
     *
     * @param serie Una instancia de serie con los datos de la creacion
     *              de la serie nueva
     * @return la serie creada
     */
    @Override
    public Serie create(Serie serie) {
        return this.serieRepository.save(serie);
    }

    /**
     * Metodo para actualizar una serie existente
     *
     * @param serie Una serie con los datos nuevos a ser actualizados
     * @return la serie que fue actualizada
     */
    @Override
    public Serie update(Serie serie) {
        return this.serieRepository.save(serie);
    }

    /**
     * Metodo para eliminar una serie
     *
     * @param serie La instancia de la serie a ser eliminada
     * @return un booleano que identifica si fue o no eliminada la serie
     */
    @Override
    public boolean delete(Serie serie) {
        if(this.serieRepository.findById(serie.getId()).isPresent()) {
            this.serieRepository.delete(serie);
            return true;
        }
        return false;
    }

    /**
     * Meotodo para conseguir todas las series del reporsitorio
     *
     * @return Una lista con todas las series existentes en la aplicacion
     */
    @Override
    public List<Serie> getAll() {
        return this.serieRepository.findAll();
    }

    /**
     * Metodo para conseguir una serie existente a partir de su id
     *
     * @param id el id de la serie que se busca
     * @return la serie que se buscaba
     */
    @Override
    public Serie findById(String id) {
        Optional<Serie> serieContainer = this.serieRepository.findById(id);
        if(serieContainer.isPresent()) {
            return serieContainer.get();
        }
        return null;
    }
}
