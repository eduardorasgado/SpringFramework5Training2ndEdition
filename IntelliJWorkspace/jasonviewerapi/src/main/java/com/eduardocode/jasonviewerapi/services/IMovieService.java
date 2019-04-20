package com.eduardocode.jasonviewerapi.services;

import com.eduardocode.jasonviewerapi.model.Movie;

import java.util.Date;
import java.util.List;

/**
 * <h1>IMovieService</h1>
 * Interfaz para el servicio de Peliculas
 *
 * @author Eduardo Rasgado Ruiz
 * @version 1.0
 * @since april/2019
 */
public interface IMovieService {

    /**
     * Metodo para crear una nueva pelicula
     *
     * @param movie Contiene los datos de la pelicula a crear
     * @return Pelicula que se acaba de crear
     */
    public Movie create(Movie movie);

    /**
     * Metodo para actualizar una pelicula existente
     *
     * @param movie Contiene los datos de la pelicula que se va a actualizar
     * @return La pelicula actualizada
     */
    public Movie update(Movie movie);

    /**
     * Metodo para eliminar una pelicula
     *
     * @param movie La pelicula a ser borrada
     * @return true o false en caso de que la pelicula haya sido borrada
     */
    public boolean delete(Movie movie);

    /**
     * Metodo para obtener una lista con todas las peliculas disponibles en la aplicacion
     *
     * @return Una lista de peliculas {@code List<Movie>}
     */
    public List<Movie> getAll();

    /**
     * Metodo para encontrar una pelicula con un id especifico
     * @param id un string con el id de la pelicula deseada
     * @return una entidad de pelicula
     */
    public Movie findById(String id);

    /**
     * Encuentra una pelicula con una hora de vista y de finalizacion de vista especificos
     *
     * @param startDate fecha de incio
     * @param stopDate fecha final
     * @return una lista de peliculas
     */
    public List<Movie> findAllWithDate(Date startDate, Date stopDate);
}
