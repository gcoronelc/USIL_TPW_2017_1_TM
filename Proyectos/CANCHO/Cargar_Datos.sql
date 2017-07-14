USE SISTEMADAC;
set names utf8;

-- Tabla: Empleado

INSERT INTO empleado VALUES( '9999', 'Internet', 'Internet', 'internet', 'Internet', 'internet' );
INSERT INTO empleado VALUES( '0001', 'Tafur', 'Huingo', 'David K.', 'Lima', 'Av.Santuario 1851' );
INSERT INTO empleado VALUES( '0002', 'Castro', 'Vargas', 'Lidia', 'Lima', 'Federico Villarreal 456 - SMP' );
INSERT INTO empleado VALUES( '0003', 'Reyes', 'Ortiz', 'Claudia', 'Lima', 'Av. Aviación 3456 - San Borja' );


-- Tabla: Usuario

INSERT INTO usuario VALUES( '9999',  'internet',     SHA('internet') );
INSERT INTO usuario VALUES( '0001',  'admin',      	 SHA('admin') );
INSERT INTO usuario VALUES( '0002',  'lcastro',      SHA('flaca') );
INSERT INTO usuario VALUES( '0003',  'creyes',       SHA('linda') );

-- Tabla: Modulo

INSERT INTO Modulo VALUES( 1, 'Procesos', 'ACTIVO');
INSERT INTO Modulo VALUES( 2, 'Tablas', 'ACTIVO');
INSERT INTO Modulo VALUES( 3, 'Consultas', 'ACTIVO');
INSERT INTO Modulo VALUES( 4, 'Reportes', 'ACTIVO');
INSERT INTO Modulo VALUES( 5, 'Util', 'ACTIVO');
INSERT INTO Modulo VALUES( 6, 'Seguridad', 'ACTIVO');

-- Tabla: Permiso

-- Usuario: 0001
INSERT INTO Permiso VALUES( '0001', 1, 'ACTIVO');
INSERT INTO Permiso VALUES( '0001', 2, 'ACTIVO');
INSERT INTO Permiso VALUES( '0001', 3, 'ACTIVO');
INSERT INTO Permiso VALUES( '0001', 4, 'ACTIVO');
INSERT INTO Permiso VALUES( '0001', 5, 'ACTIVO');
INSERT INTO Permiso VALUES( '0001', 6, 'ACTIVO');

-- Usuario: 0002
INSERT INTO Permiso VALUES( '0002', 1, 'ACTIVO');
INSERT INTO Permiso VALUES( '0002', 2, 'ACTIVO');
INSERT INTO Permiso VALUES( '0002', 3, 'ACTIVO');
INSERT INTO Permiso VALUES( '0002', 4, 'ACTIVO');
INSERT INTO Permiso VALUES( '0002', 5, 'CANCELADO');
INSERT INTO Permiso VALUES( '0002', 6, 'CANCELADO');

-- Usuario: 0003
INSERT INTO Permiso VALUES( '0003', 1, 'ACTIVO');
INSERT INTO Permiso VALUES( '0003', 2, 'CANCELADO');
INSERT INTO Permiso VALUES( '0003', 3, 'ACTIVO');
INSERT INTO Permiso VALUES( '0003', 4, 'ACTIVO');
INSERT INTO Permiso VALUES( '0003', 5, 'ACTIVO');
INSERT INTO Permiso VALUES( '0003', 6, 'CANCELADO');

-- Tabla: Alumno

insert into Alumno values( '00001', 'CORONEL', 'CASTILLO', 'ERIC GUSTAVO', '06914897', 'LIMA', 'LOS OLIVOS', '9666-4457', 'gcoronel@viabcp.com' );
insert into Alumno values( '00002', 'VALENCIA', 'MORALES', 'PEDRO HUGO', '01576173', 'LIMA', 'MAGDALENA', '924-7834', 'pvalencia@terra.com.pe' );
insert into Alumno values( '00003', 'MARCELO', 'VILLALOBOS', 'RICARDO', '10762367', 'LIMA', 'LINCE', '993-62966', 'ricardomarcelo@hotmail.com' );
insert into Alumno values( '00004', 'ROMERO', 'CASTILLO', 'CARLOS ALBERTO', '06531983', 'LIMA', 'LOS OLIVOS', '865-84762', 'c.romero@hotmail.com' );
insert into Alumno values( '00005', 'ARANDA', 'LUNA', 'ALAN ALBERTO', '10875611', 'LIMA', 'SAN ISIDRO', '834-67125', 'a.aranda@hotmail.com' );
insert into Alumno values( '00006', 'AYALA', 'PAZ', 'JORGE LUIS', '10679245', 'LIMA', 'SAN BORJA', '963-34769', 'j.ayala@yahoo.com' );
insert into Alumno values( '00007', 'CHAVEZ', 'CANALES', 'EDGAR RAFAEL', '10145693', 'LIMA', 'MIRAFLORES', '999-96673', 'e.chavez@gmail.com' );
insert into Alumno values( '00008', 'FLORES', 'CHAFLOQUE', 'ROSA LIZET', '10773456', 'LIMA', 'LA MOLINA', '966-87567', 'r.florez@hotmail.com' );
insert into Alumno values( '00009', 'FLORES', 'CASTILLO', 'CRISTIAN RAFAEL', '10346723', 'LIMA', 'LOS OLIVOS', '978-43768', 'c.flores@hotmail.com' );
insert into Alumno values( '00010', 'GONZALES', 'GARCIA', 'GABRIEL ALEJANDRO', '10192376', 'LIMA', 'SAN MIGUEL', '945-56782', 'g.gonzales@yahoo.es' );

-- Tabla: Grado

insert into Grado values( '1', 'Primer Grado');
insert into Grado values( '2', 'Segundo Grado');
insert into Grado values( '3', 'Tercer Grado');
insert into Grado values( '4', 'Cuarto Grado');
insert into Grado values( '5', 'Quinto Grado');
insert into Grado values( '6', 'Sexto Grado');

-- Tabla: Secciones

insert into Seccion Values( '01', 'A');
insert into Seccion Values( '02', 'B');
insert into Seccion Values( '03', 'C');
insert into Seccion Values( '04', 'D');

-- Tabla: Matricula

insert into Matricula values('00001','00002','3','01','20170702');
insert into Matricula values('00002','00003','4','01','20170702');
insert into Matricula values('00003','00004','3','01','20170702');

-- Tabla Pagos

insert into Pago_Matricula values('001','00002','00002','300.00','Cancelado');




--Tabla Contador

INSERT INTO CONTADOR VALUES('Empleado',4,4);
INSERT INTO CONTADOR VALUES('Alumno',10,5);
INSERT INTO CONTADOR VALUES('Seccion',4,2);
INSERT INTO CONTADOR VALUES('Matricula',5,3)

