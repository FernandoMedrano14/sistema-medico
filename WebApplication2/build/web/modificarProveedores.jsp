<%-- 
    Document   : modificarProveedores
    Created on : 09-06-2018, 01:25:30 PM
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
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
        <link rel="shortcut icon" href="favicon.ico" />
        <title>Modificar Farmacia</title>
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
                    <a href="mantenimientoMedicamentos.jsp" class="btn btn-outline-info my-2 my-sm-0" margin="2px">Medicamentos</a>
                    <p>   </p>
                    <a href="mantenimientoUsuarios.jsp" class="btn btn-outline-info my-2 my-sm-0" margin="2px">Agregar Usuario</a>
                    <p>   </p>
                    <a href="loginStruts.jsp" class="btn btn-outline-danger my-2 my-sm-0">Cerrar</a>
                </form>
            </div>
        </nav>
        <br>
        <br>
        <br>
        <br>
        <br>
        <br>
        <br>
        <br>
        <br>
        <html:form action = "/MantenimientoProveedores">
            <div class="container">
                <div class="row">
                    <div class="col-12">
                        <table class="table table-stripped"> 
                            <thead>
                                <tr align="center">
                                    <th>Id Proveedor</th>
                                    <th>Nueva Rubro</th>
                                    <th>Nuevo Encargado</th>
                                    <th>Acciones</th>
                                </tr>
                            </thead>
                            <tbody align="center">
                                <tr>
                                    <td>
                                        <html:text readonly="true" property="idProveedor" size="10" maxlength="" ></html:text>
                                        </td>
                                        <td>
                                        <html:text property="rubro" size="60" maxlength="" readonly="re"></html:text>
                                        </td>
                                        <td>
                                        <html:text property="encargado" size="60" maxlength="" readonly="re"></html:text>
                                        </td>
                                        <td>
                                        <html:submit styleClass="btn btn-success" property="action" value="Modificar"/>
                                    </td>
                                </tr>
                            <br>
                            <tr colspan="3">
                                <bean:write name="ActionFormProveedores" property="error" filter="false"/>
                            </tr>
                            </tbody>
                        </table>
                        <div align="center">
                            <html:link styleClass="btn btn-info" page="/mantenimientoProveedores.jsp">Volver</html:link>
                            <html:submit styleClass="btn btn-info" property="action" value="Consultar_Proveedores"/>
                        </div>
                    </div>
                </div>
            </div>
            <br>
            <%-- <html:submit property="action" value="ConsultarId"/>--%>
        </html:form>
    </body>
</html>

