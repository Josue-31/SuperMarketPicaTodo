package com.emergentes.dao;

import com.emergentes.modelo.Detalle_compra;
import com.emergentes.utiles.ConexionDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class detalle_comDAOimpl extends ConexionDB implements detalle_comDAO {

    @Override
    public void insert(Detalle_compra detalle_compra) throws Exception {
        try {
            this.conectar();

            PreparedStatement ps = this.conn.prepareStatement("INSERT INTO detalle_compra (precio, cantidad, observaciones, cod_producto, id_factura) values (?,?,?,?,?)");

            ps.setDouble(1, detalle_compra.getPrecio());
            ps.setInt(2, detalle_compra.getCantidad());
            ps.setString(3, detalle_compra.getObservaciones());
            ps.setInt(4, detalle_compra.getCod_producto());
            ps.setInt(5, detalle_compra.getId_factura());

            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public void update(Detalle_compra detalle_compra) throws Exception {
        try {
            //conectamos a la bd
            this.conectar();
            //consulta sql en una variable
            String sql = "UPDATE detalle_compra SET precio = ?, cantidad = ?, observaciones = ?, cod_producto = ?, id_factura = ? WHERE id = ?";
            //preparamos la sentenica
            PreparedStatement ps = this.conn.prepareStatement(sql);
            //se ponen los parametros
            ps.setDouble(1, detalle_compra.getPrecio());
            ps.setInt(2, detalle_compra.getCantidad());
            ps.setString(3, detalle_compra.getObservaciones());
            ps.setInt(4, detalle_compra.getCod_producto());
            ps.setInt(5, detalle_compra.getId_factura());
            ps.setInt(6, detalle_compra.getId());
            //se ejecuta la sentencia en executeUpdate para el crud
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public void delete(int id) throws Exception {
        try {
            //conectamos a la bd
            this.conectar();
            //consulta sql en una variable
            String sql = "DELETE FROM detalle_compra WHERE id = ?";
            //preparamos la sentenica
            PreparedStatement ps = this.conn.prepareStatement(sql);
            //se ponen los aprametros
            ps.setInt(1, id);
            //se ejecuta la sentencia en executeUpdate para el crud
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public Detalle_compra getById(int id) throws Exception {
        Detalle_compra dc = new Detalle_compra();
        try {
            //conectamos a la bd
            this.conectar();
            //consulta sql en una variable
            String sql = "SELECT * FROM detalle_compra WHERE id = ?";
            //preparamos la sentenica
            PreparedStatement ps = this.conn.prepareStatement(sql);
            //se ponen los aprametros
            ps.setInt(1, id);
            //se ejecuta la sentencia executeQuery()para seleccionar un registro
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                dc.setId(rs.getInt("id"));
                dc.setPrecio(rs.getDouble("precio"));
                dc.setCantidad(rs.getInt("cantidad"));
                dc.setObservaciones(rs.getString("observaciones"));
                dc.setCod_producto(rs.getInt("cod_producto"));
                dc.setId_factura(rs.getInt("id_factura"));

            }
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
        return dc;
    }

    @Override
    public List<Detalle_compra> getAll(int id_factura) throws Exception {
        List<Detalle_compra> lista = null;

        try {
            //conectamos a la bd
            this.conectar();
            //consulta sql en una variable           
            String sql = "SELECT dc.*, p.nombre_producto FROM detalle_compra dc ";
            sql += "LEFT JOIN producto p ON dc.cod_producto = p.cod_producto WHERE id_factura = ?";
            //preparamos la sentenica
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, id_factura);
            //se ejecuta la sentencia executeQuery()para seleccionar un registro
            ResultSet rs = ps.executeQuery();
            lista = new ArrayList<Detalle_compra>();
            while (rs.next()) {
                Detalle_compra dc = new Detalle_compra();
                dc.setId(rs.getInt("id"));
                dc.setPrecio(rs.getDouble("precio"));
                dc.setCantidad(rs.getInt("cantidad"));
                dc.setObservaciones(rs.getString("observaciones"));
                dc.setCod_producto(rs.getInt("cod_producto"));
                dc.setId_factura(rs.getInt("id_factura"));
                dc.setNombre_producto(rs.getString("nombre_producto"));

                //adicionar  a la coleccion
                lista.add(dc);

            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
        return lista;
    }

    @Override
    public void update_stock(int id_factura, int cod_producto) throws Exception {
        try {
            //conectamos a la bd
            this.conectar();
            //consulta sql en una variable
            String sql = "UPDATE producto as pro set pro.stock = (select p.stock + (select SUM(cantidad) from detalle_compra where cod_producto = p.cod_producto and id_factura = ?) ";
            sql += "from producto as p where p.cod_producto IN ";
            sql += "(select pr.cod_producto from detalle_compra as dc INNER JOIN  producto as pr on dc.cod_producto = pr.cod_producto where dc.id_factura = ? GROUP BY dc.cod_producto HAVING pr.cod_producto = ? )";
            sql += ") where pro.cod_producto = ?";
            //preparamos la sentencia
            PreparedStatement ps = this.conn.prepareStatement(sql);
            //se ponen los aprametros
            ps.setInt(1, id_factura);
            ps.setInt(2, id_factura);
            ps.setInt(3, cod_producto);
            ps.setInt(4, cod_producto);
            //se ejecuta la sentencia en executeUpdate para el crud
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }

    }

}
