package com.pan.controller;

import com.pan.bean.GradePercent;
import com.pan.bean.Msg;
import com.pan.service.GradePercentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @description:
 * @author: Mr.Pan
 * @create: 2020-12-21 15:40
 **/
@Controller
public class GradePercentController {
    @Autowired
    private GradePercentService gradePercentService;

    @ResponseBody
    @GetMapping("/getGrdPct")
    public Msg getGradePercent() {
        GradePercent gradePercent = gradePercentService.getGradePercent();
        return Msg.success().add("grdPct", gradePercent);
    }

    @ResponseBody
    @PostMapping("/saveGrdPct")
    public Msg saveGradePercent(GradePercent gradePercent) {
        gradePercentService.saveGradePercent(gradePercent);
        return Msg.success();
    }
}
