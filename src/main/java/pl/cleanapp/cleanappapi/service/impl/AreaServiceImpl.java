package pl.cleanapp.cleanappapi.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.cleanapp.cleanappapi.model.Area;
import pl.cleanapp.cleanappapi.repository.AreaRepository;
import pl.cleanapp.cleanappapi.service.AreaService;

import java.util.List;

@Service
public class AreaServiceImpl implements AreaService {

    @Autowired
    AreaRepository areaRepository;

    @Override
    public List<Area> areasByUser(Long userId) {
        return areaRepository.findAllByUserId(userId);
    }
}
