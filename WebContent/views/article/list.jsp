<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page session="false" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>文章列表</title>
</head>
<body>
	<ul>
		<c:forEach items="${list}" var="a">
			<li>
			<a href="article?action=add&id=${a.id}">
			<c:out value="${a.title}"></c:out></a>
			<a href="article?action=delete&id=${a.id}">删除</a>
			
		    </li>
		</c:forEach>
	</ul>
</body>
</html>