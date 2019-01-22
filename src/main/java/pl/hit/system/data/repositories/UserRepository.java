package pl.hit.system.data.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import pl.hit.system.data.model.User;


@Transactional(isolation = Isolation.READ_UNCOMMITTED)
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query(nativeQuery = true, value =
            "SELECT CASE WHEN count(*) = 1  THEN 'true' ELSE 'false' END " +
                    "from users where login = ?1 and  password = ?2")
    boolean checkIfUserExists(String login, String password);


    @Query(nativeQuery = true, value =
            "SELECT CASE WHEN count(*) = 1  THEN 'true' ELSE 'false' END " +
                    "from users where login = ?1")
    boolean checkIfEmailExist(String login);

    User getUserByLoginAndPassword(String login, String password);

    @Modifying
    @Query(nativeQuery = true, value =
            "Insert into users(first_name, last_name, login, password)" +
                    "values(?1, ?2, ?3, ?4 )")
    void saveUserInDB(String firstName, String lastName, String login,
                      String password);

    @Modifying
    @Query(nativeQuery = true, value = "UPDATE users SET first_name=?2,last_name= ?3, " +
            "password = ?4 WHERE login = ?1")
    void updateUser(String loggedUserLogin, String firstName, String lastName, String password);

    @Modifying
    @Query(nativeQuery = true, value = "DELETE FROM users WHERE login = ?1")
    void deleteUser(String login);

    User getUserByLogin(String login);

}
