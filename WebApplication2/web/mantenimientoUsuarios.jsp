<%-- 
    Document   : mantenimientoUsuarios
    Created on : 08-21-2018, 02:38:48 PM
    Author     : Admin109
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="css/Style.css" rel="stylesheet" type="text/css"/>
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
        <link rel="shortcut icon" href="favicon.ico" />
        <title>Mantenimiento de usuarios</title>
    </head>
    <body>
        <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
            <a class="navbar-brand" href="#">
                <img id="logo" src="https://res.cloudinary.com/disputebills/image/upload/v1462474206/blue-mark_cnzgry.png">
            </a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>

            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav mr-auto">
                    <li class="nav-item active">
                        <a class="nav-link" href="inicio.jsp">Inicio <span class="sr-only">(current)</span></a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">Galeria</a>
                    </li>
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            Opciones
                        </a>
                        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                            <a class="dropdown-item" href="mantenimientoProveedores.jsp">Proveedores</a>
                            <a class="dropdown-item" href="mantenimientoFarmacias.jsp">Farmacias</a>
                            <a class="dropdown-item" href="mantenimientoConsultorios.jsp">Consultorios</a>
                            <a class="dropdown-item" href="mantenimientoEspecialidades.jsp">Especialidades</a>
                            <%--<div class="dropdown-divider"></div>
                            <a class="dropdown-item" href="#">Configuración</a>--%>
                        </div>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link disabled" href="#">Configuracion</a>
                    </li>
                </ul>
                <form class="form-inline my-2 my-lg-0">
                    <a href="mantenimientoUsuarios.jsp" class="btn btn-outline-info my-2 my-sm-0" margin="2px">Agregar Usuario</a>
                    <p>   </p>
                    <a href="loginStruts.jsp" class="btn btn-outline-danger my-2 my-sm-0">Salir</a>
                </form>
            </div>
        </nav>
        <br>
        <br>
        <br>
        <br>
        <html:form action="/MantenimientoUsuarios">
            <br>
            <br>
            <br>
            <br>
            <br>
            <br>
            <h4 align="center">Formulario de ingreso para nuevo usuario</h4>
            <h4 align="center">Rellene todos los campos</h4>
            <br>
            <div class="container">
                <div class="row>">
                    <div class="col-12">
                        <table class="table table-striped">
                            <thead>
                                <tr>
                                    <th scope="col"></th>
                                    <th scope="col">Nombre</th>
                                    <th scope="col">Correo</th>
                                    <th scope="col">Contraseña</th>
                                    <th scope="col">Genero</th>
                                    <th scope="col">Tipo</th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr>
                                    <th scope="row"></th>
                                    <td><html:text property="nombre" size="30" maxlength="100"/></td>
                                    <td><html:text property="correo" size="30" maxlength="50"/></td>
                                    <td><html:password property="contra" size="30" maxlength="16"/></td>
                                    <td>
                                        <html:select property="genero">
                                            <html:option value="">Seleccione</html:option>
                                            <html:option value="Masculino"/>
                                            <html:option value="Femenino"/>
                                        </html:select>
                                    </td>
                                    <td>
                                        <html:select property="tipo">
                                            <html:option value="">Seleccione</html:option>
                                            <html:option value="Admin"/>
                                            <html:option value="Usuario"/>
                                        </html:select>
                                    </td>
                                </tr>
                            </tbody>
                        </table>
                        <br>
                        <center>${advertencia}</center>

                        <br>
                        <div align="center">
                            <html:submit styleClass="btn btn-info" property="action" value="Agregar"/>
                            <html:submit styleClass="btn btn-info" property="action" value="Consultar"/>
                        </div>
                    </div>
                </div>
            </div>
        </html:form>
        <br>
        <br>
    </body>
</html>


<%--<table border="0">
    <tbody>
        <tr>
            <td>Nombre:</td>
            <td><html:text property="nombre" size="50" maxlength="100"></html:text>
        </tr>
         <tr>
            <td>Correo:</td>
            <td><html:text property="correo" size="50" maxlength="50"></html:text>
        </tr>
         <tr>
            <td>Contraseña:</td>
            <td><html:text property="contra" size="16" maxlength="16"></html:text>
        </tr>
         <tr>
            <td>Genero:</td>
            <td><html:text property="genero" size="50" maxlength="25"></html:text>
        </tr>
         <tr>
            <td>Tipo:</td>
            <td><html:text property="tipo" size="10" maxlength="50"></html:text>
        </tr>
        
        <tr colspan="2">
        <bean:write name="ActionFormUsuarios" property="error" filter="false"/>
        </tr>
    </tbody>
</table>--%>