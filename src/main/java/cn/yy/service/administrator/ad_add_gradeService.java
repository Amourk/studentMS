package cn.yy.service.administrator;

import org.apache.ibatis.annotations.Param;

public interface ad_add_gradeService {
    boolean add_grade(@Param("studentId") String sid, @Param("courseId") String cid, @Param("courseScore") float cscore);

}
