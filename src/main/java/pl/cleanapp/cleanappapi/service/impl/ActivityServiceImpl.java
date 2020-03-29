package pl.cleanapp.cleanappapi.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.cleanapp.cleanappapi.model.*;
import pl.cleanapp.cleanappapi.repository.ActivityRepository;
import pl.cleanapp.cleanappapi.service.ActivityService;


import java.util.List;

@Service
public class ActivityServiceImpl implements ActivityService {

    @Autowired
    ActivityRepository activityRepository;




    @Override
    public ActivityStatus getActivityStatusById(Long activityId) {
        return activityRepository.findById(activityId).get().getActivityStatus();
    }

    @Override
    public List<Activity> getActivitiesByAreaId(Long areaId) {
        return activityRepository.findActivityByAreaId(areaId);
    }

    @Override
    public boolean checkIfActivityIsNeeded(Week week, Frequency frequency) {
        if (frequency.equals(Frequency.ALWAYS)) {
            return true;
        }
        boolean isWeekEven = (Integer.parseInt(week.name.substring(2)) % 2 == 0);
        if ((isWeekEven && frequency.equals(Frequency.EVEN)) || !isWeekEven && frequency.equals(Frequency.ODD))
            return true;
        return false;
    }

//    @Override
//    public void setActivityStatus(ActivityStatus activityStatus) {
//        activityRepository.setActivityStatus(activityStatus);
//    }
}
