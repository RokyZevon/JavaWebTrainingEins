package com.cnstrong.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.cnstrong.dbutils.DBUtil;
import com.cnstrong.entity.Page;
import com.cnstrong.entity.Permission;
import com.cnstrong.entity.User;
import com.cnstrong.iface.RoleDao;
import com.cnstrong.iface.UserDao;

import org.apache.log4j.Logger;

public class UserjdbcDao implements UserDao{
	static Logger logger = Logger.getLogger(UserjdbcDao.class);
	RoleDao roleDao = new RolejdbcDao();
	@Override
	public void queryallBypage(Page<User> page) {
		// TODO Auto-generated method stub
		 List<User> list = new ArrayList<User>();
		 String sql = "select * from (select t1.*,rownum rn from (select * from users order by id) t1) t2 where rn <=?*? and rn>(?-1)*?";
		 Connection conn = DBUtil.getConn();
			try {
				PreparedStatement state = conn.prepareStatement(sql);
				state.setInt(1, page.getPagenumber());
				state.setInt(2, page.getCountpage());
				state.setInt(3, page.getCountpage());
				state.setInt(4, page.getPagenumber());
				ResultSet rs = state.executeQuery();
				while(rs.next())
				{
					User u = new User(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4));
					list.add(u);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			page.setPagelist(list);
			DBUtil.closeConn(conn);
	}
	@Override
	public int getTotalRows() {
		int totalrows=0;
		String sql = "select count(*)from users";
		Connection connection = null;
		connection = DBUtil.getConn();
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet resultSet = statement.executeQuery();
			if(resultSet.next())
			{
				totalrows = resultSet.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DBUtil.closeConn(connection);
		return totalrows;
	}

	@Override
	public List<User> queryAll() {
		List<User> list = new ArrayList<User>();
		String sql = "select * from users order by id";
		Connection conn = DBUtil.getConn();
		try {
			PreparedStatement state = conn.prepareStatement(sql);
			ResultSet rs = state.executeQuery();
			while(rs.next())
			{
				User u = new User(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4));
				list.add(u);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DBUtil.closeConn(conn);
		return list;
	}
	@Override
	public void Useradd( String name, String password, String telephone) {
		String sql = "insert into users values (seq_users.nextVal,?,?,?)";
		Connection conn = null;
		conn = DBUtil.getConn();
		try {
			PreparedStatement state = conn.prepareStatement(sql);
			state.setString(1, name);
			state.setString(2, password);
			state.setString(3, telephone);
			state.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DBUtil.closeConn(conn);
	}

	@Override
	public void Userdelete(int userid) {
		String sql = "delete from users where id = ?";
		Connection conn = null;
		conn=DBUtil.getConn();
		try {
			
			PreparedStatement state = conn.prepareStatement(sql);
			state.setInt(1, userid);
			state.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DBUtil.closeConn(conn);
	}

	@Override
	public void Userupdate(int userid, String name,String password,String telephone) {
		String sql = "update users set name = ?,password = ? , telephone = ? where id = ?";
		Connection conn = null;
		conn = DBUtil.getConn();
		try {
			PreparedStatement state = conn.prepareStatement(sql);
			state.setString(1, name);
			state.setString(2, password);
			state.setString(3, telephone);
			state.setInt(4, userid);
			state.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DBUtil.closeConn(conn);
	}

	
	@Override
	public List<User> Userselect(int userid) {
		String sql = "select * from users where id = ?";
		List<User> list = new ArrayList<User>();
		Connection conn = null;
		conn=DBUtil.getConn();
		try {
			PreparedStatement state = conn.prepareStatement(sql);
			state.setInt(1, userid);
			ResultSet rs = state.executeQuery();
			while(rs.next())
			{
				User u = new User(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4));
				list.add(u);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DBUtil.closeConn(conn);
		return list;
	}
	@Override
	public int Checked(String username, String password) {
		// TODO Auto-generated method stub
		String sql = "select * from users where name =?and password =?";
		int count = -1;
		Connection connection = DBUtil.getConn();
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, username);
			statement.setString(2, password);
			ResultSet resultSet = statement.executeQuery();
			if(resultSet.next())
			{
				count = resultSet.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DBUtil.closeConn(connection);
		return count;
	}
	@Override
	public Map<String, Permission> getPermission(int userid) {
		// TODO Auto-generated method stub
		Map<String, Permission> map = new HashMap<String,Permission>();
		String sql = "select role.* from usersrole,role where role.id = usersrole.roleid and usersrole.userid = ? order by role.id";
		Connection connection = DBUtil.getConn();
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, userid);
			ResultSet resultSet = statement.executeQuery();
			while(resultSet.next())
			{
				map.putAll(roleDao.getPermission(resultSet.getInt(1)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DBUtil.closeConn(connection);
		return map;
	}
	@Override
	public boolean UserselectByName(String username) {
		// TODO Auto-generated method stub
		boolean flag = false;
		String sql = "select * from users where name = ?";
		Connection connection = DBUtil.getConn();
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, username);
			int count = statement.executeUpdate();
			if(count>0)
			{
				flag=true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DBUtil.closeConn(connection);
		return flag;
	}

	
	
	
}
