package cn.yy.service.impl.administrator;

//import cn.yy.service.administrator.ad_updata_informationService;

import cn.yy.dao.Administrator.ad_updata_informationDao;
import cn.yy.service.administrator.ad_updata_informationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ad_updata_informationServiceImpl implements ad_updata_informationService {

    @Autowired
    private ad_updata_informationDao ad_updata_informationDao;

    @Override
    public boolean updata(String sid, String sname, String ssex, String sdepartment, String sclass, String splace, String sbirthday, String inschool) {
        return ad_updata_informationDao.updata(sid,sname,ssex,sdepartment,sclass,splace,sbirthday,inschool);
    }
}
