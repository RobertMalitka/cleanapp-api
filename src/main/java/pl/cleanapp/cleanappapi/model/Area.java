package pl.cleanapp.cleanappapi.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table (name="areas")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Area {
    @Id
    Long id;
    String name;
    @OneToMany(mappedBy = "area", cascade = CascadeType.ALL)
    List<Activity> activities;
    @OneToOne(mappedBy = "area", fetch = FetchType.LAZY)
    User user;
    AreaStatus areaStatus;
    @ManyToOne
    Week week;
}
