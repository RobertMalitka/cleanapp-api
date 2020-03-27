package pl.cleanapp.cleanappapi.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;

public enum AreaStatus {
    DELAYED,
    INACTIVE,
    PENDING,
    DONE
}
