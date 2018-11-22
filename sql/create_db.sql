-- Poner las tablas correspondientes a entidades aqui

-- Subsistema Gestion de Empleados

-- Subsistema Gestion de Menus

CREATE TABLE Menu (
	id_menu VARCHAR(4) PRIMARY KEY,
	precio NUMBER(5,2) CONSTRAINT precio_no_nulo NOT NULL CONSTRAINT precio_mayor_igual_0 CHECK (precio >= 0),
	disponibilidad VARCHAR(2) CONSTRAINT disponibilidad_no_nula NOT NULL
							  CONSTRAINT disponibilidad_si_no CHECK (disponibilidad IN ('SI', 'NO'))
);

CREATE TABLE Plato (
	cod_plato VARCHAR(4) PRIMARY KEY,
	nombre VARCHAR(25) CONSTRAINT nombre_no_nulo NOT NULL,
	precio NUMBER(5,2) CONSTRAINT precio_no_nulo NOT NULL CONSTRAINT precio_mayor_igual_0 CHECK (precio >= 0),
	productos_alergenos VARCHAR(50) CONSTRAINT alergenos_no_nulo NOT NULL,
	disponibilidad VARCHAR(2) CONSTRAINT disponibilidad_no_nula NOT NULL
							  CONSTRAINT disponibilidad_si_no CHECK (disponibilidad IN ('SI', 'NO'))
);

-- Subsistema Gestion de Proveedores

CREATE TABLE Proveedor(
dni varchar(9), nombre_apellidos varchar(60) CONSTRAINT nombre_no_nulo NOT NULL, 
telefono varchar(20) CONSTRAINT telefono_no_nulo NOT NULL, 
correo varchar(60), nombre_empresa varchar(60) CONSTRAINT empresa_no_nula NOT NULL, 
nif_empresa varchar(9) CONSTRAINT nif_empresa_no_nulo NOT NULL,
tipo_producto varchar(20) CONSTRAINT tipo_producto_no_nulo NOT NULL,
PRIMARY KEY(dni));


CREATE TABLE Ingrediente(
cod_ing int(5), tipo varchar(20) CONSTRAINT tipo_ingrediente_no_nulo NOT NULL, 
nombre varchar(25) CONSTRAINT nombre_ingrediente_no_nulo NOT NULL, 
cantidad integer(3) CONSTRAINT cantidad_mayor_a_1 NOT NULL,
PRIMARY KEY(cod_ing),
CHECK(1 <= cantidad <= 500));

----------------------------------------------------------------------------------------------------------------

-- Poner las tablas correspondientes a relaciones aqui

CREATE TABLE menu_contiene_plato (
	id_menu VARCHAR(4),
	cod_plato VARCHAR(4),
	PRIMARY KEY(id_menu, cod_plato),
	FOREIGN KEY(id_menu, cod_plato)
	REFERENCES Menu(id_menu), Plato(cod_plato)
);

CREATE TABLE plato_contiene_ing (
	cod_plato VARCHAR(4),
	cod_ing INTEGER,
	PRIMARY KEY(cod_plato, cod_ing),
	FOREIGN KEY(cod_plato, cod_ing)
	REFERENCES Plato(cod_plato), Ingrediente(cod_ing)
);

CREATE TABLE provee(
dni_prov varchar(9), cod_ing int(5),
PRIMARY KEY(dni_prov, cod_ing)
FOREIGN KEY(dni_prov, cod_ing)
REFERENCES Proveedor(dni_prov), Ingredientes(cod_ing));
