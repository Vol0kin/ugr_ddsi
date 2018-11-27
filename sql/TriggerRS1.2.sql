USE pomodoro

-- Gestión de Empleados

DELIMITER |
CREATE TRIGGER eliminar_emp BEFORE DELETE ON Empleado
	FOR EACH ROW
	BEGIN
		DELETE FROM asignacion WHERE asignacion.dni_emp = OLD.dni_emp;
	END
	|
DELIMITER ;

-- Gestión de Menús

-- Gestión de Proveedores

DELIMITER |

CREATE TRIGGER disp_proveedores 
BEFORE INSERT ON Proveedor
BEGIN
	IF NEW.edad < 18 THEN
		SIGNAL SQLSTATE '55555'
		SET MESSAGE_TEXT = 'Error en la edad del proveedor. No puede ser menor que 18';

	ELSE
		INSERT NEW INTO Proveedor;
	END IF;
END;

|

DELIMITER ;


