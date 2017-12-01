<%-- 
    Document   : pedidosListado
    Created on : 29-11-2017, 23:44:12
    Author     : jose tolosa
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="estructura/header.jsp" %>

<div class="row pb-25">
    <div class="col form-inline">
        <h1 class="h1">Pedidos</h1>
        <a href="pedidosAgregar.jsp">Nuevo</a>
    </div>
</div>
<div class="row">
    <div class="col">
        <label>Rut Cliente</label>
        <div class="form-group form-inline">
            <input type="text" name="rut" id="rut" placeholder="Rut Cliente" class="form-control col">
            &nbsp;
            <button type="button" value="Buscar" class="btn btn-info"/>
                <i class="fa fa-search" aria-hidden="true"></i> Buscar
            </button>
        </div>
    </div>
</div>

<div class="row">
    <div class="col">
        <table class="table">
            <thead>
                <tr>
                    <th>Pedido</th>
                    <th>Total</th>
                    <th>Pedir</th>
                </tr>
            </thead>
            <tbody>
                
            </tbody>
        </table>
    </div>
</div>


