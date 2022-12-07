
<%
    if (session.getAttribute("login") != "OK") {
        response.sendRedirect("index.jsp");
    }
%>
<%
    Factura_compra items = (Factura_compra) request.getAttribute("compra");
%>
<%@page import="com.emergentes.modelo.Factura_compra"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="es">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.1/css/all.min.css"/>
        <title>Supermarket</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
        <style>
            .form-label{
                font-size: 20px;
                font-family: serif;
                color: black;
                font-weight: bold;
                .mb-3{

                    margin-left: 70px;
                    margin-right: 70px;
                    margin-top: 0px;
                    margin-bottom: 40px;
                }       
            }
            .form-control{

                border-color: black;
                border-spacing: 6px;
            }
            .mb-3{
                margin-left: 320px;
                width:90%;
                border-color: #E5BE01;
                border-spacing: 5px;
                color: chartreuse;
                    
                    
            }

        </style>
    </head>
    <body style="background: rgb(207,252,254); background: linear-gradient(90deg, rgba(207,252,254,1) 7%, rgba(168,212,217,1) 48%, rgba(100,130,196,1) 95%);height: 100vh; align-content: center">

        <div class="container" style="background: bottom; margin: 6%; align-content: center; ">
            <h1 style="font-size: 45px; font-family: serif; text-align: center; top:10px; color: white">FORMULARIO DE REGISTROS COMPRAS</h1>
            <h2 style="font-size: 35px; font-family: serif; text-align: justify; top: 20px; color:  #3b5998"><%=(items.getId_factura() == 0) ? "Nuevo Registro" : "Editar Registro"%></h2>

            <jsp:include page="WEB-INF/menu.jsp">
                <jsp:param name="opcion" value="compras"/>
            </jsp:include>
            <br>
            <form action="CompraControlador" method="POST">
                <div class="form-group" style="align-items: center; position: relative; align-content: center; ">
                    <div class="col-md-8" style="left: 270px; top: -38px">
                        <input type="hidden" name="id_factura" value="${compra.id_factura}" >
                        <div class="mb-3" >
                            <label for="" class="form-label">Fecha Compra</label>
                            <input type="date" class="form-control" name="fecha_compra" value="${compra.fecha_compra}" placeholder="Ingrese la Fecha de Compra">
                        </div>
                    </div>
                        
                    <div class="col-md-8" style="left: 170px; top: -38px">
                        <div class="mb-3">
                            <label for="" class="form-label">Proveedor</label>
                            <select name="nit" class="form-select" aria-label="Default select example">
                                <option value="">--PROVEEDOR--</option>
                                <c:forEach var="item" items="${lista_proveedor}">
                                    <option value="${item.nit}" 
                                            <c:if test="${compra.nit==item.nit}">
                                                selected
                                            </c:if>
                                            >${item.nombre}</option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                    <div class="col-md-8" style="left: 270px; top: -38px">
                        <div class="mb-3">
                            <label for="" class="form-label">Factura del Proveedor</label>
                            <input type="text" class="form-control" name="nro_factura" value="${compra.nro_factura}" placeholder="Ingrese Numero De Factura Que le dio EL Proveedor ">
                        </div>
                    </div>
                </div>
                <!-- comment -->
                <button type="submit" class="btn btn-primary" style="margin-left:73%; width: 150px; margin-top: 20px;">Enviar</button>
            </form>
        </div>
        <br>
        <br>

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
    </body>
</html> 


