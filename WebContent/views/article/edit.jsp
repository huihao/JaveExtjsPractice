<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
<%@ taglib uri="http://ckeditor.com" prefix="ckeditor" %>
<%@ page session="false" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>文章内容管理</title>
</head>
<body>
<form action='article?type=edit' method="post" enctype="multipart/form-data" name="edit">
标题：<input id="title" name="title" value="${a.title}"/>
内容：<textarea rows="5" cols="5" id="content" name="content" >${a.content}</textarea>
<input type="file" id="file" name="file"/>
<input value="提交" type="submit"/>
</form>
<ckeditor:replace replace="content" basePath="views/ckeditor/" />
</body>
</html>