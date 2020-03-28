package pl.cleanapp.cleanappapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.cleanapp.cleanappapi.dto.WeekDto;
import pl.cleanapp.cleanappapi.mapper.WeekMapper;
import pl.cleanapp.cleanappapi.service.WeekService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class MainController {

    @Autowired
    WeekMapper weekMapper;
    @Autowired
    WeekService weekService;

    public MainController(WeekMapper weekMapper, WeekService weekService){
        this.weekMapper = weekMapper;
        this.weekService = weekService;
    }

    @GetMapping("/weeks")
    List<WeekDto> weeks(){
        return weekService.weeks().stream()
                .map(weekMapper::mapToWeekDto)
                .collect(Collectors.toList());
    }

}
