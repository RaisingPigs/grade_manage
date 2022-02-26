package com.pan.controller;

import com.pan.bean.Grade;
import com.pan.bean.Msg;
import com.pan.bean.Teacher;
import com.pan.service.GradeService;
import com.pan.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @description:
 * @author: Mr.Pan
 * @create: 2020-12-20 17:03
 **/
@Controller
public class GradeController {
    @Autowired
    private GradeService gradeService;

    @Autowired
    private TeacherService teacherService;

    @ResponseBody
    @PutMapping("/updateStuGrade/{stuId}")
    public Msg updateStudentGrade(Grade grade) {
        gradeService.updateGrade(grade);
        return Msg.success();
    }

    @ResponseBody
    @PutMapping("/updateGrade/{sId}/{java}/{tId}")
    public Msg updateStudentGrade(@PathVariable("sId") Integer sId, @PathVariable("java") Integer java, @PathVariable("tId") String tId) {
        Teacher teacher = teacherService.getTeacher(Integer.parseInt(tId));
        System.out.println(teacher.getcName());
        if (teacher.getcName().equals("java")) {
            gradeService.updateJavaGradeBySId(sId, java);
        } else if (teacher.getcName().equals("c")) {
            gradeService.updateCGradeBySId(sId, java);
        } else if (teacher.getcName().equals("cpp")) {
            gradeService.updateCppGradeBySId(sId, java);
        }
        return Msg.success();
    }
}
