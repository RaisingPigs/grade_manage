package com.pan.service.impl;

import com.pan.bean.Student;
import com.pan.bean.StudentExample;
import com.pan.dao.StudentMapper;
import com.pan.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description:
 * @author: Mr.Pan
 * @create: 2020-12-16 17:41
 **/

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentMapper studentMapper;

    @Override
    public Student login(String username, String password) {
        StudentExample studentExample = new StudentExample();
        studentExample.createCriteria().andStuIdEqualTo(Integer.parseInt(username)).andStuPwdEqualTo(password);
        List<Student> students = studentMapper.selectByExample(studentExample);
        return students.isEmpty() ? null : students.get(0);
    }

    @Override
    public List<Student> getAllStus() {
        return studentMapper.selectByExampleWithGrade(null);
    }

    @Override
    public void saveStu(Student student) {
        studentMapper.insertSelective(student);
    }

    @Override
    public List<Student> getStudentsLike(StudentExample example) {
        return studentMapper.selectByExampleWithGrade(example);
    }

    @Override
    public Student getStudentWithGradeById(Integer id) {
        return studentMapper.selectByPrimaryKeyWithGrade(id);
    }

    @Override
    public void updateStudent(Student student) {
        studentMapper.updateByPrimaryKeySelective(student);
    }

    @Override
    public void deleteStudentById(Integer id) {
        studentMapper.deleteByPrimaryKey(id);
    }


}
