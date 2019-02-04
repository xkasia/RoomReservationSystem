package pl.hit.system.mvc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.hit.system.core.forms.UserUpdateForm;
import pl.hit.system.core.services.UserService;
import pl.hit.system.dto.LoggedUserDTO;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

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
    public String giveUserData(HttpSession session, Model model) {
        LoggedUserDTO user = (LoggedUserDTO)session.getAttribute("user");
        model.addAttribute(user);
        return "/user/data";
    }

    @GetMapping("/update")
    public String showUpdatePage(Model model,HttpSession session) {
        LoggedUserDTO loggedUser = (LoggedUserDTO) session.getAttribute("user");
        model.addAttribute("user", loggedUser);
        model.addAttribute("updatedUser", new UserUpdateForm());
        return "user/update";
    }

    @PostMapping("/update")
    public String update(@Valid @ModelAttribute("updatedUser") UserUpdateForm userUpdateForm, BindingResult bindingResult,
                         HttpSession session, Model model) throws IOException {
        if(bindingResult.hasErrors()){
            return "user/update";
        }

        LoggedUserDTO loggedUser = (LoggedUserDTO) session.getAttribute("user");

        userService.updateUser(loggedUser, userUpdateForm.getFirstName(), userUpdateForm.getLastName(), userUpdateForm.getPassword());

        LoggedUserDTO updatedUser = userService.getUser(loggedUser.getLogin(), userUpdateForm.getPassword());

        session.setAttribute("user", updatedUser);
        model.addAttribute("updateUserMsg", "Your account was updated successfully." +
                "You will see new data when you log in again.");

        return "user/data";
    }

    @GetMapping("/delete")
    public String showDeletePage() {
        return "/user/delete";
    }

    @PostMapping("/delete")
    public String delete(HttpSession session, String delete, Model model) {

        if (delete.equals("yes")) {
            LoggedUserDTO user = (LoggedUserDTO) session.getAttribute("user");
            userService.deleteUser(user);
            model.addAttribute("deleteUserMsg", "Your account was deleted successfully.");
            session.invalidate();
            return "home";
        } else {
            return "/user/data";
        }
    }
}
