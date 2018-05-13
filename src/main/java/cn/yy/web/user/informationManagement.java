package cn.yy.web.user;

import cn.yy.entity.student;
import cn.yy.service.uers.selectInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class informationManagement {


    @Autowired
    private selectInformationService selectInformationService;
    @RequestMapping("/information")
    private ModelAndView information(HttpServletRequest req, HttpServletResponse resp)
    {
        ModelAndView mView= new ModelAndView();
        //得到保存在session中的学生id
        String sid = req.getSession().getAttribute("STUDENT_ID").toString();
        student student = selectInformationService.selectInformation(sid);
//        System.out.printf("姓名是："+student.getStudentName());
        mView.addObject("sname",student.getStudentName());
        mView.addObject("ssex",student.getStudentSex());
        mView.addObject("sbirthday",student.getStudentBirthday());
        mView.addObject("splace",student.getStudentPlace());
        mView.addObject("sdepartment",student.getStudentDepartment());
        mView.addObject("sclass",student.getStudentClass());
        mView.addObject("sid",student.getStudentId());
        mView.addObject("sinschool",student.getStudentInschool());
        mView.setViewName("information");
        return mView;
    }
}
