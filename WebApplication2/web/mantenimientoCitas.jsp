<%-- 
    Document   : Farmacias
    Created on : 08-28-2018, 04:08:36 PM
    Author     : david.floresusam
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="css/Style.css" rel="stylesheet" type="text/css"/>
        <link rel="shortcut icon" href="favicon.ico" />
        <title>Mantenimiento Citas</title>
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
                            <%--<div class="dropdown-divider"></div>
                            <a class="dropdown-item" href="#">Configuración</a>--%>
                        </div>
                    </li>
                </ul>
                <html:form action="/AgregarUsuario" styleClass="form-inline my-2 my-lg-0">

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
        <h4 align="center">Formulario de ingreso para nueva CITA</h4>
        <h4 align="center">Ingrese la Informacion de la cita</h4>
        <br>            
        <div class="container">
            <div class="row>">
                <div class="col-12">
                    <html:form action="/MantenimientoCitas" styleClass="form">
                        <table class="table table-striped">
                            <thead align="center">
                                <tr>
                                    <th scope="col"></th>
                                    <th scope="col">Id Paciente</th>
                                    <th scope="col">Id Consultorio</th>
                                    <th scope="col">Id Medico</th>
                                    <th scope="col">Fecha Cita</th>
                                    <th scope="col">Hora Cita</th>
                                </tr>
                            </thead>
                            <tbody align="center">
                                <tr>
                                    <th scope="row"></th>
                                    <td>
                                        <html:select property="idPaciente">
                                            <logic:notEmpty name="ActionFormCitas" property="listaPacientes">
                                                <logic:iterate id="ver" name="ActionFormCitas" property="listaPacientes">
                                                    <html:option value="${ver.idPaciente}">
                                                        ${ver.idPaciente}
                                                    </html:option>
                                                </logic:iterate>
                                            </logic:notEmpty>
                                        </html:select>
                                    <td>
                                        <html:select property="idConsultorio">
                                            <logic:notEmpty name="ActionFormCitas" property="listaConsultorio">
                                                <logic:iterate id="ver" name="ActionFormCitas" property="listaConsultorio">
                                                    <html:option value="${ver.idConsultorio}">
                                                        ${ver.idConsultorio}
                                                    </html:option>
                                                </logic:iterate>
                                            </logic:notEmpty>
                                        </html:select>
                                    </td>
                                    <td>
                                        <html:select property="idMedico">
                                            <logic:notEmpty name="ActionFormCitas" property="listamedi">
                                                <logic:iterate id="ver" name="ActionFormCitas" property="listamedi">
                                                    <html:option value="${ver.idMedico}">
                                                        ${ver.idMedico}
                                                    </html:option>
                                                </logic:iterate>
                                            </logic:notEmpty>
                                        </html:select>
                                    </td>
                                    <td><html:text property="fecha_cita" size="15" maxlength="50" styleClass="form-control"/></td>
                                    <td><html:text property="hora_cita" size="15" maxlength="50" styleClass="form-control"/></td>
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
    </body>
</html>
