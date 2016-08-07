package com.cnstrong.dbutils;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.log4j.Logger;

public class DBUtil {
		public static String driverClass;
		public static String url;
		public static String name;
		public static String password;
		static Logger logger = Logger.getLogger(DBUtil.class);
		static 
		{
			Properties pro = new Properties();
			try {
				pro.load(DBUtil.class.getResourceAsStream("/jdbc.properties"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			driverClass = pro.getProperty("jdbc.className");
			url = pro.getProperty("jdbc.url");
			name = pro.getProperty("jdbc.user");
			password = pro.getProperty("jdbc.password");
			try {
				Class.forName(driverClass);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		public static Connection getConn()
		{
			Connection conn = null;
			try {
				conn = DriverManager.getConnection(url,name,password);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return conn;
		}
		public static void closeConn(Connection conn)
		{
			if(conn!=null)
			{
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
}
