package com.emergentes.controlador;

import com.emergentes.dao.cargoDAO;
import com.emergentes.dao.cargoDAOimpl;
import com.emergentes.dao.personalDAO;
import com.emergentes.dao.personalDAOimpl;
import com.emergentes.modelo.Cargo;
import com.emergentes.modelo.Personal;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "PersonalControlador", urlPatterns = {"/PersonalControlador"})
public class PersonalControlador extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            Personal personal = new Personal();
            personalDAO dao = new personalDAOimpl();

            cargoDAO daoCargo = new cargoDAOimpl();
            int id_personal;
            List<Cargo> lista_cargo = null;
            //sirve para evaluar parametros y que tipo de accion querems realizar
            String action = (request.getParameter("action") != null) ? request.getParameter("action") : "view";
            switch (action) {
                case "add":
                    lista_cargo = daoCargo.getAll();
                    request.setAttribute("lista_cargo", lista_cargo);
                    request.setAttribute("personal", personal);
                    request.getRequestDispatcher("frmpersonal.jsp").forward(request, response);
                    break;
                case "edit":
                    //obtiene el registro
                    id_personal = Integer.parseInt(request.getParameter("id_personal"));
                    //lo pone en el objeto per 
                    personal = dao.getById(id_personal);
                    lista_cargo = daoCargo.getAll();
                    request.setAttribute("lista_cargo", lista_cargo);
                    request.setAttribute("personal", personal);
                    request.getRequestDispatcher("frmpersonal.jsp").forward(request, response);
                    break;
                case "delete":
                    id_personal = Integer.parseInt(request.getParameter("id_personal"));
                    dao.delete(id_personal);
                    response.sendRedirect("PersonalControlador");
                    break;
                case "view":
                    //obtener la lista de objetos osea los registros
                    List<Personal> lista = dao.getAll();
                    //se establece como atributo en una lista
                    request.setAttribute("personal", lista);
                    //se pasa el controll
                    request.getRequestDispatcher("personal.jsp").forward(request, response);
                    break;
            }
        } catch (Exception ex) {
            System.out.println("Error" + ex.getMessage());
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id_personal = Integer.parseInt(request.getParameter("id_personal"));
        String nombres_personal = request.getParameter("nombres_personal");
        String usuario = request.getParameter("usuario");
        String password = request.getParameter("password");
        String celular = request.getParameter("celular");
        String direccion = request.getParameter("direccion");
        int cod_cargo = Integer.parseInt(request.getParameter("cod_cargo"));
        String estado = request.getParameter("estado");

        Personal per = new Personal();

        per.setId_personal(id_personal);
        per.setNombres_personal(nombres_personal);
        per.setUsuario(usuario);
        per.setPassword(password);
        per.setCelular(celular);
        per.setDireccion(direccion);
        per.setCod_cargo(cod_cargo);
        per.setEstado(estado);
        
        if (id_personal == 0) {
            //nuevo registro necesita otra vez el dao
            personalDAO dao = new personalDAOimpl();
            try {
                dao.insert(per);
            } catch (Exception ex) {
                System.out.println("Error al insertar" + ex.getMessage());
            }
        } else {
            //edicion de registro 
            personalDAO dao = new personalDAOimpl();
            try {
                dao.update(per);
            } catch (Exception ex) {
                System.out.println("Error al editar" + ex.getMessage());
            }
        }
        response.sendRedirect("PersonalControlador");
    }

}
