package Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.SelectDao;
import Model.Student;
import Model.Teacher;
import Util.UserException;

/**
 * Servlet implementation class SelectServlet
 */
@WebServlet("/SelectServlet")
public class SelectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		 Student student=new Student();
		 Teacher teacher=new Teacher();
		student=(Student)request.getSession().getAttribute("student");
		String studentNum=student.getStudentNum();
		System.out.println(studentNum);
		String teacherNum1=request.getParameter("xuanze1");
		try{
			SelectDao selectDao=new SelectDao();
			selectDao.addZhiyuan(teacherNum1, studentNum);
			request.getSession().setAttribute("student", student);
			request.getSession().setAttribute("teacher", teacher);
			response.sendRedirect(""+request.getContextPath()+"/System/SelectTutor.jsp?tianbao=yes");
		}catch(UserException e){
			request.setAttribute("loginError", e.getMessage());
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
