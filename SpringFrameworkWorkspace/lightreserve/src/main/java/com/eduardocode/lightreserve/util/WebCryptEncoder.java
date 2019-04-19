package com.eduardocode.lightreserve.util;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * Configurando un bean para configurar un cifrador de contrasena para la app
 * @author cheetos
 *
 */
@Configuration
public class WebCryptEncoder {
	
	/**
	 * Metodo para definir a bcryptpasswordencoder y darle la capacidad de autowired
	 * @return
	 */
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		return bCryptPasswordEncoder;
	}
}
