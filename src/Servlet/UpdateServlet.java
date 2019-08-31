package Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.StudentDao;
import Dao.TeacherDao;
import Model.Student;
import Model.Teacher;
import Util.UserException;

/**
 * Servlet implementation class UpdateServlet
 */
@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		request.setCharacterEncoding("UTF-8");
	   if(request.getParameter("xiugai").equals("修改"))
	    {
			StudentDao studentDao =new StudentDao();
			Student student=new Student();
//			String studentName = request.getParameter("studentName");
        	String studentNum = request.getParameter("studentNum");
			String password = request.getParameter("password");
            String studentClass = request.getParameter("studentClass");
            String grade = request.getParameter("grade");
//            String tutor = request.getParameter("tutor");
//            String tutor1 = request.getParameter("tutor1");
//            String tutor2 = request.getParameter("tutor2");
//            student.setStudentName(studentName);
            student.setStudentNum(studentNum);
            student.setPassword(password);
            student.setStudentClass(studentClass);
            student.setGrade(grade);
//            student.setTutor(tutor);
//            student.setTutor1(tutor1);
//            student.setTutor2(tutor2);
            try{
            	 PrintWriter pw=response.getWriter();
				student=studentDao.updateStudent(student);
				pw.write("<script language='javascript'>alert('修改成功！')</script>");
				request.getSession().setAttribute("student", student);
				response.sendRedirect(""+request.getContextPath()+"/System/Student.jsp？xiugai=yes");
			}catch(UserException e){
				request.setAttribute("loginError", e.getMessage());
			}
	    }
	   if(request.getParameter("xiugai").equals("确定修改")) {
		   
	    	TeacherDao teacherDao =new TeacherDao();
	        Teacher teacher=new Teacher();
	        String teacherNum = request.getParameter("teacherNum");
			String password = request.getParameter("password");
            String major = request.getParameter("major");
            int studentCount = Integer.parseInt(request.getParameter("studentCount"));
            teacher.setTeacherNum(teacherNum);
            teacher.setPassword(password);
            teacher.setMajor(major);
            teacher.setStudentCount(studentCount);
            try{
            	teacher=teacherDao.updateTeacher(teacher);
				request.getSession().setAttribute("teacher", teacher);
				response.sendRedirect(""+request.getContextPath()+"/System/Teacher.jsp？xiugai=yes");
			}catch(UserException e){
				request.setAttribute("loginError", e.getMessage());
			}
	    }

		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
