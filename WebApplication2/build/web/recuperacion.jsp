<%-- 
    Document   : consultarusuario
    Created on : 08-23-2018, 03:41:03 PM
    Author     : Admin109
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/Style.css" rel="stylesheet" type="text/css"/>
        <link rel="shortcut icon" href="favicon.ico" />
        <title>JSP Page</title>
    <body>
        <html:form action="/consultarusuario">
            <div class="container">
                <div class="row>">
                    <div class="col-12 text-center">
                        <html:submit styleClass="btn btn-primary" property="action" value="Nuevo" />
                        <html:submit styleClass="btn btn-primary" property="action" value="Agregar"/>
                        <html:submit styleClass="btn btn-primary" property="action" value="Consultar"/>
                        <html:link styleClass="btn btn-primary" page="/eliminarUsuario.jsp">Eliminar</html:link>
                        </div>
                    </div>
                </div>
        </html:form>
        <br>
        <br>
        <div align="center">
            <html:link styleClass="btn btn-secondary" page="/index.jsp">Index</html:link>
            </div>
        </body>
    </html>
