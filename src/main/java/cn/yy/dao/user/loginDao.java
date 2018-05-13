package cn.yy.dao.user;

import cn.yy.entity.accout;

public interface loginDao {
	//通过id登录系统
	accout login(String sid);

}
