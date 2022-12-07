package com.emergentes.dao;

import com.emergentes.modelo.Factura_venta;
import com.emergentes.utiles.ConexionDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class fac_venDAOimpl extends ConexionDB implements fac_venDAO {

    @Override
    public void insert(Factura_venta factura_compra) throws Exception {
        try {
            this.conectar();

            PreparedStatement ps = this.conn.prepareStatement("INSERT INTO factura_venta (fecha_venta, ci_nit) values (?,?)");

            ps.setDate(1, factura_compra.getFecha_venta());
            ps.setInt(2, factura_compra.getCi_nit());
            //ps.setDouble(3, factura_compra.getTotal());

            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public void update(Factura_venta factura_compra) throws Exception {
        try {
            //conectamos a la bd
            this.conectar();
            //consulta sql en una variable
            String sql = "UPDATE factura_venta SET fecha_venta = ?, ci_nit = ? WHERE nro_factura = ?";
            //preparamos la sentenica
            PreparedStatement ps = this.conn.prepareStatement(sql);
            //se ponen los parametros
            ps.setDate(1, factura_compra.getFecha_venta());
            ps.setInt(2, factura_compra.getCi_nit());
            //ps.setDouble(3, factura_compra.getTotal());
            ps.setInt(3, factura_compra.getNro_factura());
            //se ejecuta la sentencia en executeUpdate para el crud
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public void total(int nro_factura) throws Exception {
        try {
            //conectamos a la bd
            this.conectar();
            //consulta sql en una variable
            String sql = "UPDATE factura_venta SET total = ( ";
            sql += "select SUM(precio*cantidad) as suma ";
            sql += "from detalle_venta WHERE nro_factura = ?) WHERE nro_factura = ?";
            //preparamos la sentencia
            PreparedStatement ps = this.conn.prepareStatement(sql);
            //se ponen los aprametros
            ps.setInt(1, nro_factura);
            ps.setInt(2, nro_factura);
            //se ejecuta la sentencia en executeUpdate para el crud
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public Factura_venta getById(int nro_factura) throws Exception {
        Factura_venta fv = new Factura_venta();
        try {
            //conectamos a la bd
            this.conectar();
            //consulta sql en una variable
            String sql = "SELECT * FROM factura_venta WHERE nro_factura = ?";
            //preparamos la sentenica
            PreparedStatement ps = this.conn.prepareStatement(sql);
            //se ponen los aprametros
            ps.setInt(1, nro_factura);
            //se ejecuta la sentencia executeQuery()para seleccionar un registro
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                fv.setNro_factura(rs.getInt("nro_factura"));
                fv.setFecha_venta(rs.getDate("fecha_venta"));
                fv.setCi_nit(rs.getInt("ci_nit"));
                fv.setTotal(rs.getDouble("total"));

            }
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
        return fv;
    }

    @Override
    public List<Factura_venta> getAll() throws Exception {
        List<Factura_venta> lista = null;

        try {
            //conectamos a la bd
            this.conectar();
            //consulta sql en una variable           
            String sql = "SELECT fv.*, nombres FROM factura_venta fv ";
            sql += "LEFT JOIN cliente c ON fv.ci_nit = c.CINIT";
            //preparamos la sentenica
            PreparedStatement ps = this.conn.prepareStatement(sql);

            //se ejecuta la sentencia executeQuery()para seleccionar un registro
            ResultSet rs = ps.executeQuery();
            lista = new ArrayList<Factura_venta>();
            while (rs.next()) {
                Factura_venta fv = new Factura_venta();
                fv.setNro_factura(rs.getInt("nro_factura"));
                fv.setFecha_venta(rs.getDate("fecha_venta"));
                fv.setCi_nit(rs.getInt("ci_nit"));
                fv.setTotal(rs.getDouble("total"));
                fv.setNombres(rs.getString("nombres"));

                //adicionar  a la coleccion
                lista.add(fv);

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

}
