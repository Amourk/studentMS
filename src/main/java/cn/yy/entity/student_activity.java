package cn.yy.entity;

public class student_activity {

    private String studentId;//学生学号

    private String activityId;//活动号

    private student student;

    private activity activity;

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getActivityId() {
        return activityId;
    }

    public void setActivityId(String activityId) {
        this.activityId = activityId;
    }

    public cn.yy.entity.student getStudent() {
        return student;
    }

    public void setStudent(cn.yy.entity.student student) {
        this.student = student;
    }

    public cn.yy.entity.activity getActivity() {
        return activity;
    }

    public void setActivity(cn.yy.entity.activity activity) {
        this.activity = activity;
    }
}
