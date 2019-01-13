package pomodorogui;

import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.TableModel;
import net.proteanit.sql.DbUtils;

class PomodoroDB{
    Connection con;
    Statement stmt, stmt2;
    ResultSet rs, rs2;
    
    GestionMenu gMenu;
    GestionProveedor gProv;
    GestionEmpleados gEmp;
    
    public PomodoroDB(){
        this.crearConexion();
        gMenu = new GestionMenu(stmt, rs);
        gProv = new GestionProveedor(stmt, rs);
        gEmp = new GestionEmpleados(stmt, rs);
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
            if ("estadocivil".equals(rs.getString(1))){
                String[] options = {"soltero", "casado", "divorciado", "viudo"};
                a_insertar = (String) JOptionPane.showInputDialog(null,"Insertar valor para "+ rs.getString(1),
                        "Entrada", JOptionPane.QUESTION_MESSAGE,null,options, options[0]);
                valores += "'" + a_insertar + "',";
            }
            else if ("disponibilidad".equals(rs.getString(1))){
                String[] options = {"SI", "NO"};
                a_insertar = (String) JOptionPane.showInputDialog(null,"Insertar valor para "+ rs.getString(1),
                        "Entrada", JOptionPane.QUESTION_MESSAGE,null,options, options[0]);
                valores += "'" + a_insertar + "',";
            }
            else{
                a_insertar = JOptionPane.showInputDialog("Insertar valor para "+ rs.getString(1));

                if (("".equals(a_insertar) && "NO".equals(isNull(tabla, rs.getString(1)))) || null == a_insertar)
                    return "Operacion cancelada";
                else
                    valores += "'" + a_insertar + "',";
            }
        }
        valores = valores.substring(0, valores.length() - 1);
        
        try {
            stmt.executeUpdate("insert into "+tabla+" values("+valores+")");
            salida = "Datos insertados con exito.";
        } catch (SQLException ex) {
            salida = "Error al insertar los datos.";
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
        String valor = "", salida = "", campo = "";
        ArrayList<String> valoresList = new ArrayList<>();
        
        // Seleccionar clave primaria        
        rs=stmt.executeQuery("SELECT COLUMN_NAME FROM information_schema.KEY_COLUMN_USAGE "+
                             "WHERE TABLE_NAME = '"+tabla+"' AND CONSTRAINT_NAME = 'PRIMARY'");
        
        // Obtener nombre de la clave primaria
        rs.next();
        campo = rs.getString(1);
        
        // Obtener la columna de la clave primaria
        rs = stmt.executeQuery("SELECT " + campo + " FROM " + tabla);
        
        while (rs.next()) {
            valoresList.add(rs.getString(1));
        }
        
        String[] valoresArray = new String[valoresList.size()];
        valoresArray = valoresList.toArray(valoresArray);
        valor = (String) JOptionPane.showInputDialog(null, "Selecciona el elemento a eliminar", "Elemento...", 
                                                        JOptionPane.QUESTION_MESSAGE, null, valoresArray, valoresArray[0]);
        
        if (valor == null) {
            return "Operacion cancelada";
        }
        
        try {
            stmt.executeUpdate("DELETE FROM " + tabla + " WHERE " + campo + " = '" + valor + "'");
            salida = "Datos eliminados con exito.";
        } catch (SQLException ex) {
            salida = "Error al eliminar los datos.";
        }
        return salida;
    }
    
    
    public String modificarTabla(String tabla) throws SQLException{
        String salida = "", eleccion = "", a_insertar = "", valor = "", campos = "";
        ArrayList<String> valoresList = new ArrayList<>();
        
        rs=stmt.executeQuery("SELECT COLUMN_NAME FROM information_schema.KEY_COLUMN_USAGE "+
                             "WHERE TABLE_NAME = '"+tabla+"' AND CONSTRAINT_NAME = 'PRIMARY'");
        
        rs.next();
        campos = rs.getString(1);
        
        rs = stmt.executeQuery("SELECT " + campos + " FROM " + tabla);
        
        while (rs.next()){
            valoresList.add(rs.getString(1));
        }
        
        String[] valores = new String[valoresList.size()];
        valores = valoresList.toArray(valores);
        valor = (String) JOptionPane.showInputDialog(null, "Selecciona el elemento a modificar", "Elemento...", 
                                                        JOptionPane.QUESTION_MESSAGE, null, valores, valores[0]);
        
        if (valor == null) {
            return "Operacion cancelada";
        }
        
        valoresList.clear();
                
        rs=stmt.executeQuery("SELECT COLUMN_NAME FROM INFORMATION_SCHEMA.COLUMNS "+
                             "where table_name = '"+tabla+"' and COLUMN_KEY <> 'PRI'");
        while (rs.next()){
            valoresList.add(rs.getString(1));
        }
        
        
        valores = new String[valoresList.size()];
        valores = valoresList.toArray(valores);
        eleccion = (String) JOptionPane.showInputDialog(null,"Selecciona la columna a modificar", "Tablas...",
                                            JOptionPane.QUESTION_MESSAGE,null,valores, valores[0]);
        
        if (eleccion == null) {
            return "Operacion cancelada";
        }
        
        
        if ("estadocivil".equals(eleccion)){
            String[] options = {"soltero", "casado", "divorciado", "viudo"};
            a_insertar = (String) JOptionPane.showInputDialog(null,"Insertar valor para "+ eleccion,
                         "Entrada", JOptionPane.QUESTION_MESSAGE,null,options, options[0]);
        }
        else if ("disponibilidad".equals(eleccion)){
            String[] options = {"SI", "NO"};
            a_insertar = (String) JOptionPane.showInputDialog(null,"Insertar valor para "+ eleccion,
                         "Entrada", JOptionPane.QUESTION_MESSAGE,null,options, options[0]);
        }
        else{
            a_insertar = JOptionPane.showInputDialog("Insertar valor para "+ eleccion);
            if (("".equals(a_insertar) && "NO".equals(isNull(tabla, eleccion))) || null == a_insertar)
                return "Error al insertar los datos";
        }
        
        try {
            stmt.executeUpdate("update "+tabla+" set "+eleccion+" = '"+a_insertar+"' "+
                                "where "+campos + " = '" + valor + "'");
            salida = "Datos modificados con exito.";
        } catch (SQLException ex) {
            salida = "Error al modificar los datos.";
        }
        return salida;
    }
     
    
    public void cerrarConexion() throws SQLException {
        con.close();
    }
}