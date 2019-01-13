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
public class GestionMenu {

    private Statement stmt;
    private ResultSet rs;
    private int resultadoConsulta;

    public GestionMenu(Statement stmt, ResultSet rs) {
        this.stmt = stmt;
        this.rs = rs;
    }

    public void insertarPlato(PomodoroGUI pomGUI) {
        String consulta;
        try {
            consulta = pomDB.insertarTabla("Plato");
            JOptionPane.showMessageDialog(pomGUI, consulta);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(pomGUI, "Error al añadir el plato");
        }
    }
    
    public void eliminarPlato(PomodoroGUI pomGUI) {
        String consulta;
        
        try {
            consulta = pomDB.eliminarTabla("Plato");
            JOptionPane.showMessageDialog(pomGUI, consulta);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(pomGUI, "Error al eliminar el plato");
        }
    }
    
    public void modificarPlato(PomodoroGUI pomGUI) {
        String consulta;
        
        try {
            consulta = pomDB.modificarTabla("Plato");
            JOptionPane.showMessageDialog(pomGUI, consulta);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(pomGUI, "Error al modificar el plato");
        }
    }
    
    public void insertarMenu(PomodoroGUI pomGUI) {
        String consulta;
        
        try {
            consulta = pomDB.insertarTabla("Menu");
            JOptionPane.showMessageDialog(pomGUI, consulta);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(pomGUI, "Error al insertar el menu");
        }
    }
    
    public void eliminarMenu(PomodoroGUI pomGUI) {
        String consulta;
        
        try {
            consulta = pomDB.eliminarTabla("Menu");
            JOptionPane.showMessageDialog(pomGUI, consulta);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(pomGUI, "Error al eliminar el menu");
        }
    }
    
    public void modificarMenu(PomodoroGUI pomGUI) {
        String consulta;
        
        try {
            consulta = pomDB.modificarTabla("Menu");
            JOptionPane.showMessageDialog(pomGUI, consulta);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(pomGUI, "Error al modificar el menu");
        }
    }
    
    public void asignarPlatosMenu() throws SQLException{
        String valores = "", salida = "", menu = "";
        
        ArrayList<String> menusList = new ArrayList();
        rs=stmt.executeQuery("select id_menu from Menu where disponibilidad = 'SI'");
        while ( rs.next() ){
            menusList.add( rs.getString(1) );
        }
        String[] menus = new String[menusList.size()];
        menus = menusList.toArray(menus);
        menu = (String) JOptionPane.showInputDialog(null,"Selecciona un menú", "Menús",
                                            JOptionPane.QUESTION_MESSAGE,null,menus, menus[0]);
        
        if (menu == null) {
            return;
        }
        
        ArrayList<String> platos = new ArrayList();
        rs=stmt.executeQuery("select cod_plato from Plato where disponibilidad = 'SI' and cod_plato not in "
                           + "(select cod_plato from menu_contiene_plato where id_menu = '"+menu+"')");
        while ( rs.next() ){
            platos.add( rs.getString(1) );
        }
        
        Asignaciones asig = new Asignaciones(platos, menu, stmt, 1);
    }
    
    public void desasignarPlatosMenu() throws SQLException{
        String valores = "", salida = "", menu = "";
        
        ArrayList<String> menusList = new ArrayList();
        rs=stmt.executeQuery("select id_menu from Menu where disponibilidad = 'SI'");
        while ( rs.next() ){
            menusList.add( rs.getString(1) );
        }
        String[] menus = new String[menusList.size()];
        menus = menusList.toArray(menus);
        menu = (String) JOptionPane.showInputDialog(null,"Selecciona un menú", "Menús",
                                            JOptionPane.QUESTION_MESSAGE,null,menus, menus[0]);
        
        if (menu == null) {
            return;
        }
        
        ArrayList<String> platos = new ArrayList();
        rs=stmt.executeQuery("select cod_plato from Plato where disponibilidad = 'SI' and cod_plato in "
                           + "(select cod_plato from menu_contiene_plato where id_menu = '"+menu+"')");
        while ( rs.next() ){
            platos.add( rs.getString(1) );
        }
        
        Asignaciones asig = new Asignaciones(platos, menu, stmt, 6);
    }
    
    public void asignarIngredientePlato() throws SQLException{
        String valores = "", salida = "", plato = "";
        
        ArrayList<String> platosList = new ArrayList();
        rs=stmt.executeQuery("select cod_plato from Plato");
        while ( rs.next() ){
            platosList.add( rs.getString(1) );
        }
        String[] platos = new String[platosList.size()];
        platos = platosList.toArray(platos);
        plato = (String) JOptionPane.showInputDialog(null,"Selecciona un plato", "Platos",
                                            JOptionPane.QUESTION_MESSAGE,null,platos, platos[0]);
        
        if (plato == null) {
            return;
        }
        
        ArrayList<String> ing = new ArrayList();
        rs=stmt.executeQuery("select cod_ing from Ingrediente where cod_ing not in "
                           + "(select cod_ing from plato_contiene_ing where cod_plato = '"+plato+"')");
        while ( rs.next() ){
            ing.add( rs.getString(1) );
        }
        
        Asignaciones pci = new Asignaciones(ing, plato, stmt, 2);
        pci.setVisible(true);
    }
    
    public void desasignarIngredientesPlato() throws SQLException{
        String valores = "", salida = "", plato = "";
        
        ArrayList<String> platosList = new ArrayList();
        rs=stmt.executeQuery("select cod_plato from Plato");
        while ( rs.next() ){
            platosList.add( rs.getString(1) );
        }
        String[] platos = new String[platosList.size()];
        platos = platosList.toArray(platos);
        plato = (String) JOptionPane.showInputDialog(null,"Selecciona un plato", "Platos",
                                            JOptionPane.QUESTION_MESSAGE,null,platos, platos[0]);
        
        if (plato == null) {
            return;
        }
        
        ArrayList<String> ing = new ArrayList();
        rs=stmt.executeQuery("select cod_ing from Ingrediente where cod_ing in "
                           + "(select cod_ing from plato_contiene_ing where cod_plato = '"+plato+"')");
        while ( rs.next() ){
            ing.add( rs.getString(1) );
        }
        
        Asignaciones pci = new Asignaciones(ing, plato, stmt, 7);
        pci.setVisible(true);
    }
    
    
    
}
