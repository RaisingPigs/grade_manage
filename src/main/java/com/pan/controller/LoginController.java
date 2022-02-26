package com.pan.controller;

import com.pan.bean.Admin;
import com.pan.bean.Msg;
import com.pan.bean.Student;
import com.pan.bean.Teacher;
import com.pan.service.AdminService;
import com.pan.service.StudentService;
import com.pan.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * @description:
 * @author: Mr.Pan
 * @create: 2020-12-15 13:24
 **/
@Controller
public class LoginController {
    @Autowired
    private StudentService studentService;

    @Autowired
    private TeacherService teacherService;

    @Autowired
    private AdminService adminService;

    @ResponseBody
    @RequestMapping(value = "/loginCheck", method = RequestMethod.POST)
    public Msg loginCheck(@RequestParam("username") String username, @RequestParam("password") String password, @RequestParam("identity") String identity) {
        Student student = null;
        Teacher teacher = null;
        Admin admin = null;
        if ("student".equals(identity)) {
            student = studentService.login(username, password);
        } else if ("teacher".equals(identity)) {
            teacher = teacherService.login(username, password);
        } else if ("admin".equals(identity)) {
            admin = adminService.login(username, password);
        }

        if (student != null || teacher != null || admin != null) {
            return Msg.success().add("identity", identity);
        }

        return Msg.fail();
    }

    @RequestMapping("/loginSuccess")
    public String login(@RequestParam("identity") String identity, @RequestParam("username") String username, @RequestParam("password") String password, Model model) {
        if ("student".equals(identity)) {
            Student student = studentService.login(username, password);
            model.addAttribute("student", student);
            model.addAttribute("sId", student.getStuId());
            return "student/studentIndex";
        } else if ("teacher".equals(identity)) {
            Teacher teacher = teacherService.login(username, password);
            model.addAttribute("teacher", teacher);
            model.addAttribute("tId", teacher.getTchId());
            return "teacher/teacherIndex";
        } else if ("admin".equals(identity)) {
            Admin admin = adminService.login(username, password);
            model.addAttribute("admin", admin);
            return "backstageAdmin/backstageAdminIndex/backstageAdminIndex";
        }
        return "";
    }

    @GetMapping("/myLogin")
    public String myLogin() {
        return "login";
    }
}
