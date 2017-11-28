<%-- 
    Document   : carreteraAgregar
    Created on : 28-11-2017, 0:26:00
    Author     : jose tolosa
--%>

<%@include file="estructura/header.jsp" %>
<%%>
<h1>Carretera Agregar</h1>
<form action="./ServletCarreteraGuardar">
    <table>
        <tr>
            <td>Nombre</td>
            <td><input type="text" id="nombre" name="nombre" value="<%%>"></td>
        </tr>
        <tr>
            <td>Costo</td>
            <td><input type="number" id="costo" name="costo" value="<%%>"></td>
        </tr>
        <tr>
            <td></td>
            <td>
                <input type="hidden" id="idC" name="idC">
                <a href="carreteraListado.jsp">Cancelar</a>
                <button>Guardar</button>
            </td>
        </tr>
    </table>
</form>
    


<%@include file="estructura/footer.jsp" %>