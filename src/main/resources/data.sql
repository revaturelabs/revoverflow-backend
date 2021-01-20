
DROP TABLE IF EXISTS users;
CREATE TABLE users (
  user_id int PRIMARY KEY,
  account_id int NOT NULL,
  points int NOT NULL,
  admin_role boolean NOT NULL,
  profile_picture BYTEA,
  email varchar(250) not null,
  first_name varchar(250) NOT NULL,
  last_name varchar(250) NOT NULL,
  "PASSWORD" varchar(250) NOT NULL
);

INSERT INTO users (user_id,account_id, points, admin_role, profile_picture, email, first_name, last_name, "PASSWORD") 
VALUES (13, 15, 100, false, NULL, 'user@rss.com', 'User', 'User', '$2a$10$97GCVEL7iXNgR8MuSltN9.pHHXnNNjU0c.uoVpuYWHMgRKOljdS26'), (12, 26, 20, true, NULL, 'admin@rss.com', 'Admin', 'Admin', '$2a$10$97GCVEL7iXNgR8MuSltN9.pHHXnNNjU0c.uoVpuYWHMgRKOljdS26');
