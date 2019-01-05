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
 * @author nazaret
 */
public class GestionProveedor 
{
    private static Statement stmt = null;
    private static ResultSet rs = null;
    private static int resultado;
    
    public GestionProveedor(Statement stmt, ResultSet rs) {
        this.stmt = stmt;
        this.rs = rs;
    }
    
    public void insertarProveedor(PomodoroGUI pomGUI)
    {
        String consulta = "";
        
        try
        {
            consulta = pomDB.insertarTabla("Proveedor");
            JOptionPane.showMessageDialog(pomGUI, consulta);
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(pomGUI, "Error al insertar un proveedor");
        }
    }

    public void eliminarProveedor(PomodoroGUI pomGUI)
    {
        String consulta = "";
        
        try
        {
            consulta = pomDB.eliminarTabla("Proveedor");
            JOptionPane.showMessageDialog(pomGUI, consulta);
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(pomGUI, "Error al eliminal al proveedor");
        }
    }

    public void modificarProveedor(PomodoroGUI pomGUI)
    {
        String consulta = "";
        
        try
        {
            consulta = pomDB.modificarTabla("Proveedor");
            JOptionPane.showMessageDialog(pomGUI, consulta);
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(pomGUI, "Error al modificar un proveedor");
        }
    }

    public void buscarProveedor(Connection conn, String dato)
    {
        try
        {
            String consulta = "SELECT * FROM Proveedor WHERE dni = '" + dato + "'";

            rs = stmt.executeQuery(consulta);

            if (stmt.execute(consulta))
                rs = stmt.getResultSet();

            while(rs.next())
                System.out.println(rs.getString(1)+","+rs.getString(2)+","+rs.getString(3)+","+rs.getString(4)+","+rs.getString(5)+","+rs.getString(6)+","+rs.getString(7)+","+rs.getInt(8));

            rs.close();
        } catch(Exception e) {
            System.out.println(e);
        }
    }

    public void establecerIngredienteProvisto(PomodoroGUI pomGUI)
    {
        String consulta = "";
        
        try
        {
            consulta = pomDB.insertarTabla("Ingrediente");
            JOptionPane.showMessageDialog(pomGUI, consulta);
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(pomGUI, "Error al insertar el ingrediente");
        }
    }
    
    public void provee(PomodoroGUI pomGUI)
    {
        String valores = "", salida = "", prov = "";
        
        try
        {
            ArrayList<String> lista_prov = new ArrayList();

            rs=stmt.executeQuery("select dni from Proveedor");

            while (rs.next())
                lista_prov.add(rs.getString(1));

            String[] proveedor = new String[lista_prov.size()];
            proveedor = lista_prov.toArray(proveedor);

            prov = (String) JOptionPane.showInputDialog(null,"Selecciona un proveedor", "Proveedor",
                    JOptionPane.QUESTION_MESSAGE,null,proveedor, proveedor[0]);

            ArrayList<String> ing = new ArrayList();

            rs=stmt.executeQuery("select cod_ing from Ingrediente");

            while (rs.next())
                ing.add(rs.getString(1));
            
            Asignaciones asig = new Asignaciones(ing, prov, stmt, 3);
            asig.setVisible(true);

            //asig.establecerIngrediente(proveedor+ing.get(0));
            
        } catch(SQLException e) {
            JOptionPane.showMessageDialog(pomGUI, "Error al establecer relación entre proveedor e ingrediente");
        }
    }   
    
    public void quitarIngrediente() throws SQLException
    {
        String valores = "", salida = "", prov = "";
        
        ArrayList<String> provList = new ArrayList();
        rs=stmt.executeQuery("select dni from Proveedor");
        while ( rs.next() ){
            provList.add( rs.getString(1) );
        }
        String[] provs = new String[provList.size()];
        provs = provList.toArray(provs);
        prov = (String) JOptionPane.showInputDialog(null,"Selecciona un proveedor", "Proveedores",
                                            JOptionPane.QUESTION_MESSAGE,null,provs, provs[0]);
        
        ArrayList<String> ing = new ArrayList();
        rs=stmt.executeQuery("select cod_ing from Ingrediente where cod_ing in "
                           + "(select cod_ing from provee where dni_prov = '"+prov+"')");
        while ( rs.next() ){
            ing.add( rs.getString(1) );
        }
        
        Asignaciones ei = new Asignaciones(ing, prov, stmt, 6);
        ei.setVisible(true);
    }
}
