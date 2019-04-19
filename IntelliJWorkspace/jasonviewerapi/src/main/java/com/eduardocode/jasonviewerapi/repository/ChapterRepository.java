package com.eduardocode.jasonviewerapi.repository;

import com.eduardocode.jasonviewerapi.model.Chapter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

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

    /**
     * Metodo para conseguir una lista de capitulos que tengan las fechas requeridas
     *
     * @param startDate fecha de inicio de visualizacion
     * @param stopDate fecha de fin de visualizacion
     * @return lista de capitulos
     */
    @Query("Select c from Chapter c where c.startWatching =:startDate and c.stopWatching =:stopDate")
    public List<Chapter> find(@Param("startDate") Date startDate, @Param("stopDate") Date stopDate);
}
