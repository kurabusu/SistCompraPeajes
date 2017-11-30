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
<div class="row">
    <div class="col">
        <h1 class="h1">Usuario Modificar</h1>
    </div>
</div>
<div class="row pt-25">
    <form action="./ServletUsuarioModificar" method="POST" class="col">
        <div class="row">
            <div class="col">
                <div class="form-group">
                    <label>Nombre</label>
                    <input type="text" id="nombre" name="nombre" class="form-control" required value="<%=us.getUsuNombre() %>"/>
                </div>
            </div>
            <div class="w-100"></div>
            
            <div class="col">
                <div class="form-group">
                    <label>Usuario</label>
                    <input type="text" id="usuario" name="usuario" class="form-control" value="<%=us.getUsuUsuario() %>" readonly/>
                </div> 
            </div>
        </div>
        
        <div class="w-100 text-center">
            <input type="hidden" id="id" name="id" value="<%=us.getUsuId() %>">
            <a href="usuarioListado.jsp" class="btn btn-link">volver</a>
            <button class="btn btn-success">Guardar</button>
        </div>
            
    </form>
</div>

<%@include file="estructura/footer.jsp" %>