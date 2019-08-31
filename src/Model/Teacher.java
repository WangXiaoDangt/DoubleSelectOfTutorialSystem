package Model;

public class Teacher {
	private int id;
	private String teacherName;//教师姓名
	private String teacherNum;//教师工号
	private String password;//登录密码
	private String major;//研究方向
	private int  selectStudent;//已经选择学生人数
	private int studentCount;//可选学生人数
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTeacherName() {
		return teacherName;
	}
	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getTeacherNum() {
		return teacherNum;
	}
	public void setTeacherNum(String teacherNum) {
		this.teacherNum = teacherNum;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public int getSelectStudent() {
		return selectStudent;
	}
	public void setSelectStudent(int selectStudent) {
		this.selectStudent = selectStudent;
	}
	public int getStudentCount() {
		return studentCount;
	}
	public void setStudentCount(int studentCount) {
		this.studentCount = studentCount;
	}

}
