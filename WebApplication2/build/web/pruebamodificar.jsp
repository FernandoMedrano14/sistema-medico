<%-- 
    Document   : pruebamodificar
    Created on : 08-30-2018, 02:02:40 PM
    Author     : david.floresusam
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="css/bootstrap.min.css" rel="stylesheet">
    </head>
    <body background="img/fondo1.jpg">
        <div class="container">
            <div class="row">
                <div class="col-6">
                    <form action="controller3?action=actualizar" method="consultabyid">
                        
                            <table class="table table-bordered">
                                <tr>
                                    <td>
                                        <label>IDAUTOR</label><br />
                                        <input type="text" name="idAutor" placeholder="idAutor" readonly="readonly" value="${autore.idAutor}">
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <label>NOMBRE:</label> <br/>
                                        <input type="text" name="nombre" placeholder="nombre" value="${autore.nombre}" >
                                    </td>
                                </tr>
                                
                                
                                <tr>
                                    <td>
                                        <button class="btn btn-dark" name="action" value="actualizar">Actualizar</button>
                                    </td>
                                </tr>
                            </table>
                        
                    </form>
                    <a class="btn btn-warning" href="controller3?action=consultar">Atrás</a>
                </div>
            </div>
        </div>
    </body>
</html>

