package com.cnstrong.iface;

import java.util.List;
import java.util.Map;

import com.cnstrong.entity.Role;

public interface UserRoleDao {
	public boolean addRoleByUserid(int userid, List<Integer> roles);
	public Map<String, Role> queryRoleByUserid(int userid);
	public boolean deleteRoleByUserid(int userid);
}
