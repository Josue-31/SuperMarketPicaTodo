
package com.emergentes.dao;

import com.emergentes.modelo.Factura_venta;
import java.util.List;

public interface fac_venDAO {
    public void insert(Factura_venta factura_compra) throws Exception;

    public void update(Factura_venta factura_compra) throws Exception;

    public void total(int nro_factura) throws Exception;

    public Factura_venta getById(int nro_factura) throws Exception;

    public List<Factura_venta> getAll() throws Exception;
}
