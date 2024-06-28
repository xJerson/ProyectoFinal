package Test;

import java.sql.Connection;
import java.sql.SQLException;

import Util.ConectarBD;

public class TestConectarBD {

    public static void main(String[] args) {
        System.out.println("Iniciando test de conexión a la base de datos...");
        ConectarBD conex=new ConectarBD();
        Connection con = null;
        try {
            con = conex.getConexion();
            if (con != null && !con.isClosed()) {
                System.out.println("Conexión a la base de datos exitosa.");
            } else {
                System.err.println("No se pudo establecer la conexión a la base de datos.");
            }
        } catch (SQLException e) {
            System.err.println("Error al verificar el estado de la conexión.");
            e.printStackTrace();
        } finally {
            conex.cerrarConexion();
            System.out.println("Test de conexión a la base de datos finalizado.");
        }
    }
}
