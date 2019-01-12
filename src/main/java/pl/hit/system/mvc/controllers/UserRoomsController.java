package pl.hit.system.mvc.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.hit.system.core.services.RoomsService;
import pl.hit.system.core.services.UserService;


@Controller
@RequestMapping(value = "user")
public class UserRoomsController {

    private UserService userService;
    private RoomsService roomsService;

    public UserRoomsController(UserService userService, RoomsService roomsService) {
        this.userService = userService;
        this.roomsService = roomsService;
    }


//    @GetMapping("allRooms")
//    public String showRooms(Model model, LoggedUserDTO user){
//        List<RoomDTO> rooms = roomsService.getAllRooms();
//
//        System.out.println("Rooms" + rooms.toString());
//
//        model.addAttribute("user", user);
//        model.addAttribute("room", rooms);
//
//        return "/rooms/show";
//    }



//    @GetMapping("book")
//    public void book (Model model, LoggedUserDTO user){
//
//    }


//    @GetMapping("/rooms")
//    public String getUserRoomsPage(Model model, @SessionAttribute LoggedUserDTO user){
//        List<RoomDTO> userRooms = userService.getRoomsForUser(user);
//
//        return "/user/data";
//    }


}
