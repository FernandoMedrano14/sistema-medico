<%-- 
    Document   : loginStruts
    Created on : 08-23-2018, 09:30:18 AM
    Author     : Admin109
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html" %>

<!DOCTYPE html>
<html>
    <head>
        <title>login</title>
        <link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
        <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
        <link href="css/style2.css" rel="stylesheet" type="text/css"/>
        <link rel="shortcut icon" href="favicon.ico" />
    <body>
        <br>
        <br>
        <br>
        <div class="container">
            <div class="card card-container">
                <img id="profile-img" class="profile-img-card" src="data:image/png;base64,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" />
                <p id="profile-name" class="profile-name-card"></p>
                <html:form action="LAct">
                    <form  class="form-signin">
                        <span id="reauth-email" class="reauth-email"></span>
                        <%--<input type="email" name="username" value="" class="form-control" placeholder="Correo" required autofocus>--%>
                        <label>Usuario / Correo</label>
                        <html:text property="username" styleClass="form-control"/>
                        <br>
                        <%--<input type="password" name="password" value="" class="form-control" placeholder="Contraseña" required>--%>
                        <label>Contraseña</label>
                        <html:password property="password" styleClass="form-control"/>
                        <br>
                        <div>
                            ${mensaje}
                            <label>
                                <input type="checkbox" value="remember-me"> Recordar
                            </label>
                        </div>
                        <br>
                        <%--<button class="btn btn-lg btn-success btn-block btn-signin" type="submit">Iniciar Sesión</button>--%>
                        <html:submit property="action" value="Iniciar Sesion" styleClass="btn btn-lg btn-success btn-block btn-signin"/>
                        <br>
                        <div class="row" align="center">
                            <a href="mantenimientoUsuarios.jsp" class="btn btn-link">
                                ¿Eres nuevo? <br>¡Registrate!
                            </a>
                        </div>
                </div>
            </form>
        </html:form>
    </div>
</body>
</head>
</html>