package com.cnstrong.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.cnstrong.dbutils.DBUtil;
import com.cnstrong.entity.Role;
import com.cnstrong.iface.UserRoleDao;

public class UserRolejdbcDao implements UserRoleDao{
	static Logger logger = Logger.getLogger(UserRolejdbcDao.class);
	@Override
	public boolean addRoleByUserid(int userid, List<Integer> roles) {
		boolean flag = false;
		String sql = "insert into usersrole values(seq_usersrole.nextVal,?,?)";
		Connection connection = DBUtil.getConn();
		try {
			connection.setAutoCommit(false);
			PreparedStatement statement = connection.prepareStatement(sql);
			if(roles !=null)
			{
				for(int i : roles)
				{
					statement.setInt(1, userid);
					statement.setInt(2, i);
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
			// TODO Auto-generated catch block
			logger.info("insert userrole error..."+e.getMessage());
			try {
				connection.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		DBUtil.closeConn(connection);
		return flag;
	}

	@Override
	public Map<String, Role> queryRoleByUserid(int userid) {
		Map<String, Role> map = new HashMap<String,Role>();
		String sql = "select role.* from usersrole,role where role.id = usersrole.roleid and usersrole.userid = ? order by role.id";
		Connection connection = DBUtil.getConn();
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, userid);
			ResultSet resultSet = statement.executeQuery();
			while(resultSet.next())
			{
				Role role = new Role(resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3),"1");
				map.put(String.valueOf(role.getId()), role);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			logger.info("query all error..."+e.getMessage());
		}
		DBUtil.closeConn(connection);
		return map;
	}

	@Override
	public boolean deleteRoleByUserid(int userid) {
		boolean flag = false;
		String sql = "delete from usersrole where userid = ?";
		Connection connection = null;
		connection = DBUtil.getConn();
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, userid);
			int count = statement.executeUpdate();
			if(count>0)
			{
				flag = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DBUtil.closeConn(connection);
		return flag;
	}

}
