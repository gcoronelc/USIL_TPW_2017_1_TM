-- =============================================
-- Creación de la Base de Datos
-- =============================================

DROP DATABASE IF EXISTS SISTEMADAC;

CREATE DATABASE SISTEMADAC;


-- =============================================
-- Seleccionar la Base de Datos
-- =============================================

USE SISTEMADAC;

-- =============================================
-- CREACION DE TABLAS DE EMPLEADOS
-- =============================================

CREATE TABLE Empleado (
	chr_emplcodigo       CHAR(4) NOT NULL,
	vch_emplpaterno      VARCHAR(25) NOT NULL,
	vch_emplmaterno      VARCHAR(25) NOT NULL,
	vch_emplnombre       VARCHAR(30) NOT NULL,
	vch_emplciudad       VARCHAR(30) NOT NULL,
	vch_empldireccion    VARCHAR(50) NULL,
	CONSTRAINT PK_Empleado PRIMARY KEY (chr_emplcodigo)
) ENGINE = INNODB ;


CREATE TABLE Modulo
(
	int_moducodigo       INTEGER NOT NULL,
	vch_modunombre       VARCHAR(50) NULL,
	vch_moduestado       VARCHAR(15) NOT NULL 
						 DEFAULT 'ACTIVO' 
		                 CHECK ( vch_moduestado IN ('ACTIVO', 'ANULADO', 'CANCELADO') ),
	CONSTRAINT PK_Modulo PRIMARY KEY (int_moducodigo)
) ENGINE = INNODB ;


CREATE TABLE Usuario
(
	chr_emplcodigo       CHAR(4) NOT NULL,
	vch_emplusuario      VARCHAR(20) NOT NULL,
	vch_emplclave        VARCHAR(50) NOT NULL,
	CONSTRAINT PK_Usuario PRIMARY KEY (chr_emplcodigo),
	CONSTRAINT U_Usuario_vch_emplusuario UNIQUE (vch_emplusuario),
	FOREIGN KEY FK_Usuario_Empleado (chr_emplcodigo) REFERENCES Empleado (chr_emplcodigo)
) ENGINE = INNODB ;


CREATE TABLE Permiso
(
	chr_emplcodigo       CHAR(4) NOT NULL,
	int_moducodigo       INTEGER NOT NULL,
	vch_permestado       VARCHAR(15) NOT NULL 
	                     DEFAULT 'ACTIVO' 
						 CHECK ( vch_permestado IN ('ACTIVO', 'ANULADO', 'CANCELADO') ),
	CONSTRAINT PK_Permiso PRIMARY KEY (chr_emplcodigo,int_moducodigo),
	FOREIGN KEY FK_Permiso_Modulo (int_moducodigo) REFERENCES Modulo (int_moducodigo),
	FOREIGN KEY FK_Permiso_Usuario (chr_emplcodigo) REFERENCES Usuario (chr_emplcodigo)
) ENGINE = INNODB ;

CREATE TABLE Alumno (
	chr_alucodigo       CHAR(5) NOT NULL,
	vch_alupaterno      VARCHAR(25) NOT NULL,
	vch_alumaterno      VARCHAR(25) NOT NULL,
	vch_alunombre       VARCHAR(30) NOT NULL,
	chr_aludni          CHAR(8) NOT NULL,
	vch_aluciudad       VARCHAR(30) NOT NULL,
	vch_aludireccion    VARCHAR(50) NOT NULL,
	vch_alutelefono     VARCHAR(20) NULL,
	vch_aluemail        VARCHAR(50) NULL,
	CONSTRAINT PK_Alumno 
		PRIMARY KEY (chr_alucodigo)
) ENGINE = INNODB ;


CREATE TABLE Grado (
	chr_grcodigo		CHAR(1)NOT NULL,
	vch_grdescripcion	VARCHAR(50)NOT NULL,
	CONSTRAINT PK_Grado
		PRIMARY KEY(chr_grcodigo)
) ENGINE = INNODB;



CREATE TABLE Seccion (
	chr_seccodigo		CHAR(2)NOT NULL,
	vch_secdescripcion	VARCHAR(50)NOT NULL,
	CONSTRAINT PK_Seccion
		PRIMARY KEY(chr_seccodigo)
) ENGINE = INNODB;


CREATE TABLE Matricula (
chr_matrcodigo 			char(5) NOT NULL,
chr_alucodigo       	CHAR(5) NOT NULL,
chr_grcodigo			CHAR(1)NOT NULL,
chr_seccodigo			CHAR(2)NOT NULL,
dtt_matrfecha			DATE NOT NULL,
CONSTRAINT PK_Matricula
	PRIMARY KEY(chr_matrcodigo),
FOREIGN KEY FK_Matricula_Alumno (chr_alucodigo) REFERENCES Alumno (chr_alucodigo),
FOREIGN KEY FK_Matricula_Grado (chr_grcodigo) REFERENCES Grado (chr_grcodigo),
FOREIGN KEY FK_Matricula_Seccion (chr_seccodigo) REFERENCES Seccion (chr_seccodigo)
)ENGINE = INNODB;


CREATE TABLE Pago_Matricula(
chr_pagocodigo			CHAR(3) NOT NULL,
chr_matrcodigo 			char(5) NOT NULL,
chr_alucodigo       	CHAR(5) NOT NULL,
dec_pagomonto 			DECIMAL(12,2) NOT NULL,
vch_pagodescripcion		VARCHAR(50) NULL,
CONSTRAINT PK_Pago_Matricula
	PRIMARY KEY(chr_pagocodigo),
FOREIGN KEY FK_Pago_Matricula_Alumno (chr_alucodigo) REFERENCES Alumno (chr_alucodigo),
FOREIGN KEY FK_Pago_Matricula_Matricula (chr_matrcodigo) REFERENCES Matricula (chr_matrcodigo)
) ENGINE =  INNODB;




CREATE TABLE Contador (
	vch_conttabla        VARCHAR(30) NOT NULL,
	int_contitem         INTEGER NOT NULL,
	int_contlongitud     INTEGER NOT NULL,
	CONSTRAINT PK_Contador 
		PRIMARY KEY (vch_conttabla)
) ENGINE = INNODB ;

-- =============================================
-- CREAR EL USUARIO
-- =============================================

USE MYSQL;
GRANT ALL PRIVILEGES ON *.* TO 'notas'@'%' IDENTIFIED BY 'admin' WITH GRANT OPTION;
FLUSH PRIVILEGES;
USE SISTEMADAC;

USE MYSQL;
GRANT ALL PRIVILEGES ON *.* TO 'notas'@'localhost' IDENTIFIED BY 'admin' WITH GRANT OPTION;
FLUSH PRIVILEGES;
USE SISTEMADAC;




-- =============================================
-- HABILITAR SALIDAS
-- =============================================

SELECT DATABASE();
SHOW TABLES;
