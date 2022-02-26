package com.pan.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pan.bean.*;
import com.pan.service.ExperimentService;
import com.pan.service.HomeworkService;
import com.pan.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @description:
 * @author: Mr.Pan
 * @create: 2020-12-20 18:41
 **/
@Controller
public class TeacherController {
    @Autowired
    private TeacherService teacherService;

    @Autowired
    private ExperimentService experimentService;

    @Autowired
    private HomeworkService homeworkService;
    
/*教师信息分页处理*/
    @ResponseBody
    @RequestMapping("/teacher")
    public Msg getStusWithJson(@RequestParam(value = "pn", defaultValue = "1") Integer pn) {
        /*传入页码, 以及每页的大小*/
        PageHelper.startPage(pn, 6);

        /*startPage后紧跟的查询就是一个分页查询*/
        List<Teacher> teachers = teacherService.getAllTeachers();

        /*使用pageInfo来包装查询后的结果*/
        /*pageInfo中封装了详细的信息*/
        /*构造器中传入查询到的集合, 和连续显示的页个数*/
        PageInfo pageInfo = new PageInfo(teachers, 5);
        return Msg.success().add("pageInfo", pageInfo);
    }

    /*增加教师*/
    @ResponseBody
    @PostMapping("/teacher")
    public Msg saveStu(Teacher teacher) {
        teacherService.addTeacher(teacher);
        return Msg.success();
    }

    /*根据id查找学生*/
    @ResponseBody
    @GetMapping("/getTeacher/{id}")
    public Msg getStudentById(@PathVariable("id") Integer id) {
        Teacher teacher = teacherService.getTeacher(id);
        return Msg.success().add("teacher", teacher);
    }

    /*修改学生*/
    @ResponseBody
    @PutMapping("/updateTeacher/{tchId}")
    public Msg updateStudent(Teacher teacher) {
        System.out.println(teacher);
        teacherService.updateTeacher(teacher);
        return Msg.success();
    }

    /*删除学生*/
    @ResponseBody
    @DeleteMapping("/deleteTeacher/{id}")
    public Msg deleteStudentById(@PathVariable("id") Integer id) {
        teacherService.deleteTeacherById(id);
        return Msg.success();
    }

    /*搜索-模糊查询*/
    @ResponseBody
    @GetMapping("/searchTeacher/{teacherName}/{pn}")
    public Msg searchStudent(@PathVariable("teacherName") String teacherName, @PathVariable("pn") Integer pn) {
        PageHelper.startPage(pn, 6);
        TeacherExample teacherExample = new TeacherExample();
        teacherExample.createCriteria().andTchNameLike("%" + teacherName + "%");
        List<Teacher> teachers = teacherService.getTeachersLike(teacherExample);
        PageInfo pageInfo = new PageInfo(teachers, 5);
        return Msg.success().add("pageInfo", pageInfo);
    }


    /*教师后台首页*/
    @GetMapping("/teacherIndexControl/{tId}")
    public String toTeacherIndex(@PathVariable("tId") Integer tId, Model model) {
        model.addAttribute("tId", tId);
        Teacher teacher = teacherService.getTeacher(tId);
        model.addAttribute("teacher", teacher);
        return "teacher/teacherIndex";
    }

    /*教师学生信息*/
    @GetMapping("/teacherStudentInfoControl/{tId}")
    public String toStudentInfo(@PathVariable("tId") Integer tId, Model model) {
        model.addAttribute("tId", tId);
        Teacher teacher = teacherService.getTeacher(tId);
        model.addAttribute("teacher", teacher);
        return "teacher/teacherStudentInfo";
    }

    /*教师学生成绩*/
    @GetMapping("/teacherStudentGradeControl/{tId}")
    public String toTeacherStudentGrade(@PathVariable("tId") Integer tId, Model model) {
        model.addAttribute("tId", tId);
        Teacher teacher = teacherService.getTeacher(tId);
        model.addAttribute("teacher", teacher);
        return "teacher/teacherStudentGrade";
    }

    /*教师个人信息*/
    @GetMapping("/teacherPersonalInfoControl/{tId}")
    public String toTeacherPersonalInfo(@PathVariable("tId") Integer tId, Model model) {
        model.addAttribute("tId", tId);
        Teacher teacher = teacherService.getTeacher(tId);
        model.addAttribute("teacher", teacher);
        return "teacher/teacherPersonalInfo";
    }

    /*教师作业安排*/
    @GetMapping("/teacherHomeworkControl/{tId}")
    public String toTeacherHomework(@PathVariable("tId") Integer tId, Model model) {
        List<Homework> distinctHomework = homeworkService.getDistinctHomework(tId);
        model.addAttribute("distinctHomework", distinctHomework);
        model.addAttribute("tId", tId);
        Teacher teacher = teacherService.getTeacher(tId);
        model.addAttribute("teacher", teacher);
        return "teacher/teacherHomework";
    }

    /*教师实验安排*/
    @GetMapping("/teacherExperimentControl/{tId}")
    public String toTeacherExperiment(@PathVariable("tId") Integer tId, Model model) {
        List<Experiment> distinctExperiment = experimentService.getDistinctExperiment(tId);
        model.addAttribute("distinctExperiment", distinctExperiment);
        model.addAttribute("tId", tId);
        Teacher teacher = teacherService.getTeacher(tId);
        model.addAttribute("teacher", teacher);
        return "teacher/teacherExperiment";
    }

    /*教师查看学生实验*/
    @GetMapping("/teacherStudentExperimentControl/{tId}/{exprId}")
    public String toTeacherStudentExperimentByExprId(@PathVariable("tId") Integer tId, @PathVariable("exprId") Integer exprId, Model model) {
        model.addAttribute("exprId", exprId);
        model.addAttribute("tId", tId);
        Teacher teacher = teacherService.getTeacher(tId);
        model.addAttribute("teacher", teacher);
        return "teacher/teacherStudentExperiment";
    }

    /*教师查看学生作业*/
    @GetMapping("/teacherStudentHomeworkControl/{tId}/{hwkId}")
    public String toTeacherStudentHomework(@PathVariable("tId") Integer tId, @PathVariable("hwkId") Integer hwkId, Model model) {
        model.addAttribute("hwkId", hwkId);
        model.addAttribute("tId", tId);
        Teacher teacher = teacherService.getTeacher(tId);
        model.addAttribute("teacher", teacher);
        return "teacher/teacherStudentHomework";
    }
}
