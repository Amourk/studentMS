package cn.yy.web.user;


import cn.yy.entity.*;
import cn.yy.service.uers.gradeService;
import cn.yy.service.uers.queryService;
import cn.yy.service.uers.selectActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Controller
public class innovationController {

    String s="";
    StringBuffer sb = new StringBuffer();
    private String html[] = new String[100];//拼接html
    private List studentid = new ArrayList();//学生id
    private List name = new ArrayList();//学生的姓名
    private List<Float> test = new ArrayList();//综测总分
    private List<String> id = new ArrayList();//学号
    private List<String> sid = new ArrayList();//学号
    private List cxf = new ArrayList();//创新分
    private List zcf = new ArrayList();//综测分
    private List course = new ArrayList();//各科成绩
    private float CXF;//总的创新分
    private float ZCF;//总的综测分
    private float ZCJ;//各学科的总成绩
    private float AVG;//各学科的平均成绩
    private float zongcefen;//通过计算得到的综测分

    @Autowired//查找该学生的所有创新分  累加
    selectActivityService selectActivityService;

    @Autowired//查找该学生的各科成绩
    private queryService queryService;


    @Autowired//通过学号找到该学生的综测成绩
    private gradeService gradeService;


    @RequestMapping("/innovation")
    private ModelAndView innovation(HttpServletRequest req, HttpServletResponse resp) throws UnsupportedEncodingException {
        ModelAndView mView = new ModelAndView();

        //请空数据
//        list.clear();
//        cjlist.clear();
        studentid.clear();
        cxf.clear();
        zcf.clear();
        course.clear();
        CXF=0;
        ZCF=0;
        ZCJ=0;
        AVG=0;
        zongcefen=0;

        //得到保存在session中的学生id
        String sid = req.getSession().getAttribute("STUDENT_ID").toString();
        //用list保存找到的活动号
        List<student_activity> list = selectActivityService.selectActivityId(sid);
        if (list.size()==0)
        {
            CXF=0;
            ZCF=0;
        }else {
            //遍历list
            for (int i = 0; i < list.size(); i++) {
                //通过活动号得到具体的活动
                activity activity = selectActivityService.selectActivity(list.get(i).getActivityId());
                cxf.add(activity.getStudentCxf());//将查询的创新分保存到集合中
                zcf.add(activity.getStudentZcf());//将查询的综测分保存到集合中
//            ac.add(activity.getStudentActivity());//将查询的具体活动保存到集合中
//            time.add(activity.getActivityTime());//将查询的活动时间保存到集合中
            }
            list.clear();
            //遍历保存创新分的集合 累加得到创新分总和
            for (int i = 0; i < cxf.size(); i++) {

                Float j = (Float) cxf.get(i);
                CXF += j;//得到创新分的总和
            }
            //遍历保存综测分的集合 累加得到综测分总和
            for (int i = 0; i < zcf.size(); i++) {

                Float j = (Float) zcf.get(i);
                ZCF += j;//得到综测分的总和
            }
        }
        //用cjlist保存找到的各科成绩
        List<student_course> cjlist = queryService.queryResult(sid);
        if (cjlist.size()==0)
        {
            zongcefen=0;
        }else {
            //得到各科成绩保存到course中
            for (int i = 0; i < cjlist.size(); i++) {
                course.add(cjlist.get(i).getCourseScore());
            }
            cjlist.clear();
            //遍历course 求得各科成绩的平均值
            for (int i = 0; i < course.size(); i++) {
                Float j = (Float) course.get(i);
                ZCJ += j;//得到各学理的总成绩
            }
            AVG = ZCJ / course.size();//得到各学科的平均分
            //活动乘20% 学习80%=综测成绩
            zongcefen = (float) (ZCF * 0.2 + AVG * 0.8);
        }

        //防止每次查询时往数据库中保存数据
        List<grade> list1 = gradeService.selectId();
        for (int i = 0;i<list1.size();i++)
        {
            studentid.add(list1.get(i).getStudentId());
        }
        list1.clear();
//        studentid.contains(sid);
        if (!studentid.contains(sid))
        {
            gradeService.addGrade(sid,CXF,zongcefen);
        }



        mView.addObject("cxf",CXF);//创新分
        mView.addObject("zcf",zongcefen);//综测分

        //请空数据
        list.clear();
        cjlist.clear();
        cxf.clear();
        zcf.clear();
        course.clear();
        CXF=0;
        ZCF=0;
        ZCJ=0;
        AVG=0;
        zongcefen=0;

        mView.setViewName("innovation");
        return mView;
    }


    @RequestMapping("/ranking")
    private ModelAndView ranking(HttpServletRequest req, HttpServletResponse resp) throws UnsupportedEncodingException {

        ModelAndView mView = new ModelAndView();
        //////////////////////////////////////////////////////////////////////////////////////////
        //清空数据

        for (int i = 0 ;i<html.length;i++)
        {
            html[i]="";
        }
//        list.clear();
        name.clear();
        test.clear();
        id.clear();
        sid.clear();
        sb.setLength(0);
        s="";
        /////////////////////////////////////////////////////
        //请空数据
//        list.clear();
//        cjlist.clear();
        cxf.clear();
        zcf.clear();
        course.clear();
        CXF=0;
        ZCF=0;
        ZCJ=0;
        AVG=0;
        zongcefen=0;

        //得到保存在session中的学生id
        String suid = req.getSession().getAttribute("STUDENT_ID").toString();
        //用list保存找到的活动号
        List<student_activity> list1 = selectActivityService.selectActivityId(suid);
        //遍历list
        for (int i = 0 ;i< list1.size();i++)
        {
            //通过活动号得到具体的活动
            activity activity = selectActivityService.selectActivity(list1.get(i).getActivityId());
            cxf.add(activity.getStudentCxf());//将查询的创新分保存到集合中
            zcf.add(activity.getStudentZcf());//将查询的综测分保存到集合中
//            ac.add(activity.getStudentActivity());//将查询的具体活动保存到集合中
//            time.add(activity.getActivityTime());//将查询的活动时间保存到集合中
        }
        list1.clear();
        //遍历保存创新分的集合 累加得到创新分总和
        for (int i = 0 ;i<cxf.size();i++)
        {

            Float j = (Float) cxf.get(i);
            CXF+=j;//得到创新分的总和
        }
        //遍历保存综测分的集合 累加得到综测分总和
        for (int i = 0 ;i<zcf.size();i++)
        {

            Float j = (Float) zcf.get(i);
            ZCF+=j;//得到综测分的总和
        }
        //用cjlist保存找到的各科成绩
        List<student_course> cjlist = queryService.queryResult(suid);
        //得到各科成绩保存到course中
        for (int i=0;i<cjlist.size();i++ )
        {
            course.add(cjlist.get(i).getCourseScore());
        }
        cjlist.clear();
        //遍历course 求得各科成绩的平均值
        for (int i = 0;i<course.size();i++)
        {
            Float j = (Float) course.get(i);
            ZCJ+=j;//得到各学理的总成绩
        }
        AVG = ZCJ/course.size();//得到各学科的平均分
        //活动乘20% 学习80%=综测成绩
        zongcefen = (float) (ZCF*0.2+AVG*0.8);

        //////////////////////////////////////////////////////////////////////////////////////////

        //得到要进行排名的系别
        String department = new String( req.getParameter("select").getBytes("ISO-8859-1"),"utf-8");
        List<student> list = queryService.queryId(department);
        for (int i = 0;i<list.size();i++)
        {
            String sid = list.get(i).getStudentId();
            id.add(sid);//将该系别的学生学号保存到id集合中
        }
        list.clear();
        //通过的到学生id找到该学生的综测成绩并进行排名
        for (int i =0;i<id.size();i++)
        {
//            gradeDao.selectGrade(id.get(i));
            test.add(gradeService.selectGrade(id.get(i)).getStudentTest());
        }
        //将查询出来的分数排序(从低到高)
        for(int i=0;i<test.size();i++) {
            int min=i;//记录list剩余列表中的最小值的下标
            for(int j=i; j<test.size(); j++){
                if(test.get(min)>test.get(j)){
                    min=j;
                }
            }
            float minValue=test.get(min);//记录最小值
            //当前元素和最小值交换位置
            test.set(min,test.get(i));
            test.set(i,minValue);
        }
        Collections.reverse(test);//将集合倒序 实现综测分从高到低排序
        //通过分数找到对应的学号
        for (int i=0;i<test.size();i++) {
            sid.add(queryService.queryIdBygrade(test.get(i)).getStudentId());
        }
//        Collections.reverse(id);//将集合倒序 对应综测分
        //通过test集合中有序的综测分找到对应的该学生的姓名 放入name集和中
        for (int i =0;i<sid.size();i++)
        {
//            queryService.queryById(id.get(i)).getStudentName();
            name.add(queryService.queryById(sid.get(i)).getStudentName());
        }
        //拼接html传到前端
        for (int i = 0 ;i<test.size();i++)
        {
            String htm = "                    <tr>\n" +
                    "                        <td colspan=\"2\">"+name.get(i)+ "</td>\n" +
                    "                        <td>"+sid.get(i)+"</td>\n" +
                    "                        <td>"+test.get(i)+"</td>\n" +
                    "                        <td>"+(i+1)+"</td>\n" +
                    "                    </tr>";

            html[i]=htm;
        }//拼接html

        for(int i = 0; i < test.size(); i++){
            sb. append(html[i]);
        }
        s = sb.toString();//最终输出的拼接好的html

        mView.addObject("cxf",CXF);//创新分
        mView.addObject("zcf",zongcefen);//综测分
        mView.addObject("html",s);

//        //清空数据
//
//        for (int i = 0 ;i<html.length;i++)
//        {
//            html[i]="";
//        }
//        list.clear();
//        name.clear();
//        test.clear();
//        id.clear();
//        sb.setLength(0);
//        s="";
//        /////////////////////////////////////////////////////
//        //请空数据
//        list.clear();
//        cjlist.clear();
//        cxf.clear();
//        zcf.clear();
//        course.clear();
//        CXF=0;
//        ZCF=0;
//        ZCJ=0;
//        AVG=0;
//        zongcefen=0;

        mView.setViewName("innovation");
        return mView;
    }

}
