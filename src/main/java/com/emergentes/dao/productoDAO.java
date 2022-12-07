package com.emergentes.dao;
import com.emergentes.modelo.Producto;
import java.util.List;

public interface productoDAO {
    public void insert(Producto producto) throws Exception;

    public void update(Producto producto) throws Exception;

    public void delete(int cod_producto) throws Exception;

    public Producto getById(int cod_producto) throws Exception;

    public List<Producto> getAll() throws Exception;
}
