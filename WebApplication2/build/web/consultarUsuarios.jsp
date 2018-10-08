<%-- 
    Document   : consultarUsuarios
    Created on : 10-01-2018, 01:57:08 PM
    Author     : david.floresusam
--%>

<%-- 
    Document   : consultarClinicas
    Created on : 09-17-2018, 09:44:09 AM
    Author     : david.floresusam
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Consultar Usuarios</title>
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
        <link rel="shortcut icon" href="favicon.ico" />
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="css/Style.css" rel="stylesheet" type="text/css"/>
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
                    <p>  </p>
                    <li class="nav-item">
                        <a class="btn btn-outline-info" href="#">Galeria</a>
                    </li>
                    <p>  </p>
                    <li class="nav-item dropdown">
                        <a class="btn btn-outline-info dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            Areas
                        </a>
                        <div class="dropdown-menu bg-info " aria-labelledby="navbarDropdown">
                            <a class="dropdown-item bg-info text-white" href="iniciocitas.jsp"><b>Citas</b></a>
                            <div class="dropdown-divider"></div>
                            <a class="dropdown-item bg-info text-white" href="iniciopacientes.jsp"><b>Pacientes</b></a>
                            <div class="dropdown-divider"></div>
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
                            <a class="dropdown-item bg-info text-white" href="MantenimientoClinicas.do?action=Agregar Clinica" ><b>Agregar Clinica</b></b></a>
                            <div class="dropdown-divider"></div>
                            <a class="dropdown-item bg-info text-white" href="MantenimientoFarmacias.do?action=Consultar_Farmacias"><b>Consultar Farmacias</b></a>
                        </div>
                    </li>
                </ul>
                <html:form action="/AgregarUsuario" styleClass="form-inline my-2 my-lg-0">

                    <html:submit property="action" value="Configuracion" styleClass="btn btn-outline-info disabled"/><p>  </p>
                    <html:submit property="action" value="Cerrar Sesion" styleClass="btn btn-outline-danger my-2 my-sm-0"/>
                </html:form>
            </div>
        </nav>

        <%--inicia el formulario de consulta--%>
        <br>
        <br>
        <h1 align="center">Usuarios</h1>
        <h3 align="center">Lista de usuarios en nuestro sistema medico</h3> 
        <br>
        <br>
        <div class="container-fluid">
            <div class="row scroll">
                <div class="col-1"></div>
                <div class="col-10">    
                    <table class="table table-striped">
                        <thead>
                            <tr align="center">
                                <th>Id Usuario</th>
                                <th>Nombre</th>
                                <th>Correo</th>
                                <th>Contraseña</th>
                                <th>Genero</th>
                                <th>Tipo</th>
                                <th>Pregunta</th>
                                <th>Respuesta</th>
                                <th ${message}>        Acciones        </th>
                            </tr>
                        </thead>
                        <tbody>
                            <logic:notEmpty name="ActionFormUsuarios" property="listaUsuarios" >
                                <logic:iterate id="ver" name="ActionFormUsuarios" property="listaUsuarios">
                                    <tr align="center">
                                        <html:form action="/MantenimientoUsuarios">
                                            <td>
                                                <bean:write name="ver" property="idUsuario"/>
                                                <div hidden="hidden"><html:text name="ver" property="idUsuario" styleClass="hidden"/></div>
                                            </td>
                                            <td>
                                                <bean:write name="ver" property="nombre"/>
                                            </td>
                                            <td>
                                                <bean:write name="ver" property="correo"/>
                                            </td>
                                            <td>
                                                <bean:write name="ver" property="contra"/>
                                            </td>
                                            <td>
                                                <bean:write name="ver" property="genero"/>
                                            </td>
                                            <td>
                                                <bean:write name="ver" property="tipo"/>
                                            </td>
                                            <td>
                                                <bean:write name="ver" property="pregunta"/>
                                            </td>
                                            <td>
                                                <bean:write name="ver" property="respuesta"/>
                                            </td>
                                            <td ${message}>
                                                <a class="btn btn-sm btn-success" href="MantenimientoUsuarios.do?action=irModificar&id=<bean:write name="ver" property="idUsuario"/>">Modificar</a>
                                                <a class="btn btn-sm btn-danger" href="MantenimientoUsuarios.do?action=Eliminar&id=<bean:write name="ver" property="idUsuario"/>" onclick="return confirm('¿Seguro que desea eliminar?')">Eliminar</a>
                                                <%--<html:link styleClass="btn btn-danger" page="/eliminarFarmacia.jsp">Eliminar</html:link>--%>
                                            </td>
                                        </html:form>
                                    </tr>
                                </logic:iterate>
                            </logic:notEmpty>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
        <div class="container"  align="center">
            <div class="row">
                <div class="col-12">
                    <p>${advertencia}</p>      
                </div>  
            </div>
        </div>
    </body>
</html>


