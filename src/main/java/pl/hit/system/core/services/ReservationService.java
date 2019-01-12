package pl.hit.system.core.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.hit.system.data.model.Reservation;
import pl.hit.system.data.model.Room;
import pl.hit.system.data.model.User;
import pl.hit.system.data.repositories.ReservationRepository;
import pl.hit.system.data.repositories.RoomRepository;
import pl.hit.system.data.repositories.UserRepository;
import pl.hit.system.dto.LoggedUserDTO;
import pl.hit.system.dto.ReservationDTO;
import pl.hit.system.dto.RoomDTO;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReservationService {

    private ReservationRepository reservationRepository;
    private RoomRepository roomRepository;
    private UserRepository userRepository;

    @Autowired
    public ReservationService(ReservationRepository reservationRepository, RoomRepository roomRepository, UserRepository userRepository) {
        this.reservationRepository = reservationRepository;
        this.roomRepository = roomRepository;
        this.userRepository = userRepository;

    }


    public boolean checkIfDateAvailable(Long roomId, LocalDateTime startTime, LocalDateTime endTime) {


        return false;
    }

    public void addReservation(LoggedUserDTO loggedUserDTO, RoomDTO roomDTO, LocalDateTime starTime, LocalDateTime endTime) {
        User user = userRepository.getUserByLogin(loggedUserDTO.getLogin());
        Room room = roomRepository.getRoomByName(roomDTO.getName());

        reservationRepository.addReservation(user.getId(), room.getId(),starTime, endTime);
    }

    public List<ReservationDTO> getAllReservations() {

        List<Reservation> reservations = reservationRepository.findAll();

        List<ReservationDTO> reservationsDTO = reservations
                .stream()
                .filter(reservation -> reservation != null)
                .map(reservation ->
                {ReservationDTO reservationDTO = new ReservationDTO();
                reservationDTO.setId(reservation.getId());
                reservationDTO.setRoom(reservation.getRoom());
                reservationDTO.setUser(reservation.getUser());
                reservationDTO.setReservationStart(reservation.getReservationStart());
                reservation.setReservationEnd(reservation.getReservationEnd());
                return reservationDTO; }).collect(Collectors.toList());

       // return reservationsDTO;

        return null;
    }
}
