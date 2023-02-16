package bg.softuni.mobilele.service;

import bg.softuni.mobilele.model.dto.UserLoginDTO;
import bg.softuni.mobilele.model.dto.UserRegisterDTO;
import bg.softuni.mobilele.model.entities.User;
import bg.softuni.mobilele.repositories.UserRepository;
import bg.softuni.mobilele.user.CurrentUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final Logger LOGGER = LoggerFactory.getLogger(UserService.class);
    private final UserRepository userRepository;
    private final CurrentUser currentUser;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, CurrentUser currentUser, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.currentUser = currentUser;
        this.passwordEncoder = passwordEncoder;
    }

    public boolean login(UserLoginDTO userLoginDTO) {
        Optional<User> userOpt = userRepository.findByEmail(userLoginDTO.getEmail());

        if (userOpt.isEmpty()) {
            LOGGER.debug("User with name [{}] not found. ", userLoginDTO.getEmail());
            return false;
        }

        String rawPassword = userLoginDTO.getPassword();
        String encodedPassword = userOpt.get().getPassword();

        boolean success = passwordEncoder.matches(rawPassword, encodedPassword);


        if (success) {
            login(userOpt.get());
        } else {
            logout();
        }
        return success;
    }

    public void registerAndLogin(UserRegisterDTO userDTO) {

        User user = new User();
        user.setActive(true);
        user.setEmail(userDTO.getEmail());
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setPassword(passwordEncoder.encode(userDTO.getPassword()));

        userRepository.save(user);

        login(user);


    }


    public void login(User user) {
        currentUser.setLoggedIn(true);
        currentUser.setName(user.getFirstName() + " " + user.getLastName());
    }

    public void logout() {
        currentUser.clear();
    }
}
