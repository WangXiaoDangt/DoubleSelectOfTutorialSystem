<%@page import="Model.Teacher" %>
<%@page import="Dao.TeacherDao" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>导师制双选系统</title>
</head>
<link rel="stylesheet" href="css/public.css"/>
 <link rel="stylesheet" href="css/style.css"/>
<title>导师制双选系统</title>
</head>
<%
        Teacher teacher=new Teacher();
        teacher=(Teacher)session.getAttribute("teacher");
		if(teacher==null){
%>
			<jsp:forward page="login.jsp"></jsp:forward>
<% 
		}
		else{
			TeacherDao teacherDao =new TeacherDao();
			teacher=teacherDao.load(teacher.getTeacherNum());
			session.setAttribute("teacher", teacher);	

		}
		
%>
<body>
<!--头部-->
    <header class="publicHeader">
        <h1>导师制双选系统</h1>
        <div class="publicHeaderR">
            <p><span style="color: #fff21b"> <%=teacher.getTeacherNum() %>&nbsp;&nbsp;<%=teacher.getTeacherName()  %></span> , 欢迎你！</p>
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
                <li><a href="TeacherResult.jsp">查看结果</a></li>
                <li id="active"><a href="UpdateTeacher.jsp">用户管理</a></li>
                <li><a href="Teacher.jsp">用户信息</a></li>
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
<table align="center">
      <tr>
          <td>姓名</td>
           <td><input name="teacherName" type="text" readonly="true" value="<%=teacher.getTeacherName() %>"/></td>
      </tr>
      <tr>
          <td>工号</td>
           <td><input name="teacherNum" type="text" readonly="true" value="<%=teacher.getTeacherNum() %>"/></td>
      </tr>
      <tr>
          <td>密码</td>
           <td><input name="password" type="text"  placeholder="<%=teacher.getPassword() %>" /></td>
      </tr>
      <tr>
          <td>专业</td>
           <td><input name="major" type="text" placeholder="<%=teacher.getMajor() %>" /></td>
      </tr>
      <tr>
          <td>可选学生人数</td>
           <td><input name="studentCount" type="text" placeholder="<%=teacher.getStudentCount() %>"  /></td>
      </tr>
     
</table>
            <center>
            <input style="width:100px;"name="xiugai" type="submit"  value="确定修改"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <input style="width:100px;"name="fanhui" type="reset"  value="重置"/>
            </center>
</form>
 </div>           
           
        </div>
    </section>

</body>
</html>
</html>