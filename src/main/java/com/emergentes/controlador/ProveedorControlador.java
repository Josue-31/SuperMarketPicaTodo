package com.emergentes.controlador;

import com.emergentes.dao.proveedorDAO;
import com.emergentes.dao.proveedorDAOimpl;
import com.emergentes.modelo.Proveedores;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "ProveedorControlador", urlPatterns = {"/ProveedorControlador"})
public class ProveedorControlador extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            Proveedores pro = new Proveedores();
            proveedorDAO dao = new proveedorDAOimpl();
            int nit;
            //sirve para evaluar parametros y que tipo de accion querems realizar
            String action = (request.getParameter("action") != null) ? request.getParameter("action") : "view";
            switch (action) {
                case "add":
                    request.setAttribute("proveedores", pro);
                    request.getRequestDispatcher("frmproveedor.jsp").forward(request, response);
                    break;
                case "edit":
                    //obtiene el registro
                    nit = Integer.parseInt(request.getParameter("nit"));
                    //lo pone en el objeto cli
                    pro = dao.getById(nit);
                    request.setAttribute("proveedores", pro);
                    request.getRequestDispatcher("frmproveedor.jsp").forward(request, response);
                    break;
                case "delete":
                    nit = Integer.parseInt(request.getParameter("nit"));
                    dao.delete(nit);
                    response.sendRedirect("ProveedorControlador");
                    break;
                case "view":
                    //obtener la lista de objetos osea los registros
                    List<Proveedores> lista = dao.getAll();
                    //se establece como atributo en una lista
                    request.setAttribute("proveedor", lista);
                    //se pasa el controll
                    request.getRequestDispatcher("proveedores.jsp").forward(request, response);
                    break;

            }
        } catch (Exception ex) {
            System.out.println("Error" + ex.getMessage());
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int nit = Integer.parseInt(request.getParameter("nit"));
        String nombre = request.getParameter("nombre");
        String nro_telefono = request.getParameter("nro_telefono");       
        String direccion = request.getParameter("direccion");

        Proveedores prov = new Proveedores();

        prov.setNit(nit);
        prov.setNombre(nombre);
        prov.setNro_telefono(nro_telefono);
        prov.setDireccion(direccion);
        proveedorDAO dao = new proveedorDAOimpl();
        if (nit == 0) {
            //nuevo registro necesita otra vez el dao
            try {
                dao.insert(prov);
            } catch (Exception ex) {
                System.out.println("Error al insertar" + ex.getMessage());
            }
        } else {
            //edicion de registro 
            try {
                dao.update(prov);
            } catch (Exception ex) {
                System.out.println("Error al editar" + ex.getMessage());
            }
        }
        response.sendRedirect("ProveedorControlador");
    }

}
