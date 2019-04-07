package com.eduardocode.lightreserve.util;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Clase que va a permitir habilitar todo el soporte de swagger en el proyecto
 * @author cheetos
 *
 */
// anotacion para que sea reconicida en el contexto de spring
@Configuration
@EnableSwagger2
public class SwaggerConfiguration {
	// clase de springfox
	
	/**
	 * metodo para que swagger pueda trabajar con todo aquello que este anotado
	 * con la anotacion RestController
	 * @return
	 */
	public Docket documentation() {
		// a donde vamos a enlazar la configuracion: a swagger_2
		return new Docket(DocumentationType.SWAGGER_2).select()
				// las peticiones que van a manejarse se haran con requesthandler 
				// selectors
				.apis(RequestHandlerSelectors
						// swagger va a trabajar con las clases que tengan la anotacion
						// anotacion RestController
						.withClassAnnotation(RestController.class))
				// para hacer la seleccion o todos los elementos que son
				// servicios web
				.paths(PathSelectors.any())
				// hacer una construccion
				.build();
	}
}
