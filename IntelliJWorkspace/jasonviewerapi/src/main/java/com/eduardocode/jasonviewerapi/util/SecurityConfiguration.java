package com.eduardocode.jasonviewerapi.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.sql.DataSource;

/**
 * <h1>SecurityConfiguration</h1>
 * Clase de configuracion para el manejo de seguridad en la aplicacion
 * Hereda de {@code WebSecurityConfigurerAdapter}.
 *
 * @author Eduardo Rasgado Ruiz
 * @version 1.0
 * @since april/2019
 */
@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource  dataSource;

    @Autowired
    private BCryptPasswordEncoder encoder;

    @Value("${spring.queries.users-query}")
    private String usernameQuery;
    @Value("${spring.queries.roles-query}")
    private String authoritiesQuery;

    private String loginUrl;
    private String failureLoginUrl;
    private String homePage;

    public SecurityConfiguration() {
        this.loginUrl = "/app/login";
        this.failureLoginUrl = "/app/login?error=true";
        this.homePage = "/app/home";
    }
    /**
     * Metodo para una configuracion de logueo basica de spring security
     * @param http objeto principal de configuracion
     * @throws Exception
     */
    protected void configure(HttpSecurity http) throws Exception {
        // desactivacion de la proteccion cross site request forgery
        http .csrf().disable()
                // autorizar todas las request, tiene que estar auntenticado
                .authorizeRequests()
                .anyRequest()
                .authenticated()
                // una vez logueado
                .and()
                .formLogin().loginPage(loginUrl).permitAll()
                // en caso de fallar la autorizacion
                .failureUrl(failureLoginUrl)
                // una vez logueado, a donde ir, true es para alwaysUse
                .defaultSuccessUrl(homePage, true)
                .and()
                // salir de la session, solo basta con poner un link a '/logout'
                .logout();
    }

    /**
     * Configuracion de acceso a la base de datos para spring, con el fin de loguear al administrador
     * o usuarios que van a acceder al sistema
     * @param auth Instancia de configuracion de acceso
     * @throws Exception
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication()
                .dataSource(dataSource)
                .usersByUsernameQuery(usernameQuery)
                .authoritiesByUsernameQuery(authoritiesQuery)
                .passwordEncoder(encoder);
    }

    /**
     * Metodo que defie las rutas de la applicacion que deben de ser ignoradas por la logica del
     * login
     * @param web instancia de configuracion web
     * @throws Exception
     */
    @Override
    public void configure(WebSecurity web) throws  Exception {
        web.ignoring().antMatchers(
                "/resources/**",
                "/static/**",
                "/css/**",
                "/js/**",
                "/images/**"
        );
    }
}
