package cn.yy.service.impl.user;

import cn.yy.service.uers.abnormalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cn.yy.dao.user.abnormalDao;

@Service
public class abnormalServiceImpl implements abnormalService {

    @Autowired
    private abnormalDao abnormalDao;

    @Override
    public boolean addAbnormal(String id, String thing, String time, String abnormal_id) {
        return abnormalDao.addAbnormal(id,thing,time,abnormal_id);
    }
}
