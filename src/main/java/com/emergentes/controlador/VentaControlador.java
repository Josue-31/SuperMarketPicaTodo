
package com.emergentes.controlador;

import com.emergentes.dao.clienteDAO;
import com.emergentes.dao.clienteDAOimpl;
import com.emergentes.dao.fac_venDAO;
import com.emergentes.dao.fac_venDAOimpl;
import com.emergentes.modelo.Cliente;
import com.emergentes.modelo.Factura_venta;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "VentaControlador", urlPatterns = {"/VentaControlador"})
public class VentaControlador extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            Factura_venta venta = new Factura_venta();
            fac_venDAO dao = new fac_venDAOimpl();

            clienteDAO daoCliente = new clienteDAOimpl();
            int nro_factura;
            List<Cliente> lista_cliente = null;
            //sirve para evaluar parametros y que tipo de accion querems realizar
            String action = (request.getParameter("action") != null) ? request.getParameter("action") : "view";
            switch (action) {
                case "add":
                    lista_cliente = daoCliente.getAll();
                    request.setAttribute("lista_cliente", lista_cliente);
                    request.setAttribute("venta", venta);
                    request.getRequestDispatcher("frmventa.jsp").forward(request, response);
                    break;
                case "edit":
                    //obtiene el registro
                    nro_factura = Integer.parseInt(request.getParameter("nro_factura"));
                    //lo pone en el objeto per 
                    venta = dao.getById(nro_factura);
                    lista_cliente = daoCliente.getAll();
                    request.setAttribute("lista_cliente", lista_cliente);
                    request.setAttribute("venta", venta);
                    request.getRequestDispatcher("frmventa.jsp").forward(request, response);
                    break;
                case "total":
                    nro_factura = Integer.parseInt(request.getParameter("nro_factura"));
                    dao.total(nro_factura);
                    response.sendRedirect("VentaControlador");
                    break;
                case "view":
                    //obtener la lista de objetos osea los registros
                    List<Factura_venta> lista = dao.getAll();
                    //se establece como atributo en una lista
                    request.setAttribute("ventas", lista);
                    //se pasa el controll
                    request.getRequestDispatcher("ventas.jsp").forward(request, response);
                    break;
            }
        } catch (Exception ex) {
            System.out.println("Error" + ex.getMessage());
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int nro_factura = Integer.parseInt(request.getParameter("nro_factura"));
        String fecha_venta = request.getParameter("fecha_venta");       
        int ci_nit = Integer.parseInt(request.getParameter("ci_nit"));
        //double total = Double.parseDouble(request.getParameter("total"));

        Factura_venta fv = new Factura_venta();

        fv.setNro_factura(nro_factura);
        fv.setFecha_venta(convierteFecha(fecha_venta));
        fv.setCi_nit(ci_nit);
        //fv.setTotal(total);      
        
        if (nro_factura == 0) {
            //nuevo registro necesita otra vez el dao
            fac_venDAO dao = new fac_venDAOimpl();
            try {
                dao.insert(fv);
            } catch (Exception ex) {
                System.out.println("Error al insertar" + ex.getMessage());
            }
        } else {
            //edicion de registro 
            fac_venDAO dao = new fac_venDAOimpl();
            try {
                dao.update(fv);
            } catch (Exception ex) {
                System.out.println("Error al editar" + ex.getMessage());
            }
        }
        response.sendRedirect("VentaControlador");
    }
    
    public Date convierteFecha(String fecha) {
        Date fechaBD = null;
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");

        java.util.Date fechaTMP;
        try {
            fechaTMP = formato.parse(fecha);
            fechaBD = new Date(fechaTMP.getTime());

        } catch (ParseException ex) {
            Logger.getLogger(ProductoControlador.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        return fechaBD;
    }
}
