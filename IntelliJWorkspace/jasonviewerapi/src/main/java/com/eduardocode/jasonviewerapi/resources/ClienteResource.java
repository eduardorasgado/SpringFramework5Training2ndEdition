package com.eduardocode.jasonviewerapi.resources;

import com.eduardocode.jasonviewerapi.model.Cliente;
import com.eduardocode.jasonviewerapi.resources.vo.ClienteVO;
import com.eduardocode.jasonviewerapi.services.IClienteService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <h1>ClienteResource</h1>
 * Clase que representa el servicio web del cliente
 *
 * @author Eduardo Rasgado Ruiz
 * @version 1.0
 * @since april/2019
 */
@RestController
@RequestMapping("/api/cliente")
@Api(tags = "cliente")
public class ClienteResource {

    private final IClienteService clienteService;

    public ClienteResource(IClienteService clienteService) {
        this.clienteService = clienteService;
    }

    /**
     * Metodo que regresa todos los clientes en una lista
     *
     * @author Eduardo Rasgado Ruiz
     * @return Un cliente nuevo con una respuesta http
     */
    //---------------DOCUMENTACION UI--------------------
    @ApiOperation(value = "Listar clientes", notes= "Servicio para listar todos los clientes")
    @ApiResponses(value = {
            @ApiResponse(
                    code = 201,
                    message = "Clientes encontrados"
            ),
            @ApiResponse(
                    code = 404,
                    message = "Clientes no encontrados"
            )
    })
    //---------------------------------------------------
    @GetMapping
    public ResponseEntity<List<Cliente>> getAll() {
        return ResponseEntity.ok(this.clienteService.getAll());
    }

    /**
     * Metodo para la creacion de un nuevo cliente por medio de recibir la entidad
     * de ese cliente
     *
     * @author Eduardo Rasgado Ruiz
     * @return Un cliente recien creado y una respuesta http
     */
    //---------------DOCUMENTACION UI--------------------
    @ApiOperation(value="Crear un nuevo cliente", notes = "Servicio para crear un cliente nuevo")
    @ApiResponses( value = {
            @ApiResponse(
                    code = 201,
                    message = "Cliente creado exitosamente"
            ),
            @ApiResponse(
                    code = 400,
                    message = "Solicitud invalida"
            )
    })
    //---------------------------------------------------
    @PostMapping
    public ResponseEntity<Cliente> create(@RequestBody ClienteVO clienteVo) {
        Cliente cliente = new Cliente();
        cliente = this.mappingClienteUtil(cliente, clienteVo);

        Cliente clienteSaved = this.clienteService.create(cliente);

        return new ResponseEntity<>(clienteSaved,
                HttpStatus.CREATED);
    }

    /**
     * Servicio o metodo para actualizar un cliente existente
     *
     * @author Eduardo Rasgado Ruiz
     * @param idCliente string de identificacion del cliente a actualizar
     * @param clienteVo cliente que fue resultado del binding del cuerpo del request
     * @return un cliente con un  estatus http
     */
    //---------------DOCUMENTACION UI--------------------
    @ApiOperation(value = "Actualizar un cliente", notes = "Actualizacion de un cliente que " +
            "realmente existe en los registros")
    @ApiResponses(value = {
            @ApiResponse(
                    code = 201,
                    message = "Se ha actualizado un empleado con exito"
            ),
            @ApiResponse(
                    code = 404,
                    message = "No se encuentra el cliente en los registros"
            )
    })
    //---------------------------------------------------
    @PutMapping("/{id}")
    public ResponseEntity<Cliente> update(@PathVariable("id") String  idCliente,
                                          @RequestBody ClienteVO clienteVo) {
        Cliente cliente = this.clienteService.findById(idCliente);
        if(cliente == null) {
            // en caso de que no exista el cliente a actualizar
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            cliente = this.mappingClienteUtil(cliente, clienteVo);
        }

        return new ResponseEntity<>(this.clienteService.update(cliente),
                HttpStatus.OK);
    }

    /**
     * Servicio para eliminar un cliente que existe en los registros
     *
     * @author Eduardo Rasgado Ruiz
     * @param idCliente String con el id perteneciente al cliente a eliminar
     * @return
     */
    @ApiOperation(value = "Servicio para eliminar un cliente", notes = "Eliminacion de un cliente " +
            "existente en los registros dado su id.")
    @ApiResponses(value = {
            @ApiResponse(
                    code = 200,
                    message = "Se ha eliminado el cliente exitosamente"
            ),
            @ApiResponse(
                    code = 404,
                    message = "No se ha encontrado el cliente"
            )
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Cliente> delete(@PathVariable("id") String idCliente) {
        Cliente cliente = this.clienteService.findById(idCliente);
        if(cliente != null) {
            if(this.clienteService.delete(cliente)){
                return new ResponseEntity<>(cliente, HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    /**
     * Utilidad para mapear un cliente a partir de un cliente virtual
     *
     * @param cliente El cliente vacio
     * @param clienteVo Un cliente virtual
     * @return El cliente con los datos del frontend
     */
    private Cliente mappingClienteUtil(Cliente cliente, ClienteVO clienteVo){
        cliente.setNombre(clienteVo.getNombre());
        cliente.setApellido(clienteVo.getApellido());
        cliente.setIdentificacion(clienteVo.getIdentificacion());
        cliente.setDireccion(clienteVo.getDireccion());
        cliente.setTelefono(clienteVo.getTelefono());
        cliente.setEmail(clienteVo.getEmail());
        // TODO: encriptacion de la password del cliente
        cliente.setPassword(clienteVo.getPassword());
        // activo por default
        cliente.setActiveAccount(true);
        return cliente;
    }
}
