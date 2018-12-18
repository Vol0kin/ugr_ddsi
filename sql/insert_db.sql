-- Creacion de sentencias SQL para insertar filas en las tablas

-- Insercion de empleados

INSERT INTO Empleado VALUES ('78934567R', 'Juan Lopez Vidal', STR_TO_DATE('31/12/1981', '%d/%m/%Y'), '678453275', 'Calle Salmón, 103', 'casado', 'jlopezv@gmail.com', 'Ingenieria de lavado de platos', '1234567890123456789', '123456789023');
INSERT INTO Empleado VALUES ('71290356A', 'Alberto Torres Díaz', STR_TO_DATE('24/07/1961', '%d/%m/%Y'), '687442132', 'Calle General Rivera, 36', 'casado', null, 'Hostelero', '5789347589374899879', '734503982098');
INSERT INTO Empleado VALUES ('74251613F', 'Luis Amador Salvá', STR_TO_DATE('04/02/1973', '%d/%m/%Y'), '690235316', 'Avenida de la Consittución, 1', 'viudo', 'luama@yahoo.com', 'Cocinero Numero 1', '8391057483923109389', '918734910988');
INSERT INTO Empleado VALUES ('75613234Q', 'Alejandro Romero Sánchez', STR_TO_DATE('22/10/1982', '%d/%m/%Y'), '691093483', 'Calle María, 12', 'soltero', 'alejoro82@hotmail.com', 'FP Limpieza', '46513487951345997543', '784513987452');

-- Insercion de tareas
INSERT INTO Tarea VALUES('Limpiar platos');
INSERT INTO Tarea VALUES('Atender clientes');
INSERT INTO Tarea VALUES('Servir platos');
INSERT INTO Tarea VALUES('Cocinar');
INSERT INTO Tarea VALUES('Limpiar');

-- Insercion de menus
INSERT INTO Menu VALUES('0001', 14.95, 'SI');
INSERT INTO Menu VALUES('0002', 9.95, 'SI');
INSERT INTO Menu VALUES('0003', 12.95, 'SI');

-- Insercion de platos
INSERT INTO Plato VALUES('0001', 'Ensalada Cesar', 4.50, 'Cereales, Frutos secos, Mostaza, Huevos', 'SI');
INSERT INTO Plato VALUES('0002', 'Plato alpujareño', 5, 'Huevos', 'SI');
INSERT INTO Plato VALUES('0003', 'Macarrones con pomodorico', 9.50, 'Trigo, Gluten, Huevo', 'SI');
INSERT INTO Plato VALUES('0004', 'Pizza con piña', 10.99, 'Trigo, Gluten, Lacteos', 'SI');
INSERT INTO Plato VALUES('0005', 'Espaguetis salsa bolonesa', 14.99, 'Gluten, Trigo, Apio', 'SI');

-- Insercion de proveedores
INSERT INTO Proveedor VALUES('74826341P', 'Rodrigo Pérez Santos', '687452123', 'ropesa@gmail.com', 'Alimentos Frescos SA', 'E7844861D', 'Verdura', 32);
INSERT INTO Proveedor VALUES('74236412V', 'Pablo Escobar Ramírez', '621788421', 'pabloescobra78@gmail.com', 'Carnes Felices', 'Q7845136G', 'Carne', 47);
INSERT INTO Proveedor VALUES('79345690L', 'Carmen de la Torre Guerrero', '695221476', 'carmenprovee@gmail.com', 'Pasta para ti', 'M7435681J', 'Pasta', 29);

-- Insercion de ingredientes
INSERT INTO Ingrediente VALUES('00001', 'Carne', 'Carne picada', 499);
INSERT INTO Ingrediente VALUES('00002', 'Pasta', 'Macarones', 321);
INSERT INTO Ingrediente VALUES('00003', 'Pasta', 'Espaguetis', 450);
INSERT INTO Ingrediente VALUES('00004', 'Verdura', 'Tomate', 239);

-- Insercion de menu contiene plato
INSERT INTO menu_contiene_plato VALUES('0001', '0001');
INSERT INTO menu_contiene_plato VALUES('0001', '0002');
INSERT INTO menu_contiene_plato VALUES('0002', '0001');
INSERT INTO menu_contiene_plato VALUES('0002', '0004');

-- Insercion plato contiene ingrediente
INSERT INTO plato_contiene_ing VALUES('0001', '00004');
INSERT INTO plato_contiene_ing VALUES('0003', '00002');
INSERT INTO plato_contiene_ing VALUES('0003', '00004');
INSERT INTO plato_contiene_ing VALUES('0005', '00003');
INSERT INTO plato_contiene_ing VALUES('0005', '00001');

-- Insercion provee
INSERT INTO provee VALUES('74826341P', '00004');
INSERT INTO provee VALUES('74236412V', '00001');
INSERT INTO provee VALUES('79345690L', '00002');
INSERT INTO provee VALUES('79345690L', '00003');

-- Insercion asignacion
INSERT INTO asignacion VALUES('78934567R', 'Limpiar platos');
INSERT INTO asignacion VALUES('71290356A', 'Atender clientes');
INSERT INTO asignacion VALUES('71290356A', 'Servir platos');
INSERT INTO asignacion VALUES('74251613F', 'Cocinar');
INSERT INTO asignacion VALUES('75613234Q', 'Limpiar');
