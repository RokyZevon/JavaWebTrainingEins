package com.cnstrong.services;

import java.util.List;
import java.util.Map;

import com.cnstrong.dao.RolejdbcDao;
import com.cnstrong.dao.UserRolejdbcDao;
import com.cnstrong.entity.Role;
import com.cnstrong.iface.RoleDao;
import com.cnstrong.iface.UserRoleDao;
import com.cnstrong.service.iface.UserRoleService;

public class UserRoleServiceImpl implements UserRoleService {
	private RoleDao roleDao = new RolejdbcDao();
	private UserRoleDao userroleDao = new UserRolejdbcDao();
	@Override
	public Map<String, Role> getRole(String userid) {
		Map<String, Role> map_user = userroleDao.queryRoleByUserid(Integer.valueOf(userid));
		Map<String, Role> all_map = roleDao.queryAll();
		all_map.putAll(map_user);
		return all_map;
	}

	@Override
	public boolean updateRole(Integer userid, List<Integer> roleids) {
		boolean flag = false;
		userroleDao.deleteRoleByUserid(userid);
		if(userroleDao.addRoleByUserid(userid, roleids))
		{
			flag=true;
		}
		return flag;
	}

	@Override
	public boolean deleteRole(Integer userid) {
		if(userroleDao.deleteRoleByUserid(userid))
		{
			return true;
		}
		return false;
	}
}
