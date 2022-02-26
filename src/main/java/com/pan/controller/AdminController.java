package com.pan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @description:
 * @author: Mr.Pan
 * @create: 2020-12-20 01:08
 **/
@Controller
public class AdminController {
    /*管理员后台首页*/
    @GetMapping("/backstageIndexAdminControl")
    public String toBackstageAdminIndex() {
        return "backstageAdmin/backstageAdminIndex/backstageAdminIndex";
    }

    /*管理员后台学生信息*/
    @GetMapping("/backstageAdminStudentInfoControl")
    public String toBackstageAdminStudentInfo() {
        return "backstageAdmin/backstageAdminStudentManage/backstageAdminStudentInfo";
    }

    /*管理员后台学生成绩*/
    @GetMapping("/backstageAdminStudentGradeControl")
    public String toBackstageAdminStudentGrade() {
        return "backstageAdmin/backstageAdminStudentManage/backstageAdminStudentGrade";
    }

    /*管理员教师信息*/
    @GetMapping("/backstageAdminTeacherInfoControl")
    public String toBackstageAdminTeacherInfo() {
        return "backstageAdmin/backstageAdminTeacherManage/backstageAdminTeacherInfo";
    }

    /*管理员学生密码*/
    @GetMapping("/backstageAdminStudentPasswordControl")
    public String toBackstageAdminStudentPassword() {
        return "backstageAdmin/backstageAdminPasswordManage/backstageAdminStudentPassword";
    }

    /*管理员教师密码*/
    @GetMapping("/backstageAdminTeacherPasswordControl")
    public String toBackstageAdminTeacherPassword() {
        return "backstageAdmin/backstageAdminPasswordManage/backstageAdminTeacherPassword";
    }
    
    /*管理员个人信息*/
    @GetMapping("/backstageAdminPersonalInfoControl")
    public String toBackstageAdminPersonalInfo() {
        return "backstageAdmin/backstageAdminPersonalInfo/backstageAdminPersonalInfo";
    }
}
