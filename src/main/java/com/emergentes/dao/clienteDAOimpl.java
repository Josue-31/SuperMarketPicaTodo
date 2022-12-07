package com.emergentes.dao;

import com.emergentes.modelo.Cliente;
import com.emergentes.utiles.ConexionDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class clienteDAOimpl extends ConexionDB implements clienteDAO {

    @Override
    public void insert(Cliente cliente) throws Exception {
        try {
            this.conectar();

            PreparedStatement ps = this.conn.prepareStatement("INSERT INTO cliente (CINIT, nombres, apellido_paterno, apellido_materno, direccion) values (?,?,?,?,?)");

            ps.setInt(1, cliente.getCINIT());
            ps.setString(2, cliente.getNombres());
            ps.setString(3, cliente.getApellido_paterno());
            ps.setString(4, cliente.getApellido_materno());
            ps.setString(5, cliente.getDireccion());

            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }

    }

    @Override
    public void update(Cliente cliente) throws Exception {
        try {
            this.conectar();

            PreparedStatement ps = this.conn.prepareStatement("UPDATE cliente SET nombres = ?, apellido_paterno = ?, apellido_materno = ?, direccion = ? WHERE CINIT = ?");

            ps.setString(1, cliente.getNombres());
            ps.setString(2, cliente.getApellido_paterno());
            ps.setString(3, cliente.getApellido_materno());
            ps.setString(4, cliente.getDireccion());
            ps.setInt(5, cliente.getCINIT());

            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public void delete(int CINIT) throws Exception {
        try {
            this.conectar();

            PreparedStatement ps = this.conn.prepareStatement("DELETE FROM cliente WHERE CINIT = ?");
            ps.setInt(1, CINIT);

            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public Cliente getById(int CINIT) throws Exception {
        Cliente cli = new Cliente();
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("SELECT * FROM cliente WHERE CINIT = ?");
            ps.setInt(1, CINIT);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                cli.setCINIT(rs.getInt("CINIT"));
                cli.setNombres(rs.getString("nombres"));
                cli.setApellido_paterno(rs.getString("apellido_paterno"));
                cli.setApellido_materno(rs.getString("apellido_materno"));
                cli.setDireccion(rs.getString("direccion"));
            }

        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }

        return cli;
    }

    @Override
    public List<Cliente> getAll() throws Exception {
        List<Cliente> lista = null;
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("SELECT * FROM cliente");

            ResultSet rs = ps.executeQuery();

            lista = new ArrayList<Cliente>();
            while (rs.next()) {
                Cliente cli = new Cliente();

                cli.setCINIT(rs.getInt("CINIT"));
                cli.setNombres(rs.getString("nombres"));
                cli.setApellido_paterno(rs.getString("apellido_paterno"));
                cli.setApellido_materno(rs.getString("apellido_materno"));
                cli.setDireccion(rs.getString("direccion"));

                lista.add(cli);
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
