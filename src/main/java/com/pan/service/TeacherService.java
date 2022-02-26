package com.pan.service;

import com.pan.bean.Teacher;
import com.pan.bean.TeacherExample;

import java.util.List;

/**
 * @description:
 * @author: Mr.Pan
 * @create: 2020-12-16 17:32
 **/
public interface TeacherService {
    Teacher login(String username, String password);

    List<Teacher> getAllTeachers();

    List<Teacher> getTeachersLike(TeacherExample example);

    void addTeacher(Teacher teacher);

    void deleteTeacherById(Integer id);

    void updateTeacher(Teacher teacher);

    Teacher getTeacher(Integer id);
}
