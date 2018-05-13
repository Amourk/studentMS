package cn.yy.web.user;

import cn.yy.entity.activity;
import cn.yy.entity.student_activity;
import cn.yy.service.uers.selectActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;


@Controller
public class activityController {

    private List cxf = new ArrayList();//创新分
    private List zcf = new ArrayList();//综测分
    private List ac = new ArrayList();//具体活动
    private List time = new ArrayList();//活动时间
    private String html[] = new String[100];
    StringBuffer sb = new StringBuffer();
//    private String html1[] = new String[100];

    @Autowired
    private selectActivityService selectActivityService;

    @RequestMapping("/activity")
    private ModelAndView activity(HttpServletRequest req, HttpServletResponse resp)
    {

        for (int i = 0 ;i<html.length;i++)
        {
            html[i]="";
        }

        ModelAndView mView= new ModelAndView();
         //得到保存在session中的学生id
        String sid = req.getSession().getAttribute("STUDENT_ID").toString();
        //用list保存找到的活动号
        List<student_activity> list = selectActivityService.selectActivityId(sid);
        //遍历list
        for (int i = 0 ;i< list.size();i++)
        {
            //通过活动号得到具体的活动
            activity activity = selectActivityService.selectActivity(list.get(i).getActivityId());
            cxf.add(activity.getStudentCxf());//将查询的创新分保存到集合中
            zcf.add(activity.getStudentZcf());//将查询的综测分保存到集合中
            ac.add(activity.getStudentActivity());//将查询的具体活动保存到集合中
            time.add(activity.getActivityTime());//将查询的活动时间保存到集合中
        }


        for (int i = 0 ;i<ac.size();i++)
        {
            String htm = "                    <tr>\n" +
                    "                        <td colspan=\"2\">"+ac.get(i)+ "</td>\n" +
                    "                        <td>"+zcf.get(i)+"</td>\n" +
                    "                        <td>"+cxf.get(i)+"</td>\n" +
                    "                        <td>"+time.get(i)+"</td>\n" +
                    "                    </tr>";

            html[i]=htm;
        }//拼接html

        for(int i = 0; i < ac.size(); i++){
            sb. append(html[i]);
        }
        String s = sb.toString();//最终输出的拼接好的html
//
//        mView.addObject("cxf",cxf);//创新分
//        mView.addObject("zcf",zcf);//综测分
//        mView.addObject("ac",ac);//具体活动
//        mView.addObject("time",time);//活动时间
        mView.addObject("html",s);

        //清空数据
        cxf.clear();
        zcf.clear();
        ac.clear();
        time.clear();
        sb.setLength(0);
        s="";

        mView.setViewName("activity");
        return mView;
    }
}
