<%-- 
    Document   : inicioproveedores
    Created on : 09-07-2018, 01:20:56 PM
    Author     : david.floresusam
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
        <link rel="shortcut icon" href="favicon.ico" />
        <link href="css/styleinicio.css" rel="stylesheet" type="text/css"/>
        <link href="css/accesodenegado.css" rel="stylesheet" type="text/css"/>
        <script src="js/accesodenegado.js" type="text/javascript"></script>
        <title>Inicio Proveedores</title>
    </head>
    <body ${mensaje}>
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
                        <a class="btn btn-outline-info" href="inicio.jsp">Inicio<span class="sr-only">(current)</span></a>
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
                            <html:form action="/AgregarUsuario" styleClass="form-inline my-2 my-lg-0">
                                <html:hidden property="nombrepagina" value="denegarproveedores"/>
                                <html:hidden property="accesoagregar" value="guardadoProveedor"/>
                                <html:submit property="action" value="Agregar Proveedor" styleClass="dropdown-item bg-info text-white"/>
                            </html:form>
                            <a class="dropdown-item bg-info text-white" href="MantenimientoProveedores.do?action=Agregar" ><b>Agregar Proveedor</b></b></a>
                            <div class="dropdown-divider"></div>
                            <a class="dropdown-item bg-info text-white" href="MantenimientoProveedores.do?action=Consultar_Proveedores"><b>Consultar Proveedores</b></a>
                        </div>
                    </li>
                </ul>
                <html:form action="/AgregarUsuario" styleClass="form-inline my-2 my-lg-0">

                    <html:submit property="action" value="Configuracion" styleClass="btn btn-outline-info disabled"/><p>  </p>
                    <html:submit property="action" value="Cerrar Sesion" styleClass="btn btn-outline-danger my-2 my-sm-0"/>
                </html:form>
            </div>
        </nav>
        <div id="id01" class="modal">

            <div class="modal-content animate">
                <div class="imgcontainer">
                    <span onclick="document.getElementById('id01').style.display = 'none'" class="close" title="Close Modal">&times;</span>
                    <img src="ACCESODENEGADO.png" alt="Avatar" class="avatar">
                </div>

                <div class="container">
                    <h4 style="text-align: center">El acceso fue negado porque la accion<br/>requiere permisos de administración</h4>
                </div>

                <div class="container" style="background-color:#f1f1f1">
                    <div class="form-row">
                        <div class="form-group col-md-3"></div>
                        <div class="form-group col-md-6"><button type="button" onclick="document.getElementById('id01').style.display = 'none'" class="btn btn-info">Aceptar</button></div>
                        <div class="form-group col-md-3"></div>
                    </div>

                </div>
            </div>
        </div>
        <br>
    <center><h2>¡BIENVENIDOS A NUESTROS PROVEEDORES!</center></h2>
<br>


<div id="demo" class="carousel slide" data-ride="carousel">

    <!-- Indicators -->
    <ul class="carousel-indicators">
        <li data-target="#demo" data-slide-to="0" class="active"></li>
        <li data-target="#demo" data-slide-to="1"></li>
        <li data-target="#demo" data-slide-to="2"></li>
    </ul>

    <!-- The slideshow -->
    <div class="carousel-inner">



        <div class="carousel-item active">
            <img src="prov1.png" alt="Los Angeles" width="1100" height="500">
        </div>
        <div class="carousel-item">
            <img src="prov2.jpg" alt="Chicago" width="1100" height="500">
        </div>
        <div class="carousel-item">
            <img src="prov3.jpg" alt="New York" width="1100" height="500">
        </div>
    </div>

    <!-- Left and right controls -->
    <a class="carousel-control-prev" href="#demo" data-slide="prev">
        <span class="carousel-control-prev-icon"></span>
    </a>
    <a class="carousel-control-next" href="#demo" data-slide="next">
        <span class="carousel-control-next-icon"></span>
    </a>
    <style>
        /* Make the image fully responsive */
        .carousel-inner img {
            width: 1650px;
            height: 400px;
        }
    </style>
</div>

<br>
<div class="container">
    <div class="row">
        <div class="col-12">

            <center><h1>	
                    Sólo trabajamos con proveedores que cumplen con nuestros niveles de exigencia.

                </h1></center>
        </div>
    </div>
</div>
<br>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
</body>
</html>

