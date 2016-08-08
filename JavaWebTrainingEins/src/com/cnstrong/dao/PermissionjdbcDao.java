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
import com.cnstrong.iface.PermissionDao;

public class PermissionjdbcDao implements PermissionDao{

	@Override
	public void queryallBypage(Page<Permission> page) {
		 List<Permission> list = new ArrayList<Permission>();
		 String sql = "select * from (select t1.*,rownum rn from (select * from permission order by id) t1) t2 where rn <=?*? and rn>(?-1)*?";
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
					Permission p = new Permission(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),"0");
					list.add(p);
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
		String sql = "select count(*)from permission";
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
	public Map<String, Permission> queryAll() {
		// TODO Auto-generated method stub
		Map<String, Permission> map= new HashMap<String,Permission>(); 
		String sql = "select * from permission order by id";
		Connection connection = null;
		connection=DBUtil.getConn();
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet rSet = statement.executeQuery();
			while(rSet.next())
			{
				Permission permission = new Permission(rSet.getInt(1),rSet.getString(2),rSet.getString(3),rSet.getString(4),"0");
				map.put(String.valueOf(permission.getId()), permission);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DBUtil.closeConn(connection);
		return map;
	}

	@Override
	public void Permissionadd(String permission, String url, String desc1) {
		// TODO Auto-generated method stub
		String sql = "insert into permission values(seq_permission.nextVal,?,?,?)";
		Connection connection = null;
		connection = DBUtil.getConn();
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, permission);
			statement.setString(2, url);
			statement.setString(3, desc1);
			statement.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DBUtil.closeConn(connection);
	}

	@Override
	public void Permissiondelete(int permissionid) {
		// TODO Auto-generated method stub
		String sql = "delete from permission where id = ?";
		Connection connection = null;
		connection = DBUtil.getConn();
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, permissionid);
			statement.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DBUtil.closeConn(connection);
	}

	@Override
	public void Permissionupdate(int permissionid, String permission,String url,String desc1) {
		// TODO Auto-generated method stub
		String sql = "update permission set permission = ?,url=?,desc1=? where id = ?";
		Connection connection = null;
		connection = DBUtil.getConn();
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, permission);
			statement.setString(2, url);
			statement.setString(3, desc1);
			statement.setInt(4, permissionid);
			statement.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DBUtil.closeConn(connection);
	}

	@Override
	public List<Permission> Permissionselect(int permissionid) {
		// TODO Auto-generated method stub
		String sql = "select * from permission where id = ?";
		List<Permission> list = new ArrayList<Permission>();
		Connection connection = null;
		connection = DBUtil.getConn();
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, permissionid);
			ResultSet resultSet = statement.executeQuery();
			while(resultSet.next())
			{
				Permission permission = new Permission(resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3),resultSet.getString(4),"0");
				list.add(permission);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DBUtil.closeConn(connection);
		return list;
	}

}
