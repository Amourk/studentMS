package cn.yy.dao.user;

import org.apache.ibatis.annotations.Param;

public interface abnormalDao {
    //通过学生id添加学生提出的异常到数据库中
      boolean addAbnormal(@Param("studentId") String id, @Param("abnormalThing") String thing , @Param("abnormalTime") String time,
                          @Param("abnormalId") String abnormal_id);
}
