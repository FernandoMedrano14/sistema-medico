<%-- 
    Document   : consultarFarmacias
    Created on : 08-30-2018, 03:24:52 PM
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
        <title>Consultar Consultorios</title>
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
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
                            <a class="dropdown-item bg-info text-white" href="inicioclinicas.jsp"><b>Clinicas</b></a>
                            <div class="dropdown-divider"></div>
                            <a class="dropdown-item bg-info text-white" href="inicioproveedores.jsp"><b>Proveedores</b></a>
                            <div class="dropdown-divider"></div>
                            <a class="dropdown-item bg-info text-white" href="inicioFarmacias.jsp"><b>Farmacias</b></a>
                            <div class="dropdown-divider"></div>
                            <a class="dropdown-item bg-info text-white" href="mantenimientoConsultorios.jsp"><b>Consultorios</b></a>
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
                            <a class="dropdown-item bg-info text-white" href="mantenimientoConsultorios.jsp" ><b>Agregar Consultorio</b></b></a>
                        </div>
                    </li>
                </ul>
                <form class="form-inline my-2 my-lg-0">
                    <a href="mantenimientoUsuarios.jsp" class="btn btn-outline-info my-2 my-sm-0" margin="2px">Agregar Usuario</a>
                    <p>  </p>
                    <a class="btn btn-outline-info disabled" href="#">Configuracion</a>
                    <p>   </p>
                    <a href="loginStruts.jsp" class="btn btn-outline-danger my-2 my-sm-0">Salir</a>
                </form>
            </div>
        </nav>

        <%--inicia el formulario de consulta--%>
        <br>
        <br>
        <h1 align="center">Consultorios</h1>
        <h3 align="center">Lista de consultorios disponibles en nuestro hospital</h3> 
        <br>
        <br>
        <div class="container">
            <div class="row scroll">
                <div class="col-12">           
                    <table class="table table-striped">
                        <thead>
                            <tr align="center">
                                <th>Id Consultorio</th>
                                <th>Numero</th>
                                <th>Área</th>
                                <th>Acciones</th>
                            </tr>
                        </thead>
                        <tbody>

                            <logic:notEmpty name="ActionFormConsultorios" property="listaConsultorio" >
                                <logic:iterate id="ver" name="ActionFormConsultorios" property="listaConsultorio">
                                    <tr align="center">
                                        <html:form action="/MantenimientoConsultorios">
                                            <td>
                                                <bean:write name="ver" property="idConsultorio"/>
                                                <div hidden="hidden"><html:text name="ver" property="idConsultorio" styleClass="hidden"/></div>
                                            </td>
                                            <td>
                                                <bean:write name="ver" property="numero"/>
                                            </td>
                                            <td>
                                                <bean:write name="ver" property="area"/>
                                            </td>
                                            <td>
                                                <a class="btn btn-success" href="MantenimientoConsultorios.do?action=irModificar&id=<bean:write name="ver" property="idConsultorio"/>">Modificar</a>
                                                <a class="btn btn-danger" href="MantenimientoConsultorios.do?action=Eliminar&id=<bean:write name="ver" property="idConsultorio"/>">Eliminar</a>

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
    </body>
</html>
