package com.eduardocode.jasonviewerapi.repository;

import com.eduardocode.jasonviewerapi.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * <h1>ClienteRepository</h1>
 * Repositorio de el modelo Cliente
 * <p>
 *     Representa la transaccionalidad entre el modelo del cliente y la capa de
 *     servicio de la aplicacion
 *
 * @author Eduardo Rasgado Ruiz
 * @see com.eduardocode.jasonviewerapi.model.Cliente
 * @version 1.0
 * @since april/2019
 */
@Repository
public interface ClienteRepository extends JpaRepository<Cliente, String> {
    //
}
