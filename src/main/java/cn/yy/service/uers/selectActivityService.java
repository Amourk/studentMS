package cn.yy.service.uers;

import cn.yy.entity.activity;
import cn.yy.entity.student_activity;

import java.util.List;

public interface selectActivityService {
    List<student_activity> selectActivityId(String sid);

    activity selectActivity(String id);
}
