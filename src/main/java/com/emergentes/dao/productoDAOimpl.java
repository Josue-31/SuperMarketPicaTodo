package com.emergentes.dao;

import com.emergentes.modelo.Producto;
import com.emergentes.utiles.ConexionDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class productoDAOimpl extends ConexionDB implements productoDAO {

    @Override
    public void insert(Producto producto) throws Exception {
        try {
            //conectamos a la bd
            this.conectar();
            //consulta sql en una variable
            String sql = "INSERT INTO producto (stock, tipo, fecha_vencimiento, fecha_elaboracion, id_personal, nombre_producto, imagen, estado) values (?,?,?,?,?,?,?,?)";
            //preparamos la sentenica
            PreparedStatement ps = this.conn.prepareStatement(sql);
            //se ponen los aprametros
            ps.setInt(1, producto.getStock());
            ps.setString(2, producto.getTipo());
            ps.setDate(3, producto.getFecha_vencimiento());
            ps.setDate(4, producto.getFecha_elaboracion());
            ps.setInt(5, producto.getId_personal());
            ps.setString(6, producto.getNombre_producto());
            ps.setString(7, producto.getImagen());
            ps.setString(8, producto.getEstado());
            //se ejecuta la sentencia en executeUpdate para el crud
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public void update(Producto producto) throws Exception {
        try {
            //conectamos a la bd
            this.conectar();
            //consulta sql en una variable
            String sql = "UPDATE producto SET stock = ?, tipo = ?, fecha_vencimiento = ?, fecha_elaboracion = ?, id_personal = ?, nombre_producto = ?, imagen = ?, estado = ? WHERE cod_producto = ?";
            //preparamos la sentenica
            PreparedStatement ps = this.conn.prepareStatement(sql);
            //se ponen los aprametros
            ps.setInt(1, producto.getStock());
            ps.setString(2, producto.getTipo());
            ps.setDate(3, producto.getFecha_vencimiento());
            ps.setDate(4, producto.getFecha_elaboracion());
            ps.setInt(5, producto.getId_personal());
            ps.setString(6, producto.getNombre_producto());
            ps.setString(7, producto.getImagen());
            ps.setString(8, producto.getEstado());
            ps.setInt(9, producto.getCod_producto());
            //se ejecuta la sentencia en executeUpdate para el crud
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public void delete(int cod_producto) throws Exception {
        try {
            //conectamos a la bd
            this.conectar();
            //consulta sql en una variable
            String sql = "DELETE FROM producto WHERE cod_producto = ?";
            //preparamos la sentenica
            PreparedStatement ps = this.conn.prepareStatement(sql);
            //se ponen los aprametros
            ps.setInt(1, cod_producto);
            //se ejecuta la sentencia en executeUpdate para el crud
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public Producto getById(int cod_producto) throws Exception {
        Producto pro = new Producto();
        try {
            //conectamos a la bd
            this.conectar();
            //consulta sql en una variable
            String sql = "SELECT * FROM producto WHERE cod_producto = ?";
            //preparamos la sentenica
            PreparedStatement ps = this.conn.prepareStatement(sql);
            //se ponen los aprametros
            ps.setInt(1, cod_producto);
            //se ejecuta la sentencia executeQuery()para seleccionar un registro
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                pro.setCod_producto(rs.getInt("cod_producto"));
                pro.setStock(rs.getInt("stock"));
                pro.setTipo(rs.getString("tipo"));
                pro.setFecha_vencimiento(rs.getDate("fecha_vencimiento"));
                pro.setFecha_elaboracion(rs.getDate("fecha_elaboracion"));
                pro.setId_personal(rs.getInt("id_personal"));
                pro.setNombre_producto(rs.getString("nombre_producto"));
                pro.setImagen(rs.getString("imagen"));
                pro.setEstado(rs.getString("estado"));

            }
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
        return pro;
    }

    @Override
    public List<Producto> getAll() throws Exception {
        List<Producto> lista = null;

        try {
            //conectamos a la bd
            this.conectar();
            //consulta sql en una variable           

            String sql = "SELECT p.*, per.nombres_personal as nombre  FROM producto p ";
            sql += "LEFT JOIN personal per ON per.id_personal = p.id_personal";
            //preparamos la sentenica
            PreparedStatement ps = this.conn.prepareStatement(sql);

            //se ejecuta la sentencia executeQuery()para seleccionar un registro
            ResultSet rs = ps.executeQuery();
            lista = new ArrayList<Producto>();
            while (rs.next()) {
                Producto pro = new Producto();
                pro.setCod_producto(rs.getInt("cod_producto"));
                pro.setStock(rs.getInt("stock"));
                pro.setTipo(rs.getString("tipo"));
                pro.setFecha_vencimiento(rs.getDate("fecha_vencimiento"));
                pro.setFecha_elaboracion(rs.getDate("fecha_elaboracion"));
                pro.setId_personal(rs.getInt("id_personal"));
                pro.setNombre_producto(rs.getString("nombre_producto"));
                pro.setImagen(rs.getString("imagen"));
                pro.setEstado(rs.getString("estado"));
                pro.setNombre(rs.getString("nombre"));
                //adicionar  a la coleccion
                lista.add(pro);

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
