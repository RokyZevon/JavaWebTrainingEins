package com.cnstrong.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cnstrong.dao.RolejdbcDao;
import com.cnstrong.entity.Role;
import com.cnstrong.iface.RoleDao;

@WebServlet("/role.update.servlet")
public class RoleUpdateServlet extends HttpServlet {
	private RoleDao roles =  new RolejdbcDao();
	private static final long serialVersionUID = 1L;
    public RoleUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		String ids =null == request.getParameter("ids")?"":request.getParameter("ids");
		String countpage =null == request.getParameter("countpage")?"":request.getParameter("countpage");
		if(!"".equals(ids))
		{
			int n = Integer.parseInt(ids);
			List<Role> list = roles.Roleselect(n);
			request.setAttribute("countpage", countpage);
			request.getSession().setAttribute("roles", list);
			request.getRequestDispatcher("views/roleupdate.jsp").forward(request, response);
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
