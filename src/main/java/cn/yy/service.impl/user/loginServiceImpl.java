package cn.yy.service.impl.user;

import cn.yy.dao.user.loginDao;
import cn.yy.entity.accout;
import cn.yy.entity.student;
import cn.yy.service.uers.loginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class loginServiceImpl implements loginService
{

    @Autowired
    private loginDao loginDao;

    @Override
    public accout login(String sid) {
        return loginDao.login(sid);
    }
}
