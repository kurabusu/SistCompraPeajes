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

<div class="row pb-25">
    <div class="col">
        <h1 class="h1 float-left">Empresas</h1>
        <a href="empresaAgregar.jsp" class="btn btn-primary float-right">Agregar</a>
    </div>
</div>

<div class="row">
    <div class="col"> 
        <table class="table">
            <thead class="thead-dark">
                <tr>
                    <th>Rut</th>
                    <th>Nombre</th>
                    <th>Dirección</th>
                    <th style="width: 200px;">Opciones</th>
                </tr>
            </thead>
            <tbody> 
                <% for (ClassEmpresa ce : lce) { %>
                <tr>
                    <td><%=ce.getEmpRut() %></td>
                    <td><%=ce.getEmpNombre() %></td>
                    <td><%=ce.getEmpDireccion() %></td> 
                    <td><a href="empresaModificar.jsp?id=<%=ce.getEmpId() %>" class="btn btn-link" title="Modificar">Modificar</a></td>
                </tr>
                <% }%>
            </tbody>
        </table>
    </div>
</div>
        
<%@include file="estructura/footer.jsp" %>