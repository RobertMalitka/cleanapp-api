package pl.cleanapp.cleanappapi.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="activities")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Activity {

    @Id
    Long Id;
    String name;
    @Enumerated(EnumType.STRING)
    ActivityStatus activityStatus;
    @Enumerated(EnumType.STRING)
    Frequency frequency;
    @ManyToOne
    Area area;
}
