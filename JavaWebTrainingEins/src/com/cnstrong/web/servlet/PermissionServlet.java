package com.cnstrong.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cnstrong.dao.PermissionjdbcDao;
import com.cnstrong.entity.Page;
import com.cnstrong.entity.Permission;
import com.cnstrong.iface.PermissionDao;


@WebServlet("/permission.servlet")
public class PermissionServlet extends HttpServlet {
	private  PermissionDao permissions = new PermissionjdbcDao();
	private static final long serialVersionUID = 1L;
    public PermissionServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		String state = request.getParameter("state");
		String ids = null == request.getParameter("ids")?"":request.getParameter("ids");
		String countpage= null==request.getParameter("countpage")?"":request.getParameter("countpage");
		String newids=new String(ids.getBytes("ISO8859-1"), "UTF-8");
		if("delete".equals(state)&&!"".equals(newids))
		{
			String[] states = ids.split(",");
			for(int  i = 0;i<states.length;i++)
			{
				int n = Integer.parseInt(states[i]);
				permissions.Permissiondelete(n);
			}
			request.getRequestDispatcher("permission.servlet?state=init").forward(request, response);
		}
		if("add".equals(state)&&!"".equals(newids))
		{
			String[] states = newids.split(",");
			permissions.Permissionadd(states[0], states[1], states[2]);
			request.getRequestDispatcher("permission.servlet?state=init").forward(request, response);
		}
		if ("update".equals(state)&&!"".equals(newids)) 
		{
			String[] states = newids.split(",");
			int n = Integer.parseInt(states[0]);
			permissions.Permissionupdate(n, states[1], states[2], states[3]);
			request.getRequestDispatcher("permission.servlet?state=init").forward(request, response);
		}
		if("init".equals(state))
		{
			if(countpage=="")
			{
				countpage="1";
			}
			Page<Permission> page = new Page<Permission>();
			page.setCountpage(Integer.valueOf(countpage));
			page.setTotalrows(permissions.getTotalRows());
			if(page.getTotalrows()%page.getPagenumber()==0)
			{
				page.setTotalpages(page.getTotalrows()/page.getPagenumber());
			}
			else{
				page.setTotalpages(page.getTotalrows()/page.getPagenumber()+1);
			}
			permissions.queryallBypage(page);
			request.setAttribute("page", page);
			request.getRequestDispatcher("views/permissionmanager.jsp").forward(request, response);
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
