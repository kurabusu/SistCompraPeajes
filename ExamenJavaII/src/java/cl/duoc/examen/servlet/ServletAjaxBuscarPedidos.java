/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.duoc.examen.servlet;

import cl.duoc.examen.controlador.CtrlCompra;
import cl.duoc.examen.controlador.CtrlEmpresa;
import cl.duoc.examen.modelo.ClassCompra;
import cl.duoc.examen.modelo.ClassEmpresa;
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
 * @author jose tolosa
 */
@WebServlet(name = "ServletAjaxBuscarPedidos", urlPatterns = {"/ServletAjaxBuscarPedidos"})
public class ServletAjaxBuscarPedidos extends HttpServlet {

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
            
            String rut =  request.getParameter("rut");
             
            if(rut != null){
                CtrlEmpresa ctrle = new CtrlEmpresa();
                List<ClassEmpresa> le = ctrle.obtenerLista(new ClassEmpresa(0, rut, null, null)); 
                
                if(le.size() > 0){
                    CtrlCompra ctrl = new CtrlCompra();
                    ClassCompra c = new ClassCompra();
                    c.setEmpId(le.get(0).getEmpId());
                    
                    List<ClassCompra> lista = ctrl.obtenerLista(c);
                    int i = 0;
                    out.println("[");
                    for (ClassCompra classCompra : lista) {
                        if(i > 0) out.println(",");
                        
                        out.println(classCompra.toStringListaCorta()); 
                        i++;
                    }
                    out.println("]");
                    
                }else{
                     out.println("{\"error\": \"Rut no encontrado\"}");
                }
                
                
                
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
