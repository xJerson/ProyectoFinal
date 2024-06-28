package Test;

import java.sql.Connection;
import java.sql.SQLException;

import Util.ConectarBD;

public class TestConectarBD {

    public static void main(String[] args) {
        System.out.println("Iniciando test de conexi�n a la base de datos...");
        ConectarBD conex=new ConectarBD();
        Connection con = null;
        try {
            con = conex.getConexion();
            if (con != null && !con.isClosed()) {
                System.out.println("Conexi�n a la base de datos exitosa.");
            } else {
                System.err.println("No se pudo establecer la conexi�n a la base de datos.");
            }
        } catch (SQLException e) {
            System.err.println("Error al verificar el estado de la conexi�n.");
            e.printStackTrace();
        } finally {
            conex.cerrarConexion();
            System.out.println("Test de conexi�n a la base de datos finalizado.");
        }
    }
}
