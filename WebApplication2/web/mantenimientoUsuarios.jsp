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
                        <a class="btn btn-outline-info" href="inicio.jsp">Inicio <span class="sr-only">(current)</span></a>
                    </li>
                    <p> </p>
                    <p> </p>
                    <li class="nav-item">
                        <a class="btn btn-outline-info" href="#">Galeria</a>
                    </li>
                    <p> </p>
                    <p> </p>
                    <%--<li class="nav-item dropdown">
                        <a class="btn btn-outline-info dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            Areas
                        </a>
                        <div class="dropdown-menu bg-info " aria-labelledby="navbarDropdown">
                            <a class="dropdown-item bg-info text-white" href="iniciomedicamentos.jsp"><b>Medicamentos</b></a>
                            <div class="dropdown-divider"></div>
                            <a class="dropdown-item bg-info text-white" href="iniciomedicos.jsp"><b>Medicos</b></a>
                            <div class="dropdown-divider"></div>
                            <a class="dropdown-item bg-info text-white" href="inicioclinicas.jsp"><b>Clinicas</b></a>
                            <div class="dropdown-divider"></div>
                            <a class="dropdown-item bg-info text-white" href="inicioproveedores.jsp"><b>Proveedores</b></a>
                            <div class="dropdown-divider"></div>
                            <a class="dropdown-item bg-info text-white" href="inicioFarmacias.jsp"><b>Farmacias</b></a>
                            <div class="dropdown-divider"></div>
                            <a class="dropdown-item bg-info text-white" href="inicioconsultorios.jsp"><b>Consultorios</b></a>
                            <div class="dropdown-divider"></div>
                            <a class="dropdown-item bg-info text-white" href="inicioespecialidades.jsp"><b>Especialidades</b></a>
                        </div>
                    </li>
                    <p>  </p>
                    <li class="nav-item dropdown">
                        <a class="btn btn-outline-info dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            Acciones
                        </a>
                        <div class="dropdown-menu bg-info " aria-labelledby="navbarDropdown">
                            <a class="dropdown-item bg-info text-white" href="MantenimientoUsuarios.do?action=Consultar_Usuarios"><b>Consultar usuarios</b></a>
                        </div>
                    </li>--%>
                </ul>
                <html:form action="/AgregarUsuario" styleClass="form-inline my-2 my-lg-0">
                    <html:submit property="action" value="Agregar Usuario" styleClass="btn btn-outline-info my-2 my-sm-0"/><p>  </p>
                    <html:submit property="action" value="Configuracion" styleClass="btn btn-outline-info disabled"/><p>  </p>
                    <html:submit property="action" value="Cerrar Sesion" styleClass="btn btn-outline-danger my-2 my-sm-0"/>
                </html:form>
            </div>
        </nav>
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
                    <html:form action="/MantenimientoUsuarios" styleClass="form">
                        <table class="table table-striped">
                            <thead align="center">
                                <tr>
                                    <th scope="col"></th>
                                    <th scope="col">Id</th>
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
                                    <td>
                                        <p>
                                            El id se colocará automaticamente.
                                        </p>
                                    </td>
                                    <td><html:text property="nombre" size="50" maxlength="100" styleClass="form-control"/></td>
                                    <td><html:text property="correo" size="30" maxlength="50" styleClass="form-control"/></td>
                                    <td><html:password property="contra" size="30" maxlength="16" styleClass="form-control"/></td>
                                    <td>
                                        <html:select property="genero" styleClass="form-control">
                                            <html:option value="">Seleccione</html:option>
                                            <html:option value="Masculino"/>
                                            <html:option value="Femenino"/>
                                        </html:select>
                                    </td>
                                    <td>
                                        <html:select property="tipo" styleClass="form-control">
                                            <html:option value="">Seleccione</html:option>
                                            <html:option value="Admin"/>
                                            <html:option value="Usuario"/>
                                        </html:select>
                                    </td>
                                </tr>
                                <tr>
                            <br>
                            <br>
                                    <td> </td>
                                    <td><h5 style="text-align: center">Pregunta de seguridad: </h5></td>
                                    <td>
                                        <html:select property="pregunta" styleClass="form-control">
                                            <html:option value="">Selecione una pregunta</html:option>
                                            <html:option value="¿Cual es tu animal favorito?"/>
                                            <html:option value="¿Cual es el nombre de tu mascota?"/>
                                            <html:option value="¿Cual es tu equipo de futbol favorito?"/>
                                            <html:option value="¿Cual es el nombre de la primera escuela a la que asististe?"/>
                                        </html:select>
                                    </td>
                                    <td><h5 style="text-align: center">Respuesta: </h5></td>
                                    <td><html:text property="respuesta" styleClass="form-control"/></td>
                                </tr>
                            </tbody>
                        </table>
                        <br>
                        <center>${advertencia}</center>
                        <br>
                        <div align="center">
                            <html:submit styleClass="btn btn-info" property="action" value="Agregar"/>
                        </div>
                    </html:form>
                </div>
            </div>
        </div>
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