<%-- 
    Document   : modificarPaciente
    Created on : 10-04-2018, 03:57:20 PM
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
                           <a class="dropdown-item bg-info text-white" href="MantenimientoPacientes.do?action=Agregar Paciente" ><b>Agregar Paciente</b></b></a>
                            <div class="dropdown-divider"></div>
                            <a class="dropdown-item bg-info text-white" href="MantenimientoPacientes.do?action=Consultar_Pacientes"><b>Consultar Pacientes</b></a>
                        </div>
                    </li>
                </ul>
                <html:form action="/AgregarUsuario" styleClass="form-inline my-2 my-lg-0">
                    <html:submit property="action" value="Configuracion" styleClass="btn btn-outline-info disabled"/><p>  </p>
                    <html:submit property="action" value="Cerrar Sesion" styleClass="btn btn-outline-danger my-2 my-sm-0"/>
                </html:form>
            </div>
        </nav>
        <html:form action = "/MantenimientoPacientes">
            <br>
            <br>
            <br>
            <h4 align="center" class="font-weight-bold">Formulario de modificación de Pacientes</h4>
            <h4 align="center" class="font-weight-bold">Ingrese los nuevos datos del paciente</h4>
            <br>
            <br>
            <div class="container">
                <div class="card-header">
                    <div class="row">
                        <div class="col-2"></div>
                        <div class="col-10">
                            <div class="row">
                                <div class="form-group col-md-5">
                                    <label class="font-weight-bold">Id Paciente:</label>
                                    <html:text readonly="true" property="idPaciente" size="5" maxlength="" styleClass="form-control"></html:text>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="form-group col-md-5">
                                        <label class="font-weight-bold">Id Medicamento:</label>
                                    <html:text readonly="true" property="idMedicamento" size="5" maxlength="" styleClass="form-control"></html:text>
                                    </div> 
                                    <div class="form-group col-md-5">
                                        <label class="font-weight-bold">Id Clinica:</label>
                                    <html:text readonly="true" property="idClinica" size="5" maxlength="" styleClass="form-control"></html:text>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="form-group col-md-5">
                                        <label class="font-weight-bold">Nombre:</label>
                                    <html:text property="nombre" size="5" maxlength="" styleClass="form-control"/>
                                </div> 
                                <div class="form-group col-md-5">
                                    <label class="font-weight-bold">Apellido:</label>
                                    <html:text property="apellido" size="5" maxlength="" styleClass="form-control"></html:text>
                                    </div>  
                                </div>
                                <div class="row">
                                    <div class="form-group col-md-5">
                                        <label class="font-weight-bold">Sexo:</label>
                                    <html:select property="sexo" styleClass="form-control">
                                        <html:option value="">--Seleccione--</html:option>
                                        <html:option value="Masculino"/>
                                        <html:option value="Femenino"/>
                                        <html:option value="Por definir"/>
                                    </html:select>
                                </div> 
                                <div class="form-group col-md-5">
                                    <label class="font-weight-bold">Fecha de Nacimiento:</label>
                                    <html:text property="fecha_nacimiento" size="5" maxlength="" styleClass="form-control"></html:text>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="form-group col-md-5">
                                        <label class="font-weight-bold">Telefono:</label>
                                    <html:text property="telefono" size="5" maxlength="" styleClass="form-control"></html:text>
                                    </div>
                                    <div class="form-group col-md-5">
                                        <label class="font-weight-bold">Direccion:</label>
                                    <html:text property="direccion" size="5" maxlength="" styleClass="form-control"></html:text>
                                    </div>
                                </div>
                                <br>
                                <div class="form-group col-md-10 text-center">
                                <html:submit styleClass="btn btn-success" onclick="return confirm('¿Está realmente conforme con los cambios?')"  property="action" value="Modificar"/>
                            </div>
                            <p align="center">${advertencia}</p>
                        </div>
                    </div>
                </div>
            </div>
        </html:form>
    </body>
</html>
