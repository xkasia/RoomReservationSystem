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

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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

        List<LocalDateTime> startTimes = reservationRepository.giveStartTimesGreaterThanWantedToBook(startTime, roomId);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");


        System.out.println("START TIMES " + startTimes.toString());
        System.out.println("sTART TIME = " + startTime.toString());
        System.out.println("End TIME = " + endTime.toString());

        System.out.println("Room id = " + roomId);
        System.out.println("KASIA");

        if(startTimes!=null){
            Duration reservationDuration = Duration.between(startTime,endTime);
            System.out.println("lESNIAK");
            String str_startTime = startTime.format(formatter);
            System.out.println(str_startTime);
            LocalDateTime startTimex = LocalDateTime.parse(str_startTime, formatter);
            System.out.println(startTimes.size());
            for (int i = 0; i <startTimes.size() ; i++) {
                System.out.println("JAKUB");

                String time = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(startTime);
                System.out.println("TIMEEE " + time);


                System.out.println("TIME ");



                System.out.println("s + " + startTimex.format(formatter));




                //LocalDateTime startTimeFromDB = startTimes.get(i);

//                LocalDateTime localDB = LocalDateTime
//                        .ofInstant(startTimes.get(i).toInstant(ZoneOffset.UTC), ZoneOffset.ofHours(0));

                //System.out.println("localdb" + localDB);

                System.out.println("pipa");
                //Duration durationFromDatabase= Duration.between(startTime, startTimeFromDB);

                //Duration duratioFromDatabase= Duration.between(startTimex.format(formatter), startTimes.get(i));
                System.out.println("WOCHAL");
//                if (reservationDuration.compareTo(durationFromDatabase) == 1) {
//                    System.out.println("MILOSC");
//                    return false;
//                }

            }
        }
        return true;
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
                reservationDTO.setReservationEnd(reservation.getReservationEnd());
                return reservationDTO; }).collect(Collectors.toList());

        return reservationsDTO;

    }


//    @Override
//    public Timestamp convertToDatabaseColumn(LocalDateTime ldt) {
//        return Timestamp.valueOf(ldt);
//    }
//
//    @Override
//    public LocalDateTime convertToEntityAttribute(Timestamp ts) {
//        if(ts!=null){
//            return ts.toLocalDateTime();
//        }
//        return null;
//    }

    public List<ReservationDTO> getUserReservations(LoggedUserDTO userDTO) {

        User user = userRepository.getUserByLogin(userDTO.getLogin());

        List<Reservation> reservations = reservationRepository.getUserReservations(user.getId());


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
}
