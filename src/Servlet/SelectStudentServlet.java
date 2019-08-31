package Servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.SelectDao;
import Dao.StudentDao;
import Dao.TeacherDao;
import Model.Student;
import Model.Teacher;
import Util.UserException;

/**
 * Servlet implementation class SelectStudentServlet
 */
@WebServlet("/SelectStudentServlet")
public class SelectStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectStudentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String[] studentsNum=request.getParameterValues("choice");
		Teacher teacher=(Teacher)request.getSession().getAttribute("teacher");
		TeacherDao teacherDao= new TeacherDao();
		teacher=teacherDao.load(teacher.getTeacherNum());
		SelectDao selectDao=new SelectDao();
		StudentDao studentDao=new StudentDao();
		int i=0;
		try {
			for(String studentNum:studentsNum)
			{
				i++;
				selectDao.addResult(teacher.getTeacherNum(), studentNum);  
				selectDao.delete(studentNum);
				studentDao.updateTeacher(studentNum, teacher.getTeacherName());
			}
			teacherDao.updateTeacher(teacher.getTeacherNum(), teacher.getSelectStudent()+i);
			if((teacher.getStudentCount()-i)<=0)
			{
				selectDao.deleteAll(teacher.getTeacherNum());
			}
			request.getSession().setAttribute("teacher", teacher);
			response.sendRedirect(""+request.getContextPath()+"/System/SelectStudent.jsp?tianbao=yes");
		}
	  catch(UserException e){
		request.setAttribute("Ñ¡ÔñÑ§ÉúÊ§°Ü", e.getMessage());
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
