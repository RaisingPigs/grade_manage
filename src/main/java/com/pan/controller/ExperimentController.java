package com.pan.controller;

import com.pan.bean.Experiment;
import com.pan.bean.Msg;
import com.pan.service.ExperimentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @description:
 * @author: Mr.Pan
 * @create: 2020-12-26 09:41
 **/
@Controller
public class ExperimentController {
    @Autowired
    private ExperimentService experimentService;

    @ResponseBody
    @GetMapping("/distinctExpr")
    public Msg getDistinctExpr() {
        List<Experiment> distinctExperiment = experimentService.getDistinctExperimentStu();
        return Msg.success().add("ditExpr", distinctExperiment);
    }

    @ResponseBody
    @GetMapping("/getExprQuestion/{id}/{exprId}")
    public Msg getExprQuestion(@PathVariable("id") Integer id, @PathVariable("exprId") String exprId) {
        Experiment experiment = experimentService.getExperimentBySIdAndExprId(id, Integer.parseInt(exprId));
        return Msg.success().add("experiment", experiment);
    }
    
    @ResponseBody
    @PutMapping("/updateExprGrade/{id}/{exprId}")
    public Msg updateExprGrade(@PathVariable("id") Integer id, @PathVariable("exprId") String exprId, @RequestParam("exprGrd") Integer exprGrd) {
        Experiment experiment = new Experiment(Integer.parseInt(exprId), id, null, null, null, exprGrd);
        experimentService.updateExprGrd(experiment);
        return Msg.success();
    }

    @ResponseBody
    @PutMapping("/insertExpr/{tId}")
    public Msg insertExpr(@RequestParam("question") String question, @PathVariable("tId") String tId) {
        experimentService.insertExpr(question, Integer.parseInt(tId));
        return Msg.success();
    }

    @ResponseBody
    @PutMapping("/updateExprAnswer/{sId}/{exprId}")
    public Msg updateExprAnswer(@PathVariable("sId") Integer sId, @PathVariable("exprId") String exprId, @RequestParam("answer") String answer) {
        experimentService.updateExprAnswer(sId, exprId, answer);
        return Msg.success();
    }

    @ResponseBody
    @GetMapping("/getExprGrd/{sId}/{tId}")
    public Msg getExprGrd(@PathVariable("sId") Integer sId, @PathVariable("tId") Integer tId) {
        List<Experiment> experiments = experimentService.getExprBySIdAndTId(sId, tId);
        Integer exprGrd = 0;
        int count = 0;
        for (Experiment experiment : experiments) {
            exprGrd += experiment.getExprGrd();
            count++;
        }
        if (count == 0) {
            exprGrd = 0;
        } else {
            exprGrd /= count;
        }
        return Msg.success().add("exprGrd", exprGrd);
    }

    @ResponseBody
    @DeleteMapping("/deleteExpr/{exprId}")
    public Msg deleteExpr(@PathVariable("exprId") Integer exprId) {
        experimentService.deleteExpr(exprId);
        return Msg.success();
    }

    @ResponseBody
    @GetMapping("/getExprAnswer/{sId}/{exprId}")
    public Msg getExprAnswer(@PathVariable("sId") Integer sId, @PathVariable("exprId") Integer exprId) {
        Experiment experiment = experimentService.getExperimentBySIdAndExprId(sId, exprId);
        return Msg.success().add("expr", experiment);
    }
}
