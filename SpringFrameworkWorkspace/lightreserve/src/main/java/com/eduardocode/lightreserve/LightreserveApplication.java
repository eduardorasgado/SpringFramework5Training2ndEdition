package com.eduardocode.lightreserve;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

/**
 * clase principal del api mediante el cual corre spring boot
 * @author cheetos
 *
 */
// exclude ... con esto spring boot ignorara la configuracion de seguridad
// por default para usar la configurada usando spring security en:
@SpringBootApplication(exclude= {SecurityAutoConfiguration.class})
public class LightreserveApplication {

	public static void main(String[] args) {
		SpringApplication.run(LightreserveApplication.class, args);
	}

}
