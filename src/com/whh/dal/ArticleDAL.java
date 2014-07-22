package com.whh.dal;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.whh.model.Article;
import com.whh.utils.DBUtil;

public class ArticleDAL {

	public void add(Article a) throws ClassNotFoundException, SQLException,
			IOException {

		final PreparedStatement preparedStatement = DBUtil.getConnection()
				.prepareStatement(
						"insert into article(title,content) values (?,?)");
		preparedStatement.setString(1, a.getTitle());
		preparedStatement.setString(2, a.getContent());
		preparedStatement.executeUpdate();
	}

	public Article find(int id) {

		Article a = new Article();
		try {
			final PreparedStatement preparedStatement = DBUtil.getConnection()
					.prepareStatement("select * from article where id=?");
			preparedStatement.setInt(1, id);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				a.setContent(rs.getString("content"));
				a.setTitle(rs.getString("title"));
				a.setId(rs.getInt("id"));
			}

		} catch (ClassNotFoundException | SQLException | IOException e) {

			e.printStackTrace();
		}

		return a;
	}

	public void update(Article a) {

		try {

			final PreparedStatement preparedStatement = DBUtil
					.getConnection()
					.prepareStatement(
							"update article set title=? , content=? where id=?");
			preparedStatement.setString(1, a.getTitle());
			preparedStatement.setString(2, a.getContent());
			preparedStatement.setInt(3, a.getId());
			preparedStatement.executeUpdate();

		} catch (ClassNotFoundException | SQLException | IOException e) {

			e.printStackTrace();
		}
	}

	public List<Article> getAll() {

		List<Article> list = new ArrayList<Article>();
		try {

			final PreparedStatement preparedStatement = DBUtil.getConnection()
					.prepareStatement("select * from article");
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				Article a = new Article();
				a.setContent(rs.getString("content"));
				a.setTitle(rs.getString("title"));
				a.setId(rs.getInt("id"));
				list.add(a);
			}
		} catch (ClassNotFoundException | SQLException | IOException e) {

			e.printStackTrace();
		}

		return list;
	}

	public void delete(int id) {
		try {
			final PreparedStatement preparedStatement = DBUtil.getConnection()
					.prepareStatement("delete from article where id=?");
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();
		} catch (ClassNotFoundException | SQLException | IOException e) {

			e.printStackTrace();
		}
	}
}
