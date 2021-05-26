package com.emergentes.controlador;

import com.emergentes.dao.UsuarioDAO;
import com.emergentes.dao.UsuarioDAOimple;
import com.emergentes.dao.RolDAO;
import com.emergentes.dao.RolDAOimple;
import com.emergentes.dao.PermisoDAO;
import com.emergentes.dao.PermisoDAOimple;
import com.emergentes.modelo.Usuario;
import com.emergentes.modelo.Rol;
import com.emergentes.modelo.Permiso;
import java.util.List;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "PermisoControlador", urlPatterns = {"/PermisoControlador"})
public class PermisoControlador extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       try{
            PermisoDAO dao = new PermisoDAOimple();
            RolDAO daoRol = new RolDAOimple();
            UsuarioDAO daoUsuario = new UsuarioDAOimple();
            int id;
            
            List<Usuario> lista_usuarios = null;
            List<Rol> lista_roles = null;
            
            Permiso per = new Permiso();
            
            String action = (request.getParameter("action") != null) ? request.getParameter("action") : "view";
            System.out.println("Opcion = "+ action);
            switch(action){
                case "add":
                    lista_roles = daoRol.getAll();
                    lista_usuarios = daoUsuario.getAll();
                    request.setAttribute("lista_roles", lista_roles);
                    request.setAttribute("lista_usuarios", lista_usuarios);
                    request.setAttribute("permiso", per);
                    request.getRequestDispatcher("frmpermisos.jsp").forward(request, response);
                    break;
                case "edit":
                    id = Integer.parseInt(request.getParameter("id"));
                    per = dao.getById(id);
                    lista_roles = daoRol.getAll();
                    lista_usuarios = daoUsuario.getAll();
                    request.setAttribute("lista_productos", lista_roles);
                    request.setAttribute("lista_clientes", lista_usuarios);
                    request.setAttribute("permiso",per);
                    request.getRequestDispatcher("frmpermisos.jsp").forward(request, response);
                    break;
                case "delete":
                    id = Integer.parseInt(request.getParameter("id"));
                    dao.delete(id);
                    response.sendRedirect("PermisoControlador");
                    break;
                case "view":
                    List<Permiso> lista = dao.getAll();
                    request.setAttribute("permisos", lista);
                    request.getRequestDispatcher("permisos.jsp").forward(request, response);
                    break;
            }
        }catch(Exception ex){
            System.out.println("Error fatal " + ex.getMessage());
        }
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        int id_usuario = Integer.parseInt(request.getParameter("id_usuario"));
        int id_rol = Integer.parseInt(request.getParameter("id_rol"));
        String fecha = request.getParameter("fecha");
        
        Permiso venta = new Permiso();
        
        venta.setId(id);
        venta.setId_rol(id_rol);
        venta.setId_usuario(id_usuario);
        
        if(id == 0){
            // Nuevo
            PermisoDAO dao = new PermisoDAOimple();
            try {
                dao.insert(venta);
                response.sendRedirect("PermisoControlador");
            } catch (Exception ex) {
                System.out.println("Error al insertar "+ex.getMessage());
            }
        }
        else{
            //Editar
            PermisoDAO dao = new PermisoDAOimple();
            try {
                dao.update(venta);
                response.sendRedirect("VentaControlador");
            } catch (Exception ex) {
                System.out.println("Error al editar "+ex.getMessage());
            }            
        }
        response.sendRedirect("PermisoControlador");
    }

}
