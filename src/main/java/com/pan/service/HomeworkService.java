package com.pan.service;

import com.pan.bean.Homework;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @description:
 * @author: Mr.Pan
 * @create: 2020-12-22 14:50
 **/
public interface HomeworkService {
    void insertHomework(String question, Integer tId);
    
    List<Homework> getDistinctHomework(Integer tId);
    
    List<Homework> getDistinctHomeworkStu();
    
    void deleteHwk(Integer hwkId);

    Homework getHomeworkBySIdAndHwkId(Integer sId, Integer hwkId);

    void updateHwkGrd(Integer sId, Integer hwkId, Integer hwkGrd);
    
    void updateHomeworkAnswer(Integer sId, Integer hwkId, String answer);

    List<Homework> getHomeworkBySId(Integer sId);

    List<Homework> getHomeworkBySIdAndTId(Integer sId, Integer tId);
}
