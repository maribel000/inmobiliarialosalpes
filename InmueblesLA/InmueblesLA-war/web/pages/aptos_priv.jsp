<%--
    Document   : tabla para inmuebles de tipo apartamento
    Created on : Sep 26, 2010, 1:08:45 PM
    Author     : andres
--%>
<%@ page import="com.losalpes.entities.*,com.losalpes.persistence.PersistenceServices,java.util.List, javax.naming.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<table border="0" width="500px">
    <thead>
        <tr>
            <th>Apartamento&nbsp;</th>
            <th>Descripción &nbsp;</th>
            <th>Comprar</th>
        </tr>
    </thead>
    <tbody>
        <%
        PersistenceServices p = new PersistenceServices();
        List<Inmueble> l = p.darInmueblesPorTipo(1);

        int id;
        String nombre;
        String desc;

        for (int i = 0; i < l.size(); i++) {
            nombre = l.get(i).getNombre();
            desc = l.get(i).getDescripcion();
            id = l.get(i).getIdInmueble();
        %>
        <form action="../comprar.jsp" method="GET">
            <input type="hidden" id="idimueble" value="<%= id%>"/>
        <tr>
            <td><%= nombre%></td>
            <td><%= desc%></td>
            <td><input type="button" value="Comprar" name="boton_comprar" onclick="window.location='../comprar.jsp'"/></td>
        </tr>
        </form>
        <%
        }
        %>
    </tbody>
</table>
