package com.emergentes.controlador;

import com.emergentes.dao.clienteDAO;
import com.emergentes.dao.clienteDAOimpl;
import com.emergentes.modelo.Cliente;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ClienteControlador", urlPatterns = {"/ClienteControlador"})
public class ClienteControlador extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            Cliente cliente = new Cliente();
            clienteDAO dao = new clienteDAOimpl();
            int CINIT;
            //sirve para evaluar parametros y que tipo de accion querems realizar
            String action = (request.getParameter("action") != null) ? request.getParameter("action") : "view";
            switch (action) {
                case "add":
                    request.setAttribute("cliente", cliente);
                    request.getRequestDispatcher("login_cliente.jsp").forward(request, response);
                    break;
                case "edit":
                    //obtiene el registro
                    CINIT = Integer.parseInt(request.getParameter("CINIT"));
                    //lo pone en el objeto cli
                    cliente = dao.getById(CINIT);
                    request.setAttribute("cliente", cliente);
                    request.getRequestDispatcher("frmcliente.jsp").forward(request, response);
                    break;
                case "delete":
                    CINIT = Integer.parseInt(request.getParameter("CINIT"));
                    dao.delete(CINIT);
                    response.sendRedirect("ClienteControlador");
                    break;
                case "view":
                    //obtener la lista de objetos osea los registros
                    List<Cliente> lista = dao.getAll();
                    //se pone como atributo de cliente en una lista
                    request.setAttribute("clientes", lista);
                    //se pasa el controll
                    request.getRequestDispatcher("clientes.jsp").forward(request, response);
                    break;

            }
        } catch (Exception ex) {
            System.out.println("Error" + ex.getMessage());
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int CINIT = Integer.parseInt(request.getParameter("CINIT"));
        String nombres = request.getParameter("nombres");
        String apellido_paterno = request.getParameter("apellido_paterno");
        String apellido_materno = request.getParameter("apellido_materno");
        String direccion = request.getParameter("direccion");

        Cliente cli = new Cliente();

        cli.setCINIT(CINIT);
        cli.setNombres(nombres);
        cli.setApellido_paterno(apellido_paterno);
        cli.setApellido_materno(apellido_materno);
        cli.setDireccion(direccion);
        
        if (CINIT == 0) {
            clienteDAO dao = new clienteDAOimpl();
            //nuevo registro necesita otra vez el dao
            try {
                dao.insert(cli);
            } catch (Exception ex) {
                System.out.println("Error al insertar" + ex.getMessage());
            }
            response.sendRedirect("Login");
        } else {
            clienteDAO dao = new clienteDAOimpl();
            //edicion de registro 
            try {
                dao.update(cli);
            } catch (Exception ex) {
                System.out.println("Error al editar" + ex.getMessage());
            }
            response.sendRedirect("ClienteControlador");
        }
        
    }

}