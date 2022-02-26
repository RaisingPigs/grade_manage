package com.pan.controller;

import com.pan.bean.Homework;
import com.pan.bean.Msg;
import com.pan.service.HomeworkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @description:
 * @author: Mr.Pan
 * @create: 2020-12-22 14:53
 **/
@Controller
public class HomeworkController {
    @Autowired
    private HomeworkService homeworkService;

    @ResponseBody
    @PutMapping("/insertHwk/{tId}")
    public Msg insertHwk(@RequestParam("question") String question, @PathVariable("tId") String tId) {
        homeworkService.insertHomework(question, Integer.parseInt(tId));
        return Msg.success();
    }

    @ResponseBody
    @DeleteMapping("/deleteHwk/{hwkId}")
    public Msg deleteHwk(@PathVariable("hwkId") Integer hwkId) {
        homeworkService.deleteHwk(hwkId);
        return Msg.success();
    }

    @ResponseBody
    @GetMapping("/getHwkQuestion/{sId}/{hwkId}")
    public Msg getHwkQuestion(@PathVariable("sId") Integer sId, @PathVariable("hwkId") String hwkId) {
        Homework homework = homeworkService.getHomeworkBySIdAndHwkId(sId, Integer.parseInt(hwkId));
        return Msg.success().add("homework", homework);
    }

    @ResponseBody
    @PutMapping("/updateHwkGrade/{sId}/{hwkId}")
    public Msg updateHwkGrade(@PathVariable("sId") Integer sId, @PathVariable("hwkId") String hwkId, @RequestParam("hwkGrd") Integer hwkGrd) {
        homeworkService.updateHwkGrd(sId, Integer.parseInt(hwkId), hwkGrd);
        return Msg.success();
    }

    @ResponseBody
    @PutMapping("/updateHwkAnswer/{sId}/{hwkId}")
    public Msg updateAnswer(@PathVariable("sId") Integer sId, @PathVariable("hwkId") Integer hwkId, String answer) {
        homeworkService.updateHomeworkAnswer(sId, hwkId, answer);
        return Msg.success();
    }

    @ResponseBody
    @GetMapping("/getHwkAnswer/{sId}/{hwkId}")
    public Msg getHwkAnswer(@PathVariable("sId") Integer sId, @PathVariable("hwkId") Integer hwkId) {
        Homework homework = homeworkService.getHomeworkBySIdAndHwkId(sId, hwkId);
        return Msg.success().add("hwk", homework);
    }

    @ResponseBody
    @GetMapping("/getHwkGrd/{sId}/{tId}")
    public Msg getHwkGrd(@PathVariable("sId") Integer sId, @PathVariable("tId") String tId) {
        List<Homework> homeworks = homeworkService.getHomeworkBySIdAndTId(sId, Integer.parseInt(tId));
        int hwkGrd = 0;
        int count = 0;
        for (Homework homework : homeworks) {
            hwkGrd += homework.getHwkGrd();
            count++;
        }
        if (count == 0) {
            hwkGrd = 0;
        } else {
            hwkGrd /= count;
        }
        return Msg.success().add("hwkGrd", hwkGrd);
    }
}
