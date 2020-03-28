package pl.cleanapp.cleanappapi.mapper;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;
import pl.cleanapp.cleanappapi.dto.WeekDto;
import pl.cleanapp.cleanappapi.model.Week;

@Component
@Mapper(componentModel = "spring")
public interface WeekMapper {

    WeekDto mapToWeekDto(Week week);
}
