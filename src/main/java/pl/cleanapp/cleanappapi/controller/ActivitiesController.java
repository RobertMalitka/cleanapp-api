package pl.cleanapp.cleanappapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.cleanapp.cleanappapi.dto.ActivityDto;
import pl.cleanapp.cleanappapi.mapper.ActivityMapper;
import pl.cleanapp.cleanappapi.model.Activity;
import pl.cleanapp.cleanappapi.model.ActivityStatus;
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
    AreaService areaService;

    @Autowired
    ActivityMapper activityMapper;

    @GetMapping("/activities/{areaId}")
    List<ActivityDto> activitiesByArea(@PathVariable Long areaId) {
        return activityService.getActivitiesByAreaId(areaId).stream()
                .filter(act -> activityService.checkIfActivityIsNeeded(areaService.getWeekByAreaId(areaId), act.getFrequency()))
                .map(activityMapper::mapToActivityDto)
                .collect(Collectors.toList());
    }

    @PutMapping("/activities/{activityId}")
    ActivityStatus incrementStatusByActivityId(@PathVariable Long activityId) {
        ActivityStatus as = activityService.incrementStatusByActivityId(activityId);
        Activity activity = activityService.getActivityById(activityId);
        activity.setActivityStatus(as);
        activityService.addActivity(activity);
        return as;
    }

}
