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

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReservationService {

    private ReservationRepository reservationRepository;
    private RoomRepository roomRepository;
    private UserRepository userRepository;

    @Autowired
    public ReservationService(ReservationRepository reservationRepository,
                              RoomRepository roomRepository, UserRepository userRepository) {
        this.reservationRepository = reservationRepository;
        this.roomRepository = roomRepository;
        this.userRepository = userRepository;
    }


    public boolean checkIfDateAvailable(Long roomId, LocalDateTime startTime,
                                        LocalDateTime endTime) {
        List<Timestamp> startTimesFromDB =
                reservationRepository.giveStartTimesDuringPeriodToBook(startTime, endTime, roomId);

        if(startTimesFromDB.size()!=0){
            return false;
        }

        List<Timestamp> endTimesFromDB =
                reservationRepository.giveEndTimesDuringPeriodToBook(startTime, endTime, roomId);

        if(endTimesFromDB.size()!=0){ ;
            return false;
        }

        List<Timestamp> timesFromDB = reservationRepository.giveTimesSmallerThanStartTimeAndBiggerThanEndTimeToBook(startTime,endTime,roomId);

        if(timesFromDB.size()!=0){
            return false;
        }
        return true;
    }

    public void addReservation(LoggedUserDTO loggedUserDTO, RoomDTO roomDTO,
                               LocalDateTime starTime, LocalDateTime endTime) {
        User user = userRepository.getUserByLogin(loggedUserDTO.getLogin());
        Room room = roomRepository.getRoomByName(roomDTO.getName());

        reservationRepository.addReservation(user.getId(), room.getId(), starTime, endTime);
    }

    public List<ReservationDTO> getAllReservations() {

        List<Reservation> reservations = reservationRepository.findAll();

        List<ReservationDTO> reservationsDTO = reservations
                .stream()
                .filter(reservation -> reservation != null)
                .map(reservation ->
                {
                    ReservationDTO reservationDTO = new ReservationDTO();
                    reservationDTO.setId(reservation.getId());
                    reservationDTO.setRoom(reservation.getRoom());
                    reservationDTO.setUser(reservation.getUser());
                    reservationDTO.setReservationStart(reservation.getReservationStart());
                    reservationDTO.setReservationEnd(reservation.getReservationEnd());
                    return reservationDTO;
                }).collect(Collectors.toList());

        return reservationsDTO;

    }

    public List<ReservationDTO> getUserReservations(LoggedUserDTO userDTO) {

        User user = userRepository.getUserByLogin(userDTO.getLogin());

        List<Reservation> reservations = reservationRepository.getUserReservations(user.getId());

        List<ReservationDTO> reservationsDTO = reservations
                .stream()
                .filter(reservation -> reservation != null)
                .map(reservation ->
                {
                    ReservationDTO reservationDTO = new ReservationDTO();
                    reservationDTO.setId(reservation.getId());
                    reservationDTO.setRoom(reservation.getRoom());
                    reservationDTO.setUser(reservation.getUser());
                    reservationDTO.setReservationStart(reservation.getReservationStart());
                    reservationDTO.setReservationEnd(reservation.getReservationEnd());
                    return reservationDTO;
                }).collect(Collectors.toList());

        return reservationsDTO;
    }

    public ReservationDTO getReservation(Long reservationId) {

        Reservation reservation = reservationRepository.getReservationById(reservationId);

        ReservationDTO reservationDTO = new ReservationDTO(reservation.getId(),
                reservation.getRoom(), reservation.getUser(),
                reservation.getReservationStart(), reservation.getReservationEnd());

        return reservationDTO;
    }

    public void deleteReservation(ReservationDTO reservationDTO) {
        Reservation reservation = reservationRepository.getReservationById(reservationDTO.getId());
        reservationRepository.delete(reservation);
    }

    public List<ReservationDTO> getReservationSInChoosedTime(String startTime, String endTime) {
        List<Reservation> reservations = null;

        if(startTime.length()!=0 && endTime.length()!=0){
            reservations = reservationRepository.getReservationsInTimeFrame
                    (LocalDateTime.parse(startTime),LocalDateTime.parse(endTime));
        }
        else if(startTime.length()!=0 && endTime.length()==0){
            reservations = reservationRepository.getReservationsFromDate(LocalDateTime.parse(startTime));

        }
        else if(startTime.length()==0 && endTime.length()!=0){
            reservations = reservationRepository.getReservationsToDate(LocalDateTime.parse(endTime));
        }
        else return null;

        List<ReservationDTO> reservationsDTO = reservations
                .stream()
                .filter(reservation -> reservation != null)
                .map(reservation ->
                {
                    ReservationDTO reservationDTO = new ReservationDTO();
                    reservationDTO.setId(reservation.getId());
                    reservationDTO.setRoom(reservation.getRoom());
                    reservationDTO.setUser(reservation.getUser());
                    reservationDTO.setReservationStart(reservation.getReservationStart());
                    reservationDTO.setReservationEnd(reservation.getReservationEnd());
                    return reservationDTO;
                }).collect(Collectors.toList());

        return reservationsDTO;

    }

    public List<ReservationDTO> getUserReservationSInChoosedTimeFrame(LoggedUserDTO userDTO, String startTime, String endTime) {
        List<Reservation> reservations = null;
        User user = userRepository.getUserByLogin(userDTO.getLogin());

        if(startTime.length()!=0 && endTime.length()!=0){
            reservations = reservationRepository.getUserReservationsInTimeFrame
                    (LocalDateTime.parse(startTime),LocalDateTime.parse(endTime), user.getId());
        }
        else if(startTime.length()!=0 && endTime.length()==0){
            reservations = reservationRepository.getUserReservationsFromDate(LocalDateTime.parse(startTime), user.getId());

        }
        else if(startTime.length()==0 && endTime.length()!=0){
            reservations = reservationRepository.getUserReservationsToDate(LocalDateTime.parse(endTime), user.getId());
        }
        else return null;

        List<ReservationDTO> reservationsDTO = reservations
                .stream()
                .filter(reservation -> reservation != null)
                .map(reservation ->
                {
                    ReservationDTO reservationDTO = new ReservationDTO();
                    reservationDTO.setId(reservation.getId());
                    reservationDTO.setRoom(reservation.getRoom());
                    reservationDTO.setUser(reservation.getUser());
                    reservationDTO.setReservationStart(reservation.getReservationStart());
                    reservationDTO.setReservationEnd(reservation.getReservationEnd());
                    return reservationDTO;
                }).collect(Collectors.toList());

        return reservationsDTO;

    }

    public List<ReservationDTO> getReservationsInChoosedTimeForRoom(String startTime, String endTime, RoomDTO roomDTO) {
        List<Reservation> reservations = null;
        Room room = roomRepository.getRoomByName(roomDTO.getName());

        if(startTime.length()!=0 && endTime.length()!=0){
            reservations = reservationRepository.getRoomReservationsInTimeFrame
                    (LocalDateTime.parse(startTime),LocalDateTime.parse(endTime), room.getId());
        }
        else if(startTime.length()!=0 && endTime.length()==0){
            reservations = reservationRepository.getRoomReservationsFromDate(LocalDateTime.parse(startTime), room.getId());

        }
        else if(startTime.length()==0 && endTime.length()!=0){
            reservations = reservationRepository.getRoomReservationsToDate(LocalDateTime.parse(endTime), room.getId());
        }
        else return null;

        List<ReservationDTO> reservationsDTO = reservations
                .stream()
                .filter(reservation -> reservation != null)
                .map(reservation ->
                {
                    ReservationDTO reservationDTO = new ReservationDTO();
                    reservationDTO.setId(reservation.getId());
                    reservationDTO.setRoom(reservation.getRoom());
                    reservationDTO.setUser(reservation.getUser());
                    reservationDTO.setReservationStart(reservation.getReservationStart());
                    reservationDTO.setReservationEnd(reservation.getReservationEnd());
                    return reservationDTO;
                }).collect(Collectors.toList());

        return reservationsDTO;
    }
}
