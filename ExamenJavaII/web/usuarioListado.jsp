<%-- 
    Document   : usuarioListado
    Created on : 28-11-2017, 23:07:24
    Author     : jose tolosa
--%>

<%@page import="cl.duoc.examen.modelo.ClassUsuario"%>
<%@page import="java.util.List"%>
<%@page import="cl.duoc.examen.controlador.CtrlUsuario"%>
<%@include file="estructura/header.jsp" %>
<%
    CtrlUsuario ctrl = new CtrlUsuario();
    List<ClassUsuario> lus = ctrl.obtenerLista(new ClassUsuario());
%>

<h1>Usuarios</h1>
<a href="usuarioAgregar.jsp">Agregar</a>

<table class="table">
    <thead>
        <tr>
            <th>Nombre</th>
            <th>Usuario</th>
            <th>Opciones</th>
        </tr>
    </thead>
    <tbody>
        <% for (ClassUsuario us : lus) { %>
        <tr>
            <td><%=us.getUsuNombre() %></td>
            <td><%=us.getUsuUsuario() %></td> 
            <td><a href="usuarioModificar.jsp?id=<%=us.getUsuId() %>">modificar</a></td>
        </tr>
        <% }%>
    </tbody>
</table>

<%@include file="estructura/footer.jsp" %>