package DB;

import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class dbMySQL {

    private static Connection dbMySQL;
    private static final String CONNECTION = "jdbc:mysql://localhost:3306/veterinaria";
    private static final String USER = "root";
    private static final String PASSWORD = "Bdatos2023";

    private static final Logger LOGGER = Logger.getLogger(dbMySQL.class);

    static {
        try {
            Class.forName("org.h2.Driver");
            LOGGER.info("Se encontró el driver para la BD - la librería está referenciada");

            try {
                dbMySQL = DriverManager.getConnection(CONNECTION, USER, PASSWORD);
                LOGGER.info("Conexión creada con éxito");
            } catch (SQLException e) {
                e.printStackTrace();
                throw new RuntimeException("No es posible establecer una conexión a la base de datos");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("No se pudo encontrar el driver JDBC para la base de datos");
        }
    }

    public static Connection getDbMySQL() {
        return dbMySQL;
    }
}
