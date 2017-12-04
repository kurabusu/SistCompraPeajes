/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.duoc.examen.servlet;

import cl.duoc.examen.controlador.CtrlCarretera;
import cl.duoc.examen.modelo.ClassCarretera;
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
@WebServlet(name = "ServletCarreteraGuardar", urlPatterns = {"/ServletCarreteraGuardar"})
public class ServletCarreteraGuardar extends HttpServlet {

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
            /* TODO output your page here. You may use following sample code. */
            RequestDispatcher dispatcher;
            HttpSession session = request.getSession(true);
            
            String nombre = request.getParameter("nombre");
            String costo = request.getParameter("costo");
            
            ClassCarretera cc =  new ClassCarretera();
            cc.setCareNombre(nombre);
            cc.setCareCosto(Integer.parseInt(costo));
            
            CtrlCarretera ctrl = new CtrlCarretera();
            
            boolean b = ctrl.ingresar(cc);
            if(b){
                session.setAttribute("mensaje", "Carreta se guardo correctamente");
                session.setAttribute("tipo", "Carretera");
                session.setAttribute("link", "./carreteraListado.jsp");

                dispatcher = request.getServletContext().getRequestDispatcher("/ventanaMensaje.jsp");
                dispatcher.forward(request, response); 
                
            }else{ 
                session.setAttribute("mensaje", "Carreta no se guardo correctamente");
                session.setAttribute("tipo", "Carretera");
                session.setAttribute("link", "./carreteraAgregar.jsp");
            
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
