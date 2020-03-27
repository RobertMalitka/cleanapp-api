package pl.cleanapp.cleanappapi.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    Long id;
    String name;
    @OneToOne(fetch = FetchType.LAZY)
    Area area;
}
