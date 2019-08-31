<%@page import="Model.Student" %>
<%@page import="Model.Teacher" %>
<%@page import="Dao.TeacherDao" %>
<%@page import="Dao.StudentDao" %>
<%@page import="Dao.SelectDao" %>
<%@page import="java.util.List"%>
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
<body>

<%
         Student student=new Student();
         student=(Student)session.getAttribute("student");
         StudentDao studentDao=new StudentDao();
         student=studentDao.load(student.getStudentNum());
         //session.setAttribute("student", student);	
         SelectDao selectDao= new SelectDao();
         Teacher teacher=new Teacher();
         teacher=selectDao.load1(student.getStudentNum());
         TeacherDao teacherDao=new TeacherDao();
%>
<!--头部-->
    <header class="publicHeader">
        <h1>导师制双选系统</h1>
        <div class="publicHeaderR">
            <p><span style="color: #fff21b">  <%=student.getStudentNum() %>&nbsp;&nbsp;<%=student.getStudentName() %></span> , 欢迎你！</p>
            <a href="login.jsp">退出</a>
        </div>
    </header>
    <section class="publicTime">
       
    </section>
<!--主体内容-->
    <section class="publicMian ">
        <div class="left">
            <h2 class="leftH2"><span class="span1"></span>功能列表 <span></span></h2>
            <nav>
                <ul class="list">
                <li ><a href="SelectTutor.jsp">选择导师</a></li>
                <li id="active"><a href="StudentJieguo.jsp">查看结果</a></li>
                <li ><a href="UpdateStudent.jsp">用户管理</a></li>
                <li><a href="Student.jsp">用户信息</a></li>
                <li><a href="login.jsp">退出系统</a></li>
                </ul>
            </nav>
        </div>
        <div class="right">
            <div class="location">
                <strong>你现在所在的位置是:</strong>
                <span>查看结果</span>
            </div>
 <%if(teacher==null) {%>  
 <br>
 <br>
 <h2>您选择的导师没有选择你，请重新选择导师！</h2>
 <%}
else { %>      
<table class="providerTable" cellpadding="0" cellspacing="0">
        <tr class="firstTr">
       <th width="25%">导师姓名</th>
       <th width="25%">研究方向</th>
       <th width="25%">已选学生人数</th>
       <th width="25%">可选学生人数</th>
       </tr>
       <tr>
       <td><%=teacher.getTeacherName() %></td>
       <td><%=teacher.getMajor() %></td>
       <td><%=teacher.getSelectStudent() %></td>
       <td><%=(teacher.getStudentCount()-teacher.getSelectStudent())%></td>
       </tr>
<%} %>
</table>
</div>
</section>
</body>
</html>