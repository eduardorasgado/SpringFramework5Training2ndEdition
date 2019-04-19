package com.eduardocode.jasonviewerapi.repository;

import com.eduardocode.jasonviewerapi.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * <h1>MovieRepository</h1>
 * Repositorio para las peliculas de la aplicacion. Hereda de JpaRepository
 * con argumentos Movie, String
 *
 * @author Eduardo Rasgado Ruiz
 * @see com.eduardocode.jasonviewerapi.model.Movie
 * @version 1.0
 * @since april/2019
 */
@Repository
public interface MovieRepository extends JpaRepository<Movie, String> {
    /**
     * Recuperando una lista de peliculas dado la fecha de visualizacion y termino de visualizacion
     *
     * @param startDate fecha de inicio de visualizacion
     * @param stopDate fecha de termino de visualizacion
     * @return lista de peliculas
     */
    @Query("Select m from Movie m where m.startWatching =:startDate and m.stopWatching =:stopDate")
    public List<Movie> find(@Param("startDate") Date startDate, @Param("stopDate") Date stopDate);
}
