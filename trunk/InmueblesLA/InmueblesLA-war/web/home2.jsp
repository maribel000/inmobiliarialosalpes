<%--
    Document   : index
    Created on : Sep 26, 2010, 1:08:45 PM
    Author     : andres
--%>

<%@ page import="javax.naming.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">


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
                <h1><a href="index.jsp">InAlpes</a></h1>
                <h2><a href="">tu inmobiliaria</a></h2>
            </div>
            <div id="menu">
                <ul>
                    <!--******************** START BUTTONS ********************-->
                    <li class="active"><a href="faces/catalogo.jsp">cat&aacute;logo</a></li>
                    <!--<li><a href="home.php?p=profile">promociones</a></li>-->
                    <!--<li><a href="ayuda.jsp">ayuda</a></li>-->
                    <li><a href="login.jsp">login</a></li>
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
                        <h1 class="title">Bienvenido Vendedor,</h1>
                        <br>
                        <div class="entry">
                            Aqui podrás validar ventas
                        </div>
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