package com.pan.service;

import com.pan.bean.Experiment;

import java.util.List;

/**
 * @description:
 * @author: Mr.Pan
 * @create: 2020-12-26 09:30
 **/
public interface ExperimentService {
    List<Experiment> getDistinctExperiment(Integer tId);
    List<Experiment> getDistinctExperimentStu();

    Experiment getExperimentBySIdAndExprId(Integer sId, Integer exprId);

    void updateExprGrd(Experiment experiment);

    void insertExpr(String question, Integer tId);

    List<Experiment> getExprBySId(Integer sId);

    void updateExprAnswer(Integer sId, String exprId, String answer);

    void deleteExpr(Integer exprId);

    List<Experiment> getExprBySIdAndTId(Integer sId, Integer tId);
}
