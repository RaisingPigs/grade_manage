package com.pan.service.impl;

import com.pan.bean.GradePercent;
import com.pan.dao.GradePercentMapper;
import com.pan.service.GradePercentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @description:
 * @author: Mr.Pan
 * @create: 2020-12-21 15:39
 **/
@Service
public class GradePercentServiceImpl implements GradePercentService {
    @Autowired
    private GradePercentMapper gradePercentMapper;
    
    @Override
    public GradePercent getGradePercent() {
        return gradePercentMapper.getGradePercentByTId();
    }

    @Override
    public void saveGradePercent(GradePercent gradePercent) {
        gradePercentMapper.updateGradePercent(gradePercent);
    }
}
