<%-- 
    Document   : listadoCarretera
    Created on : 28-11-2017, 0:22:35
    Author     : jose tolosa
--%>

<%@page import="java.util.List"%>
<%@page import="cl.duoc.examen.controlador.CtrlCarretera"%>
<%@page import="cl.duoc.examen.modelo.ClassCarretera"%>
<%@include file="estructura/header.jsp" %>
<%
    CtrlCarretera ctrl = new CtrlCarretera(); 
    List<ClassCarretera> lcc = ctrl.obtenerLista(new ClassCarretera());
%>
<h1>Carretera</h1>
<a href="carreteraAgregar.jsp">Agregar</a>

<table class="table">
    <thead>
        <tr>
            <th>Nombre</th>
            <th>Costo</th>
            <th>Opciones</th>
        </tr>
    </thead>
    <tbody>
        <%for (ClassCarretera c : lcc) { %>
        <tr>
            <td><%=c.getCareNombre() %></td>
            <td><%=c.getCareCosto() %></td>
            <td><a href="carreteraModificar.jsp?id=<%=c.getCareId() %>">modificar</a></td>
        </tr> 
        <%  }%>
    </tbody>
</table>


<%@include file="estructura/footer.jsp" %>