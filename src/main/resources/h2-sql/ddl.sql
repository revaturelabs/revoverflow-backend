DROP TABLE IF EXISTS roles CASCADE;
create table roles (
	id INTEGER generated always as identity primary key,
	role VARCHAR(20)
);
 
DROP TABLE IF EXISTS users CASCADE;
create table users (
	id INTEGER generated always as identity primary key,
	role_id INTEGER references roles(id),
	points INTEGER not null,
	constraint not_negative check(points >= 0),
	user_id INTEGER not null,
	user_name VARCHAR(50),
	email VARCHAR(100),
	password VARCHAR(50),
	address_id INTEGER
);

DROP TABLE IF EXISTS questions CASCADE;
create table questions (
	id INTEGER generated always as identity primary key,
	title VARCHAR(50) NOT NULL,
	content VARCHAR(1000) NOT NULL,
	creation_date TIMESTAMP NOT NULL,
	edit_date TIMESTAMP,
	status BOOLEAN NOT NULL,
	user_id INTEGER references users(id)
);

DROP TABLE IF EXISTS answers CASCADE;
create table answers (
	id INTEGER generated always as identity primary key,
	user_id INTEGER references users(id),
	question_id INTEGER references questions(id),
	content VARCHAR(1000),
	creation_date TIMESTAMP NOT NULL,
	edit_date TIMESTAMP
);

DROP TABLE questions CASCADE;
create table questions (
	id INTEGER generated always as identity primary key,
	accepted_id INTEGER references answers(id),
	title VARCHAR(50) NOT NULL,
	content VARCHAR(1000) NOT NULL,
	creation_date TIMESTAMP NOT NULL,
	edit_date TIMESTAMP,
	status BOOLEAN NOT NULL,
	user_id INTEGER references users(id)
);