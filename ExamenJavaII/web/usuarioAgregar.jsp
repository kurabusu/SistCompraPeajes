<%-- 
    Document   : usuarioAgregar
    Created on : 28-11-2017, 23:07:35
    Author     : jose tolosa
--%>

<%@include file="estructura/header.jsp" %>
<h1>Usuario agregar</h1>
<form action="./ServletUsuarioGuardar">
    <table>
        <tr>
            <td>Nombre</td>
            <td><input type="text" id="nombre" name="nombre" ></td>
        </tr>
        <tr>
            <td>Usuario</td>
            <td><input type="text" id="usuario" name="usuario" ></td>
        </tr>
        <tr>
            <td>Clave</td>
            <td><input type="password" id="clave" name="clave" ></td>
        </tr>
        <tr>
            <td>Repetir Clave</td>
            <td><input type="password" id="rClave" name="rClave" ></td>
        </tr>
        <tr>
            <td></td>
            <td>
                <a href="usuarioAgregar.jsp.jsp">Cancelar</a>
                <button >Guardar</button>
            </td>
        </tr>
    </table>
</form>
    


<%@include file="estructura/footer.jsp" %>