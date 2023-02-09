package bg.softuni.mobilele.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter

@Entity
@Table(name = "users")
public class User extends BaseEntity {


    @Column(nullable = false)
    private String email;

    private String password;

    private String firstName;

    private String lastName;

    private boolean isActive;

    private String imageURL;



    @ManyToMany
    private List<UserRole> userRoles = new ArrayList<>();

}
