package com.whh.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import com.whh.dao.ArticleDao;
import com.whh.model.Article;

@WebServlet("/AriticleController")
public class AriticleController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AriticleController() {
		super();
		// TODO Auto-generated constructor stub
	}

	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String action = request.getParameter("action");

		if (action.equalsIgnoreCase("add")) {

			if (request.getParameter("id") != null) {

				int id = Integer.parseInt(request.getParameter("id"));
				Article a = new ArticleDao().find(id);
				request.setAttribute("a", a);
			}

			RequestDispatcher view = request
					.getRequestDispatcher("/views/article/edit.jsp");
			view.forward(request, response);

		} else if (action.equalsIgnoreCase("list")) {

			request.setAttribute("list", new ArticleDao().getAll());
			RequestDispatcher view = request
					.getRequestDispatcher("/views/article/list.jsp");
			view.forward(request, response);

		} else if (action.equalsIgnoreCase("delete")) {

			if (request.getParameter("id") != null) {

				int id = Integer.parseInt(request.getParameter("id"));
				new ArticleDao().delete(id);
			}
			request.setAttribute("list", new ArticleDao().getAll());
			RequestDispatcher view = request
					.getRequestDispatcher("/views/article/list.jsp");
			view.forward(request, response);
		} else if (action.equalsIgnoreCase("jsonlist")) {

			List<Article> list = new ArticleDao().getAll();
			JSONArray Jlist = new JSONArray();
			for (Article a : list) {
				JSONObject json = new JSONObject();
				json.put("id", a.getId());
				json.put("title", a.getTitle());
				json.put("content", a.getContent());
				Jlist.add(json);
			}

			response.getWriter().write(JSONValue.toJSONString(Jlist));
		}
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html;charset=UTF-8");

		String acceptjson = "";
		final BufferedReader br = new BufferedReader(new InputStreamReader(
				(ServletInputStream) request.getInputStream(), "utf-8"));
		StringBuffer sb = new StringBuffer("");
		String temp;
		while ((temp = br.readLine()) != null) {
			sb.append(temp);
		}
		br.close();
		acceptjson = sb.toString();
		Object obj = JSONValue.parse(acceptjson);
		final JSONObject jsonobj = (JSONObject) obj;
		final ArticleDao dao = new ArticleDao();
		Article a;
		if(jsonobj.containsKey("id"))
		{
			a= dao.find(Integer.parseInt(jsonobj.get("id").toString()));
		}
		else
		{
			a= new Article();
		}
		 
		a.setContent(jsonobj.get("content").toString());
		a.setTitle(jsonobj.get("title").toString());
		dao.update(a);

		response.getWriter().write("success");
	}
}
