create database capstone_db;
use capstone_db;
create table accounts(
	user_id int auto_increment,
	username varchar(255) UNIQUE,
	password varchar(255),
	name varchar(255),
	balance decimal(13,2),
	primary key(user_id)
);
create table cars(
	car_id int auto_increment,
	make varchar(255),
	model varchar(255),
	color varchar(255),
	trim_level varchar(255),
	vehicle_type varchar(255),
	vehicle_year int,
	vin varchar(17),
	mileage int,
	price decimal(13,2),
	primary key(car_id)
);
