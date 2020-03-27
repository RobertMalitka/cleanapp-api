package pl.cleanapp.cleanappapi.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="weeks")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Week {
    @Id
    Long id;
    String name;
    @OneToMany(mappedBy = "week", cascade = CascadeType.ALL)
    Set<Area> areas;
}
