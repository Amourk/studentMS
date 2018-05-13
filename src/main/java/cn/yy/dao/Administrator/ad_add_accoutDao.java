package cn.yy.dao.Administrator;

import org.apache.ibatis.annotations.Param;

public interface ad_add_accoutDao {
    boolean add_accout(@Param("studentId") String sid, @Param("studentPassword") String password);
}
