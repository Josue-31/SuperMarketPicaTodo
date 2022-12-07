package com.emergentes.controlador;

import com.emergentes.dao.fac_comDAO;
import com.emergentes.dao.fac_comDAOimpl;
import com.emergentes.dao.proveedorDAO;
import com.emergentes.dao.proveedorDAOimpl;
import com.emergentes.modelo.Factura_compra;
import com.emergentes.modelo.Proveedores;
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

@WebServlet(name = "CompraControlador", urlPatterns = {"/CompraControlador"})
public class CompraControlador extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            Factura_compra compra = new Factura_compra();
            fac_comDAO dao = new fac_comDAOimpl();

            proveedorDAO daoProveedor = new proveedorDAOimpl();
            int id_factura;
            List<Proveedores> lista_proveedor = null;
            //sirve para evaluar parametros y que tipo de accion querems realizar
            String action = (request.getParameter("action") != null) ? request.getParameter("action") : "view";
            switch (action) {
                case "add":
                    lista_proveedor = daoProveedor.getAll();
                    request.setAttribute("lista_proveedor", lista_proveedor);
                    request.setAttribute("compra", compra);
                    request.getRequestDispatcher("frmcompra.jsp").forward(request, response);
                    break;
                case "edit":
                    //obtiene el registro
                    id_factura = Integer.parseInt(request.getParameter("id_factura"));
                    //lo pone en el objeto per 
                    compra = dao.getById(id_factura);
                    lista_proveedor = daoProveedor.getAll();
                    request.setAttribute("lista_proveedor", lista_proveedor);
                    request.setAttribute("compra", compra);
                    request.getRequestDispatcher("frmcompra.jsp").forward(request, response);
                    break;
                case "total":
                    id_factura = Integer.parseInt(request.getParameter("id_factura"));
                    dao.total(id_factura);
                    response.sendRedirect("CompraControlador");
                    break;
                case "view":
                    //obtener la lista de objetos osea los registros
                    List<Factura_compra> lista = dao.getAll();
                    //se establece como atributo en una lista
                    request.setAttribute("compra", lista);
                    //se pasa el controll
                    request.getRequestDispatcher("compras.jsp").forward(request, response);
                    break;
            }
        } catch (Exception ex) {
            System.out.println("Error" + ex.getMessage());
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id_factura = Integer.parseInt(request.getParameter("id_factura"));
        String fecha_compra = request.getParameter("fecha_compra");       
        int nit = Integer.parseInt(request.getParameter("nit"));
        //double total = Double.parseDouble(request.getParameter("total"));
        int nro_factura = Integer.parseInt(request.getParameter("nro_factura"));
       

        Factura_compra fc = new Factura_compra();
        
        fc.setId_factura(id_factura);
        fc.setFecha_compra(convierteFecha(fecha_compra));
        fc.setNit(nit);
        fc.setNro_factura(nro_factura);
             
        
        if (id_factura == 0) {
            //nuevo registro necesita otra vez el dao
            fac_comDAO dao = new fac_comDAOimpl();
            try {
                dao.insert(fc);
            } catch (Exception ex) {
                System.out.println("Error al insertar" + ex.getMessage());
            }
        } else {
            //edicion de registro 
            fac_comDAO dao = new fac_comDAOimpl();
            try {
                dao.update(fc);
            } catch (Exception ex) {
                System.out.println("Error al editar" + ex.getMessage());
            }
        }
        response.sendRedirect("CompraControlador");
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
