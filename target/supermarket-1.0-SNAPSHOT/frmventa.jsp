<%
    if (session.getAttribute("login") != "OK") {
        response.sendRedirect("index.jsp");
    }
%>
<%
    Factura_venta items = (Factura_venta) request.getAttribute("venta");
%>
<%@page import="com.emergentes.modelo.Factura_venta"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="es">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.1/css/all.min.css"/>
        <title>Sepermarket</title>
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
            .mb-3{
                margin-left: 290px;
                width:90%;
                border-color: #E5BE01;
                border-spacing: 5px;
                color: chartreuse;
                    
                    
            }

        </style>
    </head>
    <body style=" background: rgb(255,234,184);background: linear-gradient(90deg, rgba(255,234,184,1) 7%, rgba(207,188,160,1) 50%, rgba(196,100,100,1) 95%);height: 88vh;">

        <div class="container" class="container" style="background: bottom; margin: 6%; ">
            <h1 style="font-size: 45px; font-family: serif; text-align: center; top:10px; color: white;">FORMULARIO REGISTRO VENTAS</h1>
            <h2 style="font-size: 35px; font-family: serif; text-align: justify; top: 20px; color: darkorange;"><%=(items.getNro_factura() == 0) ? "Nuevo Registro" : "Editar Registro"%></h2>

            <jsp:include page="WEB-INF/menu.jsp">
                <jsp:param name="opcion" value="ventas"/>
            </jsp:include>
            <br>
            <form action="VentaControlador" method="POST">
                <div class="form-group" style="align-items: center; position: relative; ">
                    <input type="hidden" name="nro_factura" value="${venta.nro_factura}">
                    <div class="col-md-8" style="left: 130px; top: -36px">
                        <div class="mb-3">
                            <label for="" class="form-label">Fecha Venta</label>
                            <input type="date" class="form-control" name="fecha_venta" value="${venta.fecha_venta}" placeholder="Ingrese la Fecha">
                        </div>
                    </div>
                    <div class="col-md-8" style="left: 130px; top: -36px">
                        <div class="mb-3">
                            <label for="" class="form-label">Cliente</label>
                            <select name="ci_nit" class="form-select" aria-label="Default select example">
                                <option value="">--CLIENTE--</option>
                                <c:forEach var="item" items="${lista_cliente}">
                                    <option value="${item.CINIT}" 
                                            <c:if test="${venta.ci_nit==item.CINIT}">
                                                selected
                                            </c:if>
                                            >${item.nombres}</option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                    <!-- comment -->
                    <button type="submit" class="btn btn-primary" style="margin-left:71%; width: 150px; margin-top: 20px;">Enviar</button>
                </div>
            </form>
        </div>
        <br>
        <br>

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
    </body>
</html> 

