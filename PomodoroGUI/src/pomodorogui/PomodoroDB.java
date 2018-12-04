package pomodorogui;

import java.sql.*;
import java.awt.*;

class PomodoroDB{
    Connection con;
    Statement stmt;
    ResultSet rs;
    
    public void PomodoroDB(){  
    }
    
    public void crearConexion(){
        try{  
            Class.forName("com.mysql.jdbc.Driver");  
            con=DriverManager.getConnection(  
            "jdbc:mysql://localhost/pomodoro","root","Pomodoro_DDS1");  
            
            stmt=con.createStatement();  
              
        }catch(Exception e){ System.out.println(e);}  
    }
    
    public String mostrarEmpleados() throws SQLException{
        rs=stmt.executeQuery("select * from Empleado");
        String s = null;
        
            while(rs.next())  
                s = (rs.getString(1)+" | "+rs.getString(2)+" | "+rs.getDate(3)+" | "+
                 rs.getString(4)+" | "+rs.getString(5)+" | "+rs.getString(6)+" | "+
                 rs.getString(7)+" | "+rs.getString(8)+" | "+rs.getString(9)+" | "+
                 rs.getString(10)
                );
        return s;
    }
    
    public void cerrarConexion() throws SQLException {
        con.close();
    }
}