<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>Login</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script src="<%=basePath%>js/jquery-2.1.4/jquery.min.js"></script>
  </head>
  
  <body style="margin-left: 500px"><c:out value=""/>
     <h1 style="margin-left: 0px">登录页面----${requestScope.message }</h1><br/><br/>
     <form action="<%=basePath%>login" method="post">
         用户名 : <input type="text" name="email" id="email"/><br/><br/>
         密码&nbsp;&nbsp;&nbsp;&nbsp;: <input type="password" name="pswd" id="pswd"/><br/><br/>
         <input style="margin-left: 80px" type="submit" value="登录"/>
         &nbsp;&nbsp;&nbsp;&nbsp;
         <input style="left: 50px" onclick="register()" type="button" value="注册"/>
     </form>
     <h1 style="color: red"></h1>
  </body>
  <script type="text/javascript">

      function register(){
          location.href="<%=basePath%>permission/userInsert";
      }

  </script>
</html>