package com.emergentes.dao;

import com.emergentes.modelo.Proveedores;
import com.emergentes.utiles.ConexionDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class proveedorDAOimpl extends ConexionDB implements proveedorDAO {

    @Override
    public void insert(Proveedores proveedores) throws Exception {
        try {
            this.conectar();

            PreparedStatement ps = this.conn.prepareStatement("INSERT INTO proveedores (nombre, nro_telefono, direccion) values (?,?,?)");

            ps.setString(1, proveedores.getNombre());
            ps.setString(2, proveedores.getNro_telefono());
            ps.setString(3, proveedores.getDireccion());

            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }

    }

    @Override
    public void update(Proveedores proveedores) throws Exception {
        try {
            this.conectar();

            PreparedStatement ps = this.conn.prepareStatement("UPDATE proveedores SET nombre = ?, nro_telefono = ?, direccion = ? WHERE nit = ?");
            ps.setString(1, proveedores.getNombre());
            ps.setString(2, proveedores.getNro_telefono());
            ps.setString(3, proveedores.getDireccion());
            ps.setInt(4, proveedores.getNit());

            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public void delete(int nit) throws Exception {
        try {
            this.conectar();

            PreparedStatement ps = this.conn.prepareStatement("DELETE FROM proveedores WHERE nit = ?");
            ps.setInt(1, nit);

            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public Proveedores getById(int nit) throws Exception {
        Proveedores pr = new Proveedores();
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("SELECT * FROM proveedores WHERE nit = ?");
            ps.setInt(1, nit);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                pr.setNit(rs.getInt("nit"));
                pr.setNombre(rs.getString("nombre"));
                pr.setNro_telefono(rs.getString("nro_telefono"));
                pr.setDireccion(rs.getString("direccion"));
            }

        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }

        return pr;
    }

    @Override
    public List<Proveedores> getAll() throws Exception {
        List<Proveedores> lista = null;
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("SELECT * FROM proveedores");

            ResultSet rs = ps.executeQuery();

            lista = new ArrayList<Proveedores>();
            while (rs.next()) {
                Proveedores pr = new Proveedores();

                pr.setNit(rs.getInt("nit"));
                pr.setNombre(rs.getString("nombre"));
                pr.setNro_telefono(rs.getString("nro_telefono"));
                pr.setDireccion(rs.getString("direccion"));

                lista.add(pr);
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
