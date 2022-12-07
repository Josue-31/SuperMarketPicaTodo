package com.emergentes.dao;

import com.emergentes.modelo.Factura_compra;
import com.emergentes.utiles.ConexionDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class fac_comDAOimpl extends ConexionDB implements fac_comDAO {

    @Override
    public void insert(Factura_compra factura_compra) throws Exception {
        try {
            this.conectar();

            PreparedStatement ps = this.conn.prepareStatement("INSERT INTO factura_compra (fecha_compra, nit, nro_factura) values (?,?,?)");

            ps.setDate(1, factura_compra.getFecha_compra());
            ps.setInt(2, factura_compra.getNit());
            ps.setInt(3, factura_compra.getNro_factura());

            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public void update(Factura_compra factura_compra) throws Exception {
        try {
            //conectamos a la bd
            this.conectar();
            //consulta sql en una variable
            String sql = "UPDATE factura_compra SET fecha_compra = ?, nit = ?, nro_factura = ? WHERE id_factura = ?";
            //preparamos la sentenica
            PreparedStatement ps = this.conn.prepareStatement(sql);
            //se ponen los parametros
            ps.setDate(1, factura_compra.getFecha_compra());
            ps.setInt(2, factura_compra.getNit());
            ps.setInt(3, factura_compra.getNro_factura());
            ps.setInt(4, factura_compra.getId_factura());
            
            //se ejecuta la sentencia en executeUpdate para el crud
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public void total(int id_factura) throws Exception {
        try {
            //conectamos a la bd
            this.conectar();
            //consulta sql en una variable
            String sql = "UPDATE factura_compra SET total = ( ";
            sql += "select SUM(precio*cantidad) as suma ";
            sql += "from detalle_compra WHERE id_factura = ?) WHERE id_factura = ?";
            //preparamos la sentencia
            PreparedStatement ps = this.conn.prepareStatement(sql);
            //se ponen los aprametros
            ps.setInt(1, id_factura);
            ps.setInt(2, id_factura);
            //se ejecuta la sentencia en executeUpdate para el crud
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public Factura_compra getById(int id_factura) throws Exception {
        Factura_compra f = new Factura_compra();
        try {
            //conectamos a la bd
            this.conectar();
            //consulta sql en una variable
            String sql = "SELECT * FROM factura_compra WHERE id_factura = ?";
            //preparamos la sentenica
            PreparedStatement ps = this.conn.prepareStatement(sql);
            //se ponen los aprametros
            ps.setInt(1, id_factura);
            //se ejecuta la sentencia executeQuery()para seleccionar un registro
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                f.setId_factura(rs.getInt("id_factura"));
                f.setFecha_compra(rs.getDate("fecha_compra"));
                f.setNit(rs.getInt("nit"));
                f.setTotal(rs.getDouble("total"));
                f.setNro_factura(rs.getInt("nro_factura"));
                
            }
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
        return f;
    }

    @Override
    public List<Factura_compra> getAll() throws Exception {
        List<Factura_compra> lista = null;

        try {
            //conectamos a la bd
            this.conectar();
            //consulta sql en una variable           
            String sql = "SELECT fc.*, p.nombre as nombre  FROM factura_compra fc ";
            sql += "LEFT JOIN proveedores p ON fc.nit = p.nit";
            //preparamos la sentenica
            PreparedStatement ps = this.conn.prepareStatement(sql);

            //se ejecuta la sentencia executeQuery()para seleccionar un registro
            ResultSet rs = ps.executeQuery();
            lista = new ArrayList<Factura_compra>();
            while (rs.next()) {
                Factura_compra f = new Factura_compra();
                f.setId_factura(rs.getInt("id_factura"));
                f.setFecha_compra(rs.getDate("fecha_compra"));
                f.setNit(rs.getInt("nit"));
                f.setTotal(rs.getDouble("total"));
                f.setNro_factura(rs.getInt("nro_factura"));
                f.setNombre(rs.getString("nombre"));
                
                //adicionar  a la coleccion
                lista.add(f);

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
