INSERT INTO users (first_name, last_name, password, login,)VALUES ('John', 'Smith', 'qwerty', 'jsmith');
INSERT INTO users (first_name, last_name, password, login,)VALUES ('Jane', 'Doe', 'mySecret', 'jdoe');
INSERT INTO users (first_name, last_name, password, login,)VALUES ('Jane', 'Doe', 'password', 'login');

INSERT INTO rooms (name, location, number_of_seats, projector, phone_number)VALUES ('Large Room', '1st floor', 10, 'true', '22222222');
INSERT INTO rooms (name, location, number_of_seats, projector)VALUES ('Medium Room', '1st floor', 6, 'true');
INSERT INTO rooms (name, location, number_of_seats, projector)VALUES ('Small Room', '2nd floor', 4, 'false');

insert into reservations (user_id, room_id, reservation_start, reservation_end) values (1,1,GETDATE(), GETDATE());

