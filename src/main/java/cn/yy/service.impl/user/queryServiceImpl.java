package cn.yy.service.impl.user;

import cn.yy.dao.user.queryDao;
import cn.yy.entity.grade;
import cn.yy.entity.student;
import cn.yy.entity.student_course;
import cn.yy.service.uers.queryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class queryServiceImpl implements queryService {
    @Autowired
    private queryDao queryDao;
    @Override//通过名字查找
    public student queryByName(String sname) {
        return queryDao.queryByName(sname);
    }

    @Override//通过id查找
    public student queryById(String sid) {
        return queryDao.queryById(sid);
    }

    @Override//查找学科成绩
    public List<student_course> queryResult(String sid) {
        return queryDao.queryResult(sid);
    }
    @Override
    public List<student> queryId(String sdepartment) {
        return queryDao.queryId(sdepartment);
    }

    @Override
    public grade queryIdBygrade(float grade) {
        return queryDao.queryIdBygrade(grade);
    }

}
