package com.yb.controller;

import com.yb.entity.Student;
import com.yb.service.impl.StuServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

import static com.yb.config.Constant.ROOT_URL;

/**
 * @author Jue-PC
 */
@Controller
public class StuController {

    private final
    StuServiceImpl stuService;

    @Autowired
    public StuController(StuServiceImpl stuService) {this.stuService = stuService;}

    @RequestMapping("/")
    public String main(HttpServletRequest request) {
        if (request.getSession().getAttribute("student") != null) {
            return "writeText";
        } else {
            return "signIn";
        }
    }

    @RequestMapping("/signIn")
    public String signIn(HttpServletRequest request, Model model) {
        String stuId = request.getParameter("stuId");
        if ("111111".equals(stuId)) {
            return "redirect:"+ROOT_URL+"reader";
        }
        Student student = stuService.query(stuId);
        if (student != null) {
            request.getSession().setAttribute("student", student);
            return "writeText";
        } else {
            model.addAttribute("stuId", stuId);
            return "signUp";
        }
    }

    @RequestMapping("/signUp")
    public String signUp(HttpServletRequest request) {
        Student student = new Student();
        student.setStu_id(request.getParameter("stuId"));
        student.setName(request.getParameter("name"));
        student.setDepartment(request.getParameter("department"));
        student.setClassname(request.getParameter("classname"));
        stuService.insert(student);
        request.getSession().setAttribute("student", student);

        return "writeText";
    }

    @RequestMapping("/goWrite")
    public String goWrite() {
        return "writeText";
    }

    @RequestMapping("/signOut")
    public String signOut(HttpServletRequest request) {
        request.getSession().removeAttribute("student");
        return "redirect:" + ROOT_URL;
    }
}
