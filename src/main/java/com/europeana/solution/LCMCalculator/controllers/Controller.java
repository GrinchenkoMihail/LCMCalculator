package com.europeana.solution.LCMCalculator.controllers;

import com.europeana.solution.LCMCalculator.aspect.TimerAspect;
import com.europeana.solution.LCMCalculator.model.Answer;
import com.europeana.solution.LCMCalculator.service.SmallestMultiple;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/lcm")
public class Controller {

    @Autowired
    SmallestMultiple smallestMultiple;

    @Autowired
    TimerAspect timeFixAspect;

    @PostMapping
    @SneakyThrows

    public void setCheckNum(@RequestParam int range) {
        smallestMultiple.setLimit(range);
    }

    @GetMapping
    public Answer calculate(@RequestHeader("Accept") String acceptHeader) {
        Answer answer = new Answer();
        answer.setResult(smallestMultiple.findSmallestMultiple());
        answer.setTimeMc(timeFixAspect.getSpendTime());

        if (acceptHeader.contains(MediaType.APPLICATION_XML_VALUE)) {
            return ResponseEntity.ok().contentType(MediaType.APPLICATION_XML).body(answer).getBody();
        } else {
            return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(answer).getBody();
        }
    }

}
