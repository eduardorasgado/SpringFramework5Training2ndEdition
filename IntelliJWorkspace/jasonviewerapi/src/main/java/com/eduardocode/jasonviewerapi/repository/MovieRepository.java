package com.eduardocode.jasonviewerapi.repository;

import com.eduardocode.jasonviewerapi.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

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
    //
}
