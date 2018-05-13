package cn.yy.service.uers;

import cn.yy.entity.accout;

public interface loginService
{
    //通过id找到密码
    accout login(String sid);
}
