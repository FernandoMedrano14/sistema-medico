<%-- 
    Document   : modificarmedicamentos
    Created on : 09-28-2018, 11:34:00 AM
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
        <title>Matenimiento Clinicas</title>
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
                        </div>
                    </li>
                    <p>  </p>
                    <li class="nav-item dropdown">
                        <a class="btn btn-outline-info dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            Acciones
                        </a>
                        <div class="dropdown-menu bg-info " aria-labelledby="navbarDropdown">
                            <a class="dropdown-item bg-info text-white" href="MantenimientoMedicamentos.do?action=Agregar Medicamentos" ><b>Agregar Medicamentos</b></b></a>
                            <div class="dropdown-divider"></div>
                            <a class="dropdown-item bg-info text-white" href="MantenimientoMedicamentos.do?action=Consultar_Medicamentos"><b>Consultar Medicamentos</b></a>
                        </div>
                    </li>
                </ul>
        </nav>
        <br>
        <br>
        <br>
        <br> 
        <br>
        <br> 
        <br>
        <h4 align="center">Formulario de modificación de medicamentos</h4>
        <h4 align="center">Ingrese los nuevos datos del medicamento</h4>
        <br>
        <br>
        <br>
        <br>

        <html:form action = "/MantenimientoMedicamentos">
            <div class="container">
                <div class="row">
                    <div class="col-12">
                        <table class="table table-stripped"> 
                            <thead>
                                <tr align="center">
                                    <th>Id Medicamento</th>
                                    <th>Id Proveedor</th>
                                    <th>Id Farmacia</th>
                                    <th>Nombre</th>
                                    <th>Tipo</th>
                                    <th>Acciones</th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr align="center">
                                    <td>
                                        <html:text readonly="true" property="idMedicamento" size="5" maxlength="" ></html:text>
                                        </td>
                                        <td>
                                        <html:text readonly="true" property="idProveedor" size="5" maxlength="" ></html:text>
                                        </td>
                                        <td>
                                        <html:text readonly="true" property="idFarmacia" size="5" maxlength="" ></html:text>
                                        </td>
                                        <td>
                                        <html:text property="nombre" size="60" maxlength="" readonly="re"></html:text>
                                        </td>
                                        <td>
                                        <html:text property="tipo" size="15" maxlength="" readonly="re"></html:text>
                                        </td>
                                        <td>
                                        <html:submit styleClass="btn btn-success" onclick="return confirm('¿Está realmente conforme con los cambios?')"  property="action" value="Modificar"/>
                                    </td>
                                </tr>
                            <br>
                            <tr colspan="3">
                                <bean:write name="ActionFormMedicamentos" property="error" filter="false"/>
                            </tr>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </html:form>
        <br>
    </body>
</html>


