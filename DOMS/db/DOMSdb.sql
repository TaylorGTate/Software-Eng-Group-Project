#create schema DOMSdb;
/*
 create table AppointmentManager(
	manager_id int(11) AUTO_INCREMENT NOT NULL,
	name varchar(50),
    birthDate date,
    primary key(manager_id)
 );
 
 create table Room (
	roomNumber int(11) NOT NULL,
    avaliable varchar(20),
    primary key(roomNumber)
 );
 
 create table RoomManager (
	manager_id int(11) AUTO_INCREMENT NOT NULL,
    name varchar (50),
    birthDate date,
    primary key (manager_id)
 );
 
create table Patient(
	patientName varchar(50),
    birthDate date,
    ssn varchar(11),
    allergies varchar(500),
    preferredDoctor varchar(50),
    bloodtype varchar(3),
    primary key(ssn)
 );

 create table Appointment(
	appt_id int(11) AUTO_INCREMENT NOT NULL,
    Pssn varchar(11),
	apptDate date,
    apptTime time,
    notes varchar(500),
    status varchar(9),
    roomNum int(11),
    primary key(appt_id),
    foreign key(Pssn) references Patient(ssn),
    foreign key(roomNum) references Room(roomNumber)
 );
 */
  #select * from Patient;
  #select * from Appointment;
  #select * from RoomManager;
  #select * from Room;

  /*
  drop table Room;
  drop table RoomManager;
  drop table Patient;
  drop table Appointment;
  drop table AppointmentManager;
  */