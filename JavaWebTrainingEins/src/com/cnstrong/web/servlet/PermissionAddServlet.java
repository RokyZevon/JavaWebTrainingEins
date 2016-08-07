package com.cnstrong.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/permission.add.servlet")
public class PermissionAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public PermissionAddServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String countpage =null == request.getParameter("countpage")?"":request.getParameter("countpage");;
		request.setAttribute("countpage", countpage);
		request.getRequestDispatcher("views/permissionadd.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
