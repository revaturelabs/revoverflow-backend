insert into roles (role) values ('employee'), ('admin');

INSERT INTO users (user_id, account_id, points, admin_role, profile_picture, email, first_name, last_name) 
VALUES (13, 15, 0, false, NULL, 'user@rss.com', 'User', 'User'), (12, 26, 0, true, NULL, 'admin@rss.com', 'Admin', 'Admin');

insert into questions (title, content, creation_date, status, user_id)
values ('dasf;ldajdf;lasfdk', 'lala', '2012-12-12', false, 13);

insert into questions (title, content, creation_date, status, user_id)
values ('test', 'test', '2012-12-12', false, 13);

insert into answers (user_id, question_id, content, creation_date, edit_date)
values (13, 1, 'lalalala', '2012-12-12', NULL), (13, 2, 'number2', '2012-12-12', NULL);