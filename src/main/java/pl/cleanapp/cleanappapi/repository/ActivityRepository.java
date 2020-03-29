package pl.cleanapp.cleanappapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.cleanapp.cleanappapi.model.Activity;
import pl.cleanapp.cleanappapi.model.ActivityStatus;

import java.util.List;

@Repository
public interface ActivityRepository extends JpaRepository<Activity, Long> {
    List<Activity> findActivityByAreaId (Long areaId);

}
