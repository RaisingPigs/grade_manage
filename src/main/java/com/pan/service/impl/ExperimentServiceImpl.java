package com.pan.service.impl;


import com.pan.bean.Experiment;
import com.pan.bean.Student;
import com.pan.dao.ExperimentMapper;
import com.pan.dao.StudentMapper;
import com.pan.service.ExperimentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * @description:
 * @author: Mr.Pan
 * @create: 2020-12-26 09:30
 **/
@Service
public class ExperimentServiceImpl implements ExperimentService {
    @Autowired
    private ExperimentMapper experimentMapper;

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public List<Experiment> getDistinctExperiment(Integer tId) {
        return experimentMapper.queryDistinctExpr(tId);
    }

    @Override
    public List<Experiment> getDistinctExperimentStu() {
        return experimentMapper.queryDistinctExprStu();
    }

    @Override
    public Experiment getExperimentBySIdAndExprId(Integer sId, Integer exprId) {
        return experimentMapper.queryExperimentBySIdAndExprId(sId, exprId);
    }

    @Override
    public void updateExprGrd(Experiment experiment) {
        experimentMapper.updateExperimentGrade(experiment);
    }

    @Override
    public void insertExpr(String question, Integer tId) {
        List<Student> students = studentMapper.selectByExample(null);
        Integer exprId = experimentMapper.queryMaxExprId();
        exprId = exprId == null ? 1 : exprId + 1;
        for (Student student : students) {
            Experiment experiment = new Experiment(exprId, student.getStuId(), tId, question, "", 0);
            experimentMapper.insertExperiment(experiment);
        }
    }

    @Override
    public List<Experiment> getExprBySId(Integer sId) {
        return experimentMapper.queryExperimentBysId(sId);
    }

    @Override
    public void updateExprAnswer(Integer sId, String exprId, String answer) {
        experimentMapper.updateExperimentAnswer(new Experiment(Integer.parseInt(exprId), sId, null, null, answer, null));
    }

    @Override
    public void deleteExpr(Integer exprId) {
        experimentMapper.deleteExperiment(exprId);
    }

    @Override
    public List<Experiment> getExprBySIdAndTId(Integer sId, Integer tId) {
        return experimentMapper.queryExperimentBysIdAndTId(sId, tId);
    }
}
