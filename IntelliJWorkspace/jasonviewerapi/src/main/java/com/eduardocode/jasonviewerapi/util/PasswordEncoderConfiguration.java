package com.eduardocode.jasonviewerapi.util;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * Bean de configuracion del encoder de passwords: encriptar passwords.
 *
 * @author Eduardo Rasgado Ruiz
 * @version 1.0
 * @since april/2019
 */
@Configuration
public class PasswordEncoderConfiguration {

    /**
     * Metodo para la configuracion del bean de encriptacion de passwords
     * @return un encoder de tipo {@code BCryptPasswordEncoder}
     */
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder;
    }
}
