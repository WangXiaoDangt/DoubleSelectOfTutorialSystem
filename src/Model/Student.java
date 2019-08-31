package Model;

public class Student {
	private int id;
	private String studentName;//学生姓名
	private String studentNum;//学生学号
	private String password;//登录密码
	private String studentClass;//学生班级
	private String grade;//学生成绩
	private String Tutor;//学生选择的导师
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getStudentNum() {
		return studentNum;
	}
	public void setStudentNum(String studentNum) {
		this.studentNum = studentNum;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public String getStudentClass() {
		return studentClass;
	}
	public void setStudentClass(String studentClass) {
		this.studentClass = studentClass;
	}
	public String getTutor() {
		return Tutor;
	}
	public void setTutor(String tutor) {
		Tutor = tutor;
	}
	
    
}
