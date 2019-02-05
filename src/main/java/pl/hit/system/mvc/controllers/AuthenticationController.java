package pl.hit.system.mvc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.hit.system.core.forms.UserLoginForm;
import pl.hit.system.core.services.UserService;
import pl.hit.system.dto.LoggedUserDTO;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.io.IOException;

@Controller
public class AuthenticationController {

    private UserService userService;
    private PasswordEncoder passwordEncoder;

    @Autowired public void setPasswordEncoder( PasswordEncoder passwordEncoder)
    { this.passwordEncoder = passwordEncoder; }

    @Autowired
    public AuthenticationController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/register")
    public String showRegisterPage(Model model) {
        model.addAttribute("user", new LoggedUserDTO());
        return "/register";
    }

    @PostMapping("/register")
    public String register(@Valid @ModelAttribute("user") LoggedUserDTO loggedUser, BindingResult bindingResult,
                           HttpServletResponse response,
                           HttpSession session, Model model) throws IOException {
        boolean checkIfUserExists = userService.checkIfUserExists(loggedUser.getLogin());

        if(bindingResult.hasErrors()){
            return "/register";
        }
        if (checkIfUserExists) {
            model.addAttribute("errorMsg", "User in such login exists in our system. " +
                    "Please try again.");
            return "/register";
        }

        loggedUser.setPassword(passwordEncoder.encode(loggedUser.getPassword()));

        LoggedUserDTO loggedUserDTO = new LoggedUserDTO();
        loggedUserDTO.setFirstName(loggedUser.getFirstName());
        loggedUserDTO.setLastName(loggedUser.getLastName());
        loggedUserDTO.setPassword(loggedUser.getPassword());
        loggedUserDTO.setLogin(loggedUser.getLogin());

        userService.saveUser(loggedUserDTO);

        session.setAttribute("user", loggedUserDTO);
        model.addAttribute("successMsg", loggedUser.getFirstName()+ "!" );
        return "home";
    }

    @GetMapping("/login")
    public String showLoginPage(Model model) {
        model.addAttribute("user", new UserLoginForm());
        return "login";
    }

    @PostMapping("/login")
    public String login(@Valid @ModelAttribute("user")UserLoginForm userLoginForm ,
                        BindingResult bindingResult, HttpSession session,
                        Model model) throws IOException {
        if(bindingResult.hasErrors()){
            return "/login";
        }
        boolean validCredentials = userService.checkCredentials(userLoginForm.getLogin(), userLoginForm.getPassword());
        if (!validCredentials) {
            model.addAttribute("errorMsg", "Valid login data. Please try again.");
            return "/login";
        }

        userLoginForm.setPassword(passwordEncoder.encode(userLoginForm.getPassword()));

        LoggedUserDTO user = userService.getUser(userLoginForm.getLogin(), userLoginForm.getPassword());
        session.setAttribute("user", user);
        model.addAttribute("successMsg", user.getFirstName()+ "!" );
        return "home";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session, Model model) {

        if(session.getAttribute("user")!= null){
            model.addAttribute("logoutMsg", "You logged out successfully.");
        }
        session.invalidate();

        return "home";
    }
}
