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


