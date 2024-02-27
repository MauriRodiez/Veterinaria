package DAO;

public interface IDao<T> {

    public T insert(T t);
    public void eliminar(long id);
}
