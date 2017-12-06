<%-- 
    Document   : index
    Created on : 17-11-2017, 20:48:21
    Author     : jose tolosa
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
  HttpSession ses = request.getSession();  
%>
<!DOCTYPE html>
<html> 
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sistema de Inmobiliaria</title>
        <link rel="stylesheet" href="css/bootstrap.min.css" type="text/css">
        <link rel="stylesheet" href="css/master.css" type="text/css" >
    </head> 
    <body class="index">
        <div class="container-fluid">
            <div class="row">
                <form action="./ServletIndex" method="POST" class="col-4 offset-4">
                    <div class="form-group">
                        <label class="" for="txtUsuario">Usuario</label>
                        <input id="txtUsuario" type="text" name="txtUsuario" class="form-control" required>
                    </div>
                    
                    <div class="form-group">
                        <label class="" for="txtClave">Clave</label>
                        <input id="txtClave" type="password" name="txtClave" class="form-control" required>
                    </div>
                    
                    <div class="form-group">
                        <input type="submit" name="btnLogin" value="Ingresar" class="btn btn-success w-100">
                    </div>
                  
                    <% if (ses.getAttribute("error_login") != null){ %>
                    <%= ses.getAttribute("error_login") %>
                    <% ses.removeAttribute("error_login");}%>
                </form> 
            </div> 
        </div>
        
        <script type="text/javascript" src="js/jquery.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="js/master.js"></script>
    </body>
</html>
