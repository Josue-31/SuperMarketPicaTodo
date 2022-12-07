
package com.emergentes.dao;

import com.emergentes.modelo.Factura_compra;
import java.util.List;

public interface fac_comDAO {
    public void insert(Factura_compra factura_compra) throws Exception;

    public void update(Factura_compra factura_compra) throws Exception;

    public void total(int id_factura) throws Exception;

    public Factura_compra getById(int id_factura) throws Exception;

    public List<Factura_compra> getAll() throws Exception;
}
