package com.stock.servlets;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String user = request.getParameter("user");
        String pass = request.getParameter("pass");
        
        // Verificar las credenciales (aquí deberías implementar tu lógica de autenticación)
        // -------------------------------- INSERTAR AUTENTICACIÓN ------------------------------
        if ("usuario".equals(user) && "contraseña".equals(pass)) {
            // Iniciar sesión y redirigir al usuario a una página de bienvenida
            HttpSession session = request.getSession();
            session.setAttribute("username", user);
            //response.sendRedirect("welcome.jsp");
        } else {
            // Si las credenciales son incorrectas, redirigir al usuario de vuelta al formulario de inicio de sesión
            response.sendRedirect("login.html");
        }
	}

}
