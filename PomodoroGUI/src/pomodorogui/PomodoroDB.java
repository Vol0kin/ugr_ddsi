package pomodorogui;

import java.sql.*;
import java.awt.*;
import java.util.logging.Level;
import java.util.logging.Logger;

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
    
    public String mostrarTabla(String tabla) throws SQLException{
        rs=stmt.executeQuery("select * from "+tabla);
        String s = "";
        
            while(rs.next()){  
                s+=(rs.getString(1)+" | "+rs.getString(2)+" | "+rs.getDate(3)+  " | "+
                    rs.getString(4)+" | "+rs.getString(5)+" | "+rs.getString(6)+" | "+
                    rs.getString(7)+" | "+rs.getString(8)+" | "+rs.getString(9)+" | "+
                    rs.getString(10)+"\n"
                );
            }
        if ("".equals(s))
            s = "La tabla está vacía";
        
        return s;
    }
    
    public String eliminarEmpleado(String dni){
        String salida = "";
        
        try {
            stmt.executeUpdate("delete from Empleado where dni_emp=\""+dni+"\"");
            salida = "El empleado con DNI "+dni+" se ha eliminado correctamente";
        } catch (SQLException ex) {
            Logger.getLogger("No se ha encontrado el empleado con DNI "+dni);
        }
        
        return salida;
        
    }
    
    public void cerrarConexion() throws SQLException {
        con.close();
    }
}