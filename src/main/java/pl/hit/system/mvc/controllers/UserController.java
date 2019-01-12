package pl.hit.system.mvc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.hit.system.core.services.UserService;
import pl.hit.system.dto.LoggedUserDTO;

import javax.servlet.http.HttpSession;

import java.io.IOException;

@Controller
@RequestMapping("/user")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/data")
    public String giveUserData(HttpSession session, Model model){
        LoggedUserDTO user = (LoggedUserDTO) session.getAttribute("user");
        model.addAttribute(user);
        return "/user/data";
    }

    @GetMapping("/update")
    public String showUpdatePage(){
        return "user/update";
    }

    @PostMapping("/update")
    public String update(String firstName, String lastName, String password, String login, HttpSession session,
                         Model model) throws IOException {
        LoggedUserDTO loggedUser = (LoggedUserDTO) session.getAttribute("user");

        userService.updateUser(loggedUser, firstName, lastName, login, password);

        LoggedUserDTO updatedUser = userService.getUser(login, password);

        session.removeAttribute("user");
        session.setAttribute("user", updatedUser);

        model.addAttribute("user", updatedUser);

        return "redirect:/user/data";
    }


    @GetMapping("delete")
    public String showDeletePage(){

        return "/user/delete";
    }

    @PostMapping("delete")
    public String delete(HttpSession session, String delete){


        if(delete.equals("yes")){
            LoggedUserDTO user = (LoggedUserDTO) session.getAttribute("user");
            userService.deleteUser(user);
            session.invalidate();

            return "redirect:/home";
        }
        else{
            return "/user/data";
        }

    }


}
