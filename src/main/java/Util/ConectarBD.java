package Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConectarBD {

    private static final String URL = "jdbc:mysql://localhost:3306/bd_gestionproyectos";
    private static final String USUARIO = "root";
    private static final String PASSWORD = "";

    private static Connection con = null;

    /**
     * Obtiene una conexión a la base de datos.
     * 
     * @return Connection La conexión a la base de datos.
     */
    public   Connection getConexion() {
        if (con == null) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                con = DriverManager.getConnection(URL, USUARIO, PASSWORD);
                System.out.println("Conexión a la base de datos establecida.");
            } catch (ClassNotFoundException e) {
                System.err.println("Error: No se encontró el driver de MySQL.");
                e.printStackTrace();
            } catch (SQLException e) {
                System.err.println("Error: No se pudo conectar a la base de datos.");
                e.printStackTrace();
            }
        }
        return con;
    }

    /**
     * Cierra la conexión a la base de datos.
     */
    public   void cerrarConexion() {
        if (con != null) {
            try {
                con.close();
                con = null; // Resetear la conexión a null después de cerrarla
                System.out.println("Conexión a la base de datos cerrada.");
            } catch (SQLException e) {
                System.err.println("Error: No se pudo cerrar la conexión a la base de datos.");
                e.printStackTrace();
            }
        }
    }
}
