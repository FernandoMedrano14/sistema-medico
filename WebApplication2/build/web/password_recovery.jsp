<%-- 
    Document   : password_recovery
    Created on : 09-28-2018, 03:28:37 PM
    Author     : julio.benavidesusam
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <style>
            body{
                background-image: url("medi2.jpg")   
            }            
        </style>
        <title>JSP Page</title>
    </head>
    <body>
        <div class="container-fluid">
            <div class="row">
                <div class="col-4"></div>
                <div class="col-4"><br><br><br><br>
                    <div class="card card-container">
                         
                        <h3 style="text-align: center">Recuperacion de contraseña</h3>
                         
                        <html:form action="/AgregarUsuario">
                            <div class="form-row">
                                <div class="form-group col-md-1"></div>
                                <div class="form-group col-md-5">
                                    <label><b>Usuario:</b></label>
                                    <html:text property="username" styleClass="form-control"/>
                                </div>
                                <div class="form-group col-md-5">
                                    <label><b>Correo:</b></label>
                                    <html:text property="e_mail" styleClass="form-control"/>
                                </div>
                                <div class="form-group col-md-1"></div>
                                <div class="row">
                                    <div class="form-group col-md-1"></div>
                                    <div class="form-group col-md-5">
                                        <label>Pregunta de seguridad</label>
                                    </div>
                                    <div class="form-group col-md-5">
                                    </div>
                                    <div class="form-group col-md-1"></div>
                                </div>
                            </div>
                        </html:form>
                    </div>
                </div>
                <div class="col-4"></div>
            </div>
        </div>
    </body>
</html>
