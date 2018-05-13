package cn.yy.service.impl.user;

import cn.yy.dao.user.selectInformationDao;
import cn.yy.entity.student;
import cn.yy.service.uers.selectInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class selectInformationServiceImpl implements selectInformationService {

    @Autowired
    private selectInformationDao selectInformationDao;

    @Override
    public student selectInformation(String sid) {
        return selectInformationDao.selectInformation(sid);
    }
}
