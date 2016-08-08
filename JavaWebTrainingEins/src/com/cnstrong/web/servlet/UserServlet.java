package com.cnstrong.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cnstrong.dao.UserjdbcDao;
import com.cnstrong.entity.Page;
import com.cnstrong.entity.User;
import com.cnstrong.iface.UserDao;

@WebServlet("/user.servlet")
public class UserServlet extends HttpServlet {
	private  UserDao users = new UserjdbcDao();
	private static final long serialVersionUID = 1L;
    public UserServlet() {
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
		if("register".equals(state)&&!"".equals(newids))
		{
			String[] states = newids.split(",");
			boolean flag= false;
			flag = users.UserselectByName(states[0]);
			if(flag)
			{
				request.setAttribute("Word", "用户名已存在，请重新输入！！！");
				request.getRequestDispatcher("register.jsp").forward(request, response);
			}
			else
			{
				users.Useradd(states[0], states[1], states[2]);
				request.getRequestDispatcher("index.servlet").forward(request, response);
			}
		}
		if("add".equals(state)&&!"".equals(newids))
		{
			String[] states = newids.split(",");
			boolean flag= false;
			flag = users.UserselectByName(states[0]);
			if(flag)
			{
				request.setAttribute("Word", "用户名已存在，请重新输入！！！");
				request.setAttribute("countpage", countpage);
				request.getRequestDispatcher("views/useradd.jsp").forward(request, response);
			}
			else
			{
				users.Useradd(states[0], states[1], states[2]);
				request.getRequestDispatcher("user.servlet?state=init").forward(request, response);
			}
		}
		if("delete".equals(state)&&!"".equals(newids))
		{
			String[] states = ids.split(",");
			for(int  i = 0;i<states.length;i++)
			{
				int n = Integer.parseInt(states[i]);
				users.Userdelete(n);
			}
			request.getRequestDispatcher("user.servlet?state=init").forward(request, response);
		}
		
		if ("update".equals(state)&&!"".equals(newids)) {
			String[] states = newids.split(",");
			int n = Integer.parseInt(states[0]);
			users.Userupdate(n, states[1], states[2], states[3]);
			request.getRequestDispatcher("user.servlet?state=init").forward(request, response);
		}
		if("init".equals(state))
		{
			if(countpage=="")
			{
				countpage ="1"; 
			}
			Page<User> page = new Page<User>();
			page.setCountpage(Integer.valueOf(countpage));
			page.setTotalrows(users.getTotalRows());
			if(page.getTotalrows()%page.getPagenumber()==0)
			{
				page.setTotalpages(page.getTotalrows()/page.getPagenumber());
			}
			else
			{
				page.setTotalpages(page.getTotalrows()/page.getPagenumber()+1);
			}
			users.queryallBypage(page);
			request.setAttribute("page", page);
			request.getRequestDispatcher("views/usermanager.jsp").forward(request, response);
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
