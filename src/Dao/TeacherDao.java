package Dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import Model.Student;
import Model.Teacher;
import Util.DBUtil;
import Util.UserException;

public class TeacherDao {
    public void addStudent(Teacher teacher)//添加数据
    {
       
        String sql="insert into TEACHER(teacherName,teacherNum,password,major,selectStudent,studentCount) values"
        		+ "('"+teacher.getTeacherName()+"','"+teacher.getTeacherNum()+"','"+teacher.getPassword()+"',"
        				+ "'"+teacher.getMajor()+"','"+teacher.getSelectStudent()+"','"+teacher.getStudentCount()+"')";
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
    public Teacher updateTeacher(Teacher teacher)//修改数据
    {
    	String teacherNum=teacher.getTeacherNum();
    	String sql = "update TEACHER set  password='" + teacher.getPassword()
		+ "', major='" + teacher.getMajor()+ "',studentCount='" + teacher.getStudentCount()+ "' where teacherNum="
		+ teacherNum;
        System.out.println(sql);
        Connection con = DBUtil.getConnection();
        Statement  st = null;
       try {
	    st = con.createStatement();
	    st.executeUpdate(sql);
           } catch (SQLException e) {
	         e.printStackTrace();
         } finally {
        	 DBUtil.close(st);
        	 DBUtil.close(con);
          }
        return teacher;
    }
    public void  updateTeacher(String teacherNum,int n)//修改数据
    {
    	String sql = "update TEACHER set  selectStudent=" + n+"where teacherNum="+teacherNum;
        System.out.println(sql);
        Connection con = DBUtil.getConnection();
        Statement  st = null;
       try {
	    st = con.createStatement();
	    st.executeUpdate(sql);
           } catch (SQLException e) {
	         e.printStackTrace();
         } finally {
        	 DBUtil.close(st);
        	 DBUtil.close(con);
          }
        
    }
    public Teacher load(String teacherNum) //查询数据
    {
        Connection connection = DBUtil.getConnection();
        //准备sql语句
        String sql = "select * from TEACHER where teacherNum = "+teacherNum;
        //创建语句传输对象
        Connection con = DBUtil.getConnection();
		Statement statement = null;
		ResultSet resultSet = null;
        Teacher teacher = null;
        try {
        	statement = con.createStatement();
			resultSet = statement.executeQuery(sql);
            while(resultSet.next()) {
                teacher= new Teacher();
 				teacher.setId(resultSet.getInt("id"));
 				teacher.setTeacherName(resultSet.getString("teacherName"));
 				teacher.setTeacherNum(resultSet.getString("teacherNum"));
 				teacher.setPassword(resultSet.getString("password"));
 				teacher.setMajor(resultSet.getString("major"));
 				teacher.setSelectStudent(resultSet.getInt("selectStudent"));
 				teacher.setStudentCount(resultSet.getInt("studentCount"));
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally {
            DBUtil.close(resultSet);
            DBUtil.close(statement);
            DBUtil.close(con);
        }
        return  teacher;
    }
    
    public Teacher load(String teacherNum,String password) {
    	System.out.println(teacherNum+" "+password);
    	String sql = "select * from TEACHER where teacherNum = ?";
		Connection con = DBUtil.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		Teacher teacher=null;
		try {
			preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1, teacherNum);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				teacher = new Teacher();
				teacher.setId(resultSet.getInt("id"));
				teacher.setTeacherNum(resultSet.getString("teacherNum"));
				teacher.setPassword(resultSet.getString("password"));
				System.out.println("登录成功！");
			}
			if (teacher == null) {
				throw new UserException("该用户不存在！");
			}
			if (!teacher.getPassword().equals(password)) {
				throw new UserException("密码不正确！");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtil.close(resultSet);
			DBUtil.close(preparedStatement);
			DBUtil.close(con);
		}
		return teacher;
	}
    public List<Teacher> loadall(){
    	String sql = "select * from TEACHER";
		Connection con = DBUtil.getConnection();
		Statement statement = null;
		ResultSet resultSet = null;
		List<Teacher> teachers = new ArrayList<Teacher>();
		Teacher teacher=null;
		try {
			statement = con.createStatement();
			resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
                teacher= new Teacher();
				teacher.setId(resultSet.getInt("id"));
				teacher.setTeacherName(resultSet.getString("teacherName"));
				teacher.setTeacherNum(resultSet.getString("teacherNum"));
				teacher.setPassword(resultSet.getString("password"));
				teacher.setMajor(resultSet.getString("major"));
				teacher.setSelectStudent(resultSet.getInt("selectStudent"));
				teacher.setStudentCount(resultSet.getInt("studentCount"));
				teachers.add(teacher);
			}
			System.out.println(new Date().toString() + "\t查询成功！查询结果");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(statement);
       	    DBUtil.close(con);
		}
		return teachers;	
    }
    @SuppressWarnings("unused")
	public int countStudent(String teacherNum) {
    	String sql = "select * from INFO where teacherNum="+teacherNum;
		Connection con = DBUtil.getConnection();
		Statement statement = null;
		ResultSet resultSet = null;
		int n=0;
		Teacher teacher=null;
		try {
			statement = con.createStatement();
			resultSet= statement.executeQuery(sql);
			while (resultSet.next())
			{
			   n++;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			 DBUtil.close(statement);
        	 DBUtil.close(con);
		}
		return n;
	}
   
}
