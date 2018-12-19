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

    public void aniadirEmpleado(PomodoroGUI pomGUI) {
        String db = "";
        try {
            db = pomDB.insertarTabla("Empleado");
            JOptionPane.showMessageDialog(pomGUI, db);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(pomGUI, "Error al añadir un empleado");
        }
    }
    
    public void eliminarEmpleado(PomodoroGUI pomGUI) {
        String db = "";
        try {
            db = pomDB.eliminarTabla("Empleado");
            JOptionPane.showMessageDialog(pomGUI, db);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(pomGUI, "Error al eliminar un empleado");
        }
    }
    
    public void modificarEmpleado(PomodoroGUI pomGUI) {
        String db = "";
        try {
            db = pomDB.modificarTabla("Empleado");
            JOptionPane.showMessageDialog(pomGUI, db);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(pomGUI, "Error al modificar un empleado");
        }
    }
    
    
    public void aniadirTarea(PomodoroGUI pomGUI) {
        String db = "";
        try {
            db = pomDB.insertarTabla("Tarea");
            JOptionPane.showMessageDialog(pomGUI, db);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(pomGUI, "Error al añadir una tarea");
        }
    }
    
    public void eliminarTarea(PomodoroGUI pomGUI) {
        String db = "";
        try {
            db = pomDB.eliminarTabla("Tarea");
            JOptionPane.showMessageDialog(pomGUI, db);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(pomGUI, "Error al eliminar una tarea");
        }
    }
    
    
    public void asignarEmpleadoTarea() throws SQLException{
        String valores = "", salida = "", menu = "";
        
        ArrayList<String> menusList = new ArrayList();
        rs=stmt.executeQuery("select nom_ta from Tarea");
        while ( rs.next() ){
            menusList.add( rs.getString(1) );
        }
        String[] menus = new String[menusList.size()];
        menus = menusList.toArray(menus);
        menu = (String) JOptionPane.showInputDialog(null,"Selecciona una Tarea", "Tarea",
                                            JOptionPane.QUESTION_MESSAGE,null,menus, menus[0]);
        
        ArrayList<String> platos = new ArrayList();
        rs=stmt.executeQuery("select dni_emp from Empleado and dni_emp not in "
                           + "(select dni_emp from asignacion where nom_ta = '"+menu+"')");
        while ( rs.next() ){
            platos.add( rs.getString(1) );
        }
        
        Asignaciones asig = new Asignaciones(platos, menu, stmt, 4);
    }
  
}
