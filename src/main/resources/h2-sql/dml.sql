insert into roles (role)
  values ('employee'),
	       ('admin');

insert into users (role_id, points, user_id, user_name, email, password, address_id)
values (1, 3, 1, 'user1', 'user1@email.com', 'password', 1);

insert into users (role_id, points, user_id, user_name, email, password, address_id)
values (2, 3, 1, 'user2', 'user2@email.com', 'password', 1);

insert into questions (title, content, creation_date, status, user_id)
values ('dasf;ldajdf;lasfdk', 'lala', '2012-12-12', false, 1);

insert into questions (title, content, creation_date, status, user_id)
values ('test', 'test', '2012-12-12', false, 1);

insert into answers (user_id, question_id, content, creation_date, edit_date)
values (1, 1, 'lalalala', '2012-12-12', NULL),
       (1, 2, 'number2', '2012-12-12', NULL);