<%-- 
    Document   : index
    Created on : Sep 26, 2010, 1:08:45 PM
    Author     : andres
--%>

<%@ page import="com.losalpes.reportes.Reportes,com.losalpes.mundo.Inmueble, javax.naming.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">


<%!    private Reportes rep = null;

    public void jspInit() {
        try {
            InitialContext ic = new InitialContext();
            rep = (Reportes) ic.lookup(Reportes.class.getName());
        } catch (Exception ex) {
            System.out.println("Couldn't create reportes bean." + ex.getMessage());
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
        <link href="css/homepage.css" rel="stylesheet" type="text/css" />
    </head>
    <body>

        <!--******************** START TITLE BAR ********************-->
        <div id="header">
            <div id="logo">
                <h1><a href="index.php">InAlpes</a></h1>
                <h2><a href="">tu inmobiliaria</a></h2>
            </div>
            <div id="menu">
                <ul>
                    <!--******************** START BUTTONS ********************-->
                    <li class="active"><a href="home.php?p=menu">cat&aacute;logo</a></li>
                    <li><a href="home.php?p=profile">promociones</a></li>
                    <li><a href="home.php?p=history">ayuda</a></li>
                    <li><a href="home.php?p=help2">login</a></li>
                    <!--******************** END BUTTONS ********************-->
                </ul>
            </div>
        </div>
        <!--******************** END TITLE BAR ********************-->

        <!--******************** START PAGE ********************-->
        <div id="page">

            <!--******************** START CONTENT ********************-->
            <div id="content">

                <!--******************** START CENTER ********************-->
                <div class="left-sector">
                    <div class="post">
                        
                    </div>
                </div>

            <!--******************** END CONTENT ********************-->
            </div>

            <div style="clear: both;">&nbsp;</div>

        <!--******************** END PAGE ********************-->
        </div>


        <!--******************** START FOOTER ********************-->
        <div id="footer">
            <p id="legal">&copy;2010 InAlpes SA. Derechos Reservados. | Dise&ntilde;ado por <a href="http://www.arqsoft.com">ArqSoft.</a></p>
            <p id="links"><a href="#">Privacidad</a> | <a href="#">T&eacute;rminos</a>
            </p>
        </div>
        <!--******************** END FOOTER ********************-->

    </body>
</html>