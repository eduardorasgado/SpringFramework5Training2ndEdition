/**
 * 
 */
package com.eduardocode.lightreserve.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eduardocode.lightreserve.model.Cliente;

/**
 * Interfaz que define las operaciones de base de datos relacionadas con el
 * cliente
 * @author cheetos
 *
 */
public interface ClienteRepository extends JpaRepository<Cliente, String>{

}
