package com.eduardocode.jasonviewerapi.services;

import com.eduardocode.jasonviewerapi.model.Movie;
import com.eduardocode.jasonviewerapi.repository.MovieRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * <h1>MovieServiceImpl</h1>
 *
 * Implementacion de la interfaz IMovieService.
 * <p>
 * Servicio de transaccionalidad entre los repositorios de peliculas y
 * el frontend de la aplicacion.
 *
 * @author Eduardo Rasgado Ruiz
 * @version 1.0
 * @since april/2019
 */
@Service
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class MovieServiceImpl implements IMovieService {

    private MovieRepository movieRepository;

    public MovieServiceImpl(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }
    /**
     * Metodo para crear una nueva pelicula
     *
     * @param movie Contiene los datos de la pelicula a crear
     * @return Pelicula que se acaba de crear
     */
    @Override
    public Movie create(Movie movie) {
        return this.movieRepository.save(movie);
    }

    /**
     * Metodo para actualizar una pelicula existente
     *
     * @param movie Contiene los datos de la pelicula que se va a actualizar
     * @return La pelicula actualizada
     */
    @Override
    public Movie update(Movie movie) {
        return this.movieRepository.save(movie);
    }

    /**
     * Metodo para eliminar una pelicula
     *
     * @param movie La pelicula a ser borrada
     * @return true o false en caso de que la pelicula haya sido borrada
     */
    @Override
    public boolean delete(Movie movie) {
        if(this.movieRepository.findById(movie.getId()).isPresent()){
            this.movieRepository.delete(movie);
            return true;
        }
        return false;
    }

    /**
     * Metodo para obtener una lista con todas las peliculas disponibles en la aplicacion
     *
     * @return Una lista de peliculas {@code List<Movie>}
     */
    @Override
    public List<Movie> getAll() {
        return this.movieRepository.findAll();
    }

    /**
     * Metodo para encontrar una pelicula con un id especifico
     *
     * @param id un string con el id de la pelicula deseada
     * @return una entidad de pelicula
     */
    @Override
    public Movie findById(String id) {
        Optional<Movie> movieContainer = this.movieRepository.findById(id);
        if(movieContainer.isPresent()){
            return movieContainer.get();
        }
        return null;
    }

    /**
     * Encuentra una pelicula con una hora de vista y de finalizacion de vista especificos
     *
     * @param startDate fecha de incio
     * @param stopDate  fecha final
     * @return una lista de peliculas
     */
    @Override
    public List<Movie> findAllWithDate(Date startDate, Date stopDate) {
        return this.movieRepository.find(startDate, stopDate);
    }
}
