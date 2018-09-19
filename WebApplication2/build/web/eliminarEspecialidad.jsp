<%-- 
    Document   : eliminarEspecialidad
    Created on : 08-29-2018, 03:43:28 PM
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
        <link rel="shortcut icon" href="favicon.ico" />
        <title>Eliminar Especialidad</title>
    </head>
    <body>
        <html:form action="/MantenimientoEspecialidades">
            <div class="container">
                <div class="row">
                    <div class="col-12">
                        <br>
                        <br>
                        <div align="center"><img src="sistema.jpg"></div>
                        <br>
                        <h4 align="center">Formulario de eliminación de especialidades</h4>
                        <h4 align="center">Ingrese el ID de la especialidad que desea eliminar</h4>
                        <br>
                        <table class="table-bordered" align="center">
                            <thead>
                                <tr>
                                    <th scope="col">ID ESPECIALIDAD</th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr>
                                    <td><html:text property="idEspecialidad" size="10" maxlength="100"></html:text>
                                    </tr>                    
                                    <tr colspan="2">
                                    <bean:write name="ActionFormEspecialidades" property="error" filter="false"/>
                                </tr>
                            </tbody>
                        </table>
                        <br>
                        <div align="center">
                            <html:submit styleClass="btn btn-info"  property="action" value="Eliminar"/>
                        </div>
                    </div>
                </div>
            </div>
        </html:form>
        <br>
        <div align="center">
            <html:link styleClass="btn btn-info" page="/mantenimientoEspecialidades.jsp">Volver</html:link>
        </div>
    </body>
</html>