package com.emergentes.dao;

import com.emergentes.modelo.Cargo;
import com.emergentes.utiles.ConexionDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class cargoDAOimpl extends ConexionDB implements cargoDAO {

    @Override
    public void insert(Cargo cargo) throws Exception {
        try {
            this.conectar();

            PreparedStatement ps = this.conn.prepareStatement("INSERT INTO cargo (nombre_cargo, sueldo) values (?,?)");

            ps.setString(1, cargo.getNombre_cargo());
            ps.setInt(2, cargo.getSueldo());

            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public void update(Cargo cargo) throws Exception {
        try {
            this.conectar();

            PreparedStatement ps = this.conn.prepareStatement("UPDATE cargo SET nombre_cargo = ?, sueldo = ? WHERE cod_cargo = ?");

            ps.setString(1, cargo.getNombre_cargo());
            ps.setInt(2, cargo.getSueldo());
            ps.setInt(3, cargo.getCod_cargo());

            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public void delete(int cod_cargo) throws Exception {
        try {
            this.conectar();

            PreparedStatement ps = this.conn.prepareStatement("DELETE FROM cargo WHERE cod_cargo = ?");
            ps.setInt(1, cod_cargo);

            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public Cargo getById(int cod_cargo) throws Exception {
        Cargo c = new Cargo();
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("SELECT * FROM cargo WHERE cod_cargo = ?");
            ps.setInt(1, cod_cargo);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                c.setCod_cargo(rs.getInt("cod_cargo"));
                c.setNombre_cargo(rs.getString("nombre_cargo"));
                c.setSueldo(rs.getInt("sueldo"));
            }

        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }

        return c;
    }

    @Override
    public List<Cargo> getAll() throws Exception {
        List<Cargo> lista = null;
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("SELECT * FROM cargo");

            ResultSet rs = ps.executeQuery();

            lista = new ArrayList<Cargo>();
            while (rs.next()) {
                Cargo c = new Cargo();

                c.setCod_cargo(rs.getInt("cod_cargo"));
                c.setNombre_cargo(rs.getString("nombre_cargo"));
                c.setSueldo(rs.getInt("sueldo"));

                lista.add(c);
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
