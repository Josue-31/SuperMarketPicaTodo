package com.emergentes.dao;

import com.emergentes.modelo.Proveedores;
import java.util.List;

public interface proveedorDAO {

    public void insert(Proveedores proveedores ) throws Exception;

    public void update(Proveedores proveedores ) throws Exception;

    public void delete(int nit) throws Exception;

    public Proveedores  getById(int nit) throws Exception;

    public List<Proveedores > getAll() throws Exception;
}
