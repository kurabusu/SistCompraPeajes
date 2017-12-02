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

<div class="row pb-25">
    <div class="col ">
        <h1 class="h1 float-left">Usuarios</h1>
        <a href="usuarioAgregar.jsp" class="btn btn-primary float-right">Agregar</a> 
    </div>
</div>
        
<div class="row">
    <div class="col">
        <table class="table">
            <thead>
                <tr>
                    <th>Nombre</th>
                    <th>Usuario</th> 
                    <th style="width: 200px;">Opciones</th>
                </tr>
            </thead>
            <tbody>
                <% for (ClassUsuario us : lus) { %>
                <tr>
                    <td><%=us.getUsuNombre() %></td>
                    <td><%=us.getUsuUsuario() %></td> 
                    <td ><a href="usuarioModificar.jsp?id=<%=us.getUsuId() %>" class="btn btn-link" title="Modificar">Modificar</a></td>
                </tr>
                <% }%>
            </tbody>
        </table>
    </div>
</div>

<%@include file="estructura/footer.jsp" %>