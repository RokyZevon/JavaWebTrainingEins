package com.cnstrong.service.iface;

import java.util.List;
import java.util.Map;

import com.cnstrong.entity.Role;

public interface UserRoleService {
	
	public Map<String, Role> getRole(String userid);
	public boolean updateRole(Integer userid, List<Integer> roleids);
	public boolean deleteRole(Integer userid);
}
