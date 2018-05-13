package cn.yy.dao.user;

import cn.yy.entity.grade;
import cn.yy.entity.student;
import cn.yy.entity.student_course;

import java.util.List;

public interface queryDao {
    //通过姓名查找学生信息
    student queryByName(String sname);
    //通过学生的学号查找到学生的所有信息
    student queryById(String sid);
    //查看学生的学科成绩
    List<student_course> queryResult(String sid);
    //通过学生系别查询该系别的所有学生
    List<student> queryId(String sdepartment);
    //查询学科成绩查找学号
    grade queryIdBygrade(float grade);

}
