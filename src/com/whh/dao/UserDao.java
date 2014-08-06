package com.whh.dao;

import java.io.IOException;
import java.lang.reflect.Method;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.whh.model.User;
import com.whh.utils.DBUtil;

public class UserDao {

	public Boolean check(User user) {

		int count = 0;
		try {

			final PreparedStatement preparedStatement = DBUtil
					.getConnection()
					.prepareStatement(
							"select count(*) from user where loginid=? and password=?");
			preparedStatement.setString(1, user.getLoginid());
			preparedStatement.setString(2, user.getPassword());

			ResultSet r = preparedStatement.executeQuery();

			while (r.next()) {
				count = r.getInt(1);
			}

		} catch (ClassNotFoundException | SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (count > 0) {
			return true;
		} else {
			return false;
		}

	}
	
	public List<User> getAll() {

		List<User> list = new ArrayList<User>();
		try {

			final PreparedStatement preparedStatement = DBUtil.getConnection()
					.prepareStatement("select * from user");
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				User u = new User();
				Method m[]=User.class.getDeclaredMethods();
				for (Method method : m) {
					System.out.println(method.getName());
				}
				u.setLoginid(rs.getString("loginid"));
				u.setPassword(rs.getString("password"));
				u.setId(rs.getInt("id"));
				list.add(u);
			}
		} catch (ClassNotFoundException | SQLException | IOException e) {

			e.printStackTrace();
		}

		return list;
	}
}
