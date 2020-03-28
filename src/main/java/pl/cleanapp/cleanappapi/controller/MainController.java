package pl.cleanapp.cleanappapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import pl.cleanapp.cleanappapi.dto.AreaDto;
import pl.cleanapp.cleanappapi.mapper.AreaMapper;
import pl.cleanapp.cleanappapi.service.AreaService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class MainController {

    @Autowired
    AreaMapper areaMapper;
    @Autowired
    AreaService areaService;

    public MainController(AreaService areaService) {
        this.areaService = areaService;
    }

    @GetMapping("/areas/{userId}")
    List<AreaDto> areasByUser(@PathVariable Long userId) {

        return areaService.areasByUser(userId).stream()
                .map(areaMapper::mapToAreaDto)
                .collect(Collectors.toList());
    }
}
