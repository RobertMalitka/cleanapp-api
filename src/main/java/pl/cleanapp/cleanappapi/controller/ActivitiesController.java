package pl.cleanapp.cleanappapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import pl.cleanapp.cleanappapi.dto.ActivityDto;
import pl.cleanapp.cleanappapi.mapper.ActivityMapper;
import pl.cleanapp.cleanappapi.service.ActivityService;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class ActivitiesController {
    @Autowired
    ActivityService activityService;

    @Autowired
    ActivityMapper activityMapper;

    @GetMapping("/activities/{areaId}")
    List<ActivityDto> activitiesByArea(@PathVariable Long areaId) {
        return activityService.getActivitiesByAreaId(areaId).stream()
                .filter(act -> activityService.checkIfActivityIsNeeded(areaService.getWeekByAreaId, act.getFrequency()))
                .map(activityMapper::mapToActivityDto)
                .collect(Collectors.toList());
    }

}
