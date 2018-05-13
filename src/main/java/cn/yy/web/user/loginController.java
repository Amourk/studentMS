package cn.yy.web.user;

import cn.yy.entity.accout;
import cn.yy.service.uers.loginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class loginController {
    @Autowired
    private loginService loginService;
    @RequestMapping("/main")
    private ModelAndView main(HttpServletRequest req, HttpServletResponse resp){
        ModelAndView mView= new ModelAndView();
        //封装数据
//        mView.addObject("msg", "hello controller");

        //得到用户id和密码
        String upassword="";
        String id = req.getParameter("userid");
//        int userid = Integer.parseInt(id);
        //将id放入session中
        req.getSession().setAttribute("STUDENT_ID",id);
        String userpassword = req.getParameter("userpassword");
//        req.getSession().getAttribute("STUDENT_ID");
//        System.out.printf(req.getSession().getAttribute("STUDENT_ID").toString());
//        System.out.printf("userid=:"+userid);
//        System.out.printf("userpassword=:"+userpassword);

        //通过id从数据库中得到该ID的密码
        accout student = loginService.login(id);
        if (student==null)
        {
            mView.addObject("flag"," alert(\"密码输入错误！\")");
            mView.setViewName("login");
        }else {
            upassword = student.getStudentPassword();
        }
        if (id.equals("administrator"))
        {
            if (!userpassword.equals(upassword)||userpassword.equals(null))
            {
                mView.addObject("flag"," alert(\"密码输入错误！\")");
                mView.setViewName("login");
            }else
            {
                mView.setViewName("ad_main");//进入管理员界面
            }
        }else
        {
            if (!userpassword.equals(upassword)||userpassword.equals(null))
            {
                mView.addObject("flag"," alert(\"密码输入错误！\")");
                mView.setViewName("login");
            }else
            {
                mView.setViewName("main");//WEB-INF/jsp/main.jsp  进入学生界面
            }
        }

        return mView;
    }

}
