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
<title>学生信息更新</title>
</head>

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
                <li ><a href="SelectStudent.jsp">选择学生</a></li>
                <li><a href="StudentJieguo.jsp">选择结果</a></li>
                <li ><a href="UpdateStudent.jsp">用户管理</a></li>
                <li id="active"><a href="Student.jsp">用户信息</a></li>
                <li><a href="login.jsp">退出系统</a></li>
                </ul>
            </nav>
        </div>
        <div class="right">
            <div class="location">
                <strong>你现在所在的位置是:</strong>
                <span>用户信息</span>
            </div>
<div class="providerAdd">

<table align="center"  class="providerTable" cellpadding="0" cellspacing="0">
      <tr>
          <td>姓名</td>
           <td><%=student.getStudentName() %></td>
      </tr>
      <tr>
          <td>学号</td>
           <td><%=student.getStudentNum() %></td>
      </tr>
      <tr>
          <td>密码</td>
           <td><%=student.getPassword() %></td>
      </tr>
      <tr>
          <td>班级</td>
           <td><%=student.getStudentClass() %></td>
      </tr>
      <tr>
          <td>成绩</td>
           <td><%=student.getGrade() %></td>
      </tr>
      <tr>
          <td>导师</td>
           <td><%=student.getTutor() %></td>
      </tr>
       
</table>

 </div>           
           
        </div>
    </section>
<script> 

  var xiugaii ='<%=request.getParameter("xiugai")%>';
  if(xiugaii=='yes'){
   alert("修改成功!");
  }
</script>

</body>
</html>
</html>