package com.cnstrong.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cnstrong.dao.PermissionjdbcDao;
import com.cnstrong.entity.Permission;
import com.cnstrong.iface.PermissionDao;


@WebServlet("/permission.update.servlet")
public class PermissionUpdateServlet extends HttpServlet {
	private PermissionDao permissions =  new PermissionjdbcDao();
	private static final long serialVersionUID = 1L;
    public PermissionUpdateServlet() {
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
			List<Permission> list = permissions.Permissionselect(n);
			request.setAttribute("permissions", list);
			request.setAttribute("countpage", countpage);
			request.getRequestDispatcher("views/permissionupdate.jsp").forward(request, response);
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
