package com.eduardocode.jasonviewerapi.repository;

import com.eduardocode.jasonviewerapi.model.Serie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * <h1>SerieRepository</h1>
 * Repositorio para la transsaccionalidad entre la capa de servicio del negocio y
 * la capa de modelo. Hereda de JpaRepository<Serie, String>
 *
 * @author Eduardo Rasgado Ruiz
 * @see com.eduardocode.jasonviewerapi.model.Serie
 * @version 1.0
 * @since april/2019
 */
@Repository
public interface SerieRepository extends JpaRepository<Serie, String> {
    //
}
