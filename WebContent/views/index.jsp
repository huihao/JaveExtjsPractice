<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
<%@ page session="false" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>首页</title>
<script src="ext/bootstrap.js" type="text/javascript"></script>
<script src="ext/locale/ext-lang-zh_CN.js"></script>
<link href="ext/resources/css/ext-all-neptune.css" rel="stylesheet" />
<script>
function init() {
    Ext.MessageBox.alert("ExtJS", "Hello ExtJS");
}
Ext.onReady(init);
</script>
</head>
<body>
 <a href="article?action=list">文章列表</a>
 <a href="article?action=add">添加文章</a>
 <form action="login" method="post">
 <input id="loginid" name="loginid" />
 <input id="password" name="password"/>
 <input type="file" id="file" name="file"/>
 <input type="submit" value="login"/>
 </form>
</body>
</html>