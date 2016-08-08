package com.cnstrong.web.servlet;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		String state=request.getParameter("state"); 
		HttpSession usern = request.getSession();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		if ("login".equals(state))
		{
			if(username==null)
			{
				username = (String) usern.getAttribute("username");
			}
			if (password ==null) 
			{
				password = (String) usern.getAttribute("password");
			}
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
				if(map.size()==0)
				{
					request.setAttribute("h", "你暂时还没有任何权限！！！！！！");
				}
				else {
					request.setAttribute("h", "");
				}
				HttpSession session = request.getSession();
				session.setAttribute("username", username);
				session.setAttribute("password", password);
				request.getRequestDispatcher("views/main.jsp").forward(request, response);
			}
		}
		if("register".equals(state))
		{
			request.getRequestDispatcher("register.jsp").forward(request, response);
		}
		if("destroy".equals(state))
		{
			request.getSession().setAttribute("username", null);
			request.getSession().setAttribute("password", null);
			request.getRequestDispatcher("index.servlet").forward(request, response);
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
