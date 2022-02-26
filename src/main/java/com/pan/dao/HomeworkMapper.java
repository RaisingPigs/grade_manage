package com.pan.dao;

import com.pan.bean.Homework;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @description:
 * @author: Mr.Pan
 * @create: 2020-12-22 10:39
 **/
public interface HomeworkMapper {
    void insertHomework(Homework homework);

    List<Homework> queryDistinctHomework(@Param("tId") Integer tId);
    
    List<Homework> queryDistinctHomeworkStu();

    Integer queryMaxHwkId();
    
    void deleteHwk(@Param("hwkId") Integer hwkId);

    Homework queryHomeworkBySIdAndHwkId(@Param("sId") Integer sId, @Param("hwkId") Integer hwkId);

    void updateHomeworkAnswer(@Param("sId") Integer sId, @Param("hwkId") Integer hwkId, @Param("answer") String answer);

    void updateHwkGrd(@Param("sId") Integer sId, @Param("hwkId") Integer hwkId, @Param("hwkGrd") Integer hwkGrd);

    List<Homework> queryHomework(@Param("sId") Integer sId);

    List<Homework> queryHomeworkBySIdAndTId(@Param("sId") Integer sId, @Param("tId") Integer tId);
}
