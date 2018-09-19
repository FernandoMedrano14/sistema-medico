<%-- 
    Document   : respuestaconsultafarmacia
    Created on : 08-30-2018, 11:43:51 AM
    Author     : david.floresusam
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/Style.css" rel="stylesheet" type="text/css"/>
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link rel="shortcut icon" href="favicon.ico" />
        <title>Consultar Farmacia</title>
    </head>
    <body>
        <br>
        <br>
        <div class="container" align="center">
            <div class="row">
                <div class="col-12">
                    <img src="exito.png">
                    <h2>La consulta a Farmacias se hizo correctamente.</h2>
                    <br>
                    <br>
                    <br>
                    <div class="container">
                        <h2 align="center">Farmacias</h2>
                        <p>Abajo se muestra la dirección de la farmacia solicitada</p>            
                        <table class="table table-bordered">
                            <thead align="center">
                                <tr>
                                    <th>ID Farmacia</th>
                                    <th>Direccion Farmacia</th>
                                </tr>
                            </thead>
                            <tbody align="center">
                                <tr>
                                    <td> <bean:write name="ActionFormFarmacias" property="idFarmacia"/></td>
                                    <td> <bean:write name="ActionFormFarmacias" property="direccion"/></td>
                                </tr>
                            </tbody>
                        </table>
                    </div>
                    <br>
                    <html:link styleClass="btn btn-primary"  page="/idconsultaFarmacia.jsp">Regresar</html:link>
                    <html:link styleClass="btn btn-primary"  page="/inicio.jsp">Inicio</html:link>
                </div>
            </div>
        </div>
    </body>
</html>
