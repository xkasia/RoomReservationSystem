package pl.hit.system.mvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.hit.system.core.services.ReservationService;
import pl.hit.system.core.services.RoomsService;
import pl.hit.system.core.services.UserService;
import pl.hit.system.dto.LoggedUserDTO;
import pl.hit.system.dto.ReservationDTO;
import pl.hit.system.dto.RoomDTO;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("reservation")
public class ReservationController {
    private UserService userService;
    private RoomsService roomsService;
    private ReservationService reservationService;
    private Long reservationId;
    private List<ReservationDTO> reservationsDTOInTimeFrame;

    public ReservationController(UserService userService,
                                 RoomsService roomsService,
                                 ReservationService reservationService) {
        this.userService = userService;
        this.roomsService = roomsService;
        this.reservationService = reservationService;
    }

    @GetMapping("make")
    public String showReserveRoomPage(Model model) {
        List<RoomDTO> roomDTO = roomsService.getAllRooms();
        model.addAttribute("room", roomDTO);
        return "reservation/make";
    }

    @PostMapping("make")
    public String reserveRoom(HttpSession session,
                              @RequestParam(name = "name") String roomName,
                              String startTime,
                              String endTime, Model model) {

        List<RoomDTO> roomsDTO = roomsService.getAllRooms();
        model.addAttribute("room", roomsDTO);

        if(LocalDateTime.parse(startTime).compareTo(LocalDateTime.now())<0){
            model.addAttribute("wrongDataMsg", "Start date can not be before today. Please try again.");
            return  "reservation/make";
        }

        if(LocalDateTime.parse(startTime).compareTo(LocalDateTime.parse(endTime))>0){
            model.addAttribute("wrongDataMsg", "End date can not be before start date. Please try again.");
            return  "reservation/make";
        }

        RoomDTO roomDTO = roomsService.getRoomByName(roomName);

        Boolean isAvailable = reservationService.checkIfDateAvailable(roomDTO.getId(),
                LocalDateTime.parse(startTime), LocalDateTime.parse(endTime));

        if (isAvailable) {
            LoggedUserDTO userDTO = (LoggedUserDTO) session.getAttribute("user");
            reservationService.addReservation(userDTO,
                    roomDTO,
                    LocalDateTime.parse(startTime),
                    LocalDateTime.parse(endTime));

            List<ReservationDTO> reservationDTO = reservationService.getUserReservations(userDTO);
            model.addAttribute("reservations", reservationDTO);

            model.addAttribute("bookingSuccessMsq", "Your reservation was made successfully.");
            return "/user/reservation/all";
        }

        model.addAttribute("bookingErrorMsq", "Choosed room is already booked in selected time. Please try again.");
        return "reservation/make";
    }


    @GetMapping("show/all")
    public String showPageWithScheduleForRooms(Model model) {
        List<ReservationDTO> reservationDTO = reservationService.getAllReservations();

        for (ReservationDTO reservation: reservationDTO) {
            reservation.getReservationStart();

        }

        model.addAttribute("reservations", reservationDTO);
        return "reservation/all";
    }

    @PostMapping("show/all")
    public String showReservationsInTimeFrame(String startTime, String endTime, Model model) {

        reservationsDTOInTimeFrame =
                reservationService.getReservationSInChoosedTime(startTime, endTime);

        if(startTime.length()!=0 && endTime.length()!=0){
            if(LocalDateTime.parse(startTime).compareTo(LocalDateTime.parse(endTime))>0){
                List<ReservationDTO> reservationDTO = reservationService.getAllReservations();
                model.addAttribute("reservations", reservationDTO);
                model.addAttribute("wrongDataMsg", "End date can not be before start date. Please try again.");
                return "reservation/all";
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
        return "reservation/all";
    }

    @GetMapping("delete/{id:[0-9]+}")
    public String deleteReservation(@PathVariable Long id) {
        reservationId = id;
        return "/reservation/delete";
    }

    @GetMapping("show/room")
    public String showPageWithScheduleForRoom(Model model) {
        List<RoomDTO> roomDTO = roomsService.getAllRooms();
        model.addAttribute("room", roomDTO);

        List<ReservationDTO> reservationDTO = reservationService.getAllReservations();
        model.addAttribute("reservations", reservationDTO);
        return "reservation/room";
    }

    @PostMapping("show/room")
    public String showReservationsForRoom(@RequestParam(name = "name") String roomName, String startTime,
                                          String endTime, Model model) {

        RoomDTO roomDTO = roomsService.getRoomByName(roomName);

        reservationsDTOInTimeFrame =
                reservationService.getReservationsInChoosedTimeForRoom(startTime, endTime, roomDTO);
        model.addAttribute("reservations", reservationsDTOInTimeFrame);

        List<RoomDTO> roomDTOList = roomsService.getAllRooms();

        if(startTime.length()!=0 && endTime.length()!=0){

            if(LocalDateTime.parse(startTime).compareTo(LocalDateTime.parse(endTime))>0){
                List<RoomDTO> roomsDTO = roomsService.getAllRooms();
                model.addAttribute("room", roomsDTO);
                model.addAttribute("wrongDataMsg", "End date can not be before start date. Please try again.");
                return "reservation/room";
            }

            model.addAttribute("timeFrame", "Room name: " + roomName +". From date: " + startTime +". To date: " + endTime +".");
        }
        else if(startTime.length()!=0 && endTime.length()==0){
            model.addAttribute("timeFrame", "Room name: " + roomName +". From date: " + startTime +".");
        }
        else if (startTime.length()==0 && endTime.length()!=0){
            model.addAttribute("timeFrame", "Room name: " + roomName +". To date: " + endTime +".");
        }

        model.addAttribute("room", roomDTOList);

        return  "reservation/room";
    }

    @PostMapping("delete")
    public String deleteReservation(String delete) {
        if (delete.equals("yes")) {
            ReservationDTO reservationDTO = reservationService.getReservation(reservationId);
            reservationService.deleteReservation(reservationDTO);
        }
        return "redirect:/reservation/show/all";
    }
}
