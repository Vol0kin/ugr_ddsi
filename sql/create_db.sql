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
