import DAO.impl.MascotaDaoH2;
import Model.Mascota;
import Service.MascotaService;

public class Main {

    public static void main(String[] args) {

        Mascota mascota1 = new Mascota("Simon","Golden");
        Mascota mascota2 = new Mascota("Felipe","Labrador");
        Mascota mascota3 = new Mascota("Bruno","Ovejero Aleman");
        Mascota mascota4 = new Mascota("Olivia","Caniche");

        MascotaService mascotaService = new MascotaService();
        mascotaService.setMascotaDao(new MascotaDaoH2());


       //mascotaService.insertMascota(mascota1);
       //mascotaService.insertMascota(mascota2);
       //mascotaService.insertMascota(mascota3);
       mascotaService.insertMascota(mascota4);


    }

}
