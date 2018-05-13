package cn.yy.entity;

public class grade {

    private String studentId;//学生学号
    private float studentCreat;//学生的创新分
    private float studentTest;//学生的综测分


    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public float getStudentCreat() {
        return studentCreat;
    }

    public void setStudentCreat(float studentCreat) {
        this.studentCreat = studentCreat;
    }

    public float getStudentTest() {
        return studentTest;
    }

    public void setStudentTest(float studentTest) {
        this.studentTest = studentTest;
    }

}
