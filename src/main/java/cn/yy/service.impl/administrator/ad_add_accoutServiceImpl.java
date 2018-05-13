package cn.yy.service.impl.administrator;

import cn.yy.dao.Administrator.ad_add_accoutDao;
import cn.yy.service.administrator.ad_add_accoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ad_add_accoutServiceImpl implements ad_add_accoutService {
    @Autowired
    private ad_add_accoutDao ad_add_accoutDao;

    @Override
    public boolean add_accout(String sid, String password) {
        return ad_add_accoutDao.add_accout(sid,password);
    }
}
