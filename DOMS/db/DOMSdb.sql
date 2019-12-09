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

/*
  insert into patient values ('John Hall', '1997-05-03', '111-11-1111', 'Pine nuts, tree nuts.', 'Dr. Smith', 'A+');
  insert into patient values ('Trevor Smith', '1993-02-16', '222-22-2222', 'Tomatoes', 'Dr. Walker', 'A-');
  insert into patient values ('Hannah Carter', '1983-08-09', '333-33-3333', 'Penicillin', 'Dr. Hall', 'O-');
  insert into patient values ('Rebecca Folsom', '1992-10-13', '444-44-4444', 'N/A', 'Dr. Smith', 'O+');
  
  insert into room values ('0', 'Unassigned Room');
  insert into room values ('1', 'Clean and Ready');
  insert into room values ('2', 'Clean and Ready');
  insert into room values ('3', 'Clean and Ready');
  insert into room values ('4', 'Clean and Ready');
  insert into room values ('5', 'Clean and Ready');
  
  insert into Doctor values (1, "Dr. Smith", "1967-02-04", "111-22-3333");
  insert into Doctor values (2, "Dr. Walker", "1963-06-20", "222-33-4444");
  insert into Doctor values (3, "Dr. Hall", "1972-12-15", "333-44-5555");

  insert into AppointmentManager values (1, "Becky Smith", "1984-03-24");
  insert into AppointmentManager values (2, "Tisha Douglas", "1972-10-03");
  
  insert into RoomManager values (1, "Trey Hall", "1982-07-18");
  insert into RoomManager values (2, "Tiffany Smart", "1976-11-23");
  
  insert into DoctorManager values (1, "John Chandler", "1991-04-16");
  insert into DoctorManager values (2, "Tisha Douglas", "1987-09-15");
  
  insert into PatientManager values (1, "William Sheilds", "1994-03-12");
  insert into PatientManager values (2, "Tisha Douglas", "1979-05-22");

  insert into Appointment values (1, "111-11-1111", "2019-12-10", "09:30:00", "Checkup", "Requested", "Dr. Smith", 0);
  insert into Appointment values (2, "222-22-2222", "2019-12-10", "10:00:00", "Physical", "Requested", "Dr. Walker", 0);
  insert into Appointment values (3, "333-33-3333", "2019-12-10", "10:30:00", "Severe Cold", "Requested", "Dr. Hall", 0);
  insert into Appointment values (4, "444-44-4444", "2019-12-10", "11:00:00", "High Blood Pressure", "Requested", "Dr. Smith", 0);
*/
	    
/*
  drop table Appointment;
  drop table DoctorManager;
  drop table RoomManager;               
  drop table AppointmentManager;
  drop table Patient; 
  drop table Room;
  drop table Doctor;   
  drop table PatientManager;
 */
  
  
