package cn.yy.dao.Administrator;

import org.apache.ibatis.annotations.Param;

public interface ad_add_gradeDao {
    boolean add_grade(@Param("studentId") String sid,@Param("courseId") String cid,@Param("courseScore") float cscore);
}
