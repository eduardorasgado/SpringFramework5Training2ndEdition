package com.eduardocode.lightreserve.util;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * Clase para configurar la configuracion mas basica disponible con Spring security
 * @author cheetos
 *
 */
//con este tag el reconocimiento de esta configuracion es automatico
@Configuration
// con este tag, spring boot incorpora esta clase como su configuracion de seguridad
@EnableWebSecurity 
public class BasicSecurityConfiguration extends WebSecurityConfigurerAdapter{
	
	/**
	 * Metodo para una configuracion de logueo basica con la incorporacion de
	 * Spring Security
	 */
	protected void configure(HttpSecurity http) throws Exception {
		// desactivamos la configuracion para cross site request forgery
		http.csrf().disable()
		.authorizeRequests()
		.anyRequest()
		.authenticated()
		.and()
		// una vez iniciada la aplicacion se carga la sig ruta
		.formLogin().loginPage("/app/login").permitAll()
			// en caso de error al ser autorizado
			.failureUrl("/app/login?error=true")
			// en caso de ser autorizado para entrar, carga la ruta
			.defaultSuccessUrl("/app/home", true); // true para alwaysUse
		/*
		// trabajando con la configuracion del archivo application.properties
		http.authorizeRequests()
		.anyRequest().authenticated()
		.and()
		.formLogin()
		.and()
		.httpBasic();
		*/
	}
}
