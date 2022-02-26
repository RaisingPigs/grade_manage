package com.pan.service.impl;

import com.pan.bean.Teacher;
import com.pan.bean.TeacherExample;
import com.pan.dao.TeacherMapper;
import com.pan.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description:
 * @author: Mr.Pan
 * @create: 2020-12-16 18:16
 **/
@Service
public class TeacherServiceImpl implements TeacherService {
    @Autowired
    private TeacherMapper teacherMapper;

    @Override
    public Teacher login(String username, String password) {
        TeacherExample teacherExample = new TeacherExample();
        teacherExample.createCriteria().andTchIdEqualTo(Integer.parseInt(username)).andTchPwdEqualTo(password);
        List<Teacher> teachers = teacherMapper.selectByExample(teacherExample);
        return teachers.isEmpty() ? null : teachers.get(0);
    }

    @Override
    public List<Teacher> getAllTeachers() {
        return teacherMapper.selectByExample(null);
    }

    @Override
    public List<Teacher> getTeachersLike(TeacherExample example) {
        return teacherMapper.selectByExample(example);
    }

    @Override
    public void addTeacher(Teacher teacher) {
        teacherMapper.insertSelective(teacher);
    }

    @Override
    public void deleteTeacherById(Integer id) {
        teacherMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void updateTeacher(Teacher teacher) {
        teacherMapper.updateByPrimaryKeySelective(teacher);
    }

    @Override
    public Teacher getTeacher(Integer id) {
        return teacherMapper.selectByPrimaryKey(id);
    }

}
