<%-- 
    Document   : ventanaMensaje
    Created on : 22-11-2017, 19:26:42
    Author     : jose tolosa
--%>

<%@include file="estructura/header.jsp" %>
<%
    String mensaje = (String)ses.getAttribute("mensaje");
    String tipo = (String)ses.getAttribute("tipo");
    String link = (String)ses.getAttribute("link");
    ses.setAttribute("mensaje", "");
    ses.setAttribute("tipo", "");
%>

<h1 class="h1"> <%=tipo %> </h1>
<p class="text-center">
    <%=mensaje %>
</p>
<p class="text-center">
    <a href="<%=link %>" >Volver</a>
</p>

<%@include file="estructura/footer.jsp" %>