
package com.emergentes.controlador;

import com.emergentes.dao.detalle_venDAO;
import com.emergentes.dao.detalle_venDAOimpl;
import com.emergentes.dao.fac_venDAO;
import com.emergentes.dao.fac_venDAOimpl;
import com.emergentes.dao.productoDAO;
import com.emergentes.dao.productoDAOimpl;
import com.emergentes.modelo.Detalle_venta;
import com.emergentes.modelo.Factura_venta;
import com.emergentes.modelo.Producto;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author josue
 */
@WebServlet(name = "Detalle_ventaControlador", urlPatterns = {"/Detalle_ventaControlador"})
public class Detalle_ventaControlador extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            //coleccion que tenga las vistas o la informacion 
            detalle_venDAO dao = new detalle_venDAOimpl();
            productoDAO daoProducto = new productoDAOimpl();
            fac_venDAO daoFactura = new fac_venDAOimpl();
            
            int id_v;
            int nro_factura;
            int cod_producto;
            //ultilizamos las listas
            List<Producto> lista_productos = null;
            List<Factura_venta> lista_factura = null;

            //un objeto venta
            Detalle_venta ventas = new Detalle_venta();

            //sirve para evaluar parametros y que tipo de accion querems realizar
            String action = (request.getParameter("action") != null) ? request.getParameter("action") : "view";
            switch (action) {
                case "add":
                    //mandar datos de los clientes 
                    lista_productos = daoProducto.getAll();
                    lista_factura = daoFactura.getAll();
                    request.setAttribute("lista_factura", lista_factura);
                    request.setAttribute("lista_productos", lista_productos);
                    request.setAttribute("ventas", ventas);
                    request.getRequestDispatcher("frmdetalle.jsp").forward(request, response);
                    break;
                case "edit":
                    //mandar datos de los clientes 
                    id_v = Integer.parseInt(request.getParameter("id_v"));
                    ventas = dao.getById(id_v);
                    lista_productos = daoProducto.getAll();
                    lista_factura = daoFactura.getAll();
                    request.setAttribute("lista_factura", lista_factura);
                    request.setAttribute("lista_productos", lista_productos);
                    request.setAttribute("ventas", ventas);
                    request.getRequestDispatcher("frmdetalle.jsp").forward(request, response);
                    break;
                case "delete":
                    id_v = Integer.parseInt(request.getParameter("id_v"));
                    dao.delete(id_v);
                    response.sendRedirect("VentaControlador");
                    break;
                case "update_stock":
                    nro_factura = Integer.parseInt(request.getParameter("nro_factura"));
                    cod_producto = Integer.parseInt(request.getParameter("cod_producto"));
                    dao.update_stock(nro_factura, cod_producto);
                    response.sendRedirect("VentaControlador");
                    break;    
                case "view":
                    nro_factura = Integer.parseInt(request.getParameter("nro_factura"));
                    //obtener la lista de objetos osea los registros
                    List<Detalle_venta> lista = dao.getAll(nro_factura);
                    //se pone como atributo de cliente en una lista
                    request.setAttribute("ventas", lista);
                    //se pasa el controll
                    request.getRequestDispatcher("detalle_venta.jsp").forward(request, response);
                    break;

            }
        } catch (Exception ex) {
            System.out.println("Error" + ex.getMessage());
        }
    }

 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id_v = Integer.parseInt(request.getParameter("id_v"));
        double precio = Double.parseDouble(request.getParameter("precio"));
        int cantidad = Integer.parseInt(request.getParameter("cantidad"));
        String detalle = request.getParameter("detalle");
        int cod_producto = Integer.parseInt(request.getParameter("cod_producto"));
        int nro_factura = Integer.parseInt(request.getParameter("nro_factura"));      
     
        Detalle_venta dv = new Detalle_venta();

        dv.setId_v(id_v);
        dv.setPrecio(precio);
        dv.setCantidad(cantidad);
        dv.setDetalle(detalle);
        dv.setCod_producto(cod_producto);
        dv.setNro_factura(nro_factura);
        
        
        if (id_v == 0) {
            //nuevo registro necesita otra vez el dao
            detalle_venDAO dao = new detalle_venDAOimpl();
            try {
                dao.insert(dv);
            } catch (Exception ex) {
                System.out.println("Error al insertar" + ex.getMessage());
            }
        } else {
            //edicion de registro 
            detalle_venDAO dao = new detalle_venDAOimpl();
            try {
                dao.update(dv);
            } catch (Exception ex) {
                System.out.println("Error al editar" + ex.getMessage());
            }
        }
        response.sendRedirect("VentaControlador");
    }

}
