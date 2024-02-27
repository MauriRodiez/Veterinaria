package Service;

import DAO.IDao;
import DAO.impl.MascotaDaoH2;
import Model.Mascota;

public class MascotaService {

    private IDao<Mascota> mascotaDao;

    public MascotaService(){

    }

    public MascotaService(IDao<Mascota> mascotaDao) {
        this.mascotaDao = mascotaDao;
    }

    public void setMascotaDao(IDao<Mascota> mascotaDao) {
        this.mascotaDao = mascotaDao;
    }

    public Mascota insertMascota(Mascota mascota){
        return mascotaDao.insert(mascota);
    }
}
