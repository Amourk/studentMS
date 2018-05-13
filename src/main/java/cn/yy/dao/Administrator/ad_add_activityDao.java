package cn.yy.dao.Administrator;

import org.apache.ibatis.annotations.Param;

public interface ad_add_activityDao {
    boolean addActivity(@Param("studentId") String sid,@Param("studentZcf") float zcf,@Param("studentCxf") float cxf,
                        @Param("studentActivity") String activity,@Param("activityTime") String time,@Param("activityId") String aid);

    boolean addStudentActivity(@Param("studentId") String sid,@Param("activityId") String aid);
}
