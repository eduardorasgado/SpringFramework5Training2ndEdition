package com.eduardocode.jasonviewerapi.repository;

import com.eduardocode.jasonviewerapi.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

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
    /**
     * Metodo para buscar un cliente en base a su apellido
     *
     * @return List<Cliente> regresa una lista de Clientes
     * @param apellido apellido del usuario
     *  since april/2019
     */
    public List<Cliente> findByApellido(String apellido);

    /**
     * Busca un cliente dada una identificacion
     *
     * @param identificacion el campo de identificacion de un cliente
     * @return Cliente la entidad de un cliente
     * @since april/2019
     */
    public Cliente findByIdentificacion(String identificacion);

}
