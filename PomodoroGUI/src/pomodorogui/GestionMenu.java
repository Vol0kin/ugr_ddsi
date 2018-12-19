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

    public void aniadirPlato(PomodoroGUI pomGUI) {
        String db = "";
        try {
            db = pomDB.insertarTabla("Plato");
            JOptionPane.showMessageDialog(pomGUI, db);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(pomGUI, "Error al añadir un plato");
        }
    }
    
    
    public void insertarPlatosMenu() throws SQLException{
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
        
        ArrayList<String> platos = new ArrayList();
        rs=stmt.executeQuery("select cod_plato from Plato where disponibilidad = 'SI' and cod_plato not in "
                           + "(select cod_plato from menu_contiene_plato where id_menu = '"+menu+"')");
        while ( rs.next() ){
            platos.add( rs.getString(1) );
        }
        
        Asignaciones asig = new Asignaciones(platos, menu, stmt, 1);
    }
    
    public void insertarIngredientePlato() throws SQLException{
        String valores = "", salida = "", plato = "";
        
        ArrayList<String> platosList = new ArrayList();
        rs=stmt.executeQuery("select cod_plato from Plato where disponibilidad = 'SI'");
        while ( rs.next() ){
            platosList.add( rs.getString(1) );
        }
        String[] platos = new String[platosList.size()];
        platos = platosList.toArray(platos);
        plato = (String) JOptionPane.showInputDialog(null,"Selecciona un plato", "Platos",
                                            JOptionPane.QUESTION_MESSAGE,null,platos, platos[0]);
        
        ArrayList<String> ing = new ArrayList();
        rs=stmt.executeQuery("select cod_ing from Ingrediente and cod_ing not in "
                           + "(select cod_ing from plato_contiene_ing where cod_plato = '"+plato+"')");
        while ( rs.next() ){
            ing.add( rs.getString(1) );
        }
        
        Asignaciones pci = new Asignaciones(ing, plato, stmt, 2);
        pci.setVisible(true);
    }
}
