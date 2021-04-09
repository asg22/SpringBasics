CREATE DATABASE  IF NOT EXISTS `spring_sec`;
USE `spring_sec`;
drop table if exists userdetails;
CREATE TABLE userdetails (
    id serial PRIMARY KEY,
    username varchar(20) NOT NULL,
    password VARCHAR(20) NOT NULL,
    active boolean NOT NULL,
    roles TEXT NOT NULL 
);

INSERT IuserdetailsNTO userdetails (id,username,password,active,roles) VALUES
 	(1,'testuser1', 'pass1', true, 'ROLE_USER'),
	(2,'testuser2', 'pass2', true, 'ROLE_USER'),
	(3,'admin', 'admin', true, 'ROLE_ADMIN');