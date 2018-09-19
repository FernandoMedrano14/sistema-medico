<%-- 
    Document   : failure
    Created on : 08-23-2018, 11:18:36 AM
    Author     : Admin109
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>


<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Error al ingresar</title>
        <link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
        <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
        <link href="css/Style.css" rel="stylesheet" type="text/css"/>
        <link rel="shortcut icon" href="favicon.ico" />
    <body>
        <div class="container">
            <div class="card card-container">
                <img id="profile-img" class="profile-img-card" src="https://upload.wikimedia.org/wikipedia/commons/e/e9/SlashCircle.svg" />
                <p id="profile-name" class="profile-name-card"></p>
                <html:form action="LAct">
                    <form  class="form-signin">
                        <span id="reauth-email" class="reauth-email"></span>
                        <input type="email" name="username" value="" class="form-control" placeholder="User Name" required autofocus>
                        <input type="password" name="password" value="" class="form-control" placeholder="Password" required>
                        <div id="remember" class="checkbox">
                            <label>
                                <input type="checkbox" value="remember-me"> Recordar
                            </label>
                        </div>
                        <button class="btn btn-lg btn-primary btn-block btn-signin" type="submit">ingresar</button>
                    </form>
                    <br>
                    <div align="center" class="alert-danger" role="alert">
                        <h4>Usuario y/o Contraseñas incorrectos</h4>
                    </div>
                </html:form>
                <div class="row" align="center">
                    <a href="mantenimientoUsuarios.jsp" class="btn btn-link">¿Olvidaste tu contraseña?</a>
                </div>
            </div>
        </div>
    </head>
</body>
</html>
<%--<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <title>Error al ingresar</title>
    </head>
    <body>
        <h1>Usuarios y/o Contraseñas incorrectos</h1>
    </body>
</html>--%>
