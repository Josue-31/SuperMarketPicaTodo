
package com.emergentes.dao;

import com.emergentes.modelo.Personal;
import java.util.List;

public interface personalDAO {
    public void insert(Personal personal) throws Exception;

    public void update(Personal personal) throws Exception;

    public void delete(int id_personal) throws Exception;

    public Personal getById(int id_personal) throws Exception;

    public List<Personal> getAll() throws Exception;
}
