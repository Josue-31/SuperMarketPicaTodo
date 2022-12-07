package com.emergentes.dao;

import com.emergentes.modelo.Detalle_venta;
import com.emergentes.utiles.ConexionDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class detalle_venDAOimpl extends ConexionDB implements detalle_venDAO {

    @Override
    public void insert(Detalle_venta detalle_venta) throws Exception {
        try {
            this.conectar();

            PreparedStatement ps = this.conn.prepareStatement("INSERT INTO detalle_venta (precio, cantidad, detalle, cod_producto, nro_factura) values (?,?,?,?,?)");

            ps.setDouble(1, detalle_venta.getPrecio());
            ps.setInt(2, detalle_venta.getCantidad());
            ps.setString(3, detalle_venta.getDetalle());
            ps.setInt(4, detalle_venta.getCod_producto());
            ps.setInt(5, detalle_venta.getNro_factura());

            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public void update(Detalle_venta detalle_venta) throws Exception {
        try {
            //conectamos a la bd
            this.conectar();
            //consulta sql en una variable
            String sql = "UPDATE detalle_venta SET precio = ?, cantidad = ?, detalle = ?, cod_producto = ?, nro_factura = ? WHERE id_v = ?";
            //preparamos la sentenica
            PreparedStatement ps = this.conn.prepareStatement(sql);
            //se ponen los parametros
            ps.setDouble(1, detalle_venta.getPrecio());
            ps.setInt(2, detalle_venta.getCantidad());
            ps.setString(3, detalle_venta.getDetalle());
            ps.setInt(4, detalle_venta.getCod_producto());
            ps.setInt(5, detalle_venta.getNro_factura());
            ps.setInt(6, detalle_venta.getId_v());
            //se ejecuta la sentencia en executeUpdate para el crud
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public void delete(int id_v) throws Exception {
        try {
            //conectamos a la bd
            this.conectar();
            //consulta sql en una variable
            String sql = "DELETE FROM detalle_venta WHERE id_v = ?";
            //preparamos la sentenica
            PreparedStatement ps = this.conn.prepareStatement(sql);
            //se ponen los aprametros
            ps.setInt(1, id_v);
            //se ejecuta la sentencia en executeUpdate para el crud
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public Detalle_venta getById(int id_v) throws Exception {
        Detalle_venta dv = new Detalle_venta();
        try {
            //conectamos a la bd
            this.conectar();
            //consulta sql en una variable
            String sql = "SELECT * FROM detalle_venta WHERE id_v = ?";
            //preparamos la sentenica
            PreparedStatement ps = this.conn.prepareStatement(sql);
            //se ponen los aprametros
            ps.setInt(1, id_v);
            //se ejecuta la sentencia executeQuery()para seleccionar un registro
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                dv.setId_v(rs.getInt("id_v"));
                dv.setPrecio(rs.getDouble("precio"));
                dv.setCantidad(rs.getInt("cantidad"));
                dv.setDetalle(rs.getString("detalle"));
                dv.setCod_producto(rs.getInt("cod_producto"));
                dv.setNro_factura(rs.getInt("nro_factura"));

            }
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
        return dv;
    }

    @Override
    public List<Detalle_venta> getAll(int nro_factura) throws Exception {
        List<Detalle_venta> lista = null;

        try {
            //conectamos a la bd
            this.conectar();
            //consulta sql en una variable           
            String sql = "SELECT dv.*, p.nombre_producto as producto FROM detalle_venta dv ";
            sql += "LEFT JOIN producto p ON dv.cod_producto = p.cod_producto WHERE nro_factura = ?";
            //preparamos la sentenica
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, nro_factura);
            //se ejecuta la sentencia executeQuery()para seleccionar un registro
            ResultSet rs = ps.executeQuery();
            lista = new ArrayList<Detalle_venta>();
            while (rs.next()) {
                Detalle_venta dc = new Detalle_venta();
                dc.setId_v(rs.getInt("id_v"));
                dc.setPrecio(rs.getDouble("precio"));
                dc.setCantidad(rs.getInt("cantidad"));
                dc.setDetalle(rs.getString("detalle"));
                dc.setCod_producto(rs.getInt("cod_producto"));
                dc.setNro_factura(rs.getInt("nro_factura"));
                dc.setNombre_producto(rs.getString("producto"));

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
        public void update_stock(int nro_factura, int cod_producto) throws Exception {
        try {
            //conectamos a la bd
            this.conectar();
            //consulta sql en una variable
            String sql = "UPDATE producto as pro set pro.stock = (select p.stock - (select SUM(cantidad) from detalle_venta where cod_producto = p.cod_producto and nro_factura = ?) ";
            sql += "from producto as p where p.cod_producto IN ";
            sql += "(select pr.cod_producto from detalle_venta as dc INNER JOIN  producto as pr on dc.cod_producto = pr.cod_producto where dc.nro_factura = ? GROUP BY dc.cod_producto HAVING pr.cod_producto = ?) ";
            sql += ") where pro.cod_producto = ?";
            //preparamos la sentencia
            PreparedStatement ps = this.conn.prepareStatement(sql);
            //se ponen los aprametros
            ps.setInt(1, nro_factura);
            ps.setInt(2, nro_factura);
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
