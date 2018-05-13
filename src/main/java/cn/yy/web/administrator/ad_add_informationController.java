package cn.yy.web.administrator;

import cn.yy.service.administrator.ad_add_accoutService;
import cn.yy.dao.Administrator.ad_add_informationDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;

@Controller
public class ad_add_informationController {

    @Autowired
    private ad_add_informationDao ad_add_informationDao;

    @RequestMapping("/ad_add_information")
    private ModelAndView ad_add_information()
    {
        ModelAndView mView = new ModelAndView();
        mView.setViewName("ad_add_information");
        return mView;
    }

    @Autowired
    private ad_add_accoutService ad_add_accoutService;

    @RequestMapping("/add_information")
    private ModelAndView add_information(HttpServletRequest req, HttpServletResponse resp) throws UnsupportedEncodingException {
        ModelAndView mView = new ModelAndView();
        //得到jsp传来的数据
//        String ss =req.getParameter("name");
        String sname = new String( req.getParameter("name").getBytes("ISO-8859-1"),"utf-8");
        String sid = new String( req.getParameter("id").getBytes("ISO-8859-1"),"utf-8");
        String sclass = new String( req.getParameter("class").getBytes("ISO-8859-1"),"utf-8");
        String ssex = new String( req.getParameter("sex").getBytes("ISO-8859-1"),"utf-8");
        String sdepartment = new String( req.getParameter("select").getBytes("ISO-8859-1"),"utf-8");
        String splace = new String( req.getParameter("place").getBytes("ISO-8859-1"),"utf-8");
        String rx_n = req.getParameter("rx_n");
        String rx_y = req.getParameter("rx_y");
        String rx_r = req.getParameter("rx_r");
        String rx_data = rx_n+"-"+rx_y+"-"+rx_r;
        String cs_n = req.getParameter("cs_n");
        String cs_y = req.getParameter("cs_y");
        String cs_r = req.getParameter("cs_r");
        String cs_data = cs_n+"-"+cs_y+"-"+cs_r;
        //将数据保存到数据库中
        ad_add_accoutService.add_accout(sid,"123456");
        boolean flag = ad_add_informationDao.addInformation(sid,sname,ssex,sdepartment,sclass,splace,rx_data,cs_data);
        if (flag) {
            mView.addObject("flag"," alert(\"录入成功！\")");
            mView.setViewName("ad_add_information");
        }else
        {
            mView.addObject("flag"," alert(\"录入失败！\")");
            mView.setViewName("ad_add_information");
        }
        return mView;
    }
}
