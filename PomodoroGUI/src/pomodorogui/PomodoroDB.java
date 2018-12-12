package pomodorogui;

import java.sql.*;
import java.awt.*;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.TableModel;
import net.proteanit.sql.DbUtils;

class PomodoroDB{
    Connection con;
    Statement stmt, stmt2;
    ResultSet rs, rs2;
    
    public void PomodoroDB(){  
    }
    
    
    public void crearConexion(){
        try{  
            Class.forName("com.mysql.jdbc.Driver");  
            con=DriverManager.getConnection(  
            "jdbc:mysql://localhost/pomodoro","root","Pomodoro_DDS1");  
            
            stmt=con.createStatement();
            stmt2=con.createStatement();
              
        }catch(Exception e){ System.out.println(e);}  
    }
    
    
    public void mostrarTabla(String tabla) throws SQLException{
        rs=stmt.executeQuery("select * from "+tabla);
        
        Tablas tablaMostrar = new Tablas();
        tablaMostrar.setVisible(true);
        
        TableModel model = DbUtils.resultSetToTableModel(rs);
        tablaMostrar.jLabel1.setText("Contenido de la tabla "+tabla);
        tablaMostrar.jTable1.setModel(model); 
    }
    
   
    public String insertarTabla(String tabla) throws SQLException{
        String valores = "", salida = "", a_insertar;
        
        rs=stmt.executeQuery("show columns from "+tabla);
        while (rs.next()){
            a_insertar = JOptionPane.showInputDialog("Insertar valor para "+ rs.getString(1));
            
            if ("".equals(a_insertar) && "NO".equals(isNull(tabla, rs.getString(1))) )
                return "Error al insertar los datos";
            else
                valores += "'" + a_insertar + "',";
        }
        valores = valores.substring(0, valores.length() - 1);
        
        try {
            stmt.executeUpdate("insert into "+tabla+" values("+valores+")");
            salida = "Query OK";
        } catch (SQLException ex) {
            salida = "Error";
        }
        return salida;
    }
    
    public String isNull(String tabla, String columna) throws SQLException{
        rs2 = stmt2.executeQuery("SELECT IS_NULLABLE COLUMN_DEFAULT FROM INFORMATION_SCHEMA.COLUMNS"
                              + " WHERE table_name = '"+tabla+"' AND column_name = '"+columna+"'");
        rs2.next();
        return rs2.getString(1);
    }
    
       
    public String eliminarTabla(String tabla) throws SQLException{
        String valores = "", salida = "", valor = "", campos = "";
        
        rs=stmt.executeQuery("SELECT COLUMN_NAME FROM information_schema.KEY_COLUMN_USAGE "+
                             "WHERE TABLE_NAME = '"+tabla+"' AND CONSTRAINT_NAME = 'PRIMARY'");
        while (rs.next()){
            valor = JOptionPane.showInputDialog("Insertar valor para "+rs.getString(1));
            campos += rs.getString(1)+",";
            valores += "'"+valor+"',";
        }
        campos = campos.substring(0, campos.length() - 1);
        valores = valores.substring(0, valores.length() - 1);
        
        try {
            stmt.executeUpdate("delete from "+tabla+" where ("+campos+") in (("+valores+"))");
            salida = "Query OK";
        } catch (SQLException ex) {
            salida = "Error";
        }
        return salida;
    }
     
    
    public void cerrarConexion() throws SQLException {
        con.close();
    }
}