package pl.cleanapp.cleanappapi.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.cleanapp.cleanappapi.model.Week;
import pl.cleanapp.cleanappapi.repository.WeekRepository;
import pl.cleanapp.cleanappapi.service.WeekService;

import java.util.List;

@Service
public class WeekServiceImpl implements WeekService {

    @Autowired
    WeekRepository weekRepository;

    public WeekServiceImpl(WeekRepository weekRepository){
        this.weekRepository = weekRepository;
    }

    @Override
    public List<Week> weeks() {
        return weekRepository.findAll();
    }
}
