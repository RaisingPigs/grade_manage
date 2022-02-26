package com.pan.service.impl;

import com.pan.bean.Homework;
import com.pan.bean.Student;
import com.pan.dao.HomeworkMapper;
import com.pan.dao.StudentMapper;
import com.pan.service.HomeworkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description:
 * @author: Mr.Pan
 * @create: 2020-12-22 14:51
 **/
@Service
public class HomeworkServiceImpl implements HomeworkService {
    @Autowired
    private HomeworkMapper homeworkMapper;

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public void insertHomework(String question, Integer tId) {
        List<Student> students = studentMapper.selectByExample(null);
        Integer hwkId = homeworkMapper.queryMaxHwkId();
        hwkId = hwkId == null ? 1 : hwkId + 1;
        for (Student student : students) {
            Homework homework = new Homework(hwkId, student.getStuId(), tId, question, "", 0);
            homeworkMapper.insertHomework(homework);
        }
    }

    @Override
    public List<Homework> getDistinctHomework(Integer tId) {
        return homeworkMapper.queryDistinctHomework(tId);
    }

    @Override
    public List<Homework> getDistinctHomeworkStu() {
        return homeworkMapper.queryDistinctHomeworkStu();
    }

    @Override
    public void deleteHwk(Integer hwkId) {
        homeworkMapper.deleteHwk(hwkId);
    }

    @Override
    public Homework getHomeworkBySIdAndHwkId(Integer sId, Integer hwkId) {
        return homeworkMapper.queryHomeworkBySIdAndHwkId(sId, hwkId);
    }

    @Override
    public void updateHwkGrd(Integer sId, Integer hwkId, Integer hwkGrd) {
        homeworkMapper.updateHwkGrd(sId, hwkId, hwkGrd);
    }

    @Override
    public void updateHomeworkAnswer(Integer sId, Integer hwkId, String answer) {
        homeworkMapper.updateHomeworkAnswer(sId, hwkId, answer);
    }

    @Override
    public List<Homework> getHomeworkBySId(Integer sId) {
        return homeworkMapper.queryHomework(sId);
    }

    @Override
    public List<Homework> getHomeworkBySIdAndTId(Integer sId, Integer tId) {
        return homeworkMapper.queryHomeworkBySIdAndTId(sId, tId);
    }

}
