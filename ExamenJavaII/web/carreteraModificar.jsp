<%-- 
    Document   : carreteraAgregar
    Created on : 28-11-2017, 0:26:00
    Author     : jose tolosa
--%>

<%@page import="cl.duoc.examen.controlador.CtrlCarretera"%>
<%@page import="cl.duoc.examen.modelo.ClassCarretera"%>
<%@include file="estructura/header.jsp" %>
<%
    String rId = (String)request.getParameter("id");
    if(rId == null){
        response.sendRedirect("carreteraListado.jsp");
    }
    int id = Integer.parseInt(request.getParameter("id"));
    CtrlCarretera ctrl = new CtrlCarretera();
    ClassCarretera cc = ctrl.obtener(id);
    
%>
<h1>Carretera Modificar</h1>
<form action="./ServletCarreteraModificar">
    <table> 
        <tr>
            <td>Nombre</td>
            <td><input type="text" id="nombre" name="nombre" value="<%=cc.getCareNombre() %>"></td>
        </tr> 
        <tr>
            <td>Costo</td>
            <td><input type="number" id="costo" name="costo" value="<%=cc.getCareCosto() %>"></td>
        </tr>
        <tr>
            <td><input type="hidden" id="id" name="id" value="<%=cc.getCareId() %>"></td>
            <td> 
                <a href="carreteraListado.jsp">Cancelar</a>
                <button>Modificar</button>
            </td>
        </tr>
    </table>
</form>
    


<%@include file="estructura/footer.jsp" %>