package com.eduardocode.lightreserve.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Paquete Controladores: No forma parte de la aplicacion principal y solo se
 * implementa por motivos de interfaz de usuario o empresa propietaria de esta API
 * con el sistema de login y acceso a la documentacion de esta API
 * 
 * LoginController: Controla el acceso al login personalizo para el propietario
 * de la API
 * 
 * @author cheetos
 *
 */

@Controller
@RequestMapping("/app")
public class LoginController {
	
	/**
	 * Metodo para acceder a la vista de logueo de la API mediante las rutas /login o /
	 * @return
	 */
	@GetMapping(value= {"/login", "/"})
	public ModelAndView login() {
		// este metodo no regresa un string como en spring mvc debido a que
		// no tenemos una carpeta WebContent y un dispatcher servlet que nos lleve
		// a configurar el acceso a ese folder.
		ModelAndView mav = new ModelAndView();
		
		String errorMessage="Sus credenciales pueden estar incorrectas, reviselas";
		
		// en spring boot dado que el acceso es a resources/static/templates, no
		// regresamos un string integrando con Model sino un ModelAndView
		mav.addObject("errorMsg", errorMessage);
		mav.setViewName("login"); // acceso a /templates/login.html
		return mav;
	}
	
	/**
	 * Metodo para acceder a la interfaz de administracion de la documentacion
	 * de la presente API
	 * @return
	 */
	@GetMapping("/home")
	public ModelAndView home() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("home");
		return mav;
	}
}
