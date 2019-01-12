INSERT INTO users (first_name, last_name, password, login,)VALUES ('John', 'Smith', 'qwerty', 'jsmith');
INSERT INTO users (first_name, last_name, password, login,)VALUES ('Jane', 'Doe', '	mySecret', 'jdoe');

INSERT INTO rooms (name, location, number_of_seats, projector, phone_number)VALUES ('Large Room', '1st floor', 10, 'true', '22-22-22-22');
INSERT INTO rooms (name, location, number_of_seats, projector)VALUES ('Medium Room', '1st floor', 6, 'true');
INSERT INTO rooms (name, location, number_of_seats, projector)VALUES ('Small Room', '2nd floor', 4, 'false');



INSERT INTO users (first_name, last_name, password, login,)VALUES ('jnowak', 'jnowak', 'password', 'logicccccc');
INSERT INTO users (first_name, last_name, password, login,)VALUES ('jnowak', 'jnowak', 'password', 'logsccss');
INSERT INTO users (first_name, last_name, password, login,)VALUES ('jnowak', 'jnowak', 'password', 'login');
INSERT INTO users (first_name, last_name, password, login,)VALUES ('jnowak', 'jnowak', 'password', 'lkccss');
INSERT INTO rooms (name, location, number_of_seats, projector, phone_number)VALUES ('name', 'location', 22, 'true', '333');
INSERT INTO rooms (name, location, number_of_seats, phone_number)VALUES ('nam', 'locat', 66, '66');
INSERT INTO rooms (name, location, number_of_seats, phone_number)VALUES('nas', 'locssat', 663, 'ss6');
INSERT INTO rooms (name, location, number_of_seats, phone_number)VALUES('nasfs', 'locsssat', 663, 'ss6');
--
-- insert into user_rooms(user_id, room_id) values (1,1);

insert into reservation (user_id, room_id, reservation_start, reservation_end) values (1,1,GETDATE(), GETDATE());