<%@page import="Model.Student" %>
<%@page import="Dao.StudentDao" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="css/public.css"/>
    <link rel="stylesheet" href="css/style.css"/>
<title>导师制双选系统</title>
</head>
<body>
<!--头部-->
<header class="publicHeader">
    <h1>导师制双选系统</h1>
    <div class="publicHeaderR">
        <a href="login.jsp">退出</a>
    </div>
</header>
<%
		Student student=new Student();
        student=(Student)session.getAttribute("student");
		if(student==null){
%>
			<jsp:forward page="login.jsp"></jsp:forward>
<% 
		}
		else{
			StudentDao studentDao =new StudentDao();
			student=studentDao.load(student.getStudentNum());
			System.out.println("shuru"+student.getStudentNum());
			session.setAttribute("student", student);
		}
		
%>
<!--主体内容-->
<section class="publicMian">
    <div class="left">
        <h2 class="leftH2"><span class="span1"></span>功能列表 <span></span></h2>
        <nav>
            <ul class="list">
                <li ><a href="SelectTutor.jsp">选择导师</a></li>
                <li><a href="StudentJieguo.jsp">选择结果</a></li>
                <li><a href="UpdateStudent.jsp">用户管理</a></li>
               <li><a href="Student.jsp">用户信息</a></li>
                <li><a href="login.jsp">退出系统</a></li>
            </ul>
        </nav>
    </div>
    <div class="right">
        <img class="wColck" src="img/clock.jpg" alt=""/>
        <div class="wFont">
            <h2><%=student.getStudentNum() %>&nbsp;&nbsp;<%=student.getStudentName() %></h2>
            <p>欢迎来到导师制双选系统!</p>
			<span id="hours"></span>
        </div>
    </div>
</section>

<script src="js/time.js"></script>
</body>
</html>