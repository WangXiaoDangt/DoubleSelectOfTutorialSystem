package Servlet;

import java.io.IOException;
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
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String leixing =request.getParameter("leixing");
		if(leixing.equals("1"))
		{
			StudentDao studentDao =new StudentDao();
			String studentNum = request.getParameter("username");
			String password = request.getParameter("password");
			
			try{
				Student student=new Student();
				student=studentDao.load(studentNum,password);
				request.getSession().setAttribute("student", student);
				response.sendRedirect(""+request.getContextPath()+"/System/index1.jsp");
			}catch(UserException e){
				 response.sendRedirect(""+request.getContextPath()+"/System/login.jsp?error=yes");
			}
		}
		else 
		{

			TeacherDao teacherDao =new TeacherDao();
			String teacherNum = request.getParameter("username");
			String password = request.getParameter("password");
			System.out.println(teacherNum+" "+password);
			try{
				Teacher teacher=new Teacher();
				teacher=teacherDao.load(teacherNum,password);
				teacherDao.load(teacherNum);
				request.getSession().setAttribute("teacher", teacher);
				response.sendRedirect(""+request.getContextPath()+"/System/index2.jsp");
			}catch(UserException e){
				 response.sendRedirect(""+request.getContextPath()+"/System/login.jsp?error=yes");
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
