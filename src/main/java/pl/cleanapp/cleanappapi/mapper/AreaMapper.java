package pl.cleanapp.cleanappapi.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;
import pl.cleanapp.cleanappapi.dto.AreaDto;
import pl.cleanapp.cleanappapi.model.Area;
@Component
@Mapper(componentModel = "spring")
public interface AreaMapper {

    @Mapping(source = "area.user.name", target = "user")
    @Mapping(source = "area.week.name", target = "week")
    AreaDto mapToAreaDto(Area area);
}
