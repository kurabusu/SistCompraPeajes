<%-- 
    Document   : pedidosListado
    Created on : 29-11-2017, 23:44:12
    Author     : jose tolosa
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="estructura/header.jsp" %>

<div class="row pb-25">
    <div class="col">
        <h1 class="h1 float-left">Pedidos</h1>
        <div class="float-right">
            <a href="pedidosAgregar.jsp" class="btn btn-primary">Nuevo</a> 
            <a href="carreteraListado.jsp" class="btn btn-link" >Ver carreteras</a>
        </div>
    </div>
</div>
<div class="row">
    <div class="col">
        <label>Rut Cliente</label>
        <div class="form-group form-inline">
            <input type="text" name="rut" id="rutBusqueda" placeholder="Rut Cliente" class="form-control col">
            &nbsp;
            <button id="bBuscarPedidos" type="button" value="Buscar" class="btn btn-info"/>
                <i class="fa fa-search" aria-hidden="true"></i> Buscar
            </button>
        </div>
    </div>
</div>

<div class="row">
    <div class="col">
        <table class="table" id="tablaPedidosLista">
            <thead class="thead-dark">
                <tr>
                    <th>Pedido</th>
                    <th>Total</th>
                    <th  style="width: 200px;">Pedir</th>
                </tr>
            </thead>
            <tbody>
                
            </tbody>
        </table>
    </div>
</div>

<%@include file="estructura/footer.jsp" %>
