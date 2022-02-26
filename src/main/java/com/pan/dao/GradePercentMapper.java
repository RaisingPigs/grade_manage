package com.pan.dao;

import com.pan.bean.GradePercent;

/**
 * @description:
 * @author: Mr.Pan
 * @create: 2020-12-21 15:25
 **/
public interface GradePercentMapper {
    GradePercent getGradePercentByTId();

    void updateGradePercent(GradePercent gradePercent);
}
