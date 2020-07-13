DROP TABLE IF EXISTS billionaires;
 
CREATE TABLE billionaires (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  first_name VARCHAR(250) NOT NULL,
  last_name VARCHAR(250) NOT NULL,
  career VARCHAR(250) DEFAULT NULL
);
 
INSERT INTO billionaires (first_name, last_name, career) VALUES
  ('Aliko', 'Dangote', 'Billionaire Industrialist'),
  ('Bill', 'Gates', 'Billionaire Tech Entrepreneur'),
  ('Folrunsho', 'Alakija', 'Billionaire Oil Magnate');

DROP TABLE IF EXISTS users;

CREATE TABLE users (
  user_id int PRIMARY KEY,
  account_id int NOT NULL,
  points int NOT NULL,
  admin_role boolean NOT NULL,
  profile_picture BYTEA,
  email varchar(250) not null,
  first_name varchar(250) NOT NULL,
  last_name varchar(250) NOT NULL
);

INSERT INTO users (user_id,account_id,points,admin_role,profile_picture,email,first_name,last_name) VALUES
(13,15,0,false,NULL,'user@rss.com','User','User'),
(12,26,0,true,NULL,'admin@rss.com','Admin','Admin');