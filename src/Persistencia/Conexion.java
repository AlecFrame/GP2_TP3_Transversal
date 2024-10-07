
package Persistencia;

import java.sql.*;
import javax.swing.JOptionPane;

public class Conexion {
    private static String URL = "jdbc:mysql://localhost/";
    private static String BD = "gp2_UniversidadULP_Transversal";
    private static String USUARIO = "root";
    private static String PASSWORD = "";
    
    public static Connection conexion = null;
    
    public static Connection cargaConexion() {
        if (conexion == null) {
            try {
                Class.forName("org.mariadb.jdbc.Driver");
                conexion=DriverManager.getConnection(URL+BD,USUARIO,PASSWORD);
            }catch(SQLException|ClassNotFoundException e) {
               JOptionPane.showMessageDialog(null, "No cargaron los drives o base de datos");
            }
        }
        return conexion;
    }
}
