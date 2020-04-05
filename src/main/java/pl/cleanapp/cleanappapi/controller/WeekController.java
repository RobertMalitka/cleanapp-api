package pl.cleanapp.cleanappapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.cleanapp.cleanappapi.model.Week;
import pl.cleanapp.cleanappapi.service.WeekService;
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class WeekController {

    @Autowired
    WeekService weekService;

    @GetMapping("/week")
    int getWeek(){
        return weekService.getCurrentWeek();
    }
}
