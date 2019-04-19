package com.eduardocode.jasonviewerapi.repository;

import com.eduardocode.jasonviewerapi.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * <h1>BookRepository</h1>
 * Repositorio del modelo de libro
 * <p>
 *     Hereda de JpaRepository con argumentos de clases Book y String
 *     Interfaz que representa la transaccionalidad entre la capa de servicio y el modelo
 *     de libro en la aplicacion.
 *
 * @author Eduardo Rasgado Ruiz
 * @see com.eduardocode.jasonviewerapi.model.Book
 * @version 1.0
 * @since april/2019
 */
@Repository
public interface BookRepository extends JpaRepository<Book, String> {
    //
}
