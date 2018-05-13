package cn.yy.dao.user;

import cn.yy.entity.student;

public interface selectInformationDao {
//查询学生的基本信息
    student selectInformation(String sid);
}
