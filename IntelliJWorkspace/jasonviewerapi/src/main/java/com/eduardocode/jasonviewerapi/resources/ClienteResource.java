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
     * @return
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
     * @return Un cliente recien creado
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
