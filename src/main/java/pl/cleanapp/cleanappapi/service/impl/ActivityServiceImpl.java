package pl.cleanapp.cleanappapi.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.cleanapp.cleanappapi.model.*;
import pl.cleanapp.cleanappapi.repository.ActivityRepository;
import pl.cleanapp.cleanappapi.service.ActivityService;


import java.util.List;

import static pl.cleanapp.cleanappapi.model.ActivityStatus.*;

@Service
public class ActivityServiceImpl implements ActivityService {

    @Autowired
    ActivityRepository activityRepository;

    public ActivityServiceImpl(ActivityRepository activityRepository){
        this.activityRepository = activityRepository;
    }




    @Override
    public ActivityStatus getActivityStatusById(Long activityId) {
        return activityRepository.findById(activityId).get().getActivityStatus();
    }

    @Override
    public List<Activity> getActivitiesByAreaId(Long areaId) {
        return activityRepository.findActivityByAreaId(areaId);
    }

    @Override
    public ActivityStatus incrementStatusByActivityId(Long activityId) {
        ActivityStatus current = activityRepository.findById(activityId).get().getActivityStatus();
        switch (current){
            case UNDONE:
                return READY_TO_CHECK;
            case READY_TO_CHECK:
                return CHECKED;
            default:
                return UNDONE;
        }
    }

    @Override
    public Activity addActivity(Activity activity) {
        return activityRepository.save(activity);
    }

    @Override
    public Activity getActivityById(Long activityId) {
        return activityRepository.findById(activityId).get();
    }

    @Override
    public boolean checkIfActivityIsNeeded(Week week, Frequency frequency) {
        if (frequency==Frequency.ALWAYS){
            return true;
        }
        boolean isWeekEven = (Integer.parseInt(week.name.substring(2)) % 2 == 0);
        if ((isWeekEven && (frequency == Frequency.EVEN)) || (!isWeekEven && (frequency == Frequency.ODD))) {
            return true;
        }
        else {
            return false;
        }
    }

//    @Override
//    public void setActivityStatus(ActivityStatus activityStatus) {
//        activityRepository.setActivityStatus(activityStatus);
//    }
}
