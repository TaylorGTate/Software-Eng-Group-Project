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
	appt_id int(11) AUTO_INCREMENT,
    Pssn varchar(11),
	apptDate date,
    apptTime datetime,
    notes varchar(500),
    status varchar(9),
    primary key(appt_id),
    foreign key(Pssn) references Patient(ssn)
 );
 
 create table AppointmentManager(
	manager_id int(11) AUTO_INCREMENT,
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
	
 
  #select * from RoomManager;
  #select * from Room;

  /*
  drop table Room;
  drop table RoomManager;
  drop table Patient;
  drop table Appointment;
  drop table AppointmentManager;
  */