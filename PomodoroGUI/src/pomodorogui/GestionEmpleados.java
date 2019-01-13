/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pomodorogui;

import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import static pomodorogui.PomodoroGUI.pomDB;

/**
 *
 * @author vladislav
 */
public class GestionEmpleados {

    private Statement stmt;
    private ResultSet rs;
    private int resultadoConsulta;

    public GestionEmpleados(Statement stmt, ResultSet rs) {
        this.stmt = stmt;
        this.rs = rs;
    }

    
    public void insertarEmpleado(PomodoroGUI pomGUI) {
        String consulta;
        try {
            consulta = pomDB.insertarTabla("Empleado");
            JOptionPane.showMessageDialog(pomGUI, consulta);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(pomGUI, "Error al añadir un empleado");
        }
    }
    
    public void eliminarEmpleado(PomodoroGUI pomGUI) {
        String consulta;
        try {
            consulta = pomDB.eliminarTabla("Empleado");
            JOptionPane.showMessageDialog(pomGUI, consulta);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(pomGUI, "Error al eliminar un empleado");
        }
    }
    
    public void modificarEmpleado(PomodoroGUI pomGUI) {
        String consulta;
        try {
            consulta = pomDB.modificarTabla("Empleado");
            JOptionPane.showMessageDialog(pomGUI, consulta);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(pomGUI, "Error al modificar un empleado");
        }
    }
    
    
    public void insertarTarea(PomodoroGUI pomGUI) {
        String consulta;
        try {
            consulta = pomDB.insertarTabla("Tarea");
            JOptionPane.showMessageDialog(pomGUI, consulta);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(pomGUI, "Error al añadir una tarea");
        }
    }
    
    public void eliminarTarea(PomodoroGUI pomGUI) {
        String consulta;
        try {
            consulta = pomDB.eliminarTabla("Tarea");
            JOptionPane.showMessageDialog(pomGUI, consulta);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(pomGUI, "Error al eliminar una tarea");
        }
    }
    
    
    public void asignarEmpleadoTarea() throws SQLException{
        String valores = "", salida = "", tarea = "";
        
        ArrayList<String> tareasList = new ArrayList();
        rs=stmt.executeQuery("select nom_ta from Tarea");
        while ( rs.next() ){
            tareasList.add( rs.getString(1) );
        }
        String[] tareas = new String[tareasList.size()];
        tareas = tareasList.toArray(tareas);
        tarea = (String) JOptionPane.showInputDialog(null,"Selecciona una Tarea", "Tarea",
                                            JOptionPane.QUESTION_MESSAGE,null,tareas, tareas[0]);
        
        ArrayList<String> empleados = new ArrayList();
        rs=stmt.executeQuery("select dni_emp from Empleado where dni_emp not in "
                           + "(select dni_emp from asignacion where nom_ta = '"+tarea+"')");
        while ( rs.next() ){
            empleados.add( rs.getString(1) );
        }
        
        Asignaciones asig = new Asignaciones(empleados, tarea, stmt, 4);
    }
     
    public void desasignarEmpleadoTarea() throws SQLException{
        String valores = "", salida = "", tarea = "";
        
        ArrayList<String> tareasList = new ArrayList();
        rs=stmt.executeQuery("select nom_ta from Tarea");
        while ( rs.next() ){
            tareasList.add( rs.getString(1) );
        }
        String[] tareas = new String[tareasList.size()];
        tareas = tareasList.toArray(tareas);
        tarea = (String) JOptionPane.showInputDialog(null,"Selecciona una Tarea", "Tarea",
                                            JOptionPane.QUESTION_MESSAGE,null,tareas, tareas[0]);
        
        ArrayList<String> empleados = new ArrayList();
        rs=stmt.executeQuery("select dni_emp from Empleado where dni_emp in "
                           + "(select dni_emp from asignacion where nom_ta = '"+tarea+"')");
        while ( rs.next() ){
            empleados.add( rs.getString(1) );
        }
        
        Asignaciones asig = new Asignaciones(empleados, tarea, stmt, 5);
    }
  
}
