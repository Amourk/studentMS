package cn.yy.service.impl.administrator;

import cn.yy.dao.Administrator.ad_query_abnormalDao;
import cn.yy.entity.abnormal;
import cn.yy.service.administrator.ad_query_abnormalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ad_query_abnormalServiceImpl implements ad_query_abnormalService {

    @Autowired
    private ad_query_abnormalDao ad_query_abnormalDao;

    @Override
    public List<abnormal> queryAbnormal() {
        return ad_query_abnormalDao.queryAbnormal();
    }
}
