<%-- 
    Document   : carreteraAgregar
    Created on : 28-11-2017, 0:26:00
    Author     : jose tolosa
--%>

<%@include file="estructura/header.jsp" %>
<h1>Carretera Modificar</h1>
<form action="./ServletCarreteraGuardar">
    <table>
        <tr>
            <td>Nombre</td>
            <td><input type="text" id="nombre" name="nombre"></td>
        </tr>
        <tr>
            <td>Costo</td>
            <td><input type="number" id="costo" name="costo"></td>
        </tr>
        <tr>
            <td></td>
            <td>
                <a href="carreteraListado.jsp">Cancelar</a>
                <button>Guardar</button>
            </td>
        </tr>
    </table>
</form>
    


<%@include file="estructura/footer.jsp" %>