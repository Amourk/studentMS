package cn.yy.service.administrator;

import org.apache.ibatis.annotations.Param;

public interface ad_add_accoutService {
    boolean add_accout(@Param("studentId") String sid, @Param("studentPassword") String password);

}
