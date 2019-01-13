package pl.hit.system.core.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.hit.system.data.model.Reservation;
import pl.hit.system.data.model.Room;
import pl.hit.system.data.repositories.ReservationRepository;
import pl.hit.system.data.repositories.RoomRepository;
import pl.hit.system.dto.RoomDTO;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RoomsService {

    private RoomRepository roomRepository;
    private ReservationRepository reservationRepository;

    @Autowired
    public RoomsService(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    public List<RoomDTO> getAllRooms() {
        List<Room> rooms = roomRepository.findAll();
        List<RoomDTO> roomsDTO = rooms
                .stream()
                .filter(room -> room != null)
                .map(room -> {
                    RoomDTO roomDTO = new RoomDTO();
                    roomDTO.setId(room.getId());
                    roomDTO.setName(room.getName());
                    roomDTO.setLocation(room.getLocation());
                    roomDTO.setNumberOfSeats(room.getNumberOfSeats());
                    roomDTO.setPhoneNumber(room.getPhoneNumber());
                    roomDTO.setProjector(room.getProjector());
                    return roomDTO;
                })
                .collect(Collectors.toList());
        return roomsDTO;
    }

    public RoomDTO getRoomByName(String roomName) {

        RoomDTO roomDTO = null;

        Room room = roomRepository.getRoomByName(roomName);

        if(room!=null){
            roomDTO = new RoomDTO(room.getId(), room.getName(), room.getLocation(), room.getNumberOfSeats(),
                    room.getProjector(), room.getPhoneNumber());
        }
        return roomDTO;
    }

    public void updateRoom(RoomDTO roomDTO, String name, String location, Integer numberOfSeats, String projector, String phoneNumber) {

        Room room = roomRepository.getRoomByName(roomDTO.getName());

        roomRepository.updateRoom(room.getId(), name, location, numberOfSeats, projector, phoneNumber);

    }

    public void deleteRoom(RoomDTO roomDTO) {

        Room room = roomRepository.getRoomByName(roomDTO.getName());


        if (room.getReservation() != null) {
            List<Reservation> roomReservations = room.getReservation();
            for (int i = 0; i <roomReservations.size() ; i++) {
                reservationRepository.delete(roomReservations.get(i));
            }
           room.setReservation(null);
        }

        roomRepository.deleteRoom(room.getId());

    }

    public boolean checkIfRoomExists(String name) {
        boolean checkIfNameExists = roomRepository.checkIfNameExists(name);

        return checkIfNameExists;
    }

    public void saveRoom(RoomDTO roomDTO) {

        Room room = new Room();
        room.setName(roomDTO.getName());
        room.setLocation(roomDTO.getLocation());
        room.setNumberOfSeats(roomDTO.getNumberOfSeats());
        room.setProjector(roomDTO.getProjector());
        room.setPhoneNumber(roomDTO.getPhoneNumber());

        roomRepository.saveRoomInDb(room.getName(), room.getLocation(), room.getNumberOfSeats(),
        room.getProjector(), room.getPhoneNumber());

    }


    public RoomDTO getRoomById(Long roomId) {

        RoomDTO roomDTO = null;
        Room room = roomRepository.getRoomById(roomId);

        if(room!=null){
            roomDTO = new RoomDTO(room.getId(), room.getName(), room.getLocation(), room.getNumberOfSeats(),
                    room.getProjector(), room.getPhoneNumber());
        }
        return roomDTO;
    }
}
