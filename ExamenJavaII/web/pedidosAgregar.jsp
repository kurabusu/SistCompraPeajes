<%-- 
    Document   : pedidoAgregar
    Created on : 30-11-2017, 0:02:00
    Author     : jose tolosa
--%>

<%@page import="cl.duoc.examen.modelo.ClassCarretera"%>
<%@page import="java.util.List"%>
<%@page import="cl.duoc.examen.controlador.CtrlCarretera"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="estructura/header.jsp" %>
<%
    CtrlCarretera ctrl = new CtrlCarretera(); 
    List<ClassCarretera> lcc = ctrl.obtenerLista(new ClassCarretera());
%>

<div class="row pb-25">
    <div class="col">
        <h1 class="h1">Pedido Nuevo</h1>
    </div>
</div>
<div class="row">
    <form action="./ServletPedidoGuardar" method="POST" class="col">
        <div class="row">
            <div class="col">
                <label>Rut</label>
                <div class="form-group">
                    <div class="form-inline"> 
                        <input type="hidden" id="idE" name="idE" > &nbsp;
                        <input type="text" id="rut" name="rut" class="form-control col" placeholder="Rut" required> &nbsp;
                        <button type="button" id="bRutPButton" name="bRutP" class="btn btn-info"> 
                            <i class="fa fa-search" aria-hidden="true"></i>  Buscar
                        </button>
                    </div>
                </div>
            </div>
            <div class="w-100"></div>
            
            <div class="col">
                <div class="form-group">
                    <label>Nombre</label>
                    <input type="text" id="nombre" name="nombre" class="form-control" placeholder="Nombre" readonly>
                </div>
            </div>
            <div class="w-100"></div>
            
            <div class="col">
                <div class="form-group">
                    <label>Dirección</label>
                    <input type="text" id="direccion" name="direccion" class="form-control" placeholder="Dirección" readonly>
                </div>
            </div>
            <div class="w-100"></div>
            
            <div class="col">
                <div class="form-group">
                    <label>Comprado Por</label>
                    <input type="text" id="comprador" name="comprador" class="form-control" placeholder="Comprado Por" required>
                </div>
            </div>
            <div class="w-100"></div>
            
            <div class="col">
                <label>Opciones de pago</label>
                <div class="form-group">
                    <label class="custom-control custom-radio">
                        <input id="optPago1" name="optPago" type="radio" value="1" class="custom-control-input">
                        <span class="custom-control-indicator"></span>
                        <span class="custom-control-description">Transferencia</span>
                    </label>
                </div>
                <div class="form-group">
                    <label class="custom-control custom-radio">
                        <input id="optPago2" name="optPago" type="radio" value="2" class="custom-control-input">
                        <span class="custom-control-indicator"></span>
                        <span class="custom-control-description">Pago en linea</span>
                    </label>
                </div>
                <div class="form-group">
                    <label class="custom-control custom-radio">
                        <input id="optPago3" name="optPago" type="radio" value="2" class="custom-control-input">
                        <span class="custom-control-indicator"></span>
                        <span class="custom-control-description">Orden de Compra</span>
                    </label>
                </div>
            </div>
            <div class="col">
                <label>Opciones de Retiro</label>
                <div class="form-group">
                    <label class="custom-control custom-radio">
                        <input id="optRetiro1" name="optRetiro" type="radio" value="1" class="custom-control-input">
                        <span class="custom-control-indicator"></span>
                        <span class="custom-control-description">Oficina</span>
                    </label>
                </div>
                <div class="form-group">
                    <label class="custom-control custom-radio">
                        <input id="optRetiro12" name="optRetiro" type="radio" value="2" class="custom-control-input">
                        <span class="custom-control-indicator"></span>
                        <span class="custom-control-description">Envío Cliente</span> 
                    </label>
                </div>
            </div>
            <div class="w-100"></div>
            
            <div class="col">
                <label>Seleccionar carretera y agregue al pedido.</label>
                <div class="form-group">
                    <div class="form-inline">
                        <select id="selCarreteras" name="selCarreteras" class="form-control col"> 
                            <option value="">Selecionar</option>
                            <%for (ClassCarretera c : lcc) { %>
                            <option value="<%=c.getCareId() %>"><%=c.getCareNombre() %></option>
                            <% }%>
                        </select>
                        &nbsp;
                        <input id="aCarPButton" type="button" value="Agregar" class="btn btn-primary">
                    </div>
                </div>
                <div class="form-group form-inline"> 
                </div>
            </div>
            <div class="w-100"></div>
                
            <div class="col">
                <table class="table" id="PedidoCarreteras">
                    <thead>
                        <tr>
                            <th>Cerretera</th>
                            <th>Cantidad</th>
                            <th></th>
                        </tr>
                    </thead>
                    <tbody>
                        
                    </tbody>
                </table>
            </div>
            <div class="w-100"></div>
            
            <div class="col-7">
                <p>Total a pagar $<span class="total">0</span></p>
            </div>
            <div class="col">
                <input type="hidden" id="precioTotal" name="precioTotal"> 
                <a href="pedidosListado.jsp" class="btn btn-link">volver</a>
                <button class="btn btn-success">Hacer Pedido</button>
            </div>
            
        </div>
        
    </form>
</div>

<%@include file="estructura/footer.jsp" %>