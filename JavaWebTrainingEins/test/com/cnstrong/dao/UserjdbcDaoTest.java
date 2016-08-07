package com.cnstrong.dao;

import java.util.List;
import org.junit.Test;
import com.cnstrong.entity.User;

public class UserjdbcDaoTest {
	private UserjdbcDao userDao = new UserjdbcDao();
	@Test
	public void TestUserjdbcDaoTest()
	{
		List<User> list = userDao.Userselect(21);
//		for(User user : list)
//		{
//			System.out.println(user.getName()+","+user.getPassword());
//		}
		boolean flag=false;
		
		/*flag = userDao.Useradd("a", "a", "a");
		if(flag)
		{
			System.out.println("添加成功");
		}
		else
		{
			System.out.println("添加失败");
		}
		flag = userDao.Userupdate(5, "name", "b");
		if(flag)
		{
			System.out.println("修改成功");
		}
		else
		{
			System.out.println("修改失败");
		}
		
		list = userDao.Userselect(3);
		for(User user : list)
		{
			System.out.println(user.getName()+","+user.getPassword());
		}*/
		//错了 没改
//		flag = userDao.Roleadd(5,23);
//		if(flag)
//		{
//			System.out.println("添加角色成功");
//		}
//		else
//		{
//			System.out.println("添加角色失败");
//		}
//		flag= userDao.Roledelete(5, 23);
//		if(flag)
//		{
//			System.out.println("删除角色 成功");
//		}
//		else
//		{
//			System.out.println("删除角色失败");
//		}
//		flag = userDao.Userdelete(11);
//		if(flag)
//		{
//			System.out.println("删除成功");
//		}
//		else
//		{
//			System.out.println("删除失败");
//		}
	}
	
	
}
