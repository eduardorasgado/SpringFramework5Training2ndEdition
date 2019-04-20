package com.eduardocode.jasonviewerapi.services;

import com.eduardocode.jasonviewerapi.model.Cliente;

import java.util.List;

/**
 * <h1>IClienteService</h1>
 * Interfaz que permite la creacion de una clase de servicio de cliente
 *
 * @author Eduardo Rasgado Ruiz
 * @version 1.0
 * @since april/2019
 */
public interface IClienteService {
    /**
     * Metodo que crea un cliente a partir de una intancia proporcionada por el usuario
     *
     * @param cliente Instancia de cliente proveniente del frontend
     * @return Cliente Nuevo cliente creado
     */
    public Cliente create(Cliente cliente);

    /**
     * Metodo que actualiza un cliente existente a partir de un cliente proporcionado por
     * el user
     *
     * @param cliente Instancia de cliente con los nuevos datos
     * @return Cliente cliente actualizado y guardado en la base de datos
     */
    public Cliente update(Cliente cliente);

    /**
     * Metodo que elimina el cliente proporcionado
     *
     * @param cliente Cliente que va a ser borrado
     * @return un booleano dependiendo si se borra o no el cliente
     */
    public boolean delete(Cliente cliente);

    /**
     * Metodo que devuelve un cliente buscado a partir de su apellido
     *
     * @param apellido string con el apellido del cliente a buscar
     * @return El cliente deseado
     */
    public List<Cliente> findByApellido(String apellido);

    /**
     * Metodo que devuelve todos los clientes existentes dentro de la aplicacion
     * @return List<Cliente> lista de todos los clientes
     */
    public List<Cliente> getAll();

    /**
     * Metodo que devuelve un cliente dado el id de este
     *
     * @param id El id del cliente a buscar
     * @return Cliente Un cliente encontrado
     */
    public Cliente findById(String id);
}
