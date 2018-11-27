-- Subsistema Gestion de Empleados

CREATE TABLE Empleado (
	dni_emp VARCHAR(9) PRIMARY KEY,
	nombre_apellidos VARCHAR(60) NOT NULL,
	fecha_nac DATE NOT NULL,
	telefono VARCHAR(20) NOT NULL,
	direccion VARCHAR(120) NOT NULL,
	estadocivil VARCHAR(10) NOT NULL
		CHECK (estadocivil IN ('soltero', 'casado', 'divorciado', 'viudo')),
	correo VARCHAR(60),
	formacion VARCHAR(200) NOT NULL,
	cuenta_bancaria VARCHAR(20) NOT NULL,
	ss VARCHAR(12) NOT NULL
);

CREATE TABLE Tarea(
	nom_ta VARCHAR(50) PRIMARY KEY
);

-- Subsistema Gestion de Menus

CREATE TABLE Menu (
	id_menu VARCHAR(4) PRIMARY KEY,
	precio FLOAT(5,2) NOT NULL CHECK (precio >= 0),
	disponibilidad VARCHAR(2) NOT NULL CHECK (disponibilidad IN ('SI', 'NO'))
);

CREATE TABLE Plato (
	cod_plato VARCHAR(4) PRIMARY KEY,
	nombre VARCHAR(25) NOT NULL,
	precio FLOAT(5,2) NOT NULL CHECK (precio >= 0),
	productos_alergenos VARCHAR(50) NOT NULL,
	disponibilidad VARCHAR(2) NOT NULL CHECK (disponibilidad IN ('SI', 'NO'))
);

-- Subsistema Gestion de Proveedores

CREATE TABLE Proveedor(
	dni varchar(9) PRIMARY KEY,
	nombre_apellidos varchar(60) NOT NULL,
	telefono varchar(20) NOT NULL,
	correo varchar(60),
	nombre_empresa varchar(60) NOT NULL,
	nif_empresa varchar(9) NOT NULL,
	tipo_producto varchar(20) NOT NULL,
	edad INT NOT NULL
);


CREATE TABLE Ingrediente(
	cod_ing varchar(5) PRIMARY KEY,
	tipo varchar(20) NOT NULL,
	nombre varchar(25) NOT NULL,
	cantidad integer(3) NOT NULL CHECK(1 <= cantidad <= 500)
);

-- --------------------------------------------------------------------------------------------------------------

CREATE TABLE menu_contiene_plato (
	id_menu VARCHAR(4) REFERENCES Menu(id_menu),
	cod_plato VARCHAR(4) REFERENCES Plato(cod_plato),
	PRIMARY KEY(id_menu, cod_plato)
);

CREATE TABLE plato_contiene_ing (
	cod_plato VARCHAR(4) REFERENCES Plato(cod_plato),
	cod_ing varchar(5) REFERENCES Ingrediente(cod_ing),
	PRIMARY KEY(cod_plato, cod_ing)
);

CREATE TABLE provee(
	dni_prov varchar(9) REFERENCES Proveedor(dni_prov),
	cod_ing varchar(5) REFERENCES Ingrediente(cod_ing),
	PRIMARY KEY(dni_prov, cod_ing)
);

CREATE TABLE asignacion(
	dni_emp VARCHAR(9) REFERENCES Empleado(dni_emp),
	nom_ta VARCHAR(50) REFERENCES Tarea(nom_ta),
	PRIMARY KEY (dni_emp, nom_ta)
);
