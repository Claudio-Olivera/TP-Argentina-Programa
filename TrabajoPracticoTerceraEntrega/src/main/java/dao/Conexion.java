package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    protected Connection conexion;
    private final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    private String url = "jdbc:mysql://localhost:3306/trabajointegrador3?serverTimezone=UTC";
    private String user = "root";
    private String password = "root";

    public void conectar() {
        try {
            Class.forName(JDBC_DRIVER);
            conexion = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void cerrar() throws SQLException {
        if (conexion != null) {
            if (!conexion.isClosed()) {
                conexion.close();
            }
        }
    }
}