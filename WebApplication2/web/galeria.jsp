<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
        <link rel="shortcut icon" href="favicon.ico" />
        <link href="css/styleinicio.css" rel="stylesheet" type="text/css"/>
        <title>Galeria</title>
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
                    <p>  </p>
                     <li class="nav-item dropdown">
                        <a class="btn btn-outline-info dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            Acciones
                        </a>
                        <div class="dropdown-menu bg-info " aria-labelledby="navbarDropdown">
                            <a class="dropdown-item bg-info text-white" href="mantenimientoFarmacias.jsp" ><b>Agregar Farmacia</b></b></a>
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

        <br>
    <center><h2>¡BIENVENIDOS A NUESTRA GALERIA!</center></h2>



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
            <img src="galeria1.jpg" alt="Los Angeles" width="1100" height="500">
        </div>
        <div class="carousel-item">
            <img src="galeria2.jpg" alt="Chicago" width="1100" height="500">
        </div>
        <div class="carousel-item">
            <img src="galeria3.jpg" alt="New York" width="1100" height="500">
        </div>
        <div class="carousel-item">
            <img src="galeria4.jpg" alt="New York" width="1100" height="500">
        </div>
        <div class="carousel-item">
            <img src="galeria5.jpg" alt="New York" width="1100" height="500">
        </div>
        <div class="carousel-item">
            <img src="galeria6.jpg" alt="New York" width="1100" height="500">
        </div>
        <div class="carousel-item">
            <img src="galeria7.jpg" alt="New York" width="1100" height="500">
        </div>
        <div class="carousel-item">
            <img src="galeria8.jpg" alt="New York" width="1100" height="500">
        </div>
        <div class="carousel-item">
            <img src="galeria9.jpg" alt="New York" width="1100" height="500">
        </div>
        <div class="carousel-item">
            <img src="galeria10.jpg" alt="New York" width="1100" height="500">
        </div>
        <div class="carousel-item">
            <img src="galeria11.jpg" alt="New York" width="1100" height="500">
        </div>
        <div class="carousel-item">
            <img src="galeria12.jpg" alt="New York" width="1100" height="500">
        </div>
        <div class="carousel-item">
            <img src="galeria13.jpg" alt="New York" width="1100" height="500">
        </div>
        <div class="carousel-item">
            <img src="galeria14.jpg" alt="New York" width="1100" height="500">
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
            height: 800px;
        }
    </style>
</div>

<br>

<br>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
</body>
</html>

