package com.cnstrong.web.servlet;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cnstrong.dao.UserjdbcDao;
import com.cnstrong.entity.Permission;
import com.cnstrong.iface.UserDao;

@WebServlet("/login.servlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     UserDao userDao = new UserjdbcDao();
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		int count=-1;
		count = userDao.Checked(username, password);
		if(count == -1)
		{
			request.setAttribute("errorLogin", "用户名或密码错误！");
			request.getRequestDispatcher("Login.jsp").forward(request, response);
		}
		else
		{
		
			Map<String, Permission> map =  userDao.getPermission(count);
			request.setAttribute("permission", map);
			request.getRequestDispatcher("views/main.jsp").forward(request, response);
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
