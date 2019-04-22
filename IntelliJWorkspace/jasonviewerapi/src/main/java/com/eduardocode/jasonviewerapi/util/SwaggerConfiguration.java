package com.eduardocode.jasonviewerapi.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
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

    @Value("${admin.doc.title}")
    private String docTitle;
    @Value("${admin.doc.description}")
    private String docDescription;
    @Value("${admin.doc.version}")
    private String docVersion;
    @Value("${admin.doc.license}")
    private String docLicense;
    @Value("${admin.doc.licenseUrl}")
    private String docLicenseUrl;
    @Value("${admin.doc.termsService}")
    private String termsService;
    @Value("${admin.contact}")
    private String contact;
    @Value("${admin.name}")
    private String adminName;

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title(docTitle)
                .description(docDescription)
                .license(docLicense)
                .licenseUrl(docLicenseUrl)
                .termsOfServiceUrl(termsService)
                .version(docVersion)
                .contact(new Contact(adminName,"", contact))
                .build();
    }

    /**
     * Meotod para que swagger pueda trabajar con todo aquello que este anotaddo con
     * la anotacion RestController
     * @return Un docket de configuracion
     */
    @Bean
    public Docket documentation(){
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.withClassAnnotation(RestController.class))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo());
    }
}
