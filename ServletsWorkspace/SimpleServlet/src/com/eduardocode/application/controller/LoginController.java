package com.eduardocode.application.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.eduardocode.application.bean.Login;

/**
 * Servlet implementation class LoginController
 */
@WebServlet(description = "Servlet que controla las peticiones para el sistema de logueo de la aplicacion.", urlPatterns = { "/login" })
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.sendRedirect("index.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		
		Login login = new Login();
		login.setName(name);
		login.setPassword(password);
		
		boolean authenticated = login.authentication();
		
		RequestDispatcher dispatcher = null;
		if(authenticated) {
			//response.sendRedirect("welcome.jsp");
			dispatcher = request.getRequestDispatcher("welcome.jsp");
		} else {
			//response.sendRedirect("error.jsp");
			dispatcher = request.getRequestDispatcher("error.jsp");
		}
		
		dispatcher.forward(request, response);
	}

}
