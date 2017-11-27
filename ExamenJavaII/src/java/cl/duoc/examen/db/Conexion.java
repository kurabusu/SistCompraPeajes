package cl.duoc.examen.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author jose tolosa
 */
public class Conexion {
    
    private static Connection cnx = null;
    
    public static Connection obtener() throws SQLException, ClassNotFoundException {
        if (cnx == null) {
            try {
                String bd = "bd_examen_java_2"; 
                String usuario = "root"; 
                String clave = "";

                Class.forName("com.mysql.jdbc.Driver");
                cnx = DriverManager.getConnection("jdbc:mysql://localhost/"+bd, usuario, clave);
            } catch (SQLException ex) {
                throw new SQLException(ex);
            } catch (ClassNotFoundException ex) {
                throw new ClassCastException(ex.getMessage());
            }
        }
        return cnx;
    }
    
    public static void cerrar() throws SQLException {
        if (cnx != null) {
            cnx.close();
        }
    }
}
