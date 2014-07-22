package com.whh.dal;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.whh.model.User;
import com.whh.utils.DBUtil;

public class UserDAL {

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
}
