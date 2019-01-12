package pl.hit.system.mvc.controllers;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.hit.system.core.services.ReservationService;
import pl.hit.system.core.services.RoomsService;
import pl.hit.system.core.services.UserService;
import pl.hit.system.dto.LoggedUserDTO;
import pl.hit.system.dto.ReservationDTO;
import pl.hit.system.dto.RoomDTO;

import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequestMapping("reservation")
public class ReservationController {
    private UserService userService;
    private RoomsService roomsService;
    private ReservationService reservationService;

    public ReservationController(UserService userService, RoomsService roomsService, ReservationService reservationService) {
        this.userService = userService;
        this.roomsService = roomsService;
        this.reservationService = reservationService;
    }

    @GetMapping("make")
    public String showReserveRoomPage(Model model){
        List<RoomDTO> roomDTO = roomsService.getAllRooms();
        model.addAttribute("room", roomDTO);
        return "reservation/make";
    }


    @PostMapping("make")
    public String reserveRoom(HttpSession session, @RequestParam(name = "name") String roomName,
                              String startTime,
                              String endTime){

        RoomDTO roomDTO = roomsService.getRoomByName(roomName);

//        Boolean isAvilable = reservationService.checkIfDateAvailable(roomDTO.getId(), starTime, endTime);
//
//        if(isAvilable){
            LoggedUserDTO userDTO = (LoggedUserDTO) session.getAttribute("user");

        System.out.println("DAADFAGAGAGAGGAAG START TIME: " + startTime);
        System.out.println("AGAGAGAGA END TIME: " + endTime);
            reservationService.addReservation(userDTO,
                    roomDTO,
                    LocalDateTime.parse(startTime),
                    LocalDateTime.parse(endTime));

//        }
        return "reservation/make";
    }

    @GetMapping("show/all")
    public String showPagePresentBookingScheduleForAllRooms(Model model){
        List<ReservationDTO> reservationDTO = reservationService.getAllReservations();
        model.addAttribute("reservation",reservationDTO);
        return "reservation/all";
    }

    @PostMapping("show/all")
    public void showBookingScheduleForAllRooms(){


    }




}
