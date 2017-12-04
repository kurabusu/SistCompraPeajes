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

<div class="row pb-25">
    <div class="col ">
        <h1 class="h1 float-left">Carretera</h1>
        <a href="carreteraAgregar.jsp" class="btn btn-primary float-right">Agregar</a>
    </div>
</div>
<div class="row">
    <div class="col">  
        <table class="table">
            <thead class="thead-dark">
                <tr>
                    <th>Nombre</th>
                    <th>Costo</th>
                    <th style="width: 200px;">Opciones</th>
                </tr>
            </thead>
            <tbody>
                <%for (ClassCarretera c : lcc) { %>
                <tr>
                    <td><%=c.getCareNombre() %></td>
                    <td><%=c.getCareCosto() %></td>
                    <td>
                        <a href="carreteraModificar.jsp?id=<%=c.getCareId() %>" class="btn btn-link" title="Modificar">Modificar</a>
                        
                        <a href="#" class="btn btn-link" title="Ver mapa"> <i class="fa fa-map-o" aria-hidden="true"></i></a>
                    </td>
                </tr> 
                <%  }%>
            </tbody>
        </table>
    </div>
</div>

<%@include file="estructura/footer.jsp" %>