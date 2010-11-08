<%--
    Document   : tabla para inmuebles de tipo apartamento
    Created on : Sep 26, 2010, 1:08:45 PM
    Author     : andres
--%>
<%@ page import="com.losalpes.entities.*,com.losalpes.persistence.PersistenceServices,java.util.List, java.util.ArrayList, javax.naming.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<table border="0" width="500px">
    <thead>
        <tr>
            <th>idTransacción</th>
            <th>idInmueble</th>
            <th>idUsuario</th>
            <th>Estado</th>
        </tr>
    </thead>
    <tbody>
        <%
        PersistenceServices p = new PersistenceServices();
        List<Transacciones> l = new ArrayList();

            Transacciones t = new Transacciones();
            t.setIdtransaccion(1);
            t.setEstado("Aprovada");
            t.setIdcomprador(new Usuario(2));
            t.setIdinmueble(new Inmueble(1));
            l.add(t);

            t = new Transacciones();
            t.setIdtransaccion(2);
            t.setEstado("Aprovada");
            t.setIdcomprador(new Usuario(4));
            t.setIdinmueble(new Inmueble(5));
            l.add(t);

            t = new Transacciones();
            t.setIdtransaccion(3);
            t.setEstado("Aprovada");
            t.setIdcomprador(new Usuario(10));
            t.setIdinmueble(new Inmueble(7));
            l.add(t);
        
        int id;
        String estado;
        int comp;
        int inmueble;

        for (int i = 0; i < l.size(); i++) {
            id = l.get(i).getIdtransaccion();
            estado = l.get(i).getEstado();
            comp = l.get(i).getIdcomprador().getIdusuario();
            inmueble = l.get(i).getIdinmueble().getIdInmueble();
        %>
        <for
        <tr>
            <td><%= id%></td>
            <td><%= inmueble%></td>
            <td><%= comp%></td>
            <td><%= estado%></td>
        </tr>
        <%
        }
        %>
    </tbody>
</table>
