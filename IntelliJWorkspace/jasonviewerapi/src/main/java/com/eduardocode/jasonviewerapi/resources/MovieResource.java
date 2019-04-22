package com.eduardocode.jasonviewerapi.resources;

import com.eduardocode.jasonviewerapi.model.Movie;
import com.eduardocode.jasonviewerapi.resources.vo.MovieVO;
import com.eduardocode.jasonviewerapi.services.IMovieService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <h1>MovieResource</h1>
 * Clase que representa el servicio web de peliculas
 *
 * @author Eduardo Rasgado Ruiz
 * @version 1.0
 * @since april/2019
 */
@RestController
@RequestMapping("/movie")
@Api(tags = "movie")
public class MovieResource {

    private final IMovieService movieService;

    public MovieResource(IMovieService movieService) {
        this.movieService = movieService;
    }

    /**
     * Metodo para obtener una lista de todas las peliculas dentro del sistema
     *
     * @return Lista de peliculas
     */
    //----------------------DOCUMENTACION  UI----------------
    @ApiOperation(value = "Conseguir todas las peliculas", notes = "Devuelve una lista de todas las" +
            "peliculas registradas en la db de la aplicacion")
    @ApiResponses(value = {
            @ApiResponse(
                    code = 201,
                    message = "Las peliculas han sido encontradas"
            ),
            @ApiResponse(
                    code = 400,
                    message = "Peticion invalida"
            ),
            @ApiResponse(
                    code = 404,
                    message = "Peliculas no encontradas"
            )
    })
    //-------------------------------------------------------
    @GetMapping
    public ResponseEntity<List<Movie>> getAll(){
        return ResponseEntity.ok(this.movieService.getAll());
    }

    /**
     * Metodo para la creacion de una nueva pelicula a partir de los datos desde el cliente
     *
     * @author Eduardo Rasgado Ruiz
     * @param movieVo Objeto virtual con datos de la nueva pelicula
     * @return la nueva pelicula con un estatus http
     */
    @ApiOperation(value = "Servicio de Creacion de una nueva pelicula", notes = "Se crea una" +
            " pelicula en base a un objeto virtual enviado desde el frontend. Devuelve un objeto de" +
            "pelicula en caso de tener exito")
    @ApiResponses(value = {
            @ApiResponse(
                    code = 201,
                    message = "Se ha creado una pelicula con exito"
            ),
            @ApiResponse(
                    code = 400,
                    message = "Solicitud invalida"
            )
    })
    @PostMapping
    public ResponseEntity<Movie> create(@RequestBody  MovieVO movieVo) {
        Movie movie = new Movie();

        movie = this.movieMappingUtil(movie, movieVo);

        return new ResponseEntity<Movie>(this.movieService.create(movie),
                HttpStatus.CREATED);
    }

    /**
     * Metodo para actualizar una pelicula que existe en los registros
     *
     * @param idMovie String de identificacion de la pelicula a actualizar
     * @param movieVo datos nuevos de la pelicula a ser actualizada
     * @return la pelicula ya actualizada
     */
    //------------------DOCUMENTACION UI--------------------------------
    @ApiOperation(value = "Servicio para actualizacion de una pelicula", notes = "Una pelicula debe" +
            "de estar registrada en la db para ser actualizada, se requiere de igual manera el id" +
            "de la pelicula y un json con todos los campos de la entidad pelicula")
    @ApiResponses(value = {
            @ApiResponse(
                    code = 201,
                    message = "Se ha actualizado una pelicula con exito"
            ),
            @ApiResponse(
                    code = 404,
                    message = "No se encuentra la pelicula en los registros"
            )
    })
    //------------------------------------------------------------------
    @PutMapping("/{id}")
    public ResponseEntity<Movie> update(@PathVariable("id") String idMovie,
                                        @RequestBody MovieVO movieVo){
        Movie movie = this.movieService.findById(idMovie);
        if(movie != null) {
            movie = this.movieMappingUtil(movie, movieVo);
            return new ResponseEntity<>(this.movieService.update(movie), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    /**
     * Metodo para eliminar una pelicula existente en los registros
     *
     * @param idMovie String con el identificador de la pelicula a eliminar
     * @return la pelicula que se ha eliminado o un estado http de no enccontrado
     */
    //------------------DOCUMENTACION UI--------------------------------
    @ApiOperation(value = "Servicio para eliminar una pelicula", notes = "Eliminar una pelicula" +
            "requiere su id, y por otro lado es requisito que la pelicula a eliminar exista" +
            "en los registros")
    @ApiResponses(value = {
            @ApiResponse(
                    code = 200,
                    message = "Se ha eliminado la pelicula exitosamente"
            ),
            @ApiResponse(
                    code = 404,
                    message = "No se ha encontrado la pelicula"
            )
    })
    //------------------------------------------------------------------
    @DeleteMapping("/{id}")
    public ResponseEntity<Movie> delete(@PathVariable("id") String idMovie) {
        Movie movie = this.movieService.findById(idMovie);
        if(movie != null){
            if(this.movieService.delete(movie)){
                return new ResponseEntity<>(movie, HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    private Movie movieMappingUtil(Movie movie, MovieVO movieVo) {

        String voidString = "";
        if(!movieVo.getTitle().equals(voidString)){
            movie.setTitle(movieVo.getTitle());
        }
        if(!movieVo.getGenre().equals(voidString)) {
            movie.setGenre(movieVo.getGenre());
        }
        if(movieVo.getProductionYear().shortValue() != 0){
            movie.setProductionYear(movieVo.getProductionYear().shortValue());
        }

        movie.setView(movieVo.isView());

        if(!movieVo.getDirector().equals(voidString)){
            movie.setDirector(movieVo.getDirector());
        }
        if(movieVo.getDuration() != 0){
            movie.setDuration(movieVo.getDuration());
        }
        if(movieVo.getTimeViewed() != null){
            movie.setTimeViewed(movieVo.getTimeViewed());
        }
        if(movieVo.getStartWatching() != null) {
            movie.setStartWatching(movieVo.getStartWatching());
        }
        if(movieVo.getStopWatching() != null) {
            movie.setStopWatching(movieVo.getStopWatching());
        }

        return movie;
    }
}
