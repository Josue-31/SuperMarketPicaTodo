package com.emergentes.controlador;

import com.emergentes.dao.detalle_comDAO;
import com.emergentes.dao.detalle_comDAOimpl;
import com.emergentes.dao.fac_comDAO;
import com.emergentes.dao.fac_comDAOimpl;
import com.emergentes.dao.productoDAO;
import com.emergentes.dao.productoDAOimpl;
import com.emergentes.modelo.Detalle_compra;
import com.emergentes.modelo.Factura_compra;
import com.emergentes.modelo.Producto;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Detalle_compraControlador", urlPatterns = {"/Detalle_compraControlador"})
public class Detalle_compraControlador extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            //coleccion que tenga las vistas o la informacion 
            detalle_comDAO dao = new detalle_comDAOimpl();
            productoDAO daoProducto = new productoDAOimpl();
            fac_comDAO daoFactura = new fac_comDAOimpl();

            int id;
            int id_factura;
            int cod_producto;
            //ultilizamos las listas
            List<Producto> lista_productos = null;
            List<Factura_compra> lista_factura = null;

            //un objeto venta
            Detalle_compra compras = new Detalle_compra();

            //sirve para evaluar parametros y que tipo de accion querems realizar
            String action = (request.getParameter("action") != null) ? request.getParameter("action") : "view";
            switch (action) {
                case "add":
                    //mandar datos de los clientes 
                    lista_productos = daoProducto.getAll();
                    lista_factura = daoFactura.getAll();
                    request.setAttribute("lista_factura", lista_factura);
                    request.setAttribute("lista_productos", lista_productos);
                    request.setAttribute("compras", compras);
                    request.getRequestDispatcher("frmdetallecompra.jsp").forward(request, response);
                    break;
                case "edit":
                    //mandar datos de los clientes 
                    id = Integer.parseInt(request.getParameter("id"));
                    compras = dao.getById(id);
                    lista_productos = daoProducto.getAll();
                    lista_factura = daoFactura.getAll();
                    request.setAttribute("lista_factura", lista_factura);
                    request.setAttribute("lista_productos", lista_productos);
                    request.setAttribute("compras", compras);
                    request.getRequestDispatcher("frmdetallecompra.jsp").forward(request, response);
                    break;
                case "delete":
                    id = Integer.parseInt(request.getParameter("id"));
                    dao.delete(id);
                    response.sendRedirect("CompraControlador");
                    break;
                case "update_stock":
                    id_factura = Integer.parseInt(request.getParameter("id_factura"));
                    cod_producto = Integer.parseInt(request.getParameter("cod_producto"));
                    dao.update_stock(id_factura, cod_producto);
                    response.sendRedirect("CompraControlador");
                    break;
                                       
                case "view":
                    id_factura = Integer.parseInt(request.getParameter("id_factura"));
                    //obtener la lista de objetos osea los registros
                    List<Detalle_compra> lista = dao.getAll(id_factura);
                    //se pone como atributo de compras en una lista
                    request.setAttribute("compras", lista);
                    //se pasa el controll
                    request.getRequestDispatcher("detalle_compra.jsp").forward(request, response);
                    break;

            }
        } catch (Exception ex) {
            System.out.println("Error" + ex.getMessage());
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        double precio = Double.parseDouble(request.getParameter("precio"));
        int cantidad = Integer.parseInt(request.getParameter("cantidad"));
        String observaciones = request.getParameter("observaciones");
        int cod_producto = Integer.parseInt(request.getParameter("cod_producto"));
        int id_factura = Integer.parseInt(request.getParameter("id_factura"));

        Detalle_compra dc = new Detalle_compra();

        dc.setId(id);
        dc.setPrecio(precio);
        dc.setCantidad(cantidad);
        dc.setObservaciones(observaciones);
        dc.setCod_producto(cod_producto);
        dc.setId_factura(id_factura);

        if (id == 0) {
            //nuevo registro necesita otra vez el dao
            detalle_comDAO dao = new detalle_comDAOimpl();
            try {
                dao.insert(dc);
            } catch (Exception ex) {
                System.out.println("Error al insertar" + ex.getMessage());
            }
        } else {
            //edicion de registro 
            detalle_comDAO dao = new detalle_comDAOimpl();
            try {
                dao.update(dc);
            } catch (Exception ex) {
                System.out.println("Error al editar" + ex.getMessage());
            }
        }
        response.sendRedirect("CompraControlador");
    }

}
