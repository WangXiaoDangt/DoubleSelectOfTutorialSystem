<%@page import="Model.Student" %>
<%@page import="Model.Teacher" %>
<%@page import="Dao.TeacherDao" %>
<%@page import="Dao.StudentDao" %>
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
<%
         Student student=new Student();
         student=(Student)session.getAttribute("student");
         StudentDao studentDao=new StudentDao();
         student=studentDao.load(student.getStudentNum());
         session.setAttribute("student", student);
		TeacherDao teacherDao=new TeacherDao();
		//List<Teacher> teachers=(List)session.getAttribute("teachers");
		List<Teacher> teachers=teacherDao.loadall();
		if(teachers!=null)
		{
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
                    <li id="active"><a href="SelectTutor.jsp">选择导师</a></li>
                <li><a href="StudentJieguo.jsp">选择结果</a></li>
                <li><a href="UpdateStudent.jsp">用户管理</a></li>
               <li><a href="Student.jsp">用户信息</a></li>
                <li><a href="login.jsp">退出系统</a></li>
                </ul>
            </nav>
        </div>
        <div class="right">
            <div class="location">
                <strong>你现在所在的位置是:</strong>
                <span>选择导师</span>
            </div>
                   <%
       if (!student.getTutor().equals("无") ) 
       {
    %>   
        <br>
        <br>
       <h2>您已经被导师选中！</h2>
       <%
       }  
       else
        {%>
     <form action="<%=request.getContextPath() %>/SelectServlet" method="post">

     <table class="providerTable" cellpadding="0" cellspacing="0">
       <tr class="firstTr">
       <th  width="15%"rowspan="10">志愿</th>
       <th width="20%">导师姓名</th>
       <th width="25%">研究方向</th>
       <th width="10%">当前被选次数</th>
       <th width="10%">可选学生人数</th>
       <th width="20%">选择</th>
       </tr>
       <%
		
				for(Teacher teacher : teachers)
				{
 		%>
       <tr>
       <td><%=teacher.getTeacherName() %></td>
       <td><%=teacher.getMajor() %></td>
       <td><%=teacherDao.countStudent(teacher.getTeacherNum()) %></td>
       <td><%=(teacher.getStudentCount()-teacher.getSelectStudent()) %></td>
       <td><input type="radio" name="xuanze1" value="<%=teacher.getTeacherNum()%>"/></td>
       </tr>
       <%
				}
		
		
       %>
          </table>
   
       <br>
       <center> <input style="text-align:center;width:100px;"type="submit" name="tianbao" value="确定填报"/>
       <input type="reset" style="text-align:center;width:100px;" value="重置"></center>
</form>
<%
        }
		}
%>
           
       </div>
    </section>
<script> 

  var messgi ='<%=request.getParameter("tianbao")%>';
  if(messgi=='yes'){
   alert("填报志愿成功！");
  }
</script>
</body>
</html>