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


