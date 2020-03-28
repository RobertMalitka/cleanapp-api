package pl.cleanapp.cleanappapi.mapper;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;
import pl.cleanapp.cleanappapi.dto.AreaDto;
import pl.cleanapp.cleanappapi.model.Area;
@Component
@Mapper(componentModel = "spring")
public interface AreaMapper {

    AreaDto mapToAreaDto(Area area);
    Area mapToArea(AreaDto areaDto);
}
