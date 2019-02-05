CREATE TABLE users_roles (
  id bigint NOT NULL AUTO_INCREMENT,
  login varchar(100) NOT NULL,
  role varchar(100) NOT NULL,
  PRIMARY KEY (id)
);

INSERT INTO users (first_name, last_name, password, login,)VALUES ('John', 'Smith', '{noop}qwerty', 'jsmith');
INSERT INTO users_roles (login, role) VALUES ('jsmith', 'ROLE_USER');
INSERT INTO users (first_name, last_name, password, login,)VALUES ('Jane', 'Doe', '{noop}mySecret', 'jdoe');
INSERT INTO users_roles (login, role) VALUES ('jdoe', 'ROLE_USER');
INSERT INTO users (first_name, last_name, password, login,)VALUES ('Jane', 'Doe', '{noop}password', 'login');
INSERT INTO users_roles (login, role) VALUES ('login', 'ROLE_USER');

INSERT INTO users (first_name, last_name, password, login,)VALUES ('a', 'a', '{noop}password', 'a');
INSERT INTO users_roles (login, role) VALUES ('a', 'ROLE_USER');
INSERT INTO users_roles (login, role) VALUES ('a', 'ROLE_ADMIN');


INSERT INTO rooms (name, location, number_of_seats, projector, phone_number)VALUES ('Large Room', '1st floor', 10, 'true', '22222222');
INSERT INTO rooms (name, location, number_of_seats, projector)VALUES ('Medium Room', '1st floor', 6, 'true');
INSERT INTO rooms (name, location, number_of_seats, projector)VALUES ('Small Room', '2nd floor', 4, 'false');

insert into reservations (user_id, room_id, reservation_start, reservation_end) values (1,1,GETDATE(), GETDATE());

