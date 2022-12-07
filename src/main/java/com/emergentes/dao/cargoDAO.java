
package com.emergentes.dao;

import com.emergentes.modelo.Cargo;
import java.util.List;

public interface cargoDAO {
    public void insert(Cargo cargo) throws Exception;

    public void update(Cargo cargo) throws Exception;

    public void delete(int cod_cargo) throws Exception;

    public Cargo getById(int cod_cargo) throws Exception;

    public List<Cargo> getAll() throws Exception;
}
