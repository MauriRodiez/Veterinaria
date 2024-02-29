package DB;

import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class dbManager {

    private static Connection databaseConnection;
    private static final String CONNECTION = "jdbc:h2:C:/Users/Mauricio/Documents/CV/BD/JAVA/db_Veterinaria";
    private static final String USER = "sa";
    private static final String PASSWORD = "";

    private static final Logger LOGGER = Logger.getLogger(dbManager.class);

    static {
        try {
            Class.forName("org.h2.Driver");
            LOGGER.info("Se encontró el driver para la BD - la librería está referenciada");

            try {
                databaseConnection = DriverManager.getConnection(CONNECTION, USER, PASSWORD);
                LOGGER.info("Conexión creada con éxito");
            } catch (SQLException e) {
                LOGGER.error("Error al intentar conectar a la base de datos", e);
                throw new RuntimeException("No es posible establecer una conexión a la base de datos", e);
            }
        } catch (ClassNotFoundException e) {
            LOGGER.error("No se encuentra el driver para la conexión de la BD", e);
            throw new RuntimeException("No se pudo encontrar el driver JDBC para la base de datos", e);
        }
    }

    public static Connection getDatabaseConnection() {
        return databaseConnection;
    }
}
