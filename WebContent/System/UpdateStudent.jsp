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
<%
		Student student=new Student();
        student=(Student)session.getAttribute("student");
        System.out.println(student.getStudentNum() );
		if(student==null){
%>
			<jsp:forward page="login.jsp"></jsp:forward>
<% 
		}
		else{
			StudentDao studentDao =new StudentDao();
			student=studentDao.load(student.getStudentNum());
			session.setAttribute("student", student);	
			}
		
%>
<body>

</body>
<body>
<!--头部-->
    <header class="publicHeader">
        <h1>导师制双选系统</h1>
        <div class="publicHeaderR">
            <p><span style="color: #fff21b"> <%=student.getStudentNum() %>&nbsp;&nbsp;<%=student.getStudentName() %></span> , 欢迎你！</p>
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
                <li ><a href="SelectTeacher.jsp">选择老师</a></li>
                <li><a href="StudentJieguo.jsp">查看志愿</a></li>
                <li id="active"><a href="UpdateStudent.jsp">用户管理</a></li>
                <li><a href="Student.jsp">用户信息</a></li>
                <li><a href="login.jsp">退出系统</a></li>
                </ul>
            </nav>
        </div>
        <div class="right">
            <div class="location">
                <strong>你现在所在的位置是:</strong>
                <span>用户管理</span>
            </div>
<div class="providerAdd">
<form action="<%=request.getContextPath() %>/UpdateServlet" method="post">
<table align="center"  class="providerTable" cellpadding="0" cellspacing="0">
      <tr>
          <td>姓名</td>
           <td><input name="studentName" type="text" readonly="true" value="<%=student.getStudentName() %>"/></td>
      </tr>
      <tr>
          <td>学号</td>
           <td><input name="studentNum" type="text" readonly="true" value="<%=student.getStudentNum() %>"/></td>
      </tr>
      <tr>
          <td>密码</td>
           <td><input name="password" type="text"  placeholder="<%=student.getPassword() %>" /></td>
      </tr>
      <tr>
          <td>班级</td>
           <td><input name="studentClass" type="text" placeholder="<%=student.getStudentClass() %>" /></td>
      </tr>
      <tr>
          <td>成绩</td>
           <td><input name="grade" type="text" placeholder="<%=student.getGrade() %>"  /></td>
      </tr>
       
</table>
         <br>
         <center><input style="width:100px;" name="xiugai" type="submit"  value="修改"/><input style="width:100px;"  name="fanhui" type="reset"  value="重置"/></center>
</form>
 </div>           
           
        </div>
    </section>
</body>
</html>
</html>