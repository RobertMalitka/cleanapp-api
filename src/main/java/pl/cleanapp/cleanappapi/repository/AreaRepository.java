package pl.cleanapp.cleanappapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.cleanapp.cleanappapi.model.Activity;
import pl.cleanapp.cleanappapi.model.Area;
import pl.cleanapp.cleanappapi.model.AreaStatus;

import java.util.List;

@Repository
public interface AreaRepository extends JpaRepository<Area, Long> {

    List<Area> findAllByUserId(Long userId);
   // void setAreaStatus(AreaStatus areaStatus);
}
