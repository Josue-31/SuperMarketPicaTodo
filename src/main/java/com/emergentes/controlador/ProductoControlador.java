package com.emergentes.controlador;

import com.emergentes.dao.personalDAO;
import com.emergentes.dao.personalDAOimpl;
import com.emergentes.dao.productoDAO;
import com.emergentes.dao.productoDAOimpl;
import com.emergentes.modelo.Personal;
import com.emergentes.modelo.Producto;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@MultipartConfig
@WebServlet(name = "ProductoControlador", urlPatterns = {"/ProductoControlador"})
public class ProductoControlador extends HttpServlet {

    //private productoDAO custCtr = new productoDAOimpl();
    private String pathFiles = "C:\\Users\\josue\\Documents\\NetBeansProjects\\supermarket\\src\\main\\webapp\\img\\";
    private File uploads = new File(pathFiles);
    private String[] extens = {".ico", ".png", ".jpg", ".jpeg"};

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            Producto producto = new Producto();
            productoDAO dao = new productoDAOimpl();

            personalDAO daoPersonal = new personalDAOimpl();
            int cod_producto;
            List<Personal> lista_personal = null;
            //sirve para evaluar parametros y que tipo de accion querems realizar
            String action = (request.getParameter("action") != null) ? request.getParameter("action") : "view";
            switch (action) {
                case "add":
                    lista_personal = daoPersonal.getAll();
                    request.setAttribute("lista_personal", lista_personal);
                    request.setAttribute("producto", producto);
                    request.getRequestDispatcher("frmproducto.jsp").forward(request, response);
                    break;
                case "edit":
                    //obtiene el registro
                    cod_producto = Integer.parseInt(request.getParameter("cod_producto"));
                    //lo pone en el objeto per 
                    producto = dao.getById(cod_producto);
                    lista_personal = daoPersonal.getAll();
                    request.setAttribute("lista_personal", lista_personal);
                    request.setAttribute("producto", producto);
                    request.getRequestDispatcher("frmproducto.jsp").forward(request, response);
                    break;
                case "delete":
                    cod_producto = Integer.parseInt(request.getParameter("cod_producto"));
                    dao.delete(cod_producto);
                    response.sendRedirect("ProductoControlador");
                    break;
                case "view":
                    //obtener la lista de objetos osea los registros
                    List<Producto> lista = dao.getAll();
                    //se establece como atributo en una lista
                    request.setAttribute("producto", lista);
                    //se pasa el controll
                    request.getRequestDispatcher("producto.jsp").forward(request, response);
                    break;
            }
        } catch (Exception ex) {
            System.out.println("Error" + ex.getMessage());
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int cod_producto = Integer.parseInt(request.getParameter("cod_producto"));
        int stock = Integer.parseInt(request.getParameter("stock"));
        String tipo = request.getParameter("tipo");
        String fecha_vencimiento = request.getParameter("fecha_vencimiento");
        String fecha_elaboracion = request.getParameter("fecha_elaboracion");
        int id_personal = Integer.parseInt(request.getParameter("id_personal"));
        String nombre_producto = request.getParameter("nombre_producto");
        Part imagen = request.getPart("imagen");
        String estado = request.getParameter("estado");

        Producto per = new Producto();

        per.setCod_producto(cod_producto);
        per.setStock(stock);
        per.setTipo(tipo);
        per.setFecha_vencimiento(convierteFecha(fecha_vencimiento));
        per.setFecha_elaboracion(convierteFecha(fecha_elaboracion));
        per.setId_personal(id_personal);       
        per.setNombre_producto(nombre_producto);
        
        if (isExtension(imagen.getSubmittedFileName(), extens)) {
            String photo = saveFile(imagen, uploads);
            per.setImagen(photo);
            System.out.println("img"+photo);
        }
        per.setEstado(estado);

        
        if (cod_producto == 0) {
            //nuevo registro necesita otra vez el dao
            productoDAO dao = new productoDAOimpl();
            try {
                dao.insert(per);
            } catch (Exception ex) {
                System.out.println("Error al insertar" + ex.getMessage());
            }
        } else {
            //edicion de registro 
            productoDAO dao = new productoDAOimpl();
            try {
                dao.update(per);
            } catch (Exception ex) {
                System.out.println("Error al editar" + ex.getMessage());
            }
        }

        response.sendRedirect(
                "ProductoControlador");

    }

    private String saveFile(Part part, File pathUploads) {
        String pathAbsolute = "";

        try {
            Path path = Paths.get(part.getSubmittedFileName());
            String filename = path.getFileName().toString();
            InputStream input = part.getInputStream();

            if (input != null) {
                //enlazamos la ruta con el nombre del archivo               
                File file = new File(pathUploads, filename);
                //aqui se obtiene la ruta absoluta
                pathAbsolute = file.getAbsolutePath();
                Files.copy(input, file.toPath());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pathAbsolute;
    }

    private boolean isExtension(String fileName, String[] extensions) {
        for (String et : extensions) {
            if (fileName.toLowerCase().endsWith(et)) {
                return true;
            }
        }
        return false;
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
