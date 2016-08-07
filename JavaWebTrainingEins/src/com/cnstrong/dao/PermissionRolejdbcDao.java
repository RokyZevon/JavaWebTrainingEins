package com.cnstrong.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.cnstrong.dbutils.DBUtil;
import com.cnstrong.entity.Permission;
import com.cnstrong.iface.PermissionRoleDao;

public class PermissionRolejdbcDao implements PermissionRoleDao{

	@Override
	public boolean addPermissionByRoleid(int roleid, List<Integer> permissions) {
		boolean flag = false;
		String sql = "insert into permissionrole values(seq_permissionrole.nextVal,?,?)";
		Connection connection = DBUtil.getConn();
		try {
			connection.setAutoCommit(false);
			PreparedStatement statement = connection.prepareStatement(sql);
			if(permissions!=null)
			{
				for(int i: permissions)
				{
					statement.setInt(1, i);
					statement.setInt(2, roleid);
					statement.addBatch();
				}
				int[] count = statement.executeBatch();
				connection.commit();
				if(count.length>0)
				{
					flag = true;
				}
			}
		} catch (SQLException e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
			
		}
		return flag;
	}

	@Override
	public Map<String, Permission> queryPermissionByRoleid(int roleid) {
		Map<String, Permission> map = new HashMap<String,Permission>();
		String sql = "select permission.* from permissionrole,permission where permission.id = permissionrole.permissionid and permissionrole.roleid =? order by permission.id";
		Connection connection = DBUtil.getConn();
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, roleid);
			ResultSet resultSet = statement.executeQuery();
			while(resultSet.next())
			{
				Permission permission = new Permission(resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3),resultSet.getString(4),"1");
				map.put(String.valueOf(permission.getId()), permission);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return map;
	}

	@Override
	public boolean deletePermissionByRoleid(int roleid) {
		boolean flag = false;
		String sql = "delete from permissionrole where roleid = ?";
		Connection connection = DBUtil.getConn();
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, roleid);
			int count = statement.executeUpdate();
			if(count>0)
			{
				flag = true;			
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}

}
