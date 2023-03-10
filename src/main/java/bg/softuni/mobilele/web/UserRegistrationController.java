package bg.softuni.mobilele.web;

import bg.softuni.mobilele.model.dto.UserRegisterDTO;
import bg.softuni.mobilele.service.UserService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/users")
public class UserRegistrationController {


    private final UserService userService;

    public UserRegistrationController(UserService userService) {
        this.userService = userService;
    }

@ModelAttribute("userModel")
public void initUserMode(Model model){
        model.addAttribute("userModel", new UserRegisterDTO());
}

    @GetMapping("/register")
    public String register() {

        //TODO EXPLAIN POST-redirect-GET
        return "auth-register";
    }


    @PostMapping("/register")
    public String register(@Valid UserRegisterDTO userModel, BindingResult bindingResult , RedirectAttributes redirectAttributes) {

        redirectAttributes.addFlashAttribute("userModel" , userModel);
        redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.userModel" , bindingResult);


        if (bindingResult.hasErrors()){
            return "redirect:/users/register";
        }

        userService.registerAndLogin(userModel);
        return "redirect:/";

    }



}
