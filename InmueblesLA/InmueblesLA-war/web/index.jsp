<%-- 
    Document   : index
    Created on : Sep 26, 2010, 1:08:45 PM
    Author     : andres
--%>

<%@ page import="com.losalpes.reportes.Reportes, javax.naming.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">


<%!
    private Reportes rep = null;
    public void jspInit() {
        try {
            InitialContext ic = new InitialContext();
            rep = (Reportes) ic.lookup(Reportes.class.getName());
        } catch (Exception ex) {
            System.out.println("Couldn't create reportes bean."+ ex.getMessage());
        }
    }

    public void jspDestroy() {
        rep = null;
    }
%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Inmuebles Los Alpes</title>
    </head>
    <body>
        <h1>Generacion de Reportes</h1>

        <hr>

        <form method="get">
            N&uacute;mero de cuenta: &nbsp;<input type="text" name="cuenta" value="1" editable="false" size="25">
            <br>
            <p>
            <input type="submit" value="Submit">
            <input type="reset" value="Reset">
        </form>

        <%
            String cuenta = request.getParameter("cuenta");
            String respuesta;
            if ( cuenta != null && cuenta.length() > 0 ) {
                respuesta = rep.generarReporte(cuenta);
        %>
        <p>
            <%= respuesta %>
        <p>
        <%
            }
        %>

    </body>
</html>
