package Model;

public class Teacher {
	private int id;
	private String teacherName;//��ʦ����
	private String teacherNum;//��ʦ����
	private String password;//��¼����
	private String major;//�о�����
	private int  selectStudent;//�Ѿ�ѡ��ѧ������
	private int studentCount;//��ѡѧ������
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
