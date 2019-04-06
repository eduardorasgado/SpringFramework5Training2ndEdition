package com.eduardocode.titanweb.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletLogin
 */
@WebServlet(description = "Servlet de logueo de usuarios, manipulamos la peticion de login", urlPatterns = { "/ServletLogin" })
public class ServletLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletLogin() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		// procesar la informacion que llega
		String usuario = request.getParameter("usuario");
		String empresa = request.getParameter("empresa");
		PrintWriter escritor = response.getWriter();
		escritor.println("");
		
		if(usuario != null && empresa != null) {
			if(empresa.equals("Platzi")) {
				escritor.println("Bienvenido a Platzi");
			} else {
				escritor.println("Bienvenido");
			}
		} else {
			escritor.println("usuario incorrecto");
		}
		escritor.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
