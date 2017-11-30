<%-- 
    Document   : empresaListado
    Created on : 29-11-2017, 18:43:51
    Author     : jose tolosa
--%>

<%@page import="cl.duoc.examen.modelo.ClassEmpresa"%>
<%@page import="java.util.List"%>
<%@page import="cl.duoc.examen.controlador.CtrlEmpresa"%>
<%@include file="estructura/header.jsp" %>
<%
    CtrlEmpresa ctrl = new CtrlEmpresa();
    List<ClassEmpresa> lce = ctrl.obtenerLista(new ClassEmpresa());
%>

<h1>Usuarios</h1>
<a href="empresaAgregar.jsp">Agregar</a>

<table class="table">
    <thead>
        <tr>
            <th>Rut</th>
            <th>Nombre</th>
            <th>Dirección</th>
            <th>Opciones</th>
        </tr>
    </thead>
    <tbody> 
        <% for (ClassEmpresa ce : lce) { %>
        <tr>
            <td><%=ce.getEmpRut() %></td>
            <td><%=ce.getEmpNombre() %></td>
            <td><%=ce.getEmpDireccion() %></td> 
            <td><a href="empresaModificar.jsp?id=<%=ce.getEmpId() %>">modificar</a></td>
        </tr>
        <% }%>
    </tbody>
</table>

<%@include file="estructura/footer.jsp" %>