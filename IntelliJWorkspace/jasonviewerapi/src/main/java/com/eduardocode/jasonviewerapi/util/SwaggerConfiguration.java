package com.eduardocode.jasonviewerapi.util;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * <h1>SwaggerConfiguration</h1>
 * Clase que permite habilitar todoo el soporte de swagger en el proyecto
 *
 * @author Eduardo Rasgado Ruiz
 * @version 1.0
 * @since april/2019
 */
@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

    /**
     * Meotod para que swagger pueda trabajar con todo aquello que este anotaddo con
     * la anotacion RestController
     * @return Un docket de configuracion
     */
    public Docket documentation(){
        return new Docket(DocumentationType.SWAGGER_2).select()
                .apis(RequestHandlerSelectors.withClassAnnotation(RestController.class))
                .paths(PathSelectors.any())
                .build();
    }
}
