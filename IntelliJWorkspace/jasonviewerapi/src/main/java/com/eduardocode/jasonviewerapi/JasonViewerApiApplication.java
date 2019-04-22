package com.eduardocode.jasonviewerapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.TimeZone;

/**
 * <h1>JasonViewerApiApplication</h1>
 * Esta aplicacion permite la transmision de datos de la aplicacion jason viewer desde el servidor hasta el cliente
 * sea cual sea este cliente.
 * <p>
 * Implementa spring boot, spring security, data jpa y postgresql. Está dividido a traves de un patrín de diseño
 * modelo vista controlador y un patron de arquitectura de capas.
 *
 * @author Eduardo Rasgado Ruiz
 * @version 1.0
 * @since 2019
 */
@SpringBootApplication
public class JasonViewerApiApplication {

    /**
     * Metodo para configurar la zona horaria que se ocupara en toda la aplicacion
     */
    @PostConstruct
    void started() {
        // Central Daylight Time	Mexico City
        TimeZone.setDefault(TimeZone.getTimeZone("CDT"));
    }

    /**
     * Puerta de entrada inicial de la aplicacion
     * @param args argumentos no se utilizan en esta aplicacion
     */
    public static void main(String[] args) {

        SpringApplication.run(JasonViewerApiApplication.class, args);
    }

}
