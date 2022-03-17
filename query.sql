SELECT * FROM studentdatabase.student;
create database studentdatabase;
use studentdatabase;
create table student(
	id int primary key auto_increment,
    name varchar(50),
    department varchar(50),
    country varchar(50)
);
insert into student values(1,'vincent','B.arch','India');