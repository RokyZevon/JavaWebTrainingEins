package com.cnstrong.iface;

import java.util.List;
import java.util.Map;

import com.cnstrong.entity.Page;
import com.cnstrong.entity.Permission;
import com.cnstrong.entity.Role;

public interface RoleDao {
	public void queryallBypage(Page<Role> page);
	public int getTotalRows();
	public Map<String, Role> queryAll();
	public void Roleadd(String rolename, String desc1);
	public void Roledelete(int roleid);
	public void Roleupdate(int roleid, String rolename, String desc1);
	public List<Role> Roleselect(int roleid);
	public Map<String, Permission> getPermission(int roleid);
}
