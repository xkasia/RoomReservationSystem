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
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;


@Controller
@RequestMapping(value = "user")
public class UserReservationController {

    private UserService userService;
    private RoomsService roomsService;
    private ReservationService reservationService;

    private Long reservationId;
    private List<ReservationDTO> reservationsDTOInTimeFrame;

    public UserReservationController(UserService userService,
                                     RoomsService roomsService,
                                     ReservationService reservationService) {
        this.userService = userService;
        this.roomsService = roomsService;
        this.reservationService = reservationService;
    }

    @GetMapping("show/reservations")
    public String showPageWithBookedRooms(Model model, HttpSession session) {
        LoggedUserDTO userDTO = (LoggedUserDTO) session.getAttribute("user");
        List<ReservationDTO> reservationDTO = reservationService.getUserReservations(userDTO);

        model.addAttribute("reservations", reservationDTO);
        return "/user/reservation/all";
    }

    @PostMapping("show/reservations")
    public String showReservations(String startTime, String endTime, Model model, HttpSession session) {

        LoggedUserDTO userDTO = (LoggedUserDTO)session.getAttribute("user");
        reservationsDTOInTimeFrame =
                reservationService.getUserReservationSInChoosedTimeFrame(userDTO, startTime, endTime);

        if(startTime.length()!=0 && endTime.length()!=0){
            if(LocalDateTime.parse(startTime).compareTo(LocalDateTime.parse(endTime))>0){
                LoggedUserDTO usersDTO = (LoggedUserDTO) session.getAttribute("user");
                List<ReservationDTO> reservationDTO = reservationService.getUserReservations(usersDTO);

                model.addAttribute("reservations", reservationDTO);
                model.addAttribute("wrongDataMsg", "End date can not be before start date. Please try again.");
                return  "/user/reservation/all";
            }
            model.addAttribute("timeFrame", "From date: " + startTime +". To date: " + endTime +".");
        }
        else if(startTime.length()!=0 && endTime.length()==0){
            model.addAttribute("timeFrame", "From date: " + startTime +".");
        }
        else if (startTime.length()==0 && endTime.length()!=0){
            model.addAttribute("timeFrame", "To date: " + endTime +".");
        }

        model.addAttribute("reservations", reservationsDTOInTimeFrame);
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
