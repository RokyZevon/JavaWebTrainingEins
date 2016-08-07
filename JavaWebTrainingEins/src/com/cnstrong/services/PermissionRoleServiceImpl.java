package com.cnstrong.services;

import java.util.List;
import java.util.Map;

import com.cnstrong.dao.PermissionRolejdbcDao;
import com.cnstrong.dao.PermissionjdbcDao;
import com.cnstrong.entity.Permission;
import com.cnstrong.iface.PermissionDao;
import com.cnstrong.iface.PermissionRoleDao;
import com.cnstrong.service.iface.PermissionRoleService;

public class PermissionRoleServiceImpl implements PermissionRoleService{
	PermissionDao permission = new PermissionjdbcDao();
	PermissionRoleDao permissionrole = new PermissionRolejdbcDao();
	@Override
	public Map<String, Permission> getpermission(String roleid) {
		Map<String, Permission> map_role = permissionrole.queryPermissionByRoleid(Integer.valueOf(roleid));
		Map<String, Permission> all_map = permission.queryAll();
		all_map.putAll(map_role);
		return all_map;
	}
	@Override
	public boolean updatePermission(Integer roleid, List<Integer> permissionids) {
		boolean flag = false;
		permissionrole.deletePermissionByRoleid(roleid);
		if (permissionrole.addPermissionByRoleid(roleid, permissionids))
		{
			flag = true;
		}
		return flag;
	}
	@Override
	public boolean deletePermission(Integer roleid) {
		// TODO Auto-generated method stub
		if(permissionrole.deletePermissionByRoleid(roleid))
		{
			return true;
		}
		return false;
	}

}
