package cn.yy.test;

import cn.yy.dao.user.selectActivityDao;
import cn.yy.entity.activity;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class testactivity {
    @Autowired
    private selectActivityDao selectActivityDao;
    @Test
    public void test()
    {
        String id = "201517020402";
        activity activity = selectActivityDao.selectActivity(id);

        System.out.printf(activity.toString());

    }


}
