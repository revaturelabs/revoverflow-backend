INSERT INTO TBL_EMPLOYEES (first_name, last_name, email) VALUES
  ('Lokesh', 'Gupta', 'abc@gmail.com'),
  ('Deja', 'Vu', 'xyz@email.com'),
  ('Caption', 'America', 'cap@marvel.com');

insert into roles (role)
  values ('employee'),
	       ('admin');

insert into users (role_id, points, user_id, user_name, email, password, address_id)
values (1, 3, 1, 'user1', 'user1@email.com', 'password', 1);

insert into users (role_id, points, user_id, user_name, email, password, address_id)
values (2, 3, 1, 'user2', 'user2@email.com', 'password', 1);