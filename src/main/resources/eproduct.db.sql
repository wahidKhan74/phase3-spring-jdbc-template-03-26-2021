create database ecomwebapp;

use ecomwebapp;

create table eproduct( id int(11) NOT NULL AUTO_INCREMENT, name varchar(100) ,price decimal(10,2),dateAdded timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP, primary key(`id`) );

insert into eproduct(id,name,price) values (2,'DELL xyz series laptop',105000.23);
insert into eproduct(id,name,price) values (3,'Asus xyz series laptop',97000.23);