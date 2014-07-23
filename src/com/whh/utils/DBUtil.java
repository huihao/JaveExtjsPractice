package com.whh.utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;


public class DBUtil {

	private static Connection connection = null;
	public static Connection getConnection() throws ClassNotFoundException, SQLException, IOException{
		if (connection!=null) {
			return connection;
		}
		else{
		final Properties prop = new Properties();
		InputStream inputStream = DBUtil.class.getClassLoader().getResourceAsStream("/db.properties");
		prop.load(inputStream);
		final String driver = prop.getProperty("driver");
		final String url = prop.getProperty("url");
		final String user = prop.getProperty("user");
		final String password = prop.getProperty("password");
		Class.forName(driver);
		connection = DriverManager.getConnection(url,
				user, password);
		return connection;
	}
	}
}
