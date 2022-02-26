package com.pan.mytest;

import com.pan.bean.*;
import com.pan.dao.*;
import org.apache.ibatis.jdbc.Null;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.Random;

/**
 * @description:
 * @author: Mr.Pan
 * @create: 2020-12-15 11:19
 **/

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class MapperTest {

    @Autowired
    private StudentMapper studentMapper;

    @Autowired
    private TeacherMapper teacherMapper;

    @Autowired
    private AdminMapper adminMapper;

    @Autowired
    private GradeMapper gradeMapper;

    @Autowired
    private GradePercentMapper gradePercentMapper;

    @Autowired
    private HomeworkMapper homeworkMapper;

    @Autowired
    private ExperimentMapper experimentMapper;

    @Autowired
    private SqlSession sqlSession;

    @Test
    public void test() {
        //List<Student> students = studentMapper.selectByExampleWithGrade(null);
        //for (Student student : students) {
        //    System.out.println(student);
        //}

        //adminMapper = sqlSession.getMapper(AdminMapper.class);
        //List<Admin> admins = adminMapper.selectByExample(null);
        //for (Admin admin : admins) {
        //    System.out.println(admin);
        //}

        //gradeMapper.insertSelective(new Grade(20000, null, null, null));

        //StudentExample studentExample = new StudentExample();
        //studentExample.createCriteria().andStuNameLike("%王%");
        //List<Student> students = studentMapper.selectByExample(studentExample);
        //for (Student student : students) {
        //    System.out.println(student);
        //}

        //Student student = studentMapper.selectByPrimaryKeyWithGrade(222221);
        //System.out.println(student);
        //String[] lastName = {"王", "赵", "周", "孙", "李", "吴", "杨", "张", "宋", "马"};
        //String[] firstName = {"凤", "丽", "震", "文", "豪", "佳", "恒", "静", "雷", "文", "婷", "玲", "莫", "风", "东", "栋", "冬", "秋", "水", "蓝", "草", "明", "铭", "路"};
        //studentMapper = sqlSession.getMapper(StudentMapper.class);
        //
        //for (int i = 0; i < 100; i++) {
        //    Random random = new Random();
        //    String name;
        //    if (random.nextInt(2) == 1) {
        //        name = lastName[random.nextInt(lastName.length)] + firstName[random.nextInt(firstName.length)];
        //    } else {
        //        name = lastName[random.nextInt(lastName.length)] + firstName[random.nextInt(firstName.length)] + firstName[random.nextInt(firstName.length)];
        //    }
        //    String sex = random.nextInt(2) == 1 ? "男" : "女";
        //    Integer age = random.nextInt(6) + 17;
        //    Student student = new Student(null, name, sex, age, "计算机", 2001, null, null);
        //    studentMapper.insertSelective(student);
        //}

        //GradeMapper gradeMapper = sqlSession.getMapper(GradeMapper.class);
        //Random random = new Random();
        //for (int i = 222224; i < 222324; i++) {
        //    int java = random.nextInt(50) + 40;
        //    int c = random.nextInt(50) + 40;
        //    int cpp = random.nextInt(50) + 40;
        //    gradeMapper.insertSelective(new Grade(i, java, c, cpp));
        //}

        //Grade grade = gradeMapper.getGrade(222222);
        //System.out.println(grade);
        //
        //Grade grade1 = new Grade(222222, 80, 90, 70);
        //gradeMapper.updateGradeByStuId(grade1);
        //
        //GradePercent gradePercent = gradePercentMapper.getGradePercentByTId();
        //System.out.println(gradePercent);

        //homeworkMapper = sqlSession.getMapper(HomeworkMapper.class);
        //for (int i = 0; i < 106; i++) {
        //    homeworkMapper.insertHomework(new Homework(null, 111111, "", ""));
        //}

        //homeworkMapper.updateHomeworkQuestion("");

        //homeworkMapper.updateHomeworkAnswer("123", 222221);

        //Homework homework = homeworkMapper.queryHomework(222221);
        //System.out.println(homework);

        //List<Homework> homework = homeworkMapper.queryAllHomeworks();
        //for (Homework homework1 : homework) {
        //    System.out.println(homework1);
        //};

        //String question = "实验题目3";
        //List<Student> students = studentMapper.selectByExample(null);
        //Integer exprId = experimentMapper.queryMaxExprId();
        //exprId = exprId == null ? 1 : exprId + 1;
        //for (Student student : students) {
        //    Experiment experiment = new Experiment(exprId, student.getStuId(), 111111, question, "", 0);
        //    experimentMapper.insertExperiment(experiment);
        //}
        
        //Experiment experiment = new Experiment(2, 222222, null, null, "第二个学生的回答", null);
        //experimentMapper.updateExperimentAnswer(experiment);
        
        //Experiment experiment = new Experiment(2, 222222, null, null, null, 50);
        //experimentMapper.updateExperimentGrade(experiment);

        //List<Experiment> experiments = experimentMapper.queryExperimentByExprId(2);
        //for (Experiment experiment : experiments) {
        //    System.out.println(experiment);
        //}

        //List<Experiment> experiments = experimentMapper.queryExperimentBySId(222222);
        //for (Experiment experiment : experiments) {
        //    System.out.println(experiment);
        //}

        //experimentMapper.deleteExperiment(3);

        //List<Experiment> experiments = experimentMapper.queryDistinctExpr();
        //for (Experiment experiment : experiments) {
        //    System.out.println(experiment);
        //}

        //Experiment experiment = experimentMapper.queryExperimentBySIdAndExprId(222221, 1);
        //System.out.println(experiment);

        //String question = "第一个实验";
        //List<Student> students = studentMapper.selectByExample(null);
        //Integer hwkId = homeworkMapper.queryMaxHwkId();
        //hwkId = hwkId == null ? 1 : hwkId + 1;
        //for (Student student : students) {
        //    Homework homework = new Homework(hwkId, student.getStuId(), 111111, question, null, null);
        //    homeworkMapper.insertHomework(homework);
        //}

        //Homework homework = new Homework(homeworkMapper.queryMaxHwkId() + 1, 222222, 111111, "新作业", "", null);
        //homeworkMapper.insertHomework(homework);
        //
        //List<Homework> homework1 = homeworkMapper.queryHomework(222222);
        //for (Homework homework2 : homework1) {
        //    System.out.println(homework2);
        //}
        //
        //homeworkMapper.updateHomeworkAnswer(222222, homework.gettId(), "123");
        //
        //Homework homework2 = homeworkMapper.queryHomeworkBySIdAndHwkId(222222, homework.getHwkId());
        //System.out.println(homework2);

        //GradePercent gradePercentByTId = gradePercentMapper.getGradePercentByTId();
        //System.out.println(gradePercentByTId);
        //
        //GradePercent newGradePercent = new GradePercent(111111, 10, 70, 20);
        //gradePercentMapper.updateGradePercent(newGradePercent);
        //
        //GradePercent gradePercent = gradePercentMapper.getGradePercentByTId();
        //System.out.println(gradePercent);

        Grade grade = gradeMapper.getGrade(222222);
        System.out.println(grade);

        gradeMapper.updateJavaGradeBySId(222222, 90);

        Grade newGrade = gradeMapper.getGrade(222222);
        System.out.println(newGrade);

    }
}
