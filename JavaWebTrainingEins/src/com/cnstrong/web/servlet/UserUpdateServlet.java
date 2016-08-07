package com.cnstrong.web.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cnstrong.dao.UserjdbcDao;
import com.cnstrong.entity.User;
import com.cnstrong.iface.UserDao;


@WebServlet("/user.update.servlet")
public class UserUpdateServlet extends HttpServlet {
	private UserDao users =  new UserjdbcDao();
	private static final long serialVersionUID = 1L;
    public UserUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		String ids =null == request.getParameter("ids")?"":request.getParameter("ids");
		String countpage =null == request.getParameter("countpage")?"":request.getParameter("countpage");
		if(!"".equals(ids))
		{
			int n = Integer.parseInt(ids);
			List<User> list = users.Userselect(n);
			request.setAttribute("users", list);
			request.setAttribute("countpage", countpage);
			request.getRequestDispatcher("views/userupdate.jsp").forward(request, response);
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
