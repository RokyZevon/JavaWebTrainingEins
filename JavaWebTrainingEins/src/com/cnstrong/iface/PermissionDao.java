package com.cnstrong.iface;

import java.util.List;
import java.util.Map;

import com.cnstrong.entity.Page;
import com.cnstrong.entity.Permission;

public interface PermissionDao {
	public void queryallBypage(Page<Permission> page);
	public int getTotalRows();
	public Map<String, Permission> queryAll();
	public void Permissionadd(String permission, String url, String desc1);
	public void Permissiondelete(int permissionid);
	public void Permissionupdate(int permissionid, String permission, String url, String desc1);
	public List<Permission> Permissionselect(int permissionid);
}
