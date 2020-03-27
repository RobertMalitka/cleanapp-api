package pl.cleanapp.cleanappapi.mapper;

import pl.cleanapp.cleanappapi.dto.ActivityDto;
import pl.cleanapp.cleanappapi.model.Activity;

public interface ActivityMapper {

    ActivityDto mapToActivityDto(Activity activity);
    Activity mapToActivity(ActivityDto activityDto);
}
