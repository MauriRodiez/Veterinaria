import DAO.impl.MascotaDaoH2;
import Model.Mascota;
import Service.MascotaService;

public class Main {

    public static void main(String[] args) {

        MascotaService mascotaService = new MascotaService();

        Mascota mascota1 = new Mascota("Simon","Golden");

       // mascotaService.insertMascota(mascota1);


    }

}
