<%-- 
    Document   : eliminarProveedor
    Created on : 08-28-2018, 04:22:37 PM
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
        <title>Eliminar Usuario</title>
    </head>
    <body>
        <html:form action="/MantenimientoProveedores">
            <div class="container">
                <div class="row">
                    <div class="col-12">
                        <br>
                        <br>
                        <div align="center"><img src="sistema.jpg"></div>
                        <br>
                        <h4 align="center">Formulario de eliminación de proveedor</h4>
                        <h4 align="center">Ingrese el ID del proveedor que desea eliminar</h4>
                        <br>
                        <table class="table-bordered" align="center">
                            <thead>
                                <tr>
                                    <th scope="col">ID PROVEEDOR</th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr>
                                    <td><html:text property="idProveedor" size="10" maxlength="100"></html:text>
                                    </tr>                    
                                    <tr colspan="2">
                                    <bean:write name="ActionFormProveedores" property="error" filter="false"/>
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
            <html:link styleClass="btn btn-info" page="/mantenimientoProveedores.jsp">Volver</html:link>
        </div>
    </body>
</html>
