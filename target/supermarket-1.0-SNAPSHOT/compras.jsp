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
        <title>Compras</title>
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
                color: black;
                font-size: 15px;
                font-weight: bold;
                text-align: center;
            }
            .menu-fixed{
                position: fixed;
                z-index: 1000;
                top:0;
                width: 100%;
                max-width: 100%;
                max-height: 20%;
            }
        </style>
    </head>
    <body style="background: rgb(118,21,63); background: linear-gradient(50deg, rgba(118,21,63,1) 3%, rgba(255,211,75,1) 54%, rgba(249,255,68,1) 86%); height: 150vh">
        <nav class="navbar navbar-expand-lg py-3 navbar-dark bg-dark shadow-sm menu-fixed">
            <div class="container" style="bottom: 20px; margin-top: 5%">
                <a href="#" class="navbar-brand">
                    <!-- Logo Image -->
                    <img src="imagenes/logos.png" width="55" alt="" class="d-inline-block align-middle mr-2">
                    <!-- Logo Text -->
                    <span class="text-uppercase font-weight-bold copy-text text" ><h2 style="font-family: serif; font-size: 50px; align-items: center;"><b>PICATODO</b></h2></span>
                </a>

                <button type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation" class="navbar-toggler"><span class="navbar-toggler-icon"></span></button>

                <div id="navbarSupportedContent" class="collapse navbar-collapse" style="margin-left: 550px;">
                    <ul class="navbar-nav ml-auto">

                        <li class="nav-item"><a class="nav-link" href=""><h3 style="color:white; font-size: 15px; font-weight: bold; text-transform: uppercase"><%=session.getAttribute("personal")%></h3></a> </li>
                        <li class="nav-item"><a class="nav-link " href="Logout"> <h3 style="color:white; font-size: 15px; font-weight: bold;">CERRAR</h3></a></li>
                    </ul>
                </div>
            </div>
        </nav>
        <div class="container" style="background: bottom;">
            <h1 style="color: black;font-size: 35px; font-weight: bold;">Compras</h1>
            <jsp:include page="WEB-INF/menu.jsp">
                <jsp:param name="opcion" value="compras"/>
            </jsp:include>
            <br>
            <a href="CompraControlador?action=add" class="btn btn-primary btn-sm"> <i class="fa-solid fa-circle-plus"></i>Nuevo</a>
            <br>
            <br>
            <table class="table table-striped">
                <tr>
                    <th class="txt">NUMERO FACTURA</th>
                    <th V>TOTAL</th>                    
                    <th class="txt">FECHA COMPRA</th>
                    <th class="txt">NOMBRE DEL PROVEEDOR</th>                    
                    <th class="txt">FACTURA DEL PROVEEDOR</th>                    
                        <%if ((Integer) session.getAttribute("codigo") == 1) { %> 
                    <th class="txt"></th>
                    <th class="txt"></th>
                    <th class="txt"></th>
                        <% } %> 
                </tr>
                <c:forEach var="item" items="${compra}">                   
                    <tr>
                        <td>${item.id_factura}</td>
                        <td>${item.total}</td>                       
                        <td>${item.fecha_compra}</td>
                        <td>${item.nombre}</td>
                        <td>${item.nro_factura}</td>                       
                        <%if ((Integer) session.getAttribute("codigo") == 1) { %> 
                        <td>
                            <a href="CompraControlador?action=edit&id_factura=${item.id_factura}">
                                <i class="fa-solid fa-pen-to-square"></i>
                            </a>
                        </td>
                        <td>
                            <a href="Detalle_compraControlador?action=view&id_factura=${item.id_factura}">
                                <i class="fa-solid fa-file-signature"></i>
                            </a>
                        </td>
                        <td>
                            <a href="CompraControlador?action=total&id_factura=${item.id_factura}")">
                                <i class="fa-solid fa-calculator"></i>
                            </a>
                        </td>
                        <% }%> 
                    </tr>                    
                </c:forEach>
            </table>
            
        </div>
        

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
    </body>
</html> 


