package pl.cleanapp.cleanappapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.cleanapp.cleanappapi.model.Week;

@Repository
public interface WeekRepository extends JpaRepository<Week, Long> {
}
