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

<div class="row"> 
    <div class="col">
        <h1>Carretera Modificar</h1>
    </div>
</div>
<div class="row pt-25">
    <form action="./ServletCarreteraModificar" method="POST" class="col">
        <div class="row">
            <div class="col">
                <div class="form-group">
                    <label>Nombre</label>
                    <input type="text" id="nombre" name="nombre" class="form-control" value="<%=cc.getCareNombre() %>">
                </div>
            </div>
            <div class="w-100"></div>
            <div class="col">
                <div class="form-group">
                    <label>Costo</label> 
                    <input type="number" id="costo" name="costo" class="form-control" value="<%=cc.getCareCosto() %>">
                </div>
            </div>
        </div>
        <div class="w-100 text-center">
            <input type="hidden" id="id" name="id" value="<%=cc.getCareId() %>">
            <a href="carreteraListado.jsp">Cancelar</a>
            <button class="btn btn-success">Guardar</button>
        </div>
    </form>
</div>

<%@include file="estructura/footer.jsp" %>