package bg.softuni.mobilele.model.entity;

import bg.softuni.mobilele.model.entity.enums.UserRoleEnum;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString

@Entity
@Table(name = "user_roles")
public class UserRole {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_role" , nullable = false)
    @Enumerated(EnumType.STRING)
    private UserRoleEnum userRole;




}
