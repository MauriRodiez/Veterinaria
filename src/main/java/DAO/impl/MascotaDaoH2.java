package DAO.impl;

import DAO.IDao;
import DB.dbManager;
import Model.Mascota;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class MascotaDaoH2 implements IDao<Mascota> {

    private static final Logger LOGGER = Logger.getLogger(MascotaDaoH2.class);
    private static final String SQL_INSERT_MASCOTA = "INSERT INTO MASCOTAS (NOMBRE, RAZA) VALUES (?,?)";
    private static final String SQL_DELETE_MASCOTA = "DELETE FROM MASCOTAS WHERE ID = ?";
    public MascotaDaoH2(){}
    @Override
    public Mascota insert(Mascota mascota) {

        Connection connection = null;

        try {

            connection = dbManager.getDatabaseConnection();
            PreparedStatement psInsert = connection.prepareStatement(SQL_INSERT_MASCOTA, Statement.RETURN_GENERATED_KEYS);
            psInsert.setString(1,mascota.getNombre());
            psInsert.setString(2, mascota.getRaza());
            psInsert.execute();

            LOGGER.info("Se ha ingresado una mascota");
        } catch (SQLException e) {
            LOGGER.error("Ocurrio un error y no se pudo insertar datos en la BD", e);
        } finally {
            if (connection == null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    LOGGER.error("Error al cerrar la conexión", e);
                }
            }
        }

        return mascota;
    }

    @Override
    public void eliminar(long id) {

    }
}
