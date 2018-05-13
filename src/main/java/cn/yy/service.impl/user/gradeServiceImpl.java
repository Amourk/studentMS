package cn.yy.service.impl.user;

import cn.yy.dao.user.gradeDao;
import cn.yy.entity.grade;
import cn.yy.service.uers.gradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class gradeServiceImpl implements gradeService {
    @Autowired
    private gradeDao gradeDao;


    @Override
    public grade selectGrade(String sid) {
        return gradeDao.selectGrade(sid);
    }

    @Override
    public boolean addGrade(String sid, float screat, float stest) {
        return gradeDao.addGrade(sid,screat,stest);
    }

    @Override
    public List<grade> selectId() {
        return gradeDao.selectId();
    }
}
