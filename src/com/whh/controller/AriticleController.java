package com.whh.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import com.whh.dal.ArticleDAL;
import com.whh.model.Article;

/**
 * Servlet implementation class AriticleController
 */
@WebServlet("/AriticleController")
public class AriticleController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AriticleController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String action = request.getParameter("action");
		if (action.equalsIgnoreCase("add")) {

			if (request.getParameter("id") != null) {

				int id = Integer.parseInt(request.getParameter("id"));
				Article a = new ArticleDAL().find(id);
				request.setAttribute("a", a);
			}

			RequestDispatcher view = request
					.getRequestDispatcher("/views/article/edit.jsp");
			view.forward(request, response);

		} else if (action.equalsIgnoreCase("list")) {

			request.setAttribute("list", new ArticleDAL().getAll());
			RequestDispatcher view = request
					.getRequestDispatcher("/views/article/list.jsp");
			view.forward(request, response);

		} else if (action.equalsIgnoreCase("delete")) {

			if (request.getParameter("id") != null) {

				int id = Integer.parseInt(request.getParameter("id"));
				new ArticleDAL().delete(id);
			}

			request.setAttribute("list", new ArticleDAL().getAll());
			RequestDispatcher view = request
					.getRequestDispatcher("/views/article/list.jsp");
			view.forward(request, response);
		}else if(action.equalsIgnoreCase("jsonlist")){
			
			List<Article> list= new ArticleDAL().getAll();
			JSONArray Jlist = new JSONArray();  
			for (Article a : list) {
				JSONObject json=new JSONObject();
				json.put("id", a.getId());
				json.put("title", a.getTitle());
				json.put("content", a.getContent());
				Jlist.add(json);
			}
			response.getWriter().write(JSONValue.toJSONString(Jlist));
			
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@SuppressWarnings("rawtypes")
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		String path = request.getSession().getServletContext().getRealPath("/")
				+ "pic";
		DiskFileItemFactory factory = new DiskFileItemFactory();
		factory.setRepository(new File(path));
		ServletFileUpload upload = new ServletFileUpload(factory);

		upload.setHeaderEncoding("utf-8");

		Article a = new Article();
		a.setTitle(request.getParameter("title"));
		a.setContent(request.getParameter("content"));

		final ArticleDAL dal = new ArticleDAL();
		try {

			List<FileItem> list = upload.parseRequest(request);
			for (FileItem item : list) {
				if (item.isFormField()) {
					System.out.println("表单参数名:" + item.getFieldName()
							+ "，表单参数值:" + item.getString("UTF-8"));
					String m = item.getFieldName();
					String n = m.substring(0, 1);
					m = n.toUpperCase() + m.substring(1, m.length());

					Method method = Article.class.getMethod("set" + m,
							String.class);
					method.invoke(a, item.getString("UTF-8"));

				} else {

					String fileName = item.getFieldName();
					String name = item.getName();
					System.out.println("filename:" + fileName + "____name"
							+ name);
					OutputStream fos = new FileOutputStream(
							new File(path, name));
					InputStream is = item.getInputStream();
					byte[] buffer = new byte[1024];
					int length = 0;
					while ((length = is.read(buffer)) > 0) {
						fos.write(buffer, 0, length);
					}
					is.close();
					fos.close();
					item.write(new File(path, name));
				}

			}
			// dal.add(a);
		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		RequestDispatcher view = request
				.getRequestDispatcher("/views/article/list.jsp");
		request.setAttribute("list", dal.getAll());
		view.forward(request, response);

	}

}
