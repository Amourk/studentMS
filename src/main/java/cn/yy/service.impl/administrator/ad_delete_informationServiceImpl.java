package cn.yy.service.impl.administrator;

import cn.yy.dao.Administrator.ad_delete_informationDao;
import cn.yy.service.administrator.ad_delete_informationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ad_delete_informationServiceImpl implements ad_delete_informationService{
    @Autowired
    private ad_delete_informationDao ad_delete_informationDao;

    @Override
    public boolean deleteById(String sid) {
        return ad_delete_informationDao.deleteById(sid);
    }

    @Override
    public boolean deleteByName(String sname) {
        return ad_delete_informationDao.deleteByName(sname);
    }


}
