package pl.cleanapp.cleanappapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import pl.cleanapp.cleanappapi.dto.ActivityDto;
import pl.cleanapp.cleanappapi.mapper.ActivityMapper;
import pl.cleanapp.cleanappapi.service.ActivityService;
import pl.cleanapp.cleanappapi.service.AreaService;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class ActivitiesController {
    @Autowired
    ActivityService activityService;

    @Autowired
    ActivityMapper activityMapper;

    @GetMapping("/activites/{areaId}")
    List<ActivityDto> activitiesByArea(@PathVariable Long areaId) {
        return activityService.getActivitiesByAreaId(areaId).stream()
                .map(activityMapper::mapToActivityDto)
                .collect(Collectors.toList());
    }

}
