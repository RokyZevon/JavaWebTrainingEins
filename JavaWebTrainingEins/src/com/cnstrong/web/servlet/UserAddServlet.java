package com.cnstrong.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cnstrong.dao.UserjdbcDao;
import com.cnstrong.entity.User;
import com.cnstrong.iface.UserDao;


@WebServlet("/user.add.servlet")
public class UserAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public UserAddServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String countpage =null == request.getParameter("countpage")?"":request.getParameter("countpage");;
		request.setAttribute("countpage", countpage);
		request.getRequestDispatcher("views/useradd.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
