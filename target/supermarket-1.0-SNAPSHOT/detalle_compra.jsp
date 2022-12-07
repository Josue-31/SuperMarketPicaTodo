<%
    if (session.getAttribute("login") != "OK") {
        response.sendRedirect("index.jsp");
    }
%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="es">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.1/css/all.min.css"/>
        <title>Detalle</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
        <style>
            .body{

                background-size: 50% 50%;
                background-size: auto;
                position:absolute ;
                left: 40px; top: 40px; right:100px;bottom: 0px; align-content:  center;

            }
            .container{
                width:65%; 
                height: 15%;
                margin-left: 20%;
                margin-top: 12%;
                margin-right: 15%;
                margin-bottom: 4.7%;
                border-radius: 20px 20px 20px 20px;
                border: black;
                border-width: 2px;
            }
            .txt{
                color:green;
                font-size: 17px;
                font-weight: bold;
                text-align: left;

            }
            .menu-fixed{
                position: fixed;
                z-index: 1000;
                top:0;
                width: 100%;
                max-width: 100%;
                max-height: 20%;
            }
            .tab{
                background-origin: black;
                border-color:none ;
            }
            th , td{
                padding-right: 40px;
                padding-top: 10px;
                padding-bottom: 10px;
                padding-left: 30px
            }
            td{
                color: darkblue;
                font-size: 16px
            }

        </style>
    </head>
    <body style=" background-color: #FFF5C3;">
        <nav class="navbar navbar-expand-lg py-3 navbar-dark bg-dark shadow-sm menu-fixed">
            <div class="container" style="bottom: 20px; margin-top: 5%">
                <a href="#" class="navbar-brand">
                    <!-- Logo Image -->
                    <img src="imagenes/logos.png" width="55" alt="" class="d-inline-block align-middle mr-2">
                    <!-- Logo Text -->
                    <span class="text-uppercase font-weight-bold copy-text text" ><b>PICATODO</b> </span>
                </a>

                <button type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation" class="navbar-toggler"><span class="navbar-toggler-icon"></span></button>

                <div id="navbarSupportedContent" class="collapse navbar-collapse" style="margin-left: 550px;">
                    <ul class="navbar-nav ml-auto">

                        <li class="nav-item"><a class="nav-link" href="">NOMBRE</a> </li>
                        <li class="nav-item"><a class="nav-link " href="Logout">CERRAR</a></li>
                    </ul>
                </div>
            </div>
        </nav>

        <div class="container" style="background: bottom;">
            <h1  style="color: black;font-size: 35px; font-weight: bold;">Detalle Compras</h1>
            <jsp:include page="WEB-INF/menu.jsp">
                <jsp:param name="opcion" value="compras"/>
            </jsp:include>
            <br>
            <a href="Detalle_compraControlador?action=add" class="btn btn-primary btn-sm" style="margin-left: 70%"> <i class="fa-solid fa-circle-plus" ></i>Nuevo</a>
            
            <table class="" >
                <c:forEach var="item" items="${compras}">                   

                    <tr><th class="txt">ID COMPRA</th><td>${item.id}</td>
                        <td>
                            <a href="Detalle_compraControlador?action=edit&id=${item.id}">
                                <i class="fa-solid fa-pen-to-square"></i>
                            </a>
                        </td>
                        <td>
                            <a href="Detalle_compraControlador?action=delete&id=${item.id}" onclick="return(confirm('DESEA ELIMINAR?'))">
                                <i class="fa-solid fa-trash-can"></i>
                            </a>
                        </td>
                        <td>
                            <a href="Detalle_compraControlador?action=update_stock&id_factura=${item.id_factura}&cod_producto=${item.cod_producto}")">
                                <i class="fa-solid fa-calculator"></i>
                            </a>
                        </td>
                    </tr>
                    <tr><th class="txt">PRECIO</th><td >${item.precio}</td></tr>
                    <tr><th class="txt">CANTIDAD</th><td>${item.cantidad}</td></tr>
                    <tr><th class="txt">OBSERVACIONES</th><td>${item.observaciones}</td></tr>                       
                    <tr><th class="txt">PRODUCTO</th><td>${item.nombre_producto}</td></tr>                       
                    <tr><th class="txt">ID FACTURA</th> <td>${item.id_factura}</td></tr>  
                    <tr><td  ></td><td ></td></tr>
                    <tr><td ></td><td ></td></tr>
                </c:forEach>
            </table>
            <br>
            <br>
        </div>
        <br>
        <br>
        <br>
        <br>
        <br>
        <br>

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
    </body>
</html> 
