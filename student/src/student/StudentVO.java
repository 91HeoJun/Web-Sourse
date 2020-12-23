package student;

public class StudentVO {

	private int stuNo;
	private String name;
	private int grade;
	private String addr;
	private String birthday;

	public StudentVO() {

	}

	public StudentVO(int stuNo, String name, int grade, String addr, String birthday) {
		this.stuNo = stuNo;
		this.name = name;
		this.grade = grade;
		this.addr = addr;
		this.birthday = birthday;
	}

	public int getStuNo() {
		return stuNo;
	}

	public void setStuNo(int stuNo) {
		this.stuNo = stuNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	@Override
	public String toString() {
		return "StudentVO [stuNo=" + stuNo + ", name=" + name + ", grade=" + grade + ", addr=" + addr + ", birthday="
				+ birthday + "]";
	}
}
