package pl.cleanapp.cleanappapi.dto;

import lombok.Getter;
import lombok.Setter;
import pl.cleanapp.cleanappapi.model.ActivityStatus;
import pl.cleanapp.cleanappapi.model.Frequency;

@Getter
@Setter
public class ActivityDto {

    Long id;
    String name;
    ActivityStatus activityStatus;
    Frequency frequency;
}
