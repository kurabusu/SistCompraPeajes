<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    HttpSession ses = request.getSession();
    
    if(ses.getAttribute("session_usuario") == null){
       response.sendRedirect("index.jsp");  
    }
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sistema de Peajes</title>
        <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
        <link rel="stylesheet" type="text/css" href="css/master.css"> 
    </head> 
    <body> 
        <div class="navbar navbar-expand-lg navbar-light bg-light">
            <div class="container">
                <ul class="navbar-nav mr-auto"> 
                    <li class="nav-item"> 
                        <a class="nav-link" href="bienvenido.jsp">Principal</a>
                    </li>
                    <li class="nav-item"> 
                        <a class="nav-link" href="pedidosListado.jsp">Pedidos</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="carreteraListado.jsp">Carreteras</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="empresaListado.jsp">Empresas</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="usuarioListado.jsp">Usuarios</a>
                    </li>
                   

                </ul>
                <form name="frm_logout" action="./ServletIndex" method="POST"  class="form-inline my-2 my-lg-0">
                    <button id="btnLogout" name="btnLogout" class="btn btn-danger">Cerrar Sesión</button>
                </form>
            </div>
        </div>
        <div class="container pt-50 mt-25 pb-50 mb-50">
            
