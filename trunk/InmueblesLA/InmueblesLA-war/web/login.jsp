<%--
    Document   : login
    Created on : Sep 26, 2010, 1:08:45 PM
    Author     : andres
--%>

<%@ page import="com.losalpes.reportes.Reportes,com.losalpes.mundo.Inmueble, javax.naming.*"%>
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
                <h1><a href="index.php">InAlpes</a></h1>
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
                        <h1 class="title">Usuarios con Cuenta</h1>
                        <br>
                        <div class="entry">
                            <form name="login_form" action="login.jsp" method="POST">
                                <table border="0">
                                    <tbody>
                                        <tr>
                                            <td align="right">Login</td>
                                            <td><input type="text" name="login" value="" /></td>
                                        </tr>
                                        <tr>
                                            <td align="right">Password</td>
                                            <td><input type="password" name="password" value="" /></td>
                                        </tr>
                                        <tr>
                                            <td align="right">&nbsp;</td>
                                            <td><input type="submit" value="entrar" name="submit" /></td>
                                        </tr>
                                    </tbody>
                                </table>
                            </form>
                        </div>
                    </div>
                    <div class="post">
                        <h1 class="title">Nuevos Usuarios</h1>
                        <br>
                        <div class="entry">
                            Aquí podrás crear una cuenta en InAlpes: <br> <br>
                            <form name="nuevo_form" action="agregar.jsp" method="POST">
                                <table border="0">
                                    <tbody>
                                        <tr>
                                            <td align="right">Nombres:</td>
                                            <td><input type="text" name="nombres" value="" /></td>
                                        </tr>
                                        <tr>
                                            <td align="right">Apellidos:</td>
                                            <td><input type="text" name="apellidos" value="" /></td>
                                        </tr>
                                        <tr>
                                            <td align="right">Correo:</td>
                                            <td><input type="text" name="correo" value="" /></td>
                                        </tr>
                                        <tr>
                                            <td align="right">Password:</td>
                                            <td><input type="password" name="password" value="" /></td>
                                        </tr>
                                        <tr>
                                            <td align="right">Password(2):</td>
                                            <td><input type="password" name="password2" value="" /></td>
                                        </tr>
                                    </tbody>
                                </table>
                            </form>
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