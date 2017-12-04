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
                         
                        <a href="#" class="btn btn-link" title="Ver mapa" onclick="mostrarMapa('<%=c.getCareNombre() %>')"> <i class="fa fa-map-o" aria-hidden="true"></i></a>
                    </td>
                </tr> 
                <%  }%>
            </tbody>
        </table>
    </div>
</div>

<div class="modal fade bd-example-modal-lg" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel" style="display: none;" aria-hidden="true">
  <div class="modal-dialog modal-lg">
    <div class="modal-content">

      <div class="modal-header">
        <h4 class="modal-title" id="myLargeModalLabel">Mapa Carretera</h4>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">×</span>
        </button>
      </div>
      <div class="modal-body">
          <div id="map" style="width: 100%; height: 500px;"></div>
      </div>
    </div>
  </div>
</div>      
<%@include file="estructura/footer.jsp" %>