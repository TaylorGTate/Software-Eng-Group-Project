#create schema DOMSdb;

/*create table Patient(
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
    foreign key(Pssn) references Patient(ssn)
    foreign key(roomNum) references Room(roomNumber)
 );
 
 create table AppointmentManager(
	manager_id int(11) AUTO_INCREMENT NOT NULL,
	name varchar(50),
    birthDate date,
    primary key(manager_id)
 );
 
 create table Room (
	roomNumber int(11) NOT NULL,
    buildingNumber int(11) NOT NULL,
    avaliable varchar(20),
    Pssn varchar(11),
    primary key(buildingNumber, roomNumber)
 );
 
 create table RoomManager (
	manager_id int(11) AUTO_INCREMENT NOT NULL,
    name varchar (50),
    birthDate date,
    primary key (manager_id)
 );*/
	
 
<<<<<<< HEAD
  select * from Patient;
=======
  #select * from RoomManager;
  #select * from Room;

>>>>>>> aa4013d4c13053ebd26127049e9f364e3fc13a5a
  /*
  drop table Room;
  drop table RoomManager;
  drop table Patient;
  drop table Appointment;
  drop table AppointmentManager;
  */