<%-- 
    Document   : empresaAgregar
    Created on : 29-11-2017, 19:52:15
    Author     : jose tolosa
--%>


<%@include file="estructura/header.jsp" %>
<div class="row pt-25"> 
    <div class="col">
        <h1 class="h1">Usuario agregar</h1>
    </div>
</div>

<div class="row pt-25">
    <form action="./ServletEmpresaGuardar" method="POST" class="col">
        <div class="row">
            <div class="col">
                <div class="form-group">
                    <label>Rut</label>
                    <input type="text" id="rut" name="rut" class="form-control" required>
                </div>
            </div>
            <div class="w-100"></div>
            
            <div class="col">
                <div class="form-group">
                    <label>Nombre</label>
                    <input type="text"  id="nombre" name="nombre" class="form-control" required>
                </div>
            </div>
            <div class="w-100"></div>
            
            <div class="col">
                <div class="form-group">
                    <label>Dirección</label>
                    <input type="text" id="direccion" name="direccion" class="form-control" required>
                </div>
            </div>
            <div class="w-100"></div>
        </div>
           
        <div class="w-100 text-center">
            <a href="empresaListado.jsp" class="btn btn-link">volver</a>
            <button class="btn btn-success">Guardar</button>
        </div>
    </form>
</div>
    


<%@include file="estructura/footer.jsp" %>
