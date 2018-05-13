package cn.yy.entity;

public class activity {

    private String studentId;//学生学号

    private float studentZcf;//综测分

    private float studentCxf;//创新分

    private String studentActivity;//具体活动内容

    private String activityTime;//活动时间

    private String activityId;//活动号

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public float getStudentZcf() {
        return studentZcf;
    }

    public void setStudentZcf(float studentZcf) {
        this.studentZcf = studentZcf;
    }

    public float getStudentCxf() {
        return studentCxf;
    }

    public String getActivityId() {
        return activityId;
    }

    public void setActivityId(String activityId) {
        this.activityId = activityId;
    }

    public void setStudentCxf(float studentCxf) {
        this.studentCxf = studentCxf;
    }

    public String getStudentActivity() {
        return studentActivity;
    }

    public void setStudentActivity(String studentActivity) {
        this.studentActivity = studentActivity;
    }

    public String getActivityTime() {
        return activityTime;
    }

    public void setActivityTime(String activityTime) {
        this.activityTime = activityTime;
    }

    @Override
    public String toString() {
        return "activity{" +
                "studentId='" + studentId + '\'' +
                ", studentZcf=" + studentZcf +
                ", studentCxf=" + studentCxf +
                ", studentActivity='" + studentActivity + '\'' +
                ", activityTime=" + activityTime +
                '}';
    }
}
