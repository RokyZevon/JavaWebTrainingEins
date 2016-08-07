package com.cnstrong.dbutils;

import java.sql.Connection;

import org.junit.Test;

public class DBUtilTest {
	@Test
	public void testDBUtilTest()
	{
		Connection conn  = DBUtil.getConn();
		DBUtil.closeConn(conn);
	}
}
