package com.pan.dao;

import com.pan.bean.Experiment;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @description:
 * @author: Mr.Pan
 * @create: 2020-12-25 23:45
 **/
public interface ExperimentMapper {
    void insertExperiment(Experiment experiment);

    void deleteExperiment(@Param("exprId") Integer exprId);

    void updateExperimentAnswer(Experiment experiment);
    
    void updateExperimentGrade(Experiment experiment);

    List<Experiment> queryExperimentBysId(@Param("sId") Integer sId);

    Experiment queryExperimentBySIdAndExprId(@Param("sId") Integer sId, @Param("exprId") Integer exprId);

    List<Experiment> queryAllExperiments();

    List<Experiment> queryDistinctExpr(@Param("tId") Integer tId);
    
    List<Experiment> queryDistinctExprStu();

    Integer queryMaxExprId();

    List<Experiment> queryExperimentBysIdAndTId(@Param("sId") Integer sId, @Param("tId") Integer tId);
}
