<%-- 
    Document   : usuarioAgregar
    Created on : 28-11-2017, 23:07:35
    Author     : jose tolosa
--%>

<%@include file="estructura/header.jsp" %>

<div class="row">
    <div class="col">
        <h1 class="h1">Usuario agregar</h1>
    </div>
</div>
<div class="row pt-25">
    <form id="form-usuario" name="form-usuario" action="./ServletUsuarioGuardar" method="POST" class="col">
        <div class="row">
            <div class="col">
                <div class="form-group">
                    <label>Nombre</label>
                    <input type="text" id="nombre" name="nombre" class="form-control" required />
                </div>
            </div>
            <div class="w-100"></div>
            <div class="col">
                <div class="form-group">
                    <label>Usuario</label>
                    <input type="text" id="usuario" name="usuario" class="form-control" required />
                </div>
            </div>
            <div class="w-100"></div>
            <div class="col">
                <div class="form-group">
                    <label>Clave</label>
                    <input type="password" id="clave" name="clave" class="form-control" required />
                </div>
            </div>
            <div class="col">
                <div class="form-group">
                    <label>Repetir Clave</label>
                    <input type="password" id="rClave" name="rClave" class="form-control" required />
                </div>
            </div>
        </div>
        
        <div class="w-100 text-center">
            <a href="usuarioListado.jsp" class="btn btn-link">volver</a>
            <button class="btn btn-success">Guardar</button>
        </div>  
        
    </form>
</div>

<%@include file="estructura/footer.jsp" %>