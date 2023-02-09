package bg.softuni.mobilele.model.entity;


import bg.softuni.mobilele.model.entity.enums.EngineEnum;
import bg.softuni.mobilele.model.entity.enums.TransmissionEnum;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.Type;

import java.math.BigDecimal;

@Getter
@Setter
@ToString

@Entity
@Table(name = "offers")
public class Offer extends BaseEntity {


    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private EngineEnum engine;


    private String imageUrl;

    private int kilometers;

    @Column(nullable = false)
    private BigDecimal price;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String description;


    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TransmissionEnum transmission;


    private int year;

    @ManyToOne
    private Model model;

    @ManyToOne
    private User seller;
}
