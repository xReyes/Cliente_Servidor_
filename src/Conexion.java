//package cliente.servidor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Conexion {

    Connection conn;

    public Connection Conexion() {
        try {
            DriverManager.registerDriver(new org.gjt.mm.mysql.Driver());
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost/sistema_bancario?characterEncoding=latin1&useConfigs=maxPerformance", "root", "Trabajo82463");
            // con.createStatement();
            this.conn = con;
        } catch (SQLException e) {
            //e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error en la Conexion");
        }
        return this.conn;
    }
}
