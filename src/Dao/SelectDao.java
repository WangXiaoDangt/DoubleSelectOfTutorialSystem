package Dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import Model.Student;
import Model.Teacher;
import Util.DBUtil;

public class SelectDao {
	 public void addZhiyuan(String teacherNum,String studentNum)//添加数据
	    {
	        Teacher teacher =new Teacher();
	        TeacherDao teacherDao =new TeacherDao();
	        teacher=teacherDao.load(teacherNum);
	        Student student = new Student();
	        StudentDao studentDao =new StudentDao();
	        student=studentDao.load(studentNum);
	        String sql="insert into INFO(teacherNum,teacherName,studentNum,studentName) values"
	        		+ "('"+teacherNum+"','"+teacher.getTeacherName()+"',"
	        				+ "'"+studentNum+"','"+student.getStudentName()+"')";
	        System.out.println(sql);
	        Connection con = DBUtil.getConnection();
			Statement state = null;
	        try {
	        	state = con.createStatement();
				state.execute(sql);
	        } catch (SQLException e) {
	            // TODO 自动生成的 catch 块
	            e.printStackTrace();
	        }finally{
	        	DBUtil.close(state);
	       	 DBUtil.close(con);
	        }
	    }
	 public void addResult(String teacherNum,String studentNum)//添加数据
	    {
	        Teacher teacher =new Teacher();
	        TeacherDao teacherDao =new TeacherDao();
	        teacher=teacherDao.load(teacherNum);
	        Student student = new Student();
	        StudentDao studentDao =new StudentDao();
	        student=studentDao.load(studentNum);
	        String sql="insert into RESULT(teacherNum,teacherName,studentNum,studentName) values"
	        		+ "('"+teacherNum+"','"+teacher.getTeacherName()+"',"
	        				+ "'"+studentNum+"','"+student.getStudentName()+"')";
	        System.out.println(sql);
	        Connection con = DBUtil.getConnection();
			Statement state = null;
	        try {
	        	state = con.createStatement();
				state.execute(sql);
	        } catch (SQLException e) {
	            // TODO 自动生成的 catch 块
	            e.printStackTrace();
	        }finally{
	        	DBUtil.close(state);
	       	 DBUtil.close(con);
	        }
	    }
	 public void deleteAll(String teacherNum)
	 {
		 String sql = "delete  from INFO where teacherNum="+teacherNum;
		 Connection con = DBUtil.getConnection();
		Statement state = null;
		try {
				state = con.createStatement();
				state.executeUpdate(sql);
		} catch (SQLException e) {
				e.printStackTrace();
		} finally {
				DBUtil.close(state);
				DBUtil.close(con);
		}
	 }
	 public void delete(String studentNum)
	 {
		 String sql = "delete  from INFO where studentNum="+studentNum;
		 Connection con = DBUtil.getConnection();
		Statement state = null;
		try {
				state = con.createStatement();
				state.executeUpdate(sql);
		} catch (SQLException e) {
				e.printStackTrace();
		} finally {
				DBUtil.close(state);
				DBUtil.close(con);
		}
	 }
	 public List<Student> load(String teacherNum)
	 {
		 String sql = "select * from INFO where teacherNum="+teacherNum;
			Connection con = DBUtil.getConnection();
			Statement statement = null;
			ResultSet resultSet = null;
			List<Student> students = new ArrayList<Student>();
			Student student=null;
			StudentDao studentDao=null;
			try {
				statement = con.createStatement();
				resultSet = statement.executeQuery(sql);
				while (resultSet.next()) {
	                student= new Student();
	                studentDao= new StudentDao();
	                student.setStudentNum(resultSet.getString("studentNum"));
	                student=studentDao.load(student.getStudentNum());
					students.add(student);
				}
				System.out.println(new Date().toString() + "\t查询成功！查询结果");
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				DBUtil.close(statement);
	       	    DBUtil.close(con);
			}
		return students;
		 

	 }
	 public List<Student> loadResult(String teacherNum)
	 {
		 String sql = "select * from RESULT where teacherNum="+teacherNum;
			Connection con = DBUtil.getConnection();
			Statement statement = null;
			ResultSet resultSet = null;
			List<Student> students = new ArrayList<Student>();
			Student student=null;
			StudentDao studentDao=null;
			try {
				statement = con.createStatement();
				resultSet = statement.executeQuery(sql);
				while (resultSet.next()) {
	                student= new Student();
	                studentDao= new StudentDao();
	                student.setStudentNum(resultSet.getString("studentNum"));
	                student=studentDao.load(student.getStudentNum());
					students.add(student);
				}
				System.out.println(new Date().toString() + "\t查询成功！查询结果");
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				DBUtil.close(statement);
	       	    DBUtil.close(con);
			}
		return students;
		 

	 }
	 public Teacher load1(String studentNum)
	 {
		 String sql = "select * from RESULT where studentNum="+studentNum;
			Connection con = DBUtil.getConnection();
			Statement statement = null;
			ResultSet resultSet = null;
			List<Student> students = new ArrayList<Student>();
			Teacher teacher =null;
			TeacherDao teacherDao=new TeacherDao();
			try {
				statement = con.createStatement();
				resultSet = statement.executeQuery(sql);
				while (resultSet.next()) {
	                teacher= new Teacher();
	                teacher.setTeacherNum(resultSet.getString("teacherNum"));
	                teacher=teacherDao.load(teacher.getTeacherNum());	
				}
				System.out.println(new Date().toString() + "\t查询成功！查询结果");
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				DBUtil.close(statement);
	       	    DBUtil.close(con);
			}
		return teacher;
	 }

}
