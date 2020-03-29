package pl.cleanapp.cleanappapi.service;

import pl.cleanapp.cleanappapi.model.Activity;
import pl.cleanapp.cleanappapi.model.Area;
import pl.cleanapp.cleanappapi.model.AreaStatus;

import java.util.Arrays;
import java.util.List;


public interface AreaService {
    List<Area> areasByUser(Long userId);
 //   void setAreaStatus(AreaStatus areaStatus);
}
