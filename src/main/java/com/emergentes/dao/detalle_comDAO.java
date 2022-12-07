package com.emergentes.dao;

import com.emergentes.modelo.Detalle_compra;
import java.util.List;

public interface detalle_comDAO {

    public void insert(Detalle_compra detalle_compra) throws Exception;

    public void update(Detalle_compra detalle_compra) throws Exception;

    public void delete(int id) throws Exception;
    
    public void update_stock(int id_factura, int cod_producto) throws Exception;
    
    public Detalle_compra getById(int id) throws Exception;

    public List<Detalle_compra> getAll(int id_factura) throws Exception;
}
