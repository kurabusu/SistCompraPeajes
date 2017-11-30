<%-- 
    Document   : carreteraAgregar
    Created on : 28-11-2017, 0:26:00
    Author     : jose tolosa
--%>

<%@include file="estructura/header.jsp" %>
<div class="row pt-25"> 
    <div class="col">
        <h1 class="h1">Carretera Agregar</h1>
    </div>
</div>
<div class="row pt-25">
    <form action="./ServletCarreteraGuardar" method="POST" class="col">
        <div class="row">
            <div class="col">
                <div class="form-group">
                    <label>Nombre</label>
                    <input type="text" id="nombre" name="nombre" class="form-control">
                </div>
            </div>
            <div class="w-100"></div>
            <div class="col">
                <div class="form-group">
                    <label>Costo</label> 
                    <input type="number" id="costo" name="costo" class="form-control">
                </div>
            </div>
        </div>

        <div class="w-100 text-center">
            <a href="carreteraListado.jsp">Cancelar</a>
            <button class="btn btn-success">Guardar</button>
        </div>
    </form>
</div> 


<%@include file="estructura/footer.jsp" %>