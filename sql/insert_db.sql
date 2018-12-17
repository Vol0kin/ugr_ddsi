-- Creacion de sentencias SQL para insertar filas en las tablas

-- Insercion de empleados

INSERT INTO Empleado VALUES ('789345672', 'Juan Lopez Vidal', STR_TO_DATE('31/12/1981', '%d/%m/%Y'), '678453275', 'Calle Salmón, 103', 'casado', 'jlopezv@gmail.com', 'Ingenieria de lavado de platos', '1234567890123456789', '123456789023');
INSERT INTO Empleado VALUES ('712903756', 'Alberto Torres Díaz', STR_TO_DATE('24/07/1961', '%d/%m/%Y'), '687442132', 'Calle General Rivera, 36', 'casado', null, 'Hostelero', '5789347589374899879', '734503982098');
INSERT INTO Empleado VALUES ('742511613', 'Luis Amador Salvá', STR_TO_DATE('04/02/1973', '%d/%m/%Y'), '690235316', 'Avenida de la Consittución, 1', 'viudo', 'luama@yahoo.com', 'Cocinero Numero 1', '8391057483923109389', '918734910988');
INSERT INTO Empleado VALUES ('756713234', 'Alejandro Romero Sánchez', STR_TO_DATE('22/10/1982', '%d/%m/%Y'), '691093483', 'Calle María, 12', 'soltero', 'alejoro82@hotmail.com', 'FP Limpieza', '46513487951345997543', '784513987452');

-- Insercion de tareas
INSERT INTO Tarea VALUES('Limpiar platos');
INSERT INTO Tarea VALUES('Atender clientes');
INSERT INTO Tarea VALUES('Servir platos');
INSERT INTO Tarea VALUES('Cocinar');

-- Insercion de menus
INSERT INTO Menu VALUES('0001', 14.95, 'SI');
INSERT INTO Menu VALUES('0002', 9.95, 'SI');

-- Insercion de platos
INSERT INTO Plato VALUES('0001', 'Ensalada Cesar', 4.50, 'Cereales, Frutos secos, Mostaza, Huevos', 'SI');
INSERT INTO Plato VALUES('0002', 'Plato alpujareño', 5, 'Huevos', 'SI');
INSERT INTO Plato VALUES('0003', 'Macarrones con pomodorico', 9.50, 'Trigo, Gluten, Huevo', 'SI');
INSERT INTO Plato VALUES('0004', 'Pizza con piña', 10.99, 'Trigo, Gluten, Lacteos', 'SI');
