package pl.hit.system.mvc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.hit.system.core.forms.RoomUpdateForm;
import pl.hit.system.core.forms.UserUpdateForm;
import pl.hit.system.core.services.RoomsService;
import pl.hit.system.core.services.UserService;
import pl.hit.system.data.model.Room;
import pl.hit.system.dto.LoggedUserDTO;
import pl.hit.system.dto.RoomDTO;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdministrationController {

    private UserService userService;
    private RoomsService roomsService;
    private String userLogin;
    private Long roomId;

    @Autowired
    public AdministrationController(UserService userService, RoomsService roomsService) {
        this.userService = userService;
        this.roomsService = roomsService;
    }

    @GetMapping("user/show")
    public String showUsers(Model model) {
        List<LoggedUserDTO> users = userService.getAllUsers();
        model.addAttribute("user", users);
        return "/admin/user/show";
    }

    @GetMapping("/user/update/{login:[A-Za-z0-9_.]+}")
    public String showUpdatePage(@PathVariable String login, Model model) {
        userLogin = login;
        LoggedUserDTO userDTO = userService.getUserByLogin(userLogin);
        model.addAttribute("user", userDTO);
        model.addAttribute("updatedUser", new UserUpdateForm());
        return "admin/user/update";
    }

    @PostMapping("/user/update")
    public String updateUser(@Valid @ModelAttribute("updatedUser") UserUpdateForm userUpdateForm,
                             BindingResult bindingResult, Model model) {
        if(bindingResult.hasErrors()){
            return "admin/user/update";
        }

        LoggedUserDTO userDTO = userService.getUserByLogin(userLogin);

        userService.updateUser(userDTO, userUpdateForm.getFirstName(),
                userUpdateForm.getLastName(), userUpdateForm.getPassword());

        model.addAttribute("successMsg", "User was updated successfully.");

        List<LoggedUserDTO> users = userService.getAllUsers();
        model.addAttribute("user", users);

        return "/admin/user/show";
    }

    @GetMapping("user/delete/{login:[A-Za-z0-9_.]+}")
    public String showDeleteUserPage(@PathVariable String login) {
        userLogin = login;
        return "admin/user/delete";
    }


    @PostMapping("user/delete")
    public String deleteUser(String delete, Model model) {

        if (delete.equals("yes")) {
            LoggedUserDTO userDTO = userService.getUserByLogin(userLogin);
            userService.deleteUser(userDTO);

            model.addAttribute("successMsg", "User was deleted successfully.");

            List<LoggedUserDTO> users = userService.getAllUsers();
            model.addAttribute("user", users);
            return "/admin/user/show";
        }
        return "redirect:/admin/user/show";
    }

    @GetMapping("user/add")
    public String showAddUserPage(Model model) {
        model.addAttribute("user", new LoggedUserDTO());
        return "/admin/user/add";
    }

    @PostMapping("user/add")
    public String addUser(@Valid @ModelAttribute("user") LoggedUserDTO loggedUserDTO,
                        BindingResult bindingResult, Model model) throws IOException {
        if(bindingResult.hasErrors()){
            return "/admin/user/add";
        }

        boolean checkIfUserExists = userService.checkIfUserExists(loggedUserDTO.getLogin());

        if (checkIfUserExists) {
            model.addAttribute("errorMsg", "User in such login exists in our system. " +
                    "Please try again.");
            return "/admin/user/add";
        }

        LoggedUserDTO loggedUser = new LoggedUserDTO();
        loggedUser.setFirstName(loggedUserDTO.getFirstName());
        loggedUser.setLastName(loggedUserDTO.getLastName());
        loggedUser.setPassword(loggedUserDTO.getPassword());
        loggedUser.setLogin(loggedUserDTO.getLogin());
        userService.saveUser(loggedUser);

        model.addAttribute("successMsg", "User was created successfully.");

        List<LoggedUserDTO> users = userService.getAllUsers();
        model.addAttribute("user", users);

        return "/admin/user/show";
    }

    @GetMapping("room/show")
    public String showRooms(Model model) {
        List<RoomDTO> rooms = roomsService.getAllRooms();
        model.addAttribute("room", rooms);

        return "/admin/room/show";
    }

    @GetMapping("/room/update/{id:[0-9]+}")
    public String showUpdatedRoomPage(@PathVariable Long id, Model model) {
        roomId = id;
        RoomDTO roomDTO = roomsService.getRoomById(roomId);
        model.addAttribute("room", roomDTO);
        model.addAttribute("roomUpdated", new RoomUpdateForm());
        return "admin/room/update";
    }

    @PostMapping("/room/update")
    public String updateRoom(@Valid @ModelAttribute("roomUpdated") RoomUpdateForm room,
                             BindingResult bindingResult, Model model) {

        if(bindingResult.hasErrors()){
            return "/admin/room/update";
        }

        RoomDTO roomDTO = roomsService.getRoomById(roomId);
        roomsService.updateRoom(roomDTO, room.getLocation(), room.getNumberOfSeats(),
                room.getProjector(), room.getPhoneNumber());

        model.addAttribute("successMsg", "Room was updated successfully.");
        List<RoomDTO> rooms = roomsService.getAllRooms();
        model.addAttribute("room", rooms);

        return "/admin/room/show";
    }

    @GetMapping("room/delete/{id:[0-9]+}")
    public String showDeleteRoomPage(@PathVariable Long id) {
        roomId = id;
        return "admin/room/delete";
    }


    @PostMapping("room/delete")
    public String deleteRoom(String delete, Model model) {

        if (delete.equals("yes")) {
            RoomDTO roomDTO = roomsService.getRoomById(roomId);
            roomsService.deleteRoom(roomDTO);
            model.addAttribute("successMsg", "Room was deleted successfully.");
            List<RoomDTO> rooms = roomsService.getAllRooms();
            model.addAttribute("room", rooms);
            return "/admin/room/show";
        }
        return "redirect:/admin/room/show";
    }

    @GetMapping("room/add")
    public String showAddRoomPage(Model model) {
        model.addAttribute("room", new RoomDTO());
        return "/admin/room/add";
    }

    @PostMapping("room/add")
    public String addRoom(@Valid @ModelAttribute("room") RoomDTO room, BindingResult bindingResult,
                          Model model) throws IOException {

        if(bindingResult.hasErrors()){
            return "/admin/room/add";
        }

        boolean checkIfRoomExists = roomsService.checkIfRoomExists(room.getName());

        if (checkIfRoomExists) {
            model.addAttribute("errorMsg", "Room in such name exists in our system. " +
                    "Please try again.");
            return "/admin/room/add";
        }

        RoomDTO roomDTO = new RoomDTO();
        roomDTO.setName(room.getName());
        roomDTO.setLocation(room.getLocation());
        roomDTO.setNumberOfSeats(room.getNumberOfSeats());
        roomDTO.setPhoneNumber(room.getPhoneNumber());
        roomDTO.setProjector(room.getProjector());
        roomsService.saveRoom(roomDTO);

        model.addAttribute("successMsg", "Room was created successfully.");
        List<RoomDTO> rooms = roomsService.getAllRooms();
        model.addAttribute("room", rooms);

        return "/admin/room/show";
    }
}
