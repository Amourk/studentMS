package cn.yy.service.impl.administrator;

import cn.yy.dao.Administrator.ad_add_informationDao;
import cn.yy.service.administrator.ad_add_informationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ad_add_informationServiceImpl implements ad_add_informationService {

    @Autowired
    private ad_add_informationDao ad_add_informationDao;

    @Override
    public boolean addInformation(String sid, String sname, String ssex, String sdepartment, String sclass, String splace, String sbirthday, String inschool) {
        return ad_add_informationDao.addInformation(sid,sname,ssex,sdepartment,sclass,splace,sbirthday,inschool);
    }
}
