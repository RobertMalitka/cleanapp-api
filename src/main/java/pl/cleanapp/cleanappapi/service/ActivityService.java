package pl.cleanapp.cleanappapi.service;

import pl.cleanapp.cleanappapi.model.*;

import java.util.List;

public interface ActivityService {
    ActivityStatus getActivityStatusById(Long activityId);
    boolean checkIfActivityIsNeeded(Week week, Frequency frequency);
//    void setActivityStatus(ActivityStatus activityStatus);
public List<Activity> getActivitiesByAreaId(Long areaId);

    ActivityStatus incrementStatusByActivityId(Long activityId);
    Activity addActivity(Activity activity);
    Activity getActivityById(Long activityId);
}
