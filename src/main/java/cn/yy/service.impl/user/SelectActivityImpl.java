package cn.yy.service.impl.user;

import cn.yy.dao.user.selectActivityDao;
import cn.yy.entity.activity;
import cn.yy.entity.student_activity;
import cn.yy.service.uers.selectActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SelectActivityImpl implements selectActivityService {

    @Autowired
    private selectActivityDao selectactivityDao;

    @Override//查询活动号
    public List<student_activity> selectActivityId(String sid) {
        return selectactivityDao.selectActivityId(sid);
    }

    @Override//查询具体活动
    public activity selectActivity(String id) {
        return selectactivityDao.selectActivity(id);
    }
}
