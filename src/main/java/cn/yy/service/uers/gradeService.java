package cn.yy.service.uers;

import cn.yy.entity.grade;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface gradeService {
    //通过id找到学生的成绩
    grade selectGrade(String sid);
    //添加总的创新分和综测分到数据库中
    boolean addGrade(@Param("studentId") String sid, @Param("studentCreat") float screat, @Param("studentTest") float stest);
    //查找grade表中id
    List<grade> selectId();
}
