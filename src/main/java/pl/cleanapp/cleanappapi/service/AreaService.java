package pl.cleanapp.cleanappapi.service;

import pl.cleanapp.cleanappapi.model.Activity;
import pl.cleanapp.cleanappapi.model.Area;
import pl.cleanapp.cleanappapi.model.AreaStatus;
import pl.cleanapp.cleanappapi.model.Week;

import java.util.Arrays;
import java.util.List;


public interface AreaService {
    List<Area> areasByUser(Long userId);
 //   void setAreaStatus(AreaStatus areaStatus);
    Week getWeekByAreaId(Long areaId);
}
