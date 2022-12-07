package com.emergentes.dao;

import com.emergentes.modelo.Personal;
import com.emergentes.utiles.ConexionDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class personalDAOimpl extends ConexionDB implements personalDAO {

    @Override
    public void insert(Personal personal) throws Exception {
        try {
            this.conectar();

            PreparedStatement ps = this.conn.prepareStatement("INSERT INTO personal (nombres_personal, usuario, password, celular, direccion, cod_cargo, estado) values (?,?,sha1(?),?,?,?,?)");

            ps.setString(1, personal.getNombres_personal());
            ps.setString(2, personal.getUsuario());
            ps.setString(3, personal.getPassword());
            ps.setString(4, personal.getCelular());
            ps.setString(5, personal.getDireccion());
            ps.setInt(6, personal.getCod_cargo());
            ps.setString(7, personal.getEstado());

            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public void update(Personal personal) throws Exception {
        try {
            //conectamos a la bd
            this.conectar();
            //consulta sql en una variable
            String sql = "UPDATE personal SET nombres_personal = ?, usuario = ?, password = sha1(?), celular = ?, direccion = ?, cod_cargo = ?, estado = ? WHERE id_personal = ?";
            //preparamos la sentenica
            PreparedStatement ps = this.conn.prepareStatement(sql);
            //se ponen los parametros
            ps.setString(1, personal.getNombres_personal());
            ps.setString(2, personal.getUsuario());
            ps.setString(3, personal.getPassword());
            ps.setString(4, personal.getCelular());
            ps.setString(5, personal.getDireccion());
            ps.setInt(6, personal.getCod_cargo());
            ps.setString(7, personal.getEstado());
            ps.setInt(8, personal.getId_personal());
            //se ejecuta la sentencia en executeUpdate para el crud
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public void delete(int id_personal) throws Exception {
        try {
            //conectamos a la bd
            this.conectar();
            //consulta sql en una variable
            String sql = "DELETE FROM personal WHERE id_personal = ?";
            //preparamos la sentenica
            PreparedStatement ps = this.conn.prepareStatement(sql);
            //se ponen los aprametros
            ps.setInt(1, id_personal);
            //se ejecuta la sentencia en executeUpdate para el crud
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public Personal getById(int id_personal) throws Exception {
            Personal per = new Personal();
        try {
            //conectamos a la bd
            this.conectar();
            //consulta sql en una variable
            String sql = "SELECT * FROM personal WHERE id_personal = ?";
            //preparamos la sentenica
            PreparedStatement ps = this.conn.prepareStatement(sql);
            //se ponen los aprametros
            ps.setInt(1, id_personal);
            //se ejecuta la sentencia executeQuery()para seleccionar un registro
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                per.setId_personal(rs.getInt("id_personal"));
                per.setNombres_personal(rs.getString("nombres_personal"));
                per.setUsuario(rs.getString("usuario"));
                per.setPassword(rs.getString("password"));
                per.setCelular(rs.getString("celular"));
                per.setDireccion(rs.getString("direccion"));      
                per.setCod_cargo(rs.getInt("cod_cargo"));
                per.setEstado(rs.getString("estado"));
            }
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
        return per;
    }

    @Override
    public List<Personal> getAll() throws Exception {
        List<Personal> lista = null;

        try {
            //conectamos a la bd
            this.conectar();
            //consulta sql en una variable           
            String sql = "SELECT p.*, c.nombre_cargo as cargo  FROM personal p ";
            sql += "LEFT JOIN cargo c ON p.cod_cargo = c.cod_cargo";
            //preparamos la sentenica
            PreparedStatement ps = this.conn.prepareStatement(sql);

            //se ejecuta la sentencia executeQuery()para seleccionar un registro
            ResultSet rs = ps.executeQuery();
            lista = new ArrayList<Personal>();
            while (rs.next()) {
                Personal per = new Personal();
                per.setId_personal(rs.getInt("id_personal"));
                per.setNombres_personal(rs.getString("nombres_personal"));
                per.setUsuario(rs.getString("usuario"));
                per.setPassword(rs.getString("password"));
                per.setCelular(rs.getString("celular"));
                per.setDireccion(rs.getString("direccion"));      
                per.setCod_cargo(rs.getInt("cod_cargo"));
                per.setEstado(rs.getString("estado"));
                per.setNombre_cargo(rs.getString("cargo"));
                
                //adicionar  a la coleccion
                lista.add(per);

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
