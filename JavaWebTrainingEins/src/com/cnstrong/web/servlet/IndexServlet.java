package com.cnstrong.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/index.servlet")
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public IndexServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Object username = request.getSession().getAttribute("username");
		Object password = request.getSession().getAttribute("password");
		if (username ==null||password==null) 
		{
			request.getRequestDispatcher("Login.jsp").forward(request, response);
		}
		else
		{
			request.getRequestDispatcher("login.servlet?state=login").forward(request, response);
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
