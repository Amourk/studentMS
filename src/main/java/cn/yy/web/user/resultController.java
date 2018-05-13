package cn.yy.web.user;

import cn.yy.entity.student_course;
import cn.yy.service.uers.queryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@Controller
public class resultController {

    private List course = new ArrayList();

    @Autowired
    private queryService queryService;
    @RequestMapping("/result")
    private ModelAndView result(HttpServletRequest req, HttpServletResponse resp)
    {
        ModelAndView mView= new ModelAndView();
        //得到保存在session中的学生id
        String sid = req.getSession().getAttribute("STUDENT_ID").toString();
//        int id = Integer.parseInt(sid);
        List<student_course> list = queryService.queryResult(sid);
        for (int i=0;i<list.size();i++ )
        {
            course.add(list.get(i).getCourseScore());
//            list.get(i).getCourseScore();
        }
        mView.addObject("course",course);
        mView.setViewName("result");
        return mView;
    }

}
