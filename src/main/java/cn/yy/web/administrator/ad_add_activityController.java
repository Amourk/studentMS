package cn.yy.web.administrator;

import cn.yy.service.administrator.ad_add_activityService;
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
public class ad_add_activityController {
    @Autowired
    private ad_add_activityService ad_add_activityService;

    @RequestMapping("ad_add_activity")
    private ModelAndView ad_add_activity()
    {
        ModelAndView mView = new ModelAndView();
        mView.setViewName("ad_add_activity");
        return mView;
    }

    @RequestMapping("/add_activity")
    private ModelAndView add_activity(HttpServletRequest req, HttpServletResponse resp) throws UnsupportedEncodingException {
        ModelAndView mView = new ModelAndView();
        //得到jsp传来的数据
        String id = new String( req.getParameter("id").getBytes("ISO-8859-1"),"utf-8");
        String activity = new String( req.getParameter("activity").getBytes("ISO-8859-1"),"utf-8");
        String aa = new String( req.getParameter("cxf").getBytes("ISO-8859-1"),"utf-8");
        float cxf = Float.parseFloat(aa);
        String bb = new String( req.getParameter("zcf").getBytes("ISO-8859-1"),"utf-8");
        float zcf = Float.parseFloat(bb);
        //得到当前系统时间
        Date day = new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        String time = df.format(day);
        //得到一个随机数作为活动id
        long r1 = System.currentTimeMillis();
        //返回带正号的 double 值，大于或等于 0.0，小于 1.0。
        double r2 = Math.random();
        //通过Random类来获取下一个随机的整数
        int r3 = new Random().nextInt();
        String aid = r3+"";
        //将数据保存到数据库中
        boolean flag1 = ad_add_activityService.addStudentActivity(id,aid);
        boolean flag2 = ad_add_activityService.addActivity(id,zcf,cxf,activity,time,aid);
        if (flag1&&flag2)
        {
            mView.addObject("flag"," alert(\"添加成功！\")");
            mView.setViewName("ad_add_activity");
        }else
        {
            mView.addObject("flag"," alert(\"添加失败！\")");
            mView.setViewName("ad_add_activity");
        }
        return mView;
    }
}
