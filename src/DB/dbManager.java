package DB;

import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class dbManager {

    private static Connection databaseConnection;
    private static final String CONNECTION = "jdbc:h2:./Proyecto_Back";
    private static final String USER = "sa";
    private static final String PASSWORD = "sa";

    private static final Logger LOGGER = Logger.getLogger(dbManager.class);

    static{

        databaseConnection = null;

        try {
            Class.forName("org.h2.Driver");
            LOGGER.info("Se encontro el driver para la BD - la libreria esta referenciada");

            try {
                databaseConnection = DriverManager.getConnection(CONNECTION,USER,PASSWORD);
                LOGGER.info("Conección creada con exito");

            } catch (SQLException e) {
                LOGGER.error("No es posible instanciar una conexion", e);
            } finally {
                try {
                    databaseConnection.close();
                } catch (SQLException e) {
                    LOGGER.error("Se encontro un error al cerrar la conección", e);
                }
            }
        } catch (ClassNotFoundException e) {
            LOGGER.error("No se encuentra el driver para la conexion de la BD", e);
        }
    }

    public static Connection getDatabaseConnection() {
        return databaseConnection;
    }
}
