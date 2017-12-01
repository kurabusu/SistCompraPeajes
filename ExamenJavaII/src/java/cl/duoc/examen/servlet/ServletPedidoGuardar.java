/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.duoc.examen.servlet;

import cl.duoc.examen.controlador.CtrlCompra;
import cl.duoc.examen.controlador.CtrlCompraCarretera;
import cl.duoc.examen.modelo.ClassCompra;
import cl.duoc.examen.modelo.ClassCompraCarretera;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author jose tolosa
 */
@WebServlet(name = "ServletPedidoGuardar", urlPatterns = {"/ServletPedidoGuardar"})
public class ServletPedidoGuardar extends HttpServlet {

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
            CtrlCompra ctrl =  new CtrlCompra();
            CtrlCompraCarretera ctrlCcc = new CtrlCompraCarretera();
            
            ClassCompra cc = new ClassCompra();
            ClassCompraCarretera ccc = new ClassCompraCarretera();
            
            
            String idE = request.getParameter("idE");
            String comprador = request.getParameter("comprador");
            String optPago = request.getParameter("optPago");
            String optRetiro = request.getParameter("optRetiro");
            String total = request.getParameter("precioTotal");
            
            cc.setEmpId(Integer.parseInt(idE));
            cc.setCompradorPor(comprador);
            cc.setOpcionPago(Integer.parseInt(optPago));
            cc.setOpcionRetiro(Integer.parseInt(optRetiro));
            cc.setTotal(Integer.parseInt(total));
            
            int idCompra = ctrl.ingresar(cc); 
            
            String[] carreteras = request.getParameterValues("carreteras");
            String[] cantidades = request.getParameterValues("cantidades");
            
            for (int i = 0; i < carreteras.length; i++) {
                String idCare = carreteras[i];
                String cant = cantidades[i];
                ccc = new ClassCompraCarretera();
                
                ccc.setCarreteraId(Integer.parseInt(idCare));
                ccc.setCompraId(idCompra);
                ccc.setCantidad(Integer.parseInt(cant));
                ccc.setTotal(0);
                ctrlCcc.ingresar(ccc);
            }
            
            
            if(idCompra > 0){
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
