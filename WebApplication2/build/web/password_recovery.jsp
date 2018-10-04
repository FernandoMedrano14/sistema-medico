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
                         <br>
                        
                        
                        ${mensaje}
                         <br>
                        <html:form action="/AgregarUsuario">
                            <div class="form-row">
                                <div class="form-group col-md-1"></div>
                                <div class="form-group col-md-5">
                                    <label><b>Usuario:</b></label>
                                    <html:text property="nombre" styleClass="form-control"/>
                                </div>
                                <div class="form-group col-md-5">
                                    <label><b>Correo:</b></label>                                    
                                    <html:text property="correo" styleClass="form-control"/>
                                </div>
                                <div class="form-group col-md-1"></div>
                                <div class="row" ${mensaje2}>
                                    <div class="form-group col-md-2"></div>
                                    <div class="form-group col-md-8">
                                        <label>Ingrese su usuario y su correo para continuar la recuperación de su cuenta</label>
                                    </div>
                                    <div class="form-group col-2"></div>
                                    <div class="form-group col-5"></div>
                                    <div class="form-group col-2">
                                        <html:submit property="action" value="Ingresar" styleClass="btn btn-sm btn-info"/>
                                    </div>
                                    <div class="form-group col-5"></div>
                                </div>
                                <div class="row" ${mensaje3}>
                                    <div class="form-group col-md-1"> </div>
                                    <div class="form-group col-md-10">
                                        <label>Pregunta de seguridad: </label>
                                        <bean:write name="LoginForm" property="pregunta"/><p> </p>
                                    </div>
                                    <div class="form-group col-md-1"></div>
                                    <div class="form-group col-md-1"></div>
                                    <div class="form-group col-md-10">
                                        <label>Respuesta: </label>
                                        <html:text property="respuesta" styleClass="form-control"/>
                                    </div>
                                    <div class="form-group col-md-1"></div>
                                    <div class="form-group col-md-2"></div>
                                    <div class="form-group col-md-8">
                                        <label>Ingrese la respuesta a su pregunta de seguridad y de clic a enviar para verificar la información</label>
                                    </div>
                                    <div class="form-group col-md-1"></div>
                                    <div class="form-group col-md-5"><html:text property="idUsuario" styleClass="form-control"/></div>
                                    <div class="form-group col-md-2">
                                        <html:submit property="action" value="Enviar" styleClass="btn btn-sm btn-info"/>
                                    </div>
                                    <div class="form-group col-md-5"></div>
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
