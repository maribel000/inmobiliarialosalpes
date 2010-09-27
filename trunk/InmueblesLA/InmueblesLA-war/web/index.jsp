<%-- 
    Document   : index
    Created on : Sep 26, 2010, 1:08:45 PM
    Author     : andres
--%>

<%@ page import="com.losalpes.reportes.Reportes,com.losalpes.mundo.Inmueble, javax.naming.*"%>
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
        <center>
        <h1>Generaci&oacute;n de Reportes</h1>
        </center>
        <BR>
        <form method="get">
            N&uacute;mero de inmueble: &nbsp;<input type="text" name="inmueble" value="1"  size="3">
            
            <input type="submit" value="Generar Reporte">
            <BR>
        </form>

        <%
            String inmueble = request.getParameter("inmueble");
            Inmueble in;
            if ( inmueble != null && inmueble.length() > 0 ) {
                in = rep.generarReporteInmueble(inmueble);
        %>
        <BR>
        <hr>
        <center>
            <h2>
                Reporte del Inmueble <%= in.getReferencia() %>
            </h2>
            <p>
                <table border="0">
                    <tbody>
                        <tr>
                            <td align="right">Referencia:&nbsp;</td>
                            <td><%= in.getReferencia() %></td>
                        </tr>
                        <tr>
                            <td align="right">Nombre:&nbsp;</td>
                            <td><%= in.getNombre() %></td>
                        </tr>
                        <tr>
                            <td align="right">Descripci&oacute;n:&nbsp;</td>
                            <td><%= in.getDescripcion() %></td>
                        </tr>
                        <tr>
                            <td align="right">Material:&nbsp;</td>
                            <td><%= in.getMaterial() %></td>
                        </tr>
                        <tr>
                            <td align="right">Color:&nbsp;</td>
                            <td><%= in.getColor() %></td>
                        </tr>
                    </tbody>
                </table>
            </p>
        </center>
        <%
            }
        %>
    </body>
</html>
