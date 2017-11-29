<%-- 
    Document   : usuarioModificar
    Created on : 28-11-2017, 23:07:57
    Author     : jose tolosa
--%>

<%@page import="cl.duoc.examen.modelo.ClassUsuario"%>
<%@page import="cl.duoc.examen.controlador.CtrlUsuario"%>
<%@include file="estructura/header.jsp" %>
<%
    String rId = (String)request.getParameter("id");
    if(rId == null){
        response.sendRedirect("usuarioListado.jsp");
    }
    int id = Integer.parseInt(request.getParameter("id"));
    CtrlUsuario ctrl = new CtrlUsuario();
    
    ClassUsuario us = ctrl.obtener(id);

%>
<h1>Usuario modificar</h1>
<form action="./ServletUsuarioModificar">
    <table> 
        <tr>
            <td>Nombre</td>
            <td><input type="text" id="nombre" name="nombre" value="<%=us.getUsuNombre() %>"></td>
        </tr>
        <tr>
            <td>Usuario</td>
            <td><input type="text" id="usuario" name="usuario" value="<%=us.getUsuUsuario() %>" readonly></td>
        </tr>
        <tr>
            <td><input type="hidden" id="id" name="id" value="<%=us.getUsuId() %>"></td>
            <td> 
                <a href="usuarioListado.jsp">Cancelar</a>
                <button>Modificar</button>
            </td>
        </tr>
    </table>
</form>



<%@include file="estructura/footer.jsp" %>