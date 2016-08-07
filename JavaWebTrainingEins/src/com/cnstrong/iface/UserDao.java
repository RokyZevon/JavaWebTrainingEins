package com.cnstrong.iface;

import java.util.List;
import java.util.Map;

import com.cnstrong.entity.Page;
import com.cnstrong.entity.Permission;
import com.cnstrong.entity.User;

public interface UserDao {
	public void queryallBypage(Page<User> page); 
	public int getTotalRows();
	public List<User> queryAll();
	public void Useradd(String name, String password, String telephone);
	public void Userdelete(int userid);
	public void Userupdate(int userid, String name, String password, String telephone);
	public List<User> Userselect(int userid);
	public int Checked(String username, String password);
	public Map<String, Permission> getPermission(int userid);
}
