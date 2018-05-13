package cn.yy.web.administrator;

import cn.yy.entity.student;
import cn.yy.entity.student_course;
import cn.yy.service.administrator.ad_add_gradeService;
import cn.yy.service.administrator.ad_delete_informationService;
import cn.yy.service.administrator.ad_updata_informationService;
import cn.yy.service.uers.queryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class Ad_queryController {

    private String grade_id[]={"1001","1002","1003","1004","1005","1006","1007","1008"};

//    跳转到query_id界面
    @RequestMapping("/ad_query")
    private ModelAndView ad_query(HttpServletRequest req, HttpServletResponse resp)
    {
        ModelAndView mView= new ModelAndView();
        mView.addObject("flag","");
        mView.setViewName("ad_query");
//        mView.addObject("flag","");
        return mView;
    }
    @Autowired
    private queryService queryService;
    //实现通过id查询该学生的信息
    @RequestMapping("/querybyid")
    private ModelAndView querybyid(HttpServletRequest req, HttpServletResponse resp)
    {

        ModelAndView mView= new ModelAndView();
        String id = req.getParameter("sid");
        //将查询的学号放入session中
        req.getSession().setAttribute("STUDENT_SID",id);
//        int sid = Integer.parseInt(id);
        student student = queryService.queryById(id);
        //判断是否数据库中有该id
        if (student==null)//没有
        {
            mView.addObject("flag"," alert(\"没有该学号！\")");
            mView.setViewName("ad_query");
        }else
        {
            mView.addObject("sname",student.getStudentName());
            mView.addObject("ssex",student.getStudentSex());
            mView.addObject("sbirthday",student.getStudentBirthday());
            mView.addObject("splace",student.getStudentPlace());
            mView.addObject("sdepartment",student.getStudentDepartment());
            mView.addObject("sclass",student.getStudentClass());
            mView.addObject("sid",student.getStudentId());
            mView.addObject("sinschool",student.getStudentInschool());
            mView.setViewName("ad_query_id");
        }
        return mView;
    }
//    //跳转到query_name界面
//    @RequestMapping("/query_name")
//    private ModelAndView query_name(HttpServletRequest req, HttpServletResponse resp)
//    {
//        ModelAndView mView= new ModelAndView();
//        mView.setViewName("ad_query_name");
//        return mView;
//    }

    @RequestMapping("/querybyname")
    private ModelAndView querybyname(HttpServletRequest req, HttpServletResponse resp) throws UnsupportedEncodingException {
//        req.setCharacterEncoding("UTF-8");
//        req.getParameter("nickname");
        ModelAndView mView= new ModelAndView();
        String sname = new String( req.getParameter("sname").getBytes("ISO-8859-1"),"utf-8");

//        String sname = req.getParameter("sname");
        System.out.printf("sadasda"+sname);
        //将查询的学号放入session中
        req.getSession().setAttribute("STUDENT_NAME",sname);
//        int sid = Integer.parseInt(id);
        student student = queryService.queryByName(sname);
        if (student==null)//没有
        {
            mView.addObject("flag"," alert(\"没有该姓名！\")");
            mView.setViewName("ad_query");
        }else {
            mView.addObject("ssname", student.getStudentName());
            mView.addObject("sssex", student.getStudentSex());
            mView.addObject("ssbirthday", student.getStudentBirthday());
            mView.addObject("ssplace", student.getStudentPlace());
            mView.addObject("ssdepartment", student.getStudentDepartment());
            mView.addObject("ssclass", student.getStudentClass());
            mView.addObject("ssid", student.getStudentId());
            mView.addObject("ssinschool", student.getStudentInschool());
            mView.setViewName("ad_query_name");
        }
        return mView;
    }

    @Autowired
    private ad_delete_informationService ad_delete_informationService;

    @RequestMapping("/deletebyid")//删除用户
    private ModelAndView deletebyid(HttpServletRequest req, HttpServletResponse resp)
    {
        ModelAndView mView = new ModelAndView();
        String sid = req.getSession().getAttribute("STUDENT_SID").toString();
        boolean flag = ad_delete_informationService.deleteById(sid);
        if (flag)//删除成功
        {
            mView.addObject("flag"," alert(\"删除成功！\")");
            mView.setViewName("ad_query");
        }
        else
        {
            mView.addObject("flag"," alert(\"删除失败！\")");
            mView.setViewName("ad_query");
        }
        return mView;
    }

    @RequestMapping("/updatabyid")//跳转到修改信息界面
    private ModelAndView updatabyid(HttpServletRequest req, HttpServletResponse resp)
    {
        ModelAndView mView = new ModelAndView();
        String sid = req.getSession().getAttribute("STUDENT_SID").toString();
        student student = queryService.queryById(sid);
        mView.addObject("sname",student.getStudentName());
        mView.addObject("ssex",student.getStudentSex());
        mView.addObject("sbirthday",student.getStudentBirthday());
        mView.addObject("splace",student.getStudentPlace());
        mView.addObject("sdepartment",student.getStudentDepartment());
        mView.addObject("sclass",student.getStudentClass());
        mView.addObject("sid",student.getStudentId());
        mView.addObject("sinschool",student.getStudentInschool());
        mView.setViewName("ad_updatabyid_information");
        return mView;
    }

    @Autowired
    private ad_updata_informationService ad_updata_informationService;
    @RequestMapping("updatabyid_information")//将修改的信息更新到数据库中
    private ModelAndView updata_information(HttpServletRequest req, HttpServletResponse resp) throws UnsupportedEncodingException {
        ModelAndView mView = new ModelAndView();
        String sid = req.getSession().getAttribute("STUDENT_SID").toString();
        String sname = new String( req.getParameter("name").getBytes("ISO-8859-1"),"utf-8");
        String sclass = new String( req.getParameter("class").getBytes("ISO-8859-1"),"utf-8");
        String ssex = new String( req.getParameter("sex").getBytes("ISO-8859-1"),"utf-8");
        String sdepartment = new String( req.getParameter("department").getBytes("ISO-8859-1"),"utf-8");
        String splace = new String( req.getParameter("place").getBytes("ISO-8859-1"),"utf-8");
        String birthday = new String( req.getParameter("birthday").getBytes("ISO-8859-1"),"utf-8");
        String inschool = new String( req.getParameter("inschool").getBytes("ISO-8859-1"),"utf-8");
        boolean flag = ad_updata_informationService.updata(sid,sname,ssex,sdepartment,sclass,splace,birthday,inschool);
        if (flag)
        {
            mView.addObject("flag"," alert(\"修改成功！\")");
            mView.setViewName("ad_query");
        }
        else
        {
            mView.addObject("flag"," alert(\"修改失败！\")");
            mView.setViewName("ad_updatabyid_information");
        }
        return mView;
    }
    @RequestMapping("/deletebyname")//删除用户
    private ModelAndView deletebyname(HttpServletRequest req, HttpServletResponse resp)
    {
        ModelAndView mView = new ModelAndView();
        String sname = req.getSession().getAttribute("STUDENT_NAME").toString();
        boolean flag = ad_delete_informationService.deleteByName(sname);
        if (flag)
        {
            mView.addObject("flag"," alert(\"删除成功！\")");
            mView.setViewName("ad_query");
        }else
        {
            mView.addObject("flag","alert(\"删除失败！\")");
            mView.setViewName("ad_query");
        }
        return mView;
    }
    @RequestMapping("/updatabyname")//跳转到修改信息界面
    private ModelAndView updatabyname(HttpServletRequest req, HttpServletResponse resp)
    {
        ModelAndView mView = new ModelAndView();
        String sname = req.getSession().getAttribute("STUDENT_NAME").toString();
        student student = queryService.queryByName(sname);
        mView.addObject("sname",student.getStudentName());
        mView.addObject("ssex",student.getStudentSex());
        mView.addObject("sbirthday",student.getStudentBirthday());
        mView.addObject("splace",student.getStudentPlace());
        mView.addObject("sdepartment",student.getStudentDepartment());
        mView.addObject("sclass",student.getStudentClass());
        mView.addObject("sid",student.getStudentId());
        mView.addObject("sinschool",student.getStudentInschool());
        mView.setViewName("ad_updatabyname_information");
        return mView;
    }
    @RequestMapping("updatabyname_information")//将修改的信息更新到数据库中
    private ModelAndView updatabyname_information(HttpServletRequest req, HttpServletResponse resp) throws UnsupportedEncodingException {
        ModelAndView mView = new ModelAndView();
        String name = req.getSession().getAttribute("STUDENT_NAME").toString();
        student student = queryService.queryByName(name);
        String sid = student.getStudentId();
        String sname = new String( req.getParameter("name").getBytes("ISO-8859-1"),"utf-8");
        String sclass = new String( req.getParameter("class").getBytes("ISO-8859-1"),"utf-8");
        String ssex = new String( req.getParameter("sex").getBytes("ISO-8859-1"),"utf-8");
        String sdepartment = new String( req.getParameter("department").getBytes("ISO-8859-1"),"utf-8");
        String splace = new String( req.getParameter("place").getBytes("ISO-8859-1"),"utf-8");
        String birthday = new String( req.getParameter("birthday").getBytes("ISO-8859-1"),"utf-8");
        String inschool = new String( req.getParameter("inschool").getBytes("ISO-8859-1"),"utf-8");
        boolean flag = ad_updata_informationService.updata(sid,sname,ssex,sdepartment,sclass,splace,birthday,inschool);
        if (flag)
        {
            mView.addObject("flag"," alert(\"修改成功！\")");
            mView.setViewName("ad_query");
        }
        else
        {
            mView.addObject("flag"," alert(\"修改失败！\")");
            mView.setViewName("ad_updatabyname_information");
        }
        return mView;
    }

    @RequestMapping("/addgrade")//跳转到添加成绩界面
    private ModelAndView addgrade(HttpServletRequest req, HttpServletResponse resp) {
        ModelAndView mView = new ModelAndView();
        String sid = req.getSession().getAttribute("STUDENT_SID").toString();
        List<student_course> list = queryService.queryResult(sid);
        if (list.size()==0){
        mView.setViewName("ad_add_grade");
        }else
        {
            mView.addObject("flag"," alert(\"该学生成绩已录入！\")");
            mView.setViewName("ad_query");
        }
        return mView;
    }
    @Autowired
    private ad_add_gradeService ad_add_gradeService;
    @RequestMapping("/add_grade") //实现管理员给学生添加成绩
    private ModelAndView addGrade(HttpServletRequest req, HttpServletResponse resp) throws UnsupportedEncodingException {
        ModelAndView mView = new ModelAndView();
        List<Float> grade = new ArrayList();
        String sid = req.getSession().getAttribute("STUDENT_SID").toString();
        String math = new String( req.getParameter("math").getBytes("ISO-8859-1"),"utf-8");
        String english = new String( req.getParameter("english").getBytes("ISO-8859-1"),"utf-8");
        String wuli = new String( req.getParameter("wuli").getBytes("ISO-8859-1"),"utf-8");
        String C = new String( req.getParameter("C").getBytes("ISO-8859-1"),"utf-8");
        String java = new String( req.getParameter("java").getBytes("ISO-8859-1"),"utf-8");
        String android = new String( req.getParameter("android").getBytes("ISO-8859-1"),"utf-8");
        String web = new String( req.getParameter("web").getBytes("ISO-8859-1"),"utf-8");
        String spring = new String( req.getParameter("spring").getBytes("ISO-8859-1"),"utf-8");
        float smath = Float.parseFloat(math);
        float senglish = Float.parseFloat(english);
        float swuli = Float.parseFloat(wuli);
        float sC = Float.parseFloat(C);
        float sjava = Float.parseFloat(java);
        float sandroid = Float.parseFloat(android);
        float sweb = Float.parseFloat(web);
        float sspring = Float.parseFloat(spring);
        grade.add(smath);
        grade.add(senglish);
        grade.add(swuli);
        grade.add(sC);
        grade.add(sjava);
        grade.add(sandroid);
        grade.add(sweb);
        grade.add(sspring);
        for (int i =0;i<grade_id.length;i++)
        {
            ad_add_gradeService.add_grade(sid,grade_id[i],grade.get(i));
        }
        grade.clear();
        mView.addObject("flag"," alert(\"成绩添加成功！\")");
        mView.setViewName("ad_query");
        return mView;
    }

}
