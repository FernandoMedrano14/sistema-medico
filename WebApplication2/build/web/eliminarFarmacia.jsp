<%-- 
    Document   : eliminarFarmacia
    Created on : 08-28-2018, 04:42:47 PM
    Author     : david.floresusam
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
        <link rel="shortcut icon" href="favicon.ico" />
        <title>Eliminar Farmacia</title>
    </head>
    <body>
        <nav class="navbar navbar-expand-lg navbar-light bg-light">
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
                    <a href="mantenimientoUsuarios.jsp" class="btn btn-outline-success my-2 my-sm-0" margin="2px">Agregar Usuario</a>
                    <p>   </p>
                    <a href="loginStruts.jsp" class="btn btn-outline-success my-2 my-sm-0">Cerrar</a>
                </form>
            </div>
        </nav>
        <html:form action="/MantenimientoFarmacias">
            <div class="container">
                <div class="row">
                    <div class="col-12">
                        <br>
                        <br>
                        <br>
                        <h4 align="center">Formulario de eliminación de Farmacias</h4>
                        <h4 align="center">Ingrese el ID de la Farmacia que desea eliminar</h4>
                        <br>
                        <table class="table-bordered" align="center">
                            <thead>
                                <tr>
                                    <th scope="col">ID FARMACIA</th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr>
                                    <td><html:text property="idFarmacia" size="10" maxlength="100"></html:text>
                                    </tr>                    
                                    <tr colspan="2">
                                    <bean:write name="ActionFormFarmacias" property="error" filter="false"/>
                                </tr>
                            </tbody>
                        </table>
                        <br>
                        <div align="center">
                            <html:submit styleClass="btn btn-info"  property="action" value="Eliminar"/>
                        </div>
                    </div>
                </div>
            </div>
        </html:form>
        <br>
        <div align="center">
            <html:link styleClass="btn btn-info" page="/mantenimientoFarmacias.jsp">Volver</html:link>
        </div>
    </body>
</html>