<%
    if (session.getAttribute("login") != "OK") {
        response.sendRedirect("index.jsp");
    }

    Detalle_venta items = (Detalle_venta) request.getAttribute("ventas");
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="com.emergentes.modelo.Detalle_venta"%>
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

        </style>
    </head>
    <body style=" background-image: radial-gradient(#FFF5C3, #DE6262);">

        <div class="container" style="background: bottom; margin: 6%;">
            <h1 style="font-size: 45px; font-family: serif; text-align: center; top:10px;">DETALLE VENTA</h1>
            <h2 style="font-size: 35px; font-family: serif; text-align: justify; top: 20px;"><%=(items.getId_v() == 0) ? "Nuevo Registro" : "Editar Registro"%></h2>

            <jsp:include page="WEB-INF/menu.jsp">
                <jsp:param name="opcion" value="ventas"/>
            </jsp:include>
            <br>
            <form action="Detalle_ventaControlador" method="POST">
                <input type="hidden" name="id_v" value="${ventas.id_v}">
                <div class="mb-3">
                    <label for="" class="form-label">Precio</label>
                    <input type="text" class="form-control" name="precio" value="${ventas.precio}" placeholder="Precio del Producto">
                </div>
                <div class="mb-3">
                    <label for="" class="form-label">Cantidad</label>
                    <input type="text" class="form-control" name="cantidad" value="${ventas.cantidad}" placeholder="Cantidad">
                </div>
                <div class="mb-3">
                    <label for="" class="form-label">Detalle</label>
                    <input type="text" class="form-control" name="detalle" value="${ventas.detalle}" placeholder="Algun detalle de este producto">
                </div>              

                <div class="mb-3">
                    <label for="" class="form-label">Producto</label>
                    <select name="cod_producto" class="form-select" aria-label="Default select example">
                        <option value="">--Selecciones el Producto--</option>
                        <c:forEach var="item" items="${lista_productos}">
                            <option value="${item.cod_producto}" 
                                    <c:if test="${ventas.cod_producto==item.cod_producto}">
                                        selected
                                    </c:if>
                                    >${item.nombre_producto}</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="mb-3">
                    <label for="" class="form-label">factura</label>
                    <select name="nro_factura" class="form-select" aria-label="Default select example">
                        <option value="">--Selecciones la factura--</option>
                        <c:forEach var="item" items="${lista_factura}">
                            <option value="${item.nro_factura}" 
                                    <c:if test="${ventas.nro_factura==item.nro_factura}">
                                        selected
                                    </c:if>
                                    >${item.nro_factura}</option>
                        </c:forEach>
                    </select>
                </div>

                <button type="submit" class="btn btn-primary">Enviar</button>
            </form>
        </div>
        <br>
        <br>

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
    </body>
</html> 

