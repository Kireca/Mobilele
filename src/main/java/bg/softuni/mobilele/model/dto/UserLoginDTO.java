package bg.softuni.mobilele.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter


public class UserLoginDTO {

    private String email;
    private String password;

    @Override
    public String toString() {
        return "UserLoginDTO{" +
                "username='" + email + '\'' +
                ", password='" + (password != null ? "[PROVIDED]" : null) + '\'' +
                '}';
    }
}
