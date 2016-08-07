package com.cnstrong.web.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cnstrong.entity.Permission;
import com.cnstrong.service.iface.PermissionRoleService;
import com.cnstrong.services.PermissionRoleServiceImpl;

@WebServlet("/permission.role.servlet")
public class PermissionRoleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	PermissionRoleService permissionRoleService = new PermissionRoleServiceImpl();
	public PermissionRoleServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		String state = request.getParameter("state");
		String roleid = null == request.getParameter("roleid")?"":request.getParameter("roleid");

		if("init".equals(state)&&!"".equals(roleid))
		{
			Map<String, Permission> map = permissionRoleService.getpermission(roleid);
			request.setAttribute("permissions", map);
			request.setAttribute("roleid", roleid);
			request.getRequestDispatcher("views/permissionrolemanager.jsp").forward(request, response);
		}
		if ("update".equals(state)) 
		{
			String[] permissionids = request.getParameterValues("permissionids");
			if(permissionids==null)
			{
				permissionRoleService.deletePermission(Integer.valueOf(roleid));
			}
			else
			{
				List<Integer> list = new ArrayList<Integer>();
				for(String temp:permissionids)
				{
					list.add(Integer.valueOf(temp));
				}
				permissionRoleService.updatePermission(Integer.valueOf(roleid), list);
			}
			request.getRequestDispatcher("permission.role.servlet?state=init&roleid="+roleid).forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
