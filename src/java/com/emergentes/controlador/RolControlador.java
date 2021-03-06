package com.emergentes.controlador;

import com.emergentes.dao.RolDAO;
import com.emergentes.dao.RolDAOimple;
import com.emergentes.modelo.Rol;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "RolControlador", urlPatterns = {"/RolControlador"})
public class RolControlador extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       try {
            Rol rols = new Rol();
            int id;
            RolDAO dao = new RolDAOimple();
            String action = (request.getParameter("action") != null) ? request.getParameter("action") : "view";

            switch (action) {
                case "add":
                    request.setAttribute("rol", rols);
                    request.getRequestDispatcher("frmrol.jsp").forward(request, response);
                    break;
                case "edit":
                    id = Integer.parseInt(request.getParameter("id"));
                    rols = dao.getById(id);
                    request.setAttribute("rol", rols);
                    request.getRequestDispatcher("frmrol.jsp").forward(request, response);
                    break;
                case "delete":
                    id = Integer.parseInt(request.getParameter("id"));
                    dao.delete(id);
                    response.sendRedirect("RolControlador");
                    break;
                case "view":
                    List<Rol> lista = dao.getAll();
                    request.setAttribute("roles", lista);
                    request.getRequestDispatcher("rol.jsp").forward(request, response);
                    break;
            }

        } catch (Exception ex) {
            System.out.println("Error " + ex.getMessage());
        }
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String descripcion= request.getParameter("descripcion");
        
        Rol rol = new Rol();
        
        rol.setId(id);
        rol.setDescripcion(descripcion);
        
        RolDAO dao = new RolDAOimple();
        if (id == 0){
            try {
                // Nuevo registro
                dao.insert(rol);
            } catch (Exception ex) {
                System.out.println("Error al insertar "+ex.getMessage());
            }
        }
        else{
            try {
                // Edicion de registro
                dao.update(rol);
            } catch (Exception ex) {
                System.out.println("Error al editar "+ex.getMessage());
            }
        }
        response.sendRedirect("RolControlador");
    }

}
