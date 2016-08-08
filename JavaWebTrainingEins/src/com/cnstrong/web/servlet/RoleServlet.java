package com.cnstrong.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cnstrong.dao.RolejdbcDao;
import com.cnstrong.entity.Page;
import com.cnstrong.entity.Role;
import com.cnstrong.iface.RoleDao;

@WebServlet("/role.servlet")
public class RoleServlet extends HttpServlet {
	private  RoleDao roles = new RolejdbcDao();
	private static final long serialVersionUID = 1L;
    public RoleServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		String state = request.getParameter("state");
		String ids = null == request.getParameter("ids")?"":request.getParameter("ids");
		String countpage = null == request.getParameter("countpage")?"":request.getParameter("countpage");
		String newids=new String(ids.getBytes("ISO8859-1"), "UTF-8");
		if("delete".equals(state)&&!"".equals(newids))
		{
			String[] states = newids.split(",");
			for(int  i = 0;i<states.length;i++)
			{
				int n = Integer.parseInt(states[i]);
				roles.Roledelete(n);
			}
			request.getRequestDispatcher("role.servlet?state=init").forward(request, response);
		}
		if("add".equals(state)&&!"".equals(newids))
		{
			String[] states = newids.split(",");
			roles.Roleadd(states[0], states[1]);
			request.getRequestDispatcher("role.servlet?state=init").forward(request, response);
		}
		if ("update".equals(state)&&!"".equals(newids)) {
			String[] states = newids.split(",");
			int n = Integer.parseInt(states[0]);
			roles.Roleupdate(n, states[1], states[2]);
			request.getRequestDispatcher("role.servlet?state=init").forward(request, response);
		}
		if("init".equals(state))
		{
			if(countpage=="")
			{
				countpage = "1";
			}
			Page<Role> page = new Page<Role>();
			page.setCountpage(Integer.parseInt(countpage));
			page.setTotalrows(roles.getTotalRows());
			if(page.getTotalrows()%page.getPagenumber()==0)
			{
				page.setTotalpages(page.getTotalrows()/page.getPagenumber());
			}
			else {
				page.setTotalpages(page.getTotalrows()/page.getPagenumber()+1);
			}
			roles.queryallBypage(page);
			request.setAttribute("page", page);
			request.getRequestDispatcher("views/rolemanager.jsp").forward(request, response);
		}
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
