package com.pan.service.impl;

import com.pan.bean.Grade;
import com.pan.dao.GradeMapper;
import com.pan.service.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @description:
 * @author: Mr.Pan
 * @create: 2020-12-17 18:18
 **/
@Service
public class GradeServiceImpl implements GradeService {
    @Autowired
    private GradeMapper gradeMapper;

    @Override
    public void saveGrade(Grade grade) {
        gradeMapper.insertSelective(grade);
    }

    @Override
    public void updateGrade(Grade grade) {
        gradeMapper.updateGradeByStuId(grade);
    }

    @Override
    public Grade getGrade(Integer stuId) {
        return gradeMapper.getGrade(stuId);
    }

    @Override
    public void updateJavaGradeBySId(Integer sId, Integer java) {
        gradeMapper.updateJavaGradeBySId(sId, java);
    }

    @Override
    public void updateCGradeBySId(Integer sId, Integer java) {
        gradeMapper.updateCGradeBySId(sId, java);

    }

    @Override
    public void updateCppGradeBySId(Integer sId, Integer java) {
        gradeMapper.updateCPPGradeBySId(sId, java);

    }
}
