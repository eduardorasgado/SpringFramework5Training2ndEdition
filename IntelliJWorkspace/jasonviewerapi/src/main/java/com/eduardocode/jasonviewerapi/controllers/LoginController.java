package com.eduardocode.jasonviewerapi.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * <h1>LoginController</h1>
 * Controlador para los request de la sesion del administrador
 *
 * @author Eduardo Rasgado Ruiz
 * @version 1.0
 * @since april/2019
 */
@Controller
@RequestMapping("/app")
public class LoginController {


    /**
     * Metodo para la ruta del login en caso de accesar a /login o /
     * @return retorna una vista a login
     */
    @GetMapping({"/login", "/"})
    public ModelAndView login() {
        ModelAndView mav = new ModelAndView();

        String errorMessage = "Sus credenciales son incorrectas, compruebe de nuevo.";

        mav.addObject("errorMsg", errorMessage);
        // templates/login.html
        mav.setViewName("login");
        return mav;
    }


    /**
     * Metodo para la redireccion a la ruta de home
     * @return Una vista a home
     */
    @GetMapping("/home")
    public ModelAndView home() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("home");
        return mav;
    }
}
