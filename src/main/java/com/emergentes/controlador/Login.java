package com.emergentes.controlador;

import com.emergentes.utiles.ConexionDB;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "Login", urlPatterns = {"/Login"})
public class Login extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.sendRedirect("index.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {

            //obtenemos parametros 
            String usuario = request.getParameter("usuario");
            String password = request.getParameter("password");

            ResultSet rs;
            //consulta sql
            String sql = "select * from personal where usuario = ? and password = sha1(?)";
            //creacmos conexion
            ConexionDB canal = new ConexionDB();
            Connection cn = canal.conectar();

            //preparamos la conssulta
            PreparedStatement ps = cn.prepareStatement(sql);

            ps.setString(1, usuario);
            ps.setString(2, password);

            rs = ps.executeQuery();
            //Integer cod_cargo = null;           
            if (rs.next()) {
                HttpSession ses = request.getSession();
                ses.setAttribute("login", "OK");
                ses.setAttribute("personal", rs.getString("nombres_personal"));
                ses.setAttribute("estado", rs.getString("estado"));
                ses.setAttribute("codigo", rs.getInt("cod_cargo"));
                
                response.sendRedirect("VentaControlador");

            } else {
                response.sendRedirect("login.jsp");
            }
        } catch (SQLException ex) {
            System.out.println("Error al conectar  a la base de datos" + ex.getMessage());
        }

    }

}
