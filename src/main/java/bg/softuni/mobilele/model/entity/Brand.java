package bg.softuni.mobilele.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter


@Entity
@Table(name = "brands")
public class Brand extends BaseEntity {

    private String name;



}
