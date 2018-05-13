package cn.yy.dao.user;

import cn.yy.entity.activity;
import cn.yy.entity.student_activity;

import java.util.List;

public interface selectActivityDao {

    //通过学号找到该学生参加的活动号
    List<student_activity> selectActivityId(String sid);

    //查询参加的具体活动和加得分
    activity selectActivity(String id);
}
