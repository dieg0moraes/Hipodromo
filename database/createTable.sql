create table oid(
	ultimo int not null
);

create table Usuarios(
	object_id int,
	username varchar(40) UNIQUE not null,
	password varchar(40),
	PRIMARY KEY(id),
	isStaff boolean,
	saldo float
);



create table Caballos(
	object_id int not null PRIMARY key,
	name varchar(50) not null unique,
	cuidador varchar(60)

);

create table Carreras(
	object_id int,
	date date,
	numero int,
	nombre varchar(40),
	status varchar(15),
	ganador references Caballos(object_id),


);

create table Hipodromos(
	object_id int primary key,
	name varchar(100) not null unique,
	direccion varchar(100) not null

);


create table TiposApuestas(
	object_id int PRIMARY KEY,
	tipo varchar(20) not null unique
);

create table Participaciones(
	object_id int PRIMARY KEY,
	caballo int references Caballos(object_id),
	numero_caballo int not null,
	dividendo float not null,
	carrera int references Carreras(object_id),
	tipo_apuesta int references TiposApuesta(object_id)

);


create table Apuestas(
	object_id int primary key,
	participacion int references Participaciones(object_id),
	monto float not null
);

create table ApuestaUsuario(
	usuario int references Usuarios(object_id),
	apuesta int references Apuestas(object_id)
);



create table CarreraParticipaciones(
	carrera int  references Carreras(object_id),
	participacion int references Participaciones(object_id)

);
create table Jornadas(
	object_id int PRIMARY key,
	date date not null unique,
	next_carrera_id int not null,
	carrera_actual int references Carreras(object_id)
);

create table JornadaCarrera(
	carrera int references Carreras(object_id),
	jornada int  references Jornadas(object_id)
);

create table JornadaHipodromo(
	jornada int references Jornadas(object_id),
	hipodromo int references Hipodromos(object_id) 
);

create table CarreraApuesta(
	carrera int refereces Carrera(objec_id),
	apuesta int references Apuestas(object_id)
);

insert into oid values(1);

insert into Hipodromos values 
	(1, 'Maronas', 'Calle falsa 123'), 
	(2, 'De la otra punta', 'Fake street 321'),
	(3, 'Cheto', 'Calle cheta 456')
;

insert into Usuarios values
	(4, 'admin', 'admin', true, 0),
	(5, 'user', 'user', false, 500000),
	(6, 'user1', 'user1', false, 1000000),
	(7, 'user3', 'user3', false, 200000),
	(8, 'admin2', 'admin2', true, 0)
;

insert into Caballos values
	(9, 'Bucéfalo', 'Encargado uno'),
	(10, 'Rocinante', 'Encargado uno'),
	(11, 'Babieca', 'Encargado uno'),
	(12, 'El caballo de Troya', 'Encargado uno'),
	(13, 'Seabiscuit', 'Encargado dos'),
	(14, 'Tiro al Blanco', 'Encargado dos'),
	(15, 'Pegaso', 'Encargado dos'),
	(16, 'Siete Leguas', 'Encargado dos'),
	(17, 'Pony', 'Encargado tres'),
	(18, 'El peluca', 'Encargado tres'),
	(19, 'Fornite', 'Encargado tres')
;
insert into Carreras values 
	(20, 1, '2020-06-18', 'Carrera UNO', 'FINALIZADA', 11),
	(21, 2, '2020-06-18', 'Carrera DOS', 'FINALIZADA', 12),
	(22, 3, '2020-06-18', 'Carrera TRES', 'FINALIZADA', 12),
	(23, 1, '2020-06-19', 'Carrera UNOO', 'FINALIZADA', 13),
	(24, 2, '2020-06-19', 'Carrera DOOS', 'FINALIZADA', 13),
	(25, 3, '2020-06-19', 'Carrear TREES', 'FINALIZADA', 15)
;

insert into Jornadas values 
	(26, '2020-06-18', 4, null),
	(27, '2020-06-19', 4, null),
	(28, '2020-06-20', 4, null)
;

insert into JornadaCarrera values 
	(20, 26),
	(21, 26),
	(22, 26),
	(23, 28),
	(24, 29),
	(25, 30)
;

insert into JornadaHipodromo values
	(26,1),
	(27,1),
	(28,1)
;

insert into TiposApuestas values
	(44, 'SIMPLE'),
	(45, 'TRIPLE'),
	(46, 'CUADRUPLE')
;

insert into Participaciones values
	(29, 9, 1, 2, 20, 44),
	(30, 11, 2, 1.3, 20, 45), 
	(31, 12, 3, 1.5 ,20, 44),
	(32, 15, 4, 3, 20, 44),
	(33, 17, 5, 1.5, 20, 46), 
	(34, 14, 1, 2.2, 21, 46),
	(35, 12, 2, 3.4, 21, 46), 
	(36, 10, 3, 2.2, 21, 44),
	(37, 13, 4, 1.2, 21, 45),
	(38, 9, 5, 2.3, 21, 44) ,
	(39, 12, 1, 3.3, 22, 44),
	(40, 15, 2, 1.2, 22, 44),
	(41, 17, 3, 1.12, 22, 45),
	(42, 11, 4, 2.5, 22, 44),
	(43, 10, 5, 3.1, 22, 44)
;

insert into CarreraParticipaciones values 
	(29, 20), 
	(30, 20),
	(31, 20),
	(32, 20),
	(33, 20),
	(34, 21),
	(35, 21),
	(36, 21),
	(37, 21),
	(38, 21),
	(39, 22),
	(40, 22),
	(41, 22),
	(42, 22),
	(43, 22)
;


select c.object_id, c.numero, c.date, c.nombre, c.status, c.ganador, cp.participacion, ca.apuesta 
from Carreras c right join CarreraApuesta ca on c.object_id = ca.carrera 
right join CarreraParticipaciones cp on c.object_id = cp.carrera;

select c.object_id, c.numero, c.date, c.nombre, c.status, c.ganador, cp.participacion 
from Carreras c left join CarreraParticipaciones cp on c.object_id = cp.carrera;

