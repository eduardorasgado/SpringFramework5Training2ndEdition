package com.eduardocode.jasonviewerapi.resources;

import com.eduardocode.jasonviewerapi.model.Movie;
import com.eduardocode.jasonviewerapi.services.IMovieService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
