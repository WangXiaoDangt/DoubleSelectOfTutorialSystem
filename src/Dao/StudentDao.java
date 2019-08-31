package Dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Model.Student;
import Util.DBUtil;
import Util.UserException;

public class StudentDao {
    public void addStudent(Student student)//�������
    {
        Connection connection=DBUtil.getConnection();
        String sql="insert into STUDENT(studentName,studentNum,password,studentClass,grade,Tutor)values(?,?,?,?,?,?)";
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, student.getStudentName());
            preparedStatement.setString(2, student.getStudentNum());
            preparedStatement.setString(3, student.getPassword());
            preparedStatement.setString(4, student.getStudentClass());
            preparedStatement.setString(5, student.getGrade());
            preparedStatement.setString(6, student.getTutor());
            preparedStatement.executeUpdate();
            System.out.println("����ɹ�");
        } catch (SQLException e) {
            // TODO �Զ����ɵ� catch ��
            e.printStackTrace();
        }finally{
            DBUtil.close(preparedStatement);
            DBUtil.close(connection);
        }
    }
    public Student load(String studentNum) //��ѯ����
    {
        //׼��sql���
        String sql = "select * from STUDENT  where studentNum = "+studentNum;
        Connection con = DBUtil.getConnection();
		Statement statement = null;
		ResultSet resultSet = null;
        Student student = null;
        try {
        	statement = con.createStatement();
			resultSet = statement.executeQuery(sql);
            while(resultSet.next()) {
            	student = new Student();
            	student.setStudentName(resultSet.getString("studentName"));
            	student.setStudentNum(resultSet.getString("studentNum"));
            	student.setPassword(resultSet.getString("password"));
            	student.setStudentClass(resultSet.getString("studentClass"));
            	student.setGrade(resultSet.getString("grade"));
            	student.setTutor(resultSet.getString("Tutor"));
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally {
            DBUtil.close(resultSet);
            DBUtil.close(statement);
            DBUtil.close(con);
        }
        return  student;
    }
    
    public Student load(String studentNum,String password) {
		Connection connection = DBUtil.getConnection();
		String sql = "select * from STUDENT  where studentNum = ?";
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		Student student = null;
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, studentNum);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				student = new Student();
				student.setId(resultSet.getInt("id"));
				student.setStudentNum(resultSet.getString("studentNum"));
				student.setPassword(resultSet.getString("password"));
				System.out.println("��¼�ɹ���");
			}
			if (student == null) {
				throw new UserException("���û������ڣ�");
			}
			if (!student.getPassword().equals(password)) {
				throw new UserException("���벻��ȷ��");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtil.close(resultSet);
			DBUtil.close(preparedStatement);
			DBUtil.close(connection);
		}
		return  student;
	}
    public Student updateStudent2(Student student)//�޸�����
    {
    	String studentNum=student.getStudentNum();
    	String sql = "update STUDENT set studentName='" + student.getStudentName() + "', password='" + student.getPassword()
		+ "', studentClass='" + student.getStudentClass() + "', grade='" + student.getGrade() + "', Tutor='" + student.getTutor()
		+"where studentNum="
		+ studentNum;
        System.out.println(sql);
        Connection con = DBUtil.getConnection();
        Statement  st = null;
       try {
	    st = con.createStatement();
	    st.executeUpdate(sql);
           } catch (SQLException e) {
	         e.printStackTrace();
         } finally {
	     
          }
        return student;
    }
    
    public Student updateStudent(Student student)//�޸�����
    {
    	String studentNum=student.getStudentNum();
    	String sql = "update STUDENT set  password='" + student.getPassword()
		+ "', studentClass='" + student.getStudentClass() + "', grade='" + student.getGrade() + "' where studentNum="
    			+ studentNum;
        System.out.println(sql);
        Connection con = DBUtil.getConnection();
        Statement  st = null;
       try {
	    st = con.createStatement();
	    st.executeUpdate(sql);
           } catch (SQLException e) {
	         e.printStackTrace();
         } finally {
	     
          }
        return student;
    }
    public void  updateTeacher(String studentNum,String tutor)//�޸�����
    {
    	String sql = "update STUDENT set  TUTOR = '" + tutor + "' where studentNum= "+studentNum;
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


    
   
}
