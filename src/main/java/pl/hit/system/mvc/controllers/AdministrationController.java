package pl.hit.system.mvc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.hit.system.core.services.RoomsService;
import pl.hit.system.core.services.UserService;
import pl.hit.system.dto.LoggedUserDTO;
import pl.hit.system.dto.RoomDTO;

import javax.servlet.http.HttpServletResponse;
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
    public String showUpdatePage(@PathVariable String login) {
        userLogin = login;
        return "admin/user/update";
    }

    @PostMapping("/user/update")
    public String updateUser(String firstName, String lastName, String password) {
        LoggedUserDTO userDTO = userService.getUserByLogin(userLogin);

        userService.updateUser(userDTO, firstName, lastName, password);

        return "redirect:/admin/user/show";
    }

    @GetMapping("user/delete/{login:[A-Za-z0-9_.]+}")
    public String showDeleteUserPage(@PathVariable String login) {
        userLogin = login;
        return "admin/user/delete";
    }


    @PostMapping("user/delete")
    public String deleteUser(String delete) {

        if (delete.equals("yes")) {
            LoggedUserDTO userDTO = userService.getUserByLogin(userLogin);
            userService.deleteUser(userDTO);
        }
        return "redirect:/admin/user/show";

    }

    @GetMapping("user/add")
    public String showAddUserPage() {
        return "/admin/user/add";
    }

    @PostMapping("user/add")
    public void addUser(String firstName, String lastName, String password,
                        String login, HttpServletResponse response) throws IOException {
        boolean checkIfUserExists = userService.checkIfUserExists(login);

        if (checkIfUserExists) {
            response.sendError(401, "Such user exists in our system. Please try again.");
            return;
        }

        LoggedUserDTO loggedUser = new LoggedUserDTO();
        loggedUser.setFirstName(firstName);
        loggedUser.setLastName(lastName);
        loggedUser.setPassword(password);
        loggedUser.setLogin(login);
        userService.saveUser(loggedUser);

        response.sendRedirect("/admin/user/show");
    }

    @GetMapping("room/show")
    public String showRooms(Model model) {
        List<RoomDTO> rooms = roomsService.getAllRooms();
        model.addAttribute("room", rooms);

        return "/admin/room/show";
    }

    @GetMapping("/room/update/{id:[0-9]+}")
    public String showUpdatedRoomPage(@PathVariable Long id) {
        roomId = id;
        return "admin/room/update";
    }

    @PostMapping("/room/update")
    public String updateRoom(String name, String location, Integer numberOfSeats,
                             String projector, String phoneNumber) {

        RoomDTO roomDTO = roomsService.getRoomById(roomId);

        roomsService.updateRoom(roomDTO, name, location, numberOfSeats,
                projector, phoneNumber);

        return "redirect:/admin/room/show";
    }

    @GetMapping("room/delete/{id:[0-9]+}")
    public String showDeleteRoomPage(@PathVariable Long id) {
        roomId = id;
        return "admin/room/delete";
    }


    @PostMapping("room/delete")
    public String deleteRoom(String delete) {

        if (delete.equals("yes")) {
            RoomDTO roomDTO = roomsService.getRoomById(roomId);
            roomsService.deleteRoom(roomDTO);
        }
        return "redirect:/admin/room/show";
    }

    @GetMapping("room/add")
    public String showAddRoomPage() {
        return "/admin/room/add";
    }

    @PostMapping("room/add")
    public void addRoom(String name, String location, Integer numberOfSeats,
                        String projector, String phoneNumber,
                        HttpServletResponse response) throws IOException {
        boolean checkIfRoomExists = roomsService.checkIfRoomExists(name);

        if (checkIfRoomExists) {
            response.sendError(401, "Such room exists in our system." +
                    " Please try again.");
            return;
        }

        RoomDTO roomDTO = new RoomDTO();
        roomDTO.setName(name);
        roomDTO.setLocation(location);
        roomDTO.setNumberOfSeats(numberOfSeats);

        if (projector.equals("yes")) {
            roomDTO.setProjector(true);
        } else {
            roomDTO.setProjector(false);
        }

        roomDTO.setPhoneNumber(phoneNumber);

        roomsService.saveRoom(roomDTO);
        response.sendRedirect("/admin/room/show");
    }
}
