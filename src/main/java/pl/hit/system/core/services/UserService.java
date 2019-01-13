package pl.hit.system.core.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.hit.system.data.model.Reservation;
import pl.hit.system.data.model.User;
import pl.hit.system.data.repositories.ReservationRepository;
import pl.hit.system.data.repositories.UserRepository;
import pl.hit.system.dto.LoggedUserDTO;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    private UserRepository userRepository;
    private ReservationRepository reservationRepository;

    @Autowired
    public UserService(UserRepository userRepository,
                       ReservationRepository reservationRepository) {
        this.userRepository = userRepository;
        this.reservationRepository = reservationRepository;
    }

    public boolean checkCredentials(String login, String password) {

        boolean existUser = userRepository.checkIfUserExists(login, password);

        return existUser;
    }

    public LoggedUserDTO getUser(String login, String password) {

        LoggedUserDTO loggedUserDTO = null;
        User user = userRepository.getUserByLoginAndPassword(login, password);

        if (user != null) {
            loggedUserDTO = new LoggedUserDTO(user.getId(), user.getFirstName(),
                    user.getLastName(), user.getPassword(), user.getLogin());
        }
        return loggedUserDTO;
    }


    public boolean checkIfUserExists(String login) {

        boolean checkIfEmailExists = userRepository.checkIfEmailExist(login);

        return checkIfEmailExists;
    }

    public void saveUser(LoggedUserDTO loggedUser) {

        User user = new User();
        user.setFirstName(loggedUser.getFirstName());
        user.setLastName(loggedUser.getLastName());
        user.setPassword(loggedUser.getPassword());
        user.setLogin(loggedUser.getLogin());

        userRepository.saveUserInDB(user.getFirstName(), user.getLastName(),
                user.getLogin(), user.getPassword());

    }

    public void updateUser(LoggedUserDTO loggedUser, String firstName,
                           String lastName, String password) {

        User user = userRepository.getUserByLogin(loggedUser.getLogin());
        // TODO: to change with query where key is argument
        //        int i=0;
//        String[] values = {firstName, lastName, password};
//        String[] keys = {"firstName", "lastName", "password"};
//        for (String key:keys) {
//            if (values[i] != null){
//                userRepository.updateUser(user.getLogin(), key, values[i]);
//            }
//            i++;
//        }
        userRepository.updateUser(user.getLogin(), firstName, lastName, password);
    }

    public void deleteUser(LoggedUserDTO loggedUser) {

        User user = userRepository.getUserByLogin(loggedUser.getLogin());
        if (user.getReservation() != null) {
            List<Reservation> userReservations = user.getReservation();
            for (int i = 0; i < userReservations.size(); i++) {
                reservationRepository.delete(userReservations.get(i));
            }
            user.setReservation(null);
        }
        userRepository.deleteUser(user.getLogin());
    }

    public List<LoggedUserDTO> getAllUsers() {

        return userRepository.findAll().stream()
                .filter(user -> user != null)
                .map(user -> {
                    LoggedUserDTO userDTO = new LoggedUserDTO();
                    userDTO.setId(user.getId());
                    userDTO.setFirstName(user.getFirstName());
                    userDTO.setLastName(user.getLastName());
                    userDTO.setLogin(user.getLogin());
                    userDTO.setPassword(user.getPassword());
                    return userDTO;
                }).collect(Collectors.toList());
    }

    public LoggedUserDTO getUserByLogin(String login) {
        LoggedUserDTO loggedUserDTO = null;
        User user = userRepository.getUserByLogin(login);

        if (user != null) {
            loggedUserDTO = new LoggedUserDTO(user.getId(), user.getFirstName(), user.getLastName(),
                    user.getPassword(), user.getLogin());
        }
        return loggedUserDTO;
    }
}
