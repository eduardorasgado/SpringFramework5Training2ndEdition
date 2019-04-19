package com.eduardocode.jasonviewerapi.repository;

import com.eduardocode.jasonviewerapi.model.Chapter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * <h1>ChapterRepository</h1>
 * Repositorio que opera la transaccionalidad entre la capa de servicio del negocio
 * y el modelo de los capitulos pertenecientes a una serie
 *
 * @author Eduardo Rasgado Ruiz
 * @see com.eduardocode.jasonviewerapi.model.Chapter
 * @version 1.0
 * @since april/2019
 */
@Repository
public interface ChapterRepository extends JpaRepository<Chapter, String> {
    //
}
