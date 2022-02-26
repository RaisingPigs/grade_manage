package com.pan.dao;

import com.pan.bean.Grade;
import com.pan.bean.GradeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GradeMapper {
    long countByExample(GradeExample example);

    int deleteByExample(GradeExample example);

    int insert(Grade record);

    int insertSelective(Grade record);

    List<Grade> selectByExample(GradeExample example);

    int updateByExampleSelective(@Param("record") Grade record, @Param("example") GradeExample example);

    int updateByExample(@Param("record") Grade record, @Param("example") GradeExample example);

    void updateGradeByStuId(Grade grade);

    Grade getGrade(Integer stuId);

    void updateJavaGradeBySId(@Param("sId") Integer sId, @Param("java") Integer java);

    void updateCGradeBySId(@Param("sId") Integer sId, @Param("java") Integer java);

    void updateCPPGradeBySId(@Param("sId") Integer sId, @Param("java") Integer java);
}