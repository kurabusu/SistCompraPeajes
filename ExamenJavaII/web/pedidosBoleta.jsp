<%-- 
    Document   : pedidosBoleta
    Created on : 01-12-2017, 3:07:17
    Author     : jose tolosa
--%><%@page import="cl.duoc.examen.modelo.ClassCompraCarretera"%>
<%@page import="java.util.List"%>
<%@page import="cl.duoc.examen.modelo.ClassCompra"%>
<%@page import="cl.duoc.examen.modelo.ClassEmpresa"%>
<%@page import="cl.duoc.examen.controlador.CtrlEmpresa"%>
<%@page import="cl.duoc.examen.controlador.CtrlCompraCarretera"%>
<%@page import="cl.duoc.examen.controlador.CtrlCompra"%>
    +
<%@include file="estructura/header.jsp" %>
<%
    String rId = (String)request.getParameter("id");
    if(rId == null){
        response.sendRedirect("pedidosListado.jsp");
    }
    int id = Integer.parseInt(request.getParameter("id"));
    
    CtrlCompra ctrlc = new CtrlCompra();
    CtrlEmpresa ctrle = new CtrlEmpresa();
    CtrlCompraCarretera  ctrlcc = new CtrlCompraCarretera();

    ClassCompra  cc = ctrlc.obtener(id);
    List<ClassCompraCarretera> lce = ctrlcc.obtenerLista(cc.getComId());   
%>
<div class="row">
    <div class="col">
        <h1 class="h1">Pedido Número: <%=cc.getComId() %></h1>
    </div>
</div>

<div class="row">
    <div class="col-6 text-center">
        <p>Comprador: <%=cc.getCompradorPor()%></p>
    </div>
    <div class="w-100"></div>
    
    <div class="col-6 text-center">
        <table class="table">
            <thead>
                <tr>
                    <th>Carretera</th>
                    <th>Cantidad</th>
                </tr>
            </thead>
            <tbody>
                <% for (ClassCompraCarretera ccc : lce) { %>
                <tr>
                    <td><%=ccc.getCarreteraNombre() %></td>
                    <td><%=ccc.getCantidad() %></td>
                </tr>
                <% } %>
            </tbody>
        </table>
    </div>
</div>
<div class="row">
    <div class="col">
        <p>Total a Pagar: $<%=cc.getTotal()%> </p>
    </div>
</div>
<div class="row">
    <div class="col">
        <p> Opcion de retiro: <%=cc.getOpcionRetiroDescr() %> </p>
    </div>
</div>
                
                
<%@include file="estructura/footer.jsp" %>
