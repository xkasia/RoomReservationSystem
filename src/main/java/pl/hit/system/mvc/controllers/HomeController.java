package pl.hit.system.mvc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.hit.system.core.services.UserService;
import pl.hit.system.dto.LoggedUserDTO;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@Controller
@RequestMapping(value = "home")
public class HomeController {

    private UserService userService;

    @Autowired
    public HomeController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String giveHomePage(){
        return "/home";
    }

    @GetMapping("/register")
    public String showRegisterPage(){
        return "/register";
    }

    @PostMapping("/register")
    public void register(String firstName, String lastName, String password, String login,
                         HttpServletResponse response, HttpSession session) throws IOException {
        boolean checkIfUserExists = userService.checkIfUserExists(login);

        if(checkIfUserExists){
            response.sendError(401, "Such user exists in our system. Please try again.");
            return;
        }

        LoggedUserDTO loggedUser = new LoggedUserDTO();
        loggedUser.setFirstName(firstName);
        loggedUser.setLastName(lastName);
        loggedUser.setPassword(password);
        loggedUser.setLogin(login);
        userService.saveUser(loggedUser);

        session.setAttribute("user", loggedUser);
        response.sendRedirect("/home");
        return;
    }

    @GetMapping("/login")
    public String showLoginPage(){
        return "login";
    }

    @PostMapping("/login")
    public void login(String login, String password, HttpSession session, HttpServletResponse response,
                      Model model) throws IOException {
        boolean validCredentials = userService.checkCredentials(login, password);
        if(!validCredentials){
            response.sendError(401, "Valid login data");
            return;
        }
        LoggedUserDTO user = userService.getUser(login, password);
        session.setAttribute("user", user);
        model.addAttribute("user", user);
        response.sendRedirect("/home");

    }

    @GetMapping("/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "redirect:/home";
    }

    @GetMapping("about")
    public String about(){
        return "/about";
    }



}
