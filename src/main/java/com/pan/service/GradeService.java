package com.pan.service;

import com.pan.bean.Grade;
import org.apache.ibatis.annotations.Param;

/**
 * @description:
 * @author: Mr.Pan
 * @create: 2020-12-17 18:18
 **/
public interface GradeService {
    void saveGrade(Grade grade);

    void updateGrade(Grade grade);

    Grade getGrade(Integer stuId);

    void updateJavaGradeBySId(Integer sId, Integer java);
    
    void updateCGradeBySId(Integer sId, Integer java);
    
    void updateCppGradeBySId(Integer sId, Integer java);
}
