<%@page import="Model.Student" %>
<%@page import="Model.Teacher" %>
<%@page import="Dao.TeacherDao" %>
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
<script language="javascript"> 
</script> 
<body>
            <%
         Teacher teacher=new Teacher();
         teacher=(Teacher)session.getAttribute("teacher");
         TeacherDao teacherDao =new TeacherDao();
         teacher=teacherDao.load(teacher.getTeacherNum() );
         session.setAttribute("teacher", teacher);
		 SelectDao selectDao=new SelectDao();
		List<Student> students=selectDao.loadResult(teacher.getTeacherNum());
		
%>
<!--头部-->
    <header class="publicHeader">
        <h1>导师制双选系统</h1>
        <div class="publicHeaderR">
            <p><span style="color: #fff21b">  <%=teacher.getTeacherNum() %>&nbsp;&nbsp;<%=teacher.getTeacherName() %></span> , 欢迎你！</p>
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
                <li ><a href="SelectStudent.jsp">选择学生</a></li>
                <li id="active"><a href="TeacherResult.jsp">选择结果</a></li>
                <li><a href="UpdateTeacher.jsp">用户管理</a></li>
                <li><a href="Teacher.jsp">用户信息</a></li>
                <li><a href="login.jsp">退出系统</a></li>
                </ul>
            </nav>
        </div>
        <div class="right">
            <div class="location">
                <strong>你现在所在的位置是:</strong>
                <span>选择结果</span>
            </div>

<% if(students==null){%>
<br>
<br>
<h2>您没有选择任何学生！</h2>
<%} 
else {%>
       <table   align="center"  class="providerTable" cellpadding="0" cellspacing="0">
       <tr><td colspan="5">您选择的学生：</td></tr>
       <tr>
            <th>学生姓名</th>
            <th>学生学号</th>
            <th>学生班级</th>
            <th>学生成绩</th>
       </tr>
        <%
		
				for(Student student : students)
				{
 		%>
 		<tr>
 		    <td><%=student.getStudentName() %></td>
 		     <td><%=student.getStudentNum()%></td>
 		     <td><%=student.getStudentClass() %></td>
 		     <td><%=student.getGrade() %></td>
 		    
 		</tr>
 		<%
 		}
 		%>
       </table>
       <%
       }
       %>

       
        </div>
    </section>

<script src="js/jquery.js"></script>
<script src="js/js.js"></script>
<script src="js/time.js"></script>
</body>
</html>