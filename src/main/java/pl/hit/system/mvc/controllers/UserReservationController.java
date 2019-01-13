package pl.hit.system.mvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.hit.system.core.services.ReservationService;
import pl.hit.system.core.services.RoomsService;
import pl.hit.system.core.services.UserService;
import pl.hit.system.dto.LoggedUserDTO;
import pl.hit.system.dto.ReservationDTO;

import javax.servlet.http.HttpSession;
import java.util.List;


@Controller
@RequestMapping(value = "user")
public class UserReservationController {

    private UserService userService;
    private RoomsService roomsService;
    private ReservationService reservationService;

    private Long reservationId;

    public UserReservationController(UserService userService,
                                     RoomsService roomsService,
                                     ReservationService reservationService) {
        this.userService = userService;
        this.roomsService = roomsService;
        this.reservationService = reservationService;
    }

    @GetMapping("show/reservations")
    public String showPagePresentBookingScheduleForAllRooms(Model model,
                                                            HttpSession session) {

        LoggedUserDTO userDTO = (LoggedUserDTO) session.getAttribute("user");

        List<ReservationDTO> reservationDTO = reservationService.getUserReservations(userDTO);

        model.addAttribute("reservations", reservationDTO);
        return "/user/reservation/all";
    }


    @GetMapping("delete/reservation/{id:[0-9]+}")
    public String deleteReservation(@PathVariable Long id) {
        reservationId = id;
        return "/user/reservation/delete";
    }

    @PostMapping("delete/reservation")
    public String deleteReservation(String delete) {
        if (delete.equals("yes")) {
            ReservationDTO reservationDTO = reservationService.getReservation(reservationId);
            reservationService.deleteReservation(reservationDTO);
        }
        return "redirect:/user/show/reservations";
    }

}
