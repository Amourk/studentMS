package cn.yy.web.administrator;

import cn.yy.entity.abnormal;
import cn.yy.service.administrator.ad_query_abnormalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@Controller
public class ad_query_abnormalController {

    StringBuffer sb = new StringBuffer();
    private String html[] = new String[100];//拼接html
    private List<String> id = new ArrayList();//保存学号
    private List<String> thing = new ArrayList<String>();//保存具体异常
    private List<String> time = new ArrayList<String>();//保存异常时间

    @Autowired
    private ad_query_abnormalService ad_query_abnormalService;

    @RequestMapping("/ad_query_abnormal")
    private ModelAndView query_abnormal(HttpServletRequest req, HttpServletResponse resp)
    {
        ModelAndView mView = new ModelAndView();
        List<abnormal> list =  ad_query_abnormalService.queryAbnormal();//查询数据库得到所有的异常
        for (int i= 0;i<list.size();i++)
        {
            id.add(list.get(i).getStudentId());//得到学号
            thing.add(list.get(i).getAbnormalThing());//得到具体的异常
            time.add(list.get(i).getAbnormalTime());//得到异常的时间
        }
        list.clear();
        //拼接html
        for (int i = 0 ;i<id.size();i++)
        {
            String htm = "                    <tr>\n" +
                    "                        <td colspan=\"2\">"+id.get(i)+ "</td>\n" +
                    "                        <td>"+thing.get(i)+"</td>\n" +
                    "                        <td>"+time.get(i)+"</td>\n" +
                    "                    </tr>";

            html[i]=htm;
        }//拼接html

        for(int i = 0; i < id.size(); i++){
            sb. append(html[i]);
        }
        String s = sb.toString();//最终输出的拼接好的html
        mView.addObject("html",s);

        //清除数据
        for (int i = 0 ;i<html.length;i++)
        {
            html[i]="";
        }
        sb.setLength(0);
        s="";
        id.clear();
        time.clear();
        thing.clear();

        return mView;
    }
}
