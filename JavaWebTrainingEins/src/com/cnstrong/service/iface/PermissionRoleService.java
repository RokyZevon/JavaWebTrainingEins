package com.cnstrong.service.iface;

import java.util.List;
import java.util.Map;

import com.cnstrong.entity.Permission;

public interface PermissionRoleService {
	public Map<String, Permission> getpermission(String roleid);
	public boolean updatePermission(Integer roleid, List<Integer> permissionids);
	public boolean deletePermission(Integer roleid);
}
