<%--
    Document   : tabla para inmuebles de tipo apartamento
    Created on : Sep 26, 2010, 1:08:45 PM
    Author     : andres
--%>
<%@ page import="com.losalpes.entities.*,com.losalpes.persistence.PersistenceServices,java.util.List, javax.naming.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<table border="0" width="300px">
    <thead>
        <tr>
            <th>Casa&nbsp;</th>
            <th>Descripcion&nbsp;</th>
        </tr>
    </thead>
    <tbody>

        <%
        PersistenceServices p = new PersistenceServices();
        List<Inmueble> l = p.darInmueblesPorTipo(2);

        String nombre;
        String desc;

        for (int i = 0; i < l.size(); i++) {
            nombre = l.get(i).getNombre();
            desc = l.get(i).getDescripcion();
        %>

        <tr>
            <td><%= nombre%></td>
            <td><%= desc%></td>
        </tr>

        <%
        }
        %>

    </tbody>
</table>
