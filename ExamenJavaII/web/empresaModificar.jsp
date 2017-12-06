<%-- 
    Document   : empresaModificar
    Created on : 29-11-2017, 19:55:49
    Author     : jose tolosa
--%>

<%@page import="cl.duoc.examen.modelo.ClassEmpresa"%>
<%@page import="cl.duoc.examen.controlador.CtrlEmpresa"%>
<%@include file="estructura/header.jsp" %>
<%
    String rId = (String)request.getParameter("id");
    if(rId == null){
        response.sendRedirect("empresaListado.jsp");
    }
    int id = Integer.parseInt(request.getParameter("id"));
    CtrlEmpresa ctrl = new CtrlEmpresa();
    
    ClassEmpresa ce = ctrl.obtener(id);

%>
<div class="row pt-25"> 
    <div class="col"> 
        <h1 class="h1">Modificar Empresa</h1>
    </div>
</div>

<div class="row pt-25">
    <form id="form-empresa" name="form-empresa" action="./ServletEmpresaModificar" method="POST" class="col">
        <div class="row">
            <div class="col">
                <div class="form-group">
                    <label>Rut</label>
                    <input type="text" id="rut" name="rut" class="form-control" value="<%=ce.getEmpRut() %>" required >
                </div>
            </div>
            <div class="w-100"></div>
            
            <div class="col">
                <div class="form-group">
                    <label>Nombre</label>
                    <input type="text"  id="nombre" name="nombre" class="form-control" value="<%=ce.getEmpNombre() %>" required >
                </div>
            </div>
            <div class="w-100"></div>
            
            <div class="col">
                <div class="form-group">
                    <label>Dirección</label>
                    <input type="text" id="direccion" name="direccion" class="form-control" value="<%=ce.getEmpDireccion() %>" required>
                </div>
            </div>
            <div class="w-100"></div>
        </div>
           
        <div class="w-100 text-center">
            <input type="hidden" id="id" name="id" value="<%=ce.getEmpId() %>">
            <a href="empresaListado.jsp" class="btn btn-link">volver</a>
            <button class="btn btn-success">Guardar</button>
        </div>
    </form>
</div>

<%@include file="estructura/footer.jsp" %>