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
			System.out.println("��ӳɹ�");
		}
		else
		{
			System.out.println("���ʧ��");
		}
		flag = userDao.Userupdate(5, "name", "b");
		if(flag)
		{
			System.out.println("�޸ĳɹ�");
		}
		else
		{
			System.out.println("�޸�ʧ��");
		}
		
		list = userDao.Userselect(3);
		for(User user : list)
		{
			System.out.println(user.getName()+","+user.getPassword());
		}*/
		//���� û��
//		flag = userDao.Roleadd(5,23);
//		if(flag)
//		{
//			System.out.println("��ӽ�ɫ�ɹ�");
//		}
//		else
//		{
//			System.out.println("��ӽ�ɫʧ��");
//		}
//		flag= userDao.Roledelete(5, 23);
//		if(flag)
//		{
//			System.out.println("ɾ����ɫ �ɹ�");
//		}
//		else
//		{
//			System.out.println("ɾ����ɫʧ��");
//		}
//		flag = userDao.Userdelete(11);
//		if(flag)
//		{
//			System.out.println("ɾ���ɹ�");
//		}
//		else
//		{
//			System.out.println("ɾ��ʧ��");
//		}
	}
	
	
}
