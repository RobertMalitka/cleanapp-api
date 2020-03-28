package pl.cleanapp.cleanappapi.service;

import pl.cleanapp.cleanappapi.model.Area;

import java.util.Arrays;
import java.util.List;


public interface AreaService {
    public List<Area> areasByUser(Long userId);
}
