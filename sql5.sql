CREATE DATABASE  IF NOT EXISTS `web_customer_tracker`;
USE `web_customer_tracker`;

--
-- Table structure for table `users`
--

CREATE TABLE customer (
  id int(11) NOT NULL AUTO_INCREMENT,
  name varchar(45) NOT NULL,
  email varchar(45) NOT NULL,
  phoneNumber varchar(45) NOT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=169 DEFAULT CHARSET=latin1

select * from customer;
insert into customer values(1,'sivateja','sivateja@gmail.com','6303798407');
drop table customer;

CREATE TABLE Login (
  id int(11) NOT NULL AUTO_INCREMENT,
  username varchar(45) NOT NULL,
  password varchar(45) NOT NULL,
  email varchar(45) NOT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=169 DEFAULT CHARSET=latin1

select * from Login;

insert into Login values(1,'sivateja','sivateja123','sivateja@gmail.com');

 