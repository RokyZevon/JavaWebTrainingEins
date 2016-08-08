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

import com.cnstrong.entity.Role;
import com.cnstrong.service.iface.UserRoleService;
import com.cnstrong.services.UserRoleServiceImpl;

@WebServlet("/user.role.servlet")
public class UserRoleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static UserRoleService userRoleService = new UserRoleServiceImpl();
    public UserRoleServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		String userid =null == request.getParameter("userid")?"":request.getParameter("userid");
		String state = request.getParameter("state");
		String countpage = request.getParameter("countpage");
		if("init".equals(state)&&!"".equals(userid))
		{
			Map<String, Role> map = userRoleService.getRole(userid);
			request.setAttribute("roles", map);
			request.setAttribute("userid", userid);
			request.setAttribute("countpage", countpage);
			request.getRequestDispatcher("views/userrolemanager.jsp").forward(request, response);
		}
		if("update".equals(state))
		{
			String[] roleids = request.getParameterValues("roleids");
			if(roleids==null)
			{
				userRoleService.deleteRole(Integer.valueOf(userid));
			}
			else {
				List<Integer> list = new ArrayList<Integer>();
				for(String temp :roleids )
				{
					list.add(Integer.valueOf(temp));
				}
				userRoleService.updateRole(Integer.valueOf(userid), list);
			}
			request.getRequestDispatcher("user.role.servlet?state=init&userid="+userid).forward(request, response);
			
		}
 	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
