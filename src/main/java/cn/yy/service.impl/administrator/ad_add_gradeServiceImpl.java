package cn.yy.service.impl.administrator;

import cn.yy.dao.Administrator.ad_add_gradeDao;
import cn.yy.service.administrator.ad_add_gradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ad_add_gradeServiceImpl implements ad_add_gradeService {

    @Autowired
    private ad_add_gradeDao ad_add_gradeDao;

    @Override
    public boolean add_grade(String sid, String cid, float cscore) {
        return ad_add_gradeDao.add_grade(sid,cid,cscore);
    }
}
