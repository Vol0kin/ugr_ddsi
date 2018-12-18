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
        rs=stmt.executeQuery("select cod_plato from Plato where disponibilidad = 'SI'");
        while ( rs.next() ){
            platos.add( rs.getString(1) );
        }
        
        MenuContienePlato mcp = new MenuContienePlato(platos, menu, stmt);
        mcp.setVisible(true);
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
        rs=stmt.executeQuery("select cod_ing from Ingrediente");
        while ( rs.next() ){
            ing.add( rs.getString(1) );
        }
        
        PlatoContieneIngrediente pci = new PlatoContieneIngrediente(ing, plato, stmt);
        pci.setVisible(true);
    }
    
    public void establecerIngrediente() throws SQLException{
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
        rs=stmt.executeQuery("select cod_ing from Ingrediente");
        while ( rs.next() ){
            ing.add( rs.getString(1) );
        }
        
        EstablecerIngrediente ei = new EstablecerIngrediente(ing, prov, stmt);
        ei.setVisible(true);
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
                    return "Error al insertar los datos";
                else
                    valores += "'" + a_insertar + "',";
            }
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
    
    
    public String modificarTabla(String tabla) throws SQLException{
        String salida = "", eleccion = "", a_insertar = "", valor = "", campos = "";
        ArrayList<String> valoresList = new ArrayList<>();
        
        rs=stmt.executeQuery("SELECT COLUMN_NAME FROM information_schema.KEY_COLUMN_USAGE "+
                             "WHERE TABLE_NAME = '"+tabla+"' AND CONSTRAINT_NAME = 'PRIMARY'");
        while (rs.next()){
            valor = JOptionPane.showInputDialog("Insertar valor para "+rs.getString(1));
            campos += rs.getString(1)+" = '"+valor+"' and ";
        }
        campos = campos.substring(0, campos.length() - 5);
                
        rs=stmt.executeQuery("SELECT COLUMN_NAME FROM INFORMATION_SCHEMA.COLUMNS "+
                             "where table_name = '"+tabla+"' and COLUMN_KEY <> 'PRI'");
        while (rs.next()){
            valoresList.add(rs.getString(1));
        }
        
        String[] valores = new String[valoresList.size()];
        valores = valoresList.toArray(valores);
        eleccion = (String) JOptionPane.showInputDialog(null,"Selecciona la columna a modificar", "Tablas...",
                                            JOptionPane.QUESTION_MESSAGE,null,valores, valores[0]);
        
        
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
                                "where "+campos);
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