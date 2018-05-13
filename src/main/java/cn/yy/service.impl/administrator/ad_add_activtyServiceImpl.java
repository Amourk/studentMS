package cn.yy.service.impl.administrator;

import cn.yy.dao.Administrator.ad_add_activityDao;
import cn.yy.service.administrator.ad_add_activityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ad_add_activtyServiceImpl implements ad_add_activityService {
    @Autowired
    ad_add_activityDao ad_add_activityDao;
    @Override
    public boolean addActivity(String sid, float zcf, float cxf, String activity, String time, String aid) {
        return ad_add_activityDao.addActivity(sid,zcf,cxf,activity,time,aid);
    }

    @Override
    public boolean addStudentActivity(String sid, String aid) {
        return ad_add_activityDao.addStudentActivity(sid,aid);
    }
}
