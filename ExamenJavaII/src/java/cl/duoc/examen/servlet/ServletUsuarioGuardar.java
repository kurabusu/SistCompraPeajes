/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.duoc.examen.servlet;

import cl.duoc.examen.controlador.CtrlUsuario;
import cl.duoc.examen.modelo.ClassUsuario;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author 
 */
@WebServlet(name = "ServletUsuarioGuardar", urlPatterns = {"/ServletUsuarioGuardar"})
public class ServletUsuarioGuardar extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            RequestDispatcher dispatcher;
            HttpSession session = request.getSession(true);
            
            /* TODO output your page here. You may use following sample code. */
            String nombre = request.getParameter("nombre");
            String usuario = request.getParameter("usuario");
            String clave = request.getParameter("clave");
            
            ClassUsuario us =  new ClassUsuario();
            us.setUsuNombre(nombre);
            us.setUsuUsuario(usuario);
            us.setUsuClave(clave);
            
            CtrlUsuario ctrl = new CtrlUsuario();
            boolean b = ctrl.ingresar(us);
            if(b){ 
                session.setAttribute("mensaje", "Usuario se guardo correctamente");
                session.setAttribute("tipo", "Usuario");
                session.setAttribute("link", "./usuarioListado.jsp");
            
                dispatcher = request.getServletContext().getRequestDispatcher("/ventanaMensaje.jsp");
                dispatcher.forward(request, response);
            }else{
                session.setAttribute("mensaje", "Usuario no se guardo correctamente");
                session.setAttribute("tipo", "Usuario");
                session.setAttribute("link", "./usuarioAgregar.jsp");
            
                dispatcher = request.getServletContext().getRequestDispatcher("/ventanaMensaje.jsp");
                dispatcher.forward(request, response);
            }
            
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
