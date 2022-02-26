package com.pan.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pan.bean.*;
import com.pan.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: Mr.Pan
 * @create: 2020-12-16 21:43
 **/
@Controller
public class StudentController {
    @Autowired
    private StudentService studentService;

    @Autowired
    private GradeService gradeService;

    @Autowired
    private HomeworkService homeworkService;
    
    @Autowired
    private ExperimentService experimentService;

    @Autowired
    private TeacherService teacherService;

    @ResponseBody
    @RequestMapping("/stus")
    public Msg getStusWithJson(@RequestParam(value = "pn", defaultValue = "1") Integer pn) {
        /*传入页码, 以及每页的大小*/
        PageHelper.startPage(pn, 6);

        /*startPage后紧跟的查询就是一个分页查询*/
        List<Student> students = studentService.getAllStus();

        /*使用pageInfo来包装查询后的结果*/
        /*pageInfo中封装了详细的信息*/
        /*构造器中传入查询到的集合, 和连续显示的页个数*/
        PageInfo pageInfo = new PageInfo(students, 5);
        return Msg.success().add("pageInfo", pageInfo);
    }

    @ResponseBody
    @PostMapping("/stu")
    public Msg saveStu(Student student) {
        studentService.saveStu(student);

        StudentExample studentExample = new StudentExample();
        studentExample.createCriteria().andStuNameEqualTo(student.getStuName()).andStuSexEqualTo(student.getStuSex()).andStuAgeEqualTo(student.getStuAge()).andStuMajorEqualTo("计算机").andStuClassEqualTo(2001);

        List<Student> students = studentService.getStudentsLike(studentExample);
        gradeService.saveGrade(new Grade(students.get(0).getStuId(), null, null, null));
        return Msg.success();
    }

    /*根据id查找学生*/
    @ResponseBody
    @GetMapping("/getStu/{id}")
    public Msg getStudentById(@PathVariable("id") Integer id) {
        Student student = studentService.getStudentWithGradeById(id);
        return Msg.success().add("stu", student);
    }

    /*修改学生*/
    @ResponseBody
    @PutMapping("/updateStu/{stuId}")
    public Msg updateStudent(Student student) {
        studentService.updateStudent(student);
        return Msg.success();
    }

    /*删除学生*/
    @ResponseBody
    @DeleteMapping("/deleteStu/{id}")
    public Msg deleteStudentById(@PathVariable("id") Integer id) {
        studentService.deleteStudentById(id);
        return Msg.success();
    }

    /*搜索-模糊查询*/
    @ResponseBody
    @GetMapping("/searchStu/{stuName}/{pn}")
    public Msg searchStudent(@PathVariable("stuName") String stuName, @PathVariable("pn") Integer pn) {
        PageHelper.startPage(pn, 6);
        StudentExample studentExample = new StudentExample();
        studentExample.createCriteria().andStuNameLike("%" + stuName + "%");
        List<Student> students = studentService.getStudentsLike(studentExample);
        PageInfo pageInfo = new PageInfo(students, 5);
        return Msg.success().add("pageInfo", pageInfo);
    }

    @GetMapping("/studentPersonalInfoControl/{sId}")
    public String studentPersonalInfo(@PathVariable Integer sId, Model model) {
        model.addAttribute("sId", sId);
        model.addAttribute("student", studentService.getStudentWithGradeById(sId));
        return "student/studentPersonalInfo";
    }

    @GetMapping("/studentIndexControl/{sId}")
    public String studentIndex(@PathVariable Integer sId, Model model) {
        model.addAttribute("sId", sId);
        model.addAttribute("student", studentService.getStudentWithGradeById(sId));
        return "student/studentIndex";
    }

    @GetMapping("/studentHomeworkControl/{sId}")
    public String studentHomework(@PathVariable Integer sId, Model model) {
        model.addAttribute("sId", sId);
        //List<Homework> hwks = homeworkService.getDistinctHomeworkStu();
        List<Homework> hwks = homeworkService.getHomeworkBySId(sId);
        List<Teacher> teachers = new ArrayList<>();
        for (Homework hwk : hwks) {
            System.out.println(hwk);
            Teacher teacher = teacherService.getTeacher(hwk.gettId());
            System.out.println(teacher);
            teachers.add(teacher);
        }
        model.addAttribute("hwks", hwks);
        model.addAttribute("student", studentService.getStudentWithGradeById(sId));
        model.addAttribute("teachers", teachers);
        return "student/studentHomework";
    }

    @GetMapping("/studentHomeworkInnerControl/{sId}/{hwkId}")
    public String studentHomeworkInnerControl(@PathVariable Integer sId, @PathVariable("hwkId") Integer hwkId, Model model) {
        model.addAttribute("sId", sId);
        model.addAttribute("hwkId", hwkId);
        Homework hwk = homeworkService.getHomeworkBySIdAndHwkId(sId, hwkId);
        model.addAttribute("hwk", hwk);
        model.addAttribute("student", studentService.getStudentWithGradeById(sId));
        return "student/studentHomeworkInner";
    }

    @GetMapping("/studentExperimentControl/{sId}")
    public String studentExperimentControl(@PathVariable Integer sId, Model model) {
        model.addAttribute("sId", sId);
        List<Experiment> experiments = experimentService.getExprBySId(sId);
        List<Teacher> teachers = new ArrayList<>();
        for (Experiment experiment : experiments) {
            Teacher teacher = teacherService.getTeacher(experiment.gettId());
            teachers.add(teacher);
        }
        model.addAttribute("exprs", experiments);
        model.addAttribute("student", studentService.getStudentWithGradeById(sId));
        model.addAttribute("teachers", teachers);
        return "student/studentExperiment";
    }

    @GetMapping("/studentExperimentInnerControl/{sId}/{exprId}")
    public String studentExperimentInnerControl(@PathVariable Integer sId, @PathVariable("exprId") Integer exprId, Model model) {
        model.addAttribute("sId", sId);
        model.addAttribute("exprId", exprId);
        Experiment experiment = experimentService.getExperimentBySIdAndExprId(sId, exprId);
        model.addAttribute("expr", experiment);
        model.addAttribute("student", studentService.getStudentWithGradeById(sId));
        return "student/studentExperimentInner";
    }
}
