package pl.cleanapp.cleanappapi.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.cleanapp.cleanappapi.model.*;
import pl.cleanapp.cleanappapi.repository.AreaRepository;
import pl.cleanapp.cleanappapi.service.ActivityService;
import pl.cleanapp.cleanappapi.service.AreaService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AreaServiceImpl implements AreaService {

    @Autowired
    AreaRepository areaRepository;

    @Autowired
    ActivityService activityService;


    @Override
    public List<Area> areasByUser(Long userId) {
        return areaRepository.findAllByUserId(userId);
    }

    @Override
    public Week getWeekByAreaId(Long areaId) {
        return areaRepository.findById(areaId).get().getWeek();
    }

    @Override
    public Area changeAreaStatus(Long areaId) {
        Area area = areaRepository.findById(areaId).get();
        List<Activity> list = area.getActivities().stream()
                .filter(act -> activityService.checkIfActivityIsNeeded(getWeekByAreaId(areaId),
                        act.getFrequency()))
                .collect(Collectors.toList());

        for (Activity activity : list) {
            if (activity.getActivityStatus() != ActivityStatus.CHECKED) {
                return area;
            }
        }
        area.setAreaStatus(AreaStatus.DONE);
        return areaRepository.save(area);
    }
}
