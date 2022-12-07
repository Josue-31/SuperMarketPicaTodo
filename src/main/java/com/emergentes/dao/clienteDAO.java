
package com.emergentes.dao;

import com.emergentes.modelo.Cliente;
import java.util.List;

public interface clienteDAO {
    public void insert(Cliente cliente) throws Exception;

    public void update(Cliente cliente) throws Exception;

    public void delete(int CINIT) throws Exception;

    public Cliente getById(int CINIT) throws Exception;

    public List<Cliente> getAll() throws Exception;
}
