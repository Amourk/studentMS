package cn.yy.service.administrator;

import org.apache.ibatis.annotations.Param;

public interface ad_updata_informationService {
    boolean updata(@Param("studentId") String sid, @Param("studentName") String sname,
                   @Param("studentSex") String ssex, @Param("studentDepartment") String sdepartment,
                   @Param("studentClass") String sclass, @Param("studentPlace") String splace,
                   @Param("studentBirthday") String sbirthday, @Param("studentInschool") String inschool);
}
