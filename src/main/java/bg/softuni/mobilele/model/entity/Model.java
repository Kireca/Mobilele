package bg.softuni.mobilele.model.entity;

import bg.softuni.mobilele.model.entity.enums.Category;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;

@Entity
@Table(name = "models")
public class Model extends BaseEntity {


    private String name;

    @Enumerated(EnumType.STRING)
    private Category category;

    private String imageURL;

    private int startYear;

    private Long endYear;
}
