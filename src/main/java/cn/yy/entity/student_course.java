package cn.yy.entity;

public class student_course {
	private String studentId;//学生学号
	
	private int courseId;//课程号
	
	private float courseScore;//课程得分
	
	private student student;
	
	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public float getCourseScore() {
		return courseScore;
	}

	public void setCourseScore(float courseScore) {
		this.courseScore = courseScore;
	}

	public student getStudent() {
		return student;
	}

	public void setStudent(student student) {
		this.student = student;
	}

	public course getCourse() {
		return course;
	}

	public void setCourse(course course) {
		this.course = course;
	}

	private course course;

}
