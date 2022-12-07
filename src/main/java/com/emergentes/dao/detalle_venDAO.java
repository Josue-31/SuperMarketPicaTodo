package com.emergentes.dao;

import com.emergentes.modelo.Detalle_venta;
import java.util.List;

public interface detalle_venDAO {

    public void insert(Detalle_venta detalle_venta) throws Exception;

    public void update(Detalle_venta detalle_venta) throws Exception;

    public void delete(int id_v) throws Exception;

    public void update_stock(int nro_factura, int cod_producto) throws Exception;

    public Detalle_venta getById(int id_v) throws Exception;

    public List<Detalle_venta> getAll(int nro_factura) throws Exception;
}
