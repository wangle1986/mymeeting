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
	<script src="<%=basePath%>js/jquery-2.1.4/jquery.min.js"></script>
	-->

	<!-- 新 Bootstrap 核心 CSS 文件 -->
	<link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
	 	 
	<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
	<script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>
	 
	<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
	<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  </head>
  
  <body class="text-center">
	<div class="container">
      <form class="form-signin" role="form" action="<%=basePath%>login" method="post">
        <h2 class="form-signin-heading">mymeeting登录页面----${requestScope.message }</h2>
        <label for="inputEmail" class="sr-only">请输入用户名</label>
        <input type="text" name="email" id="email" class="form-control" placeholder="请输入用户名" required autofocus>
        <div class="checkbox">
        
        </div>
        <label for="inputPassword" class="sr-only">请输入密码</label>
        <input type="password" name="pswd" id="pswd" class="form-control" placeholder="请输入密码" required>
        <div class="checkbox">
         
        </div>
        <button class="btn btn-lg btn-primary btn-block" type="submit">登录 </button>
      </form>
   </div> <!-- /container --> 

  </body>
</html>