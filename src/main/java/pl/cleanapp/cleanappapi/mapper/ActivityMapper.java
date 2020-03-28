package pl.cleanapp.cleanappapi.mapper;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;
import pl.cleanapp.cleanappapi.dto.ActivityDto;
import pl.cleanapp.cleanappapi.model.Activity;

@Component
@Mapper(componentModel = "spring")
public interface ActivityMapper {

    ActivityDto mapToActivityDto(Activity activity);
    Activity mapToActivity(ActivityDto activityDto);
}
