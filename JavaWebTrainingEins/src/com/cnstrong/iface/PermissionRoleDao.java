package com.cnstrong.iface;

import java.util.List;
import java.util.Map;

import com.cnstrong.entity.Permission;

public interface PermissionRoleDao {
	public boolean addPermissionByRoleid(int roleid, List<Integer> permissions);
	public Map<String, Permission> queryPermissionByRoleid(int roleid);
	public boolean deletePermissionByRoleid(int roleid);
}
