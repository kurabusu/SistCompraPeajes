<%-- 
    Document   : pedidosAgregarNuevo
    Created on : 03-12-2017, 14:31:39
    Author     : jose tolosa
--%>

<%@page import="cl.duoc.examen.controlador.CtrlCompraCarretera"%>
<%@page import="cl.duoc.examen.modelo.ClassCompraCarretera"%>
<%@page import="cl.duoc.examen.controlador.CtrlEmpresa"%>
<%@page import="cl.duoc.examen.modelo.ClassCompra"%>
<%@page import="cl.duoc.examen.modelo.ClassEmpresa"%>
<%@page import="cl.duoc.examen.controlador.CtrlCompra"%>
<%@page import="cl.duoc.examen.modelo.ClassCarretera"%>
<%@page import="java.util.List"%>
<%@page import="cl.duoc.examen.controlador.CtrlCarretera"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="estructura/header.jsp" %>
<%
    CtrlCarretera ctrl = new CtrlCarretera(); 
    List<ClassCarretera> lcc = ctrl.obtenerLista(new ClassCarretera());
        
    String rId = (String)request.getParameter("id");
    if(rId == null){
        response.sendRedirect("pedidosListado.jsp");
    }
    int id = Integer.parseInt(request.getParameter("id"));
    CtrlCompra ctrlCompra = new CtrlCompra();
    CtrlEmpresa crtlEmpresa = new CtrlEmpresa();
    CtrlCompraCarretera ctrlcc = new CtrlCompraCarretera();
    
    ClassCompra cc = ctrlCompra.obtener(id);
    ClassEmpresa ce = crtlEmpresa.obtener(cc.getEmpId());
    
    List<ClassCompraCarretera> lccc = ctrlcc.obtenerLista(cc.getComId());
%> 

<div class="row pb-25">
    <div class="col">
        <h1 class="h1">Pedido Nuevo</h1>
    </div>
</div>
<div class="row">
    <form id="form-pedido" action="./ServletPedidoGuardar" method="POST" class="col">
        <div class="row">
            <div class="col">
                <label>Rut</label>
                <div class="form-group">
                    <div class="form-inline"> 
                        <input type="hidden" id="idE" name="idE" value="<%=ce.getEmpId() %>" >
                        <input type="text" id="rut" name="rut" class="form-control col" placeholder="Rut" value="<%=ce.getEmpRut() %>" readonly> &nbsp;
                        <!--button type="button" id="bRutPButton" name="bRutP" class="btn btn-info"> 
                            <i class="fa fa-search" aria-hidden="true"></i>  Buscar
                        </button-->
                    </div>
                </div>
            </div>
            <div class="w-100"></div>
            
            <div class="col">
                <div class="form-group">
                    <label>Nombre</label>
                    <input type="text" id="nombre" name="nombre" class="form-control" placeholder="Nombre" value="<%=ce.getEmpNombre() %>" readonly>
                </div>
            </div>
            <div class="w-100"></div>
            
            <div class="col">
                <div class="form-group">
                    <label>Dirección</label>
                    <input type="text" id="direccion" name="direccion" class="form-control" placeholder="Dirección" value="<%=ce.getEmpDireccion() %>" readonly>
                </div>
            </div>
            <div class="w-100"></div>
            
            <div class="col">
                <div class="form-group">
                    <label>Comprado Por</label>
                    <input type="text" id="comprador" name="comprador" class="form-control" placeholder="Comprado Por" value="<%=cc.getCompradorPor() %>" required>
                </div>
            </div>
            <div class="w-100"></div>
            
            <div class="col">
                <label>Opciones de pago</label>
                <div class="form-group"> 
                    <label class="custom-control custom-radio">
                        <input id="optPago1" name="optPago" type="radio" value="1" class="custom-control-input"
                               <%=(cc.getOpcionPago()== 1)?"checked": "" %>>
                        <span class="custom-control-indicator"></span>
                        <span class="custom-control-description">Transferencia</span>
                    </label>
                </div>
                <div class="form-group">
                    <label class="custom-control custom-radio">
                        <input id="optPago2" name="optPago" type="radio" value="2" class="custom-control-input"
                               <%=(cc.getOpcionPago()== 2)?"checked": "" %>>
                        <span class="custom-control-indicator"></span>
                        <span class="custom-control-description">Pago en linea</span>
                    </label>
                </div>
                <div class="form-group">
                    <label class="custom-control custom-radio"> 
                        <input id="optPago3" name="optPago" type="radio" value="3" class="custom-control-input"
                               <%=(cc.getOpcionPago()== 3)?"checked": "" %>>
                        <span class="custom-control-indicator"></span>
                        <span class="custom-control-description">Orden de Compra</span>
                    </label>
                </div>
            </div>
            <div class="col">
                <label>Opciones de Retiro</label>
                <div class="form-group">
                    <label class="custom-control custom-radio">
                        <input id="optRetiro1" name="optRetiro" type="radio" value="1" class="custom-control-input" 
                               <%=(cc.getOpcionRetiro() == 1)?"checked": "" %> >
                        <span class="custom-control-indicator"></span>
                        <span class="custom-control-description">Oficina</span>
                    </label>
                </div>
                <div class="form-group">
                    <label class="custom-control custom-radio">
                        <input id="optRetiro12" name="optRetiro" type="radio" value="2" class="custom-control-input"
                               <%=(cc.getOpcionRetiro() == 2)?"checked": "" %>>
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
                    <thead class="thead-dark">
                        <tr>
                            <th>Cerretera</th>
                            <th>Cantidad</th>
                            <th></th>
                        </tr>
                    </thead>
                    <tbody>
                        <% for (ClassCompraCarretera elem : lccc) { 
                            ClassCarretera cn = ctrl.obtener(elem.getCarreteraId());
                        %>
                            <tr>
                                <td>
                                    <input name='carreteras' type='hidden' value="<%=elem.getCarreteraId()%>" class="carretera<%=elem.getCarreteraId()%>">
                                    <%=cn.getCareNombre() %>
                                </td> 
                                <td>
                                    <div class='form-group'>
                                        <input name='cantidades' type='number' value='<%=elem.getCantidad() %>' class='form-control' attr-valor="<%=cn.getCareCosto() %>" >
                                    </div>
                                </td>
                                <td>
                                    <button type='button' class='borrarCarretera btn btn-danger'>
                                    <i class='fa fa-remove' aria-hidden='true'></i>
                                    </button>
                                </td>
                            </tr>
                        <% } %>    
                    </tbody>
                </table>
            </div>
            <div class="w-100"></div>
            
            <div class="col-7"> 
                <p>Total a pagar $<span class="total"><%=cc.getTotal() %></span></p>
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