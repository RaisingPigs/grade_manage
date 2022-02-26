package com.pan.service;

import com.pan.bean.Student;
import com.pan.bean.StudentExample;

import java.util.List;

/**
 * @description:
 * @author: Mr.Pan
 * @create: 2020-12-16 17:32
 **/
public interface StudentService {
    Student login(String username, String password);

    List<Student> getAllStus();

    void saveStu(Student student);

    List<Student> getStudentsLike(StudentExample example);

    Student getStudentWithGradeById(Integer id);

    void updateStudent(Student student);

    void deleteStudentById(Integer id);
}
