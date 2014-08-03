package com.whh.dao;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.whh.model.Menu;
import com.whh.utils.DBUtil;

public class MenuDao {

	public Menu find(int id) {

		Menu m = new Menu();
		try {
			final PreparedStatement preparedStatement = DBUtil.getConnection()
					.prepareStatement("select * from menu where id=?");
			preparedStatement.setInt(1, id);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				m.setId(rs.getInt("id"));
				m.setParentId(rs.getInt("parentid"));
				m.setLeaf(rs.getBoolean("leaf"));
				m.setText(rs.getString("text"));
			}

		} catch (ClassNotFoundException | SQLException | IOException e) {

			e.printStackTrace();
		}

		return m;
	}

	public List<Menu> findByParentId(String parentId) {

		List<Menu> list = new ArrayList<Menu>();
		try {
			String sql="";
			if ("".equals(parentId)) {
				sql="select * from menu where parentid is null ";
			}
			else{
				sql="select * from menu where parentid = " +parentId;
			}
			final PreparedStatement preparedStatement = DBUtil.getConnection()
					.prepareStatement(sql);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				Menu m = new Menu();
				m.setId(rs.getInt("id"));
				m.setParentId(rs.getInt("parentid"));
				m.setLeaf(rs.getBoolean("leaf"));
				m.setText(rs.getString("text"));
				list.add(m);
			}
		} catch (ClassNotFoundException | SQLException | IOException e) {

			e.printStackTrace();
		}

		return list;
	}
}
