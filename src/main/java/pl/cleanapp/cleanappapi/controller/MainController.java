package pl.cleanapp.cleanappapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import pl.cleanapp.cleanappapi.dto.ActivityDto;
import pl.cleanapp.cleanappapi.dto.AreaDto;
import pl.cleanapp.cleanappapi.mapper.AreaMapper;
import pl.cleanapp.cleanappapi.model.ActivityStatus;
import pl.cleanapp.cleanappapi.model.Frequency;
import pl.cleanapp.cleanappapi.model.Week;
import pl.cleanapp.cleanappapi.service.ActivityService;
import pl.cleanapp.cleanappapi.service.AreaService;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class MainController {

    @Autowired
    AreaMapper areaMapper;
    @Autowired
    AreaService areaService;
    @Autowired
    ActivityService activityService;

    public MainController(AreaService areaService) {
        this.areaService = areaService;
    }

    @GetMapping("/areas/{userId}")
    List<AreaDto> areasByUser(@PathVariable Long userId) {

        return areaService.areasByUser(userId).stream()
                .map(areaMapper::mapToAreaDto)
                .sorted(Comparator.comparingLong(AreaDto::getId))
                .collect(Collectors.toList());
    }
}
