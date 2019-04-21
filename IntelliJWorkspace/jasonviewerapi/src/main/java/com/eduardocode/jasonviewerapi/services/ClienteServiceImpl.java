package com.eduardocode.jasonviewerapi.services;

import com.eduardocode.jasonviewerapi.model.Cliente;
import com.eduardocode.jasonviewerapi.repository.ClienteRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * <h1>ClienteServiceImplementation</h1>
 * Implementacion de la interfaz de servicio de cliente
 * <p>
 *     Entabla la transaccionalidad en la capa de servicio para las entidades de
 *     tipo cliente
 * @author Eduardo Rasgado Ruiz
 * @version 1.0
 * @since april/2019
 */
@Service
@Transactional(readOnly = false, rollbackFor = Exception.class, propagation = Propagation.REQUIRES_NEW)
public class ClienteServiceImpl implements IClienteService {

    private final ClienteRepository clienteRepository;

    public ClienteServiceImpl(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    /**
     * Metodo que crea un cliente a partir de una intancia proporcionada por el usuario
     *
     * @param cliente Instancia de cliente proveniente del frontend
     * @return Cliente Nuevo cliente creado
     */
    @Override
    public Cliente create(Cliente cliente) {
        return this.clienteRepository.save(cliente);
    }

    /**
     * Metodo que actualiza un cliente existente a partir de un cliente proporcionado por
     * el user
     *
     * @param cliente Instancia de cliente con los nuevos datos
     * @return Cliente cliente actualizado y guardado en la base de datos
     */
    @Override
    public Cliente update(Cliente cliente) {
        return this.clienteRepository.save(cliente);
    }

    /**
     * Metodo que elimina el cliente proporcionado
     *
     * @param cliente Cliente que va a ser borrado
     * @return un booleano dependiendo si se borra o no el cliente
     */
    @Override
    public boolean delete(Cliente cliente) {
        Optional<Cliente> clienteToDelete = clienteRepository.findById(cliente.getId());
        if(clienteToDelete.isPresent()) {
            clienteRepository.delete(cliente);
            return true;
        }
        return false;
    }

    /**
     * Metodo que devuelve un cliente buscado a partir de su apellido
     *
     * @param apellido string con el apellido del cliente a buscar
     * @return El cliente deseado
     */
    @Override
    @Transactional(readOnly = true)
    public List<Cliente> findByApellido(String apellido) {
       return this.clienteRepository.findByApellido(apellido);
    }

    /**
     * Metodo que devuelve todos los clientes existentes dentro de la aplicacion
     * @return List<Cliente> lista de todos los clientes
     */
    @Override
    @Transactional(readOnly = true)
    public List<Cliente> getAll() {
        return this.clienteRepository.findAll();
    }

    /**
     * Metodo que devuelve un cliente dado el id de este
     *
     * @param id El id del cliente a buscar
     * @return Cliente Un cliente encontrado
     */
    @Override
    @Transactional(readOnly = true)
    public Cliente findById(String id) {
        Optional<Cliente> clienteContainer = this.clienteRepository.findById(id);
        if(clienteContainer.isPresent()){
            return clienteContainer.get();
        }
        return null;
    }
}
