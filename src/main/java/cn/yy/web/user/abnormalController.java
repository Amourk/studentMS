package cn.yy.web.user;

import cn.yy.service.uers.abnormalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

@Controller
public class abnormalController {

    @Autowired
    private abnormalService abnormalService;

    @RequestMapping("/abnormal")
    private ModelAndView abnormal(HttpServletRequest req, HttpServletResponse resp) throws UnsupportedEncodingException {
        ModelAndView mView= new ModelAndView();
        //得到保存在session中的学生id
        String sid = req.getSession().getAttribute("STUDENT_ID").toString();
        //得到用户填写的异常
//        String name=new String(req.getParameter("name").getBytes("ISO-8859-1"),"GB2312");
        String thing = new String(req.getParameter("thing").getBytes("ISO-8859-1"),"utf-8");
        //得到系统时间
        Date day = new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        df.format()
        String time = df.format(day);
//        System.out.println(df.format(day));
        //产生随机数作为异常的id
        System.out.println("--------------test()--------------");
      //返回以毫秒为单位的当前时间。
        long r1 = System.currentTimeMillis();
      //返回带正号的 double 值，大于或等于 0.0，小于 1.0。
       double r2 = Math.random();
     //通过Random类来获取下一个随机的整数
       int r3 = new Random().nextInt();
       String abnormal_id = r3+"";
//     System.out.println("r1 = " + r1);
//    System.out.println("r3 = " + r2);
       System.out.println("r2 = " + r3);

        //将数据添加到数据库
        boolean flag =  abnormalService.addAbnormal(sid, thing, time, abnormal_id);
        if(flag)
        {
            mView.addObject("flag"," alert(\"提交成功！\")");
            mView.setViewName("abnormal");
        }else
        {
            mView.addObject("flag"," alert(\"提交失败！\")");
            mView.setViewName("abnormal");
        }
        return mView;
    }
}
