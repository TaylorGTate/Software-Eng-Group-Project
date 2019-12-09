#create schema DOMSdb;

/*
create table Patient(
	patientName varchar(50),
    birthDate date,
    ssn varchar(11),
    allergies varchar(500),
    preferredDoctor varchar(50),
    bloodtype varchar(3),
    primary key(ssn)
 );
  create table Room (
	roomNumber int(11) NOT NULL,
    avaliable varchar(20),
    primary key(roomNumber)
 );
 create table Doctor(
	doctor_id int(11) AUTO_INCREMENT NOT NULL,
	doctorName varchar(50),
    birthDate date,
    ssn varchar(11),
    primary key(doctor_id)
 );
 create table AppointmentManager(
	manager_id int(11) AUTO_INCREMENT NOT NULL,
	name varchar(50),
    birthDate date,
    primary key(manager_id)
 );
 create table RoomManager (
	manager_id int(11) AUTO_INCREMENT NOT NULL,
    name varchar (50),
    birthDate date,
    primary key (manager_id)
 );
create table DoctorManager(
	manager_id int(11) AUTO_INCREMENT NOT NULL,
	name varchar(50),
    birthDate date,
    primary key(manager_id)
 );
create table PatientManager(
	manager_id int(11) AUTO_INCREMENT NOT NULL,
	name varchar(50),
    birthDate date,
    primary key(manager_id)
 );
  create table Appointment(
	appt_id int(11) AUTO_INCREMENT NOT NULL,
    Pssn varchar(11),
	apptDate date,
    apptTime time,
    notes varchar(500),
    status varchar(11),
    preferredDoc varchar(30),
    roomNum int(11),
    primary key(appt_id),
    foreign key(Pssn) references Patient(ssn),
    foreign key(roomNum) references Room(roomNumber)
 );
 */

/*
  select * from Patient;
  select * from Appointment;
  select * from RoomManager;
  select * from Room;
  select * from AppointmentManager;
  select * from Doctor;
  select * from DoctorManager;
  select * from PatientManager;
*/

  /*insert into appointment (Pssn, apptDate, apptTime, notes, status, roomNum)
  values ('123-45-6789','2000-05-03','12:30:00','N/A','Checked-in', null);
  
  insert into appointment (Pssn, apptDate, apptTime, notes, status, roomNum)
  values ('123-45-6788','2000-05-03','12:30:00','N/A','Checked-in', null);
  
  insert into appointment (Pssn, apptDate, apptTime, notes, status, roomNum)
  values ('123-45-6787','2000-05-03','12:30:00','N/A','Checked-in', null);
  
  insert into patient
  values ('Taylor', '1997-05-03', '123-45-6789', 'N/A', 'N/A', 'A+');
  
  insert into patient
  values ('James', '1997-05-03', '123-45-6788', 'N/A', 'N/A', 'A+');
  
  insert into patient
  values ('Tori', '1997-05-03', '123-45-6787', 'N/A', 'N/A', 'A+');
  
  insert into room
  values ('0', 'Default');
            
  insert into room
  values ('1', 'Clean and Ready');
  
  insert into room
  values ('2', 'Clean and Ready');
  
  insert into room
  values ('3', 'Clean and Ready');
  
  insert into room
  values ('4', 'Clean and Ready');
	 
  insert into room
  values ('0', 'Default');
  */
	    
/*
  drop table Appointment;
  drop table DoctorManager;
  drop table RoomManager;               
  drop table AppointmentManager;
  drop table Patient; 
  drop table Room;
  drop table Doctor;   
*/
 
  
  
