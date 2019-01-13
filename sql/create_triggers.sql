USE pomodoro;

-- Gestión de Empleados

DROP TRIGGER IF EXISTS eliminar_emp;

DELIMITER |
CREATE TRIGGER eliminar_emp BEFORE DELETE ON Empleado
	FOR EACH ROW
	BEGIN
		DELETE FROM asignacion WHERE asignacion.dni_emp = OLD.dni_emp;
	END;
	|
DELIMITER ;

-- Gestión de Menús

DROP TRIGGER IF EXISTS eliminar_plato;

DELIMITER |
CREATE TRIGGER eliminar_plato BEFORE DELETE ON Plato
FOR EACH ROW
BEGIN
	DELETE FROM menu_contiene_plato WHERE menu_contiene_plato.cod_plato = OLD.cod_plato;
END;
|
DELIMITER ;

-- Gestión de Proveedores

DROP TRIGGER IF EXISTS disp_proveedores;

DELIMITER |
CREATE TRIGGER disp_proveedores
BEFORE INSERT ON Proveedor FOR EACH ROW
BEGIN
	IF NEW.edad < 18 THEN
		SIGNAL SQLSTATE '55555'
		SET MESSAGE_TEXT = 'Error en la edad del proveedor. No puede ser menor que 18';
	END IF;
END;
|
DELIMITER ;


-- Triggers nuevos para la implementacion del Subsistema

DROP TRIGGER IF EXISTS empleado_estadocivil;

DELIMITER |
CREATE TRIGGER empleado_estadocivil BEFORE INSERT ON Empleado
FOR EACH ROW
	BEGIN
		IF NEW.estadocivil <> 'soltero' AND NEW.estadocivil <> 'casado' AND NEW.estadocivil <> 'divorciado' AND NEW.estadocivil <> 'viudo' THEN
			SIGNAL SQLSTATE '55556'
			SET MESSAGE_TEXT = 'Error en el estado civil del empleado.';
		END IF;
	END;
	|
DELIMITER ;

DROP TRIGGER IF EXISTS menu_insertar;

DELIMITER |
CREATE TRIGGER menu_insertar BEFORE INSERT ON Menu
FOR EACH ROW
	BEGIN
		IF NEW.precio < 0 THEN
			SIGNAL SQLSTATE '55557'
			SET MESSAGE_TEXT = 'Error en el precio del menu.';
		END IF;

		IF NEW.disponibilidad <> 'SI' AND NEW.disponibilidad <> 'NO' THEN
			SIGNAL SQLSTATE '55558'
			SET MESSAGE_TEXT = 'Error en la disponibilidad del menu.';
		END IF;
	END;
	|
DELIMITER ;

DROP TRIGGER IF EXISTS plato_insertar;

DELIMITER |
CREATE TRIGGER plato_insertar BEFORE INSERT ON Plato
FOR EACH ROW
	BEGIN
		IF NEW.precio < 0 THEN
			SIGNAL SQLSTATE '55559'
			SET MESSAGE_TEXT = 'Error en el precio del plato.';
		END IF;

		IF NEW.disponibilidad <> 'SI' AND NEW.disponibilidad <> 'NO' THEN
			SIGNAL SQLSTATE '55560'
			SET MESSAGE_TEXT = 'Error en la disponibilidad del plato.';
		END IF;
	END;
	|
DELIMITER ;

DROP TRIGGER IF EXISTS ingrediente_insertar;

DELIMITER |
CREATE TRIGGER ingrediente_insertar BEFORE INSERT ON Ingrediente
FOR EACH ROW
	BEGIN
		IF NEW.cantidad < 1 OR NEW.cantidad > 500 THEN
			SIGNAL SQLSTATE '55561'
			SET MESSAGE_TEXT = 'Error en la cantidad de ingredientes.';
		END IF;
	END;
	|
DELIMITER ;


DROP TRIGGER IF EXISTS menu_actualizar_disp;

DELIMITER |
CREATE TRIGGER menu_actualizar_disp AFTER UPDATE ON Menu
FOR EACH ROW
	BEGIN
		IF OLD.disponibilidad = 'SI' AND NEW.disponibilidad = 'NO' THEN
			DELETE FROM menu_contiene_plato WHERE id_menu = NEW.id_menu;
		END IF;
	END;
	|
DELIMITER ;


DROP TRIGGER IF EXISTS plato_actualizar_disp;

DELIMITER |
CREATE TRIGGER plato_actualizar_disp AFTER UPDATE ON Plato
FOR EACH ROW
	BEGIN
		IF OLD.disponibilidad = 'SI' AND NEW.disponibilidad = 'NO' THEN
			DELETE FROM menu_contiene_plato WHERE cod_plato = NEW.cod_plato;
		END IF;
	END;
	|
DELIMITER ;
