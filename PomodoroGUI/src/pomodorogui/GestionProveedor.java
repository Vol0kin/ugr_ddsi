/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pomodorogui;
import java.sql.*;

/**
 *
 * @author nazaret
 */
public class GestionProveedor 
{
    private static Statement stmt = null;
    private static ResultSet rs = null;
    private static int resultado;
    
    public static void insertarProveedor(Connection conn)
    {
        try
        {
            String consulta = "INSERT INTO Proveedor"
                              + " values ('11111111A', 'Jose Lopez Perez', '123456789', 'uncorreo@gmail.com', 'Empresa1', '22222222B', 'congelados', '25')";

            stmt = conn.createStatement();
            resultado = stmt.executeUpdate(consulta);

        } catch(Exception e) {
            System.out.println(e);
        }
    }

    public static void eliminarProveedor(Connection conn)
    {
        try
        {
            String consulta = "DELETE FROM Proveedor WHERE dni = '11111111A'";

            stmt = conn.createStatement();
            stmt.executeUpdate(consulta);

        } catch(Exception e) {
            System.out.println(e);
        }
    }

    public static void modificarProveedor(Connection conn, String dato)
    {
        try
        {
            buscarProveedor(conn, dato);
            String nom_nuevo = "jose lopez perez", tel_nuevo = "958111111", correo_nuevo = "modif@gmail.com", emp_nueva = "nueva_empresa", tipo_nuevo = "pescado", edad_nueva = "45";

            String consulta = "UPDATE Proveedor SET nombre_apellidos = '" + nom_nuevo + "'"
                                                 + ", telefono = '" + tel_nuevo + "'"
                                                 + ", correo = '" + correo_nuevo + "'"
                                                 + ", nombre_empresa = '" + emp_nueva + "'"
                                                 + ", tipo_producto = '" + tipo_nuevo + "'"
                                                 + ", edad = '" + edad_nueva + "'"
                                                 + "WHERE dni = '" + dato + "'";

            PreparedStatement updateEXP = conn.prepareStatement(consulta);
            updateEXP.executeUpdate();

        } catch(Exception e) {
            System.out.println(e);
        }
    }

    public static void buscarProveedor(Connection conn, String dato)
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

    public static void establecerIngredienteProvisto(Connection conn)
    {
        try
        {
            String consulta = "INSERT INTO Ingrediente"
                              + " values ('00000', 'Fresco', 'Verdura', '25')";

            stmt = conn.createStatement();
            resultado = stmt.executeUpdate(consulta);

        } catch(Exception e) {
            System.out.println(e);
        }
    }
}
