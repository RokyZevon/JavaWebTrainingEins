package com.cnstrong.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.cnstrong.dbutils.DBUtil;
import com.cnstrong.entity.Page;
import com.cnstrong.entity.Permission;
import com.cnstrong.entity.Role;
import com.cnstrong.iface.PermissionRoleDao;
import com.cnstrong.iface.RoleDao;

public class RolejdbcDao implements RoleDao{
	static Logger logger = Logger.getLogger(RolejdbcDao.class);
	PermissionRoleDao permissionRoleDao = new PermissionRolejdbcDao();
	@Override
	public void queryallBypage(Page<Role> page) {
		 List<Role> list = new ArrayList<Role>();
		 String sql = "select * from (select t1.*,rownum rn from (select * from role order by id) t1) t2 where rn <=?*? and rn>(?-1)*?";
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
					Role r = new Role(rs.getInt(1),rs.getString(2),rs.getString(3),"0");
					list.add(r);
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
		// TODO Auto-generated method stub
		String sql = "select count(*) from role";
		Connection connection = null;
		int totalrows=0;
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
	public Map<String, Role> queryAll() {
		Map<String, Role> map = new HashMap<String,Role>();
		String sql = "select * from Role order by id";
		Connection conn = DBUtil.getConn();
		try {
			PreparedStatement state = conn.prepareStatement(sql);
			ResultSet rs = state.executeQuery();
			while(rs.next())
			{
				//有问题  后期解决//有问题  后期解决//有问题  后期解决//有问题  后期解决//有问题  后期解决//有问题  后期解决//有问题  后期解决//有问题  后期解决
				Role r = new Role(rs.getInt(1),rs.getString(2),rs.getString(3),"0");
				map.put(String.valueOf(r.getId()), r);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DBUtil.closeConn(conn);
		return map;
	}

	@Override
	public void Roleadd(String rolename, String desc1) {
		String sql = "insert into role values(seq_role.nextVal,?,?)";
		Connection conn = null;
		conn=DBUtil.getConn();
		try {
			PreparedStatement state = conn.prepareStatement(sql);
			state.setString(1, rolename);
			state.setString(2, desc1);
			state.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DBUtil.closeConn(conn);
	}

	@Override
	public void Roledelete(int roleid) {
		String sql ="delete from role where id = ?";
		Connection conn  = null;
		conn=DBUtil.getConn();
		try {
			PreparedStatement state= conn.prepareStatement(sql);
			state.setInt(1, roleid);
			state.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DBUtil.closeConn(conn);
	}

	@Override
	public void Roleupdate(int roleid, String rolename, String desc1) {
		String sql = "update role set rolename = ?,desc1 = ? where id = ?";
		Connection conn = null;
		conn = DBUtil.getConn();
		try {
			PreparedStatement state = conn.prepareStatement(sql);
			state.setString(1, rolename);
			state.setString(2, desc1);
			state.setInt(3, roleid);
			state.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DBUtil.closeConn(conn);
	}
	@Override
	public List<Role> Roleselect(int roleid) {
		String sql = "select * from role where id  = ?";
		List<Role> list = new ArrayList<Role>();
		Connection conn= null;
		conn=DBUtil.getConn();
		try {
			PreparedStatement state = conn.prepareStatement(sql);
			state.setInt(1, roleid);
			ResultSet rs = state.executeQuery();
			while(rs.next())
			{
				//有问题  后期解决//有问题  后期解决//有问题  后期解决//有问题  后期解决//有问题  后期解决//有问题  后期解决//有问题  后期解决//有问题  后期解决
				Role role  =  new Role(rs.getInt(1),rs.getString(2),rs.getString(3),"0");
				list.add(role);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DBUtil.closeConn(conn);
		return list;
	}
	@Override
	public Map<String, Permission> getPermission(int roleid) {
		// TODO Auto-generated method stub
		Map<String, Permission> map = new HashMap<String, Permission>();
		map = permissionRoleDao.queryPermissionByRoleid(roleid);
		return map;
	}

}
