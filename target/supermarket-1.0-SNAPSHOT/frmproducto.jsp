<%
    if (session.getAttribute("login") != "OK") {
        response.sendRedirect("index.jsp");
    }
%>
<%@page import="com.emergentes.modelo.Producto"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    Producto items = (Producto) request.getAttribute("producto");
%>
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
                margin-left: 230px;
                width:65%;
                border-color: #E5BE01;
                border-spacing: 5px;
                color: chartreuse;
                    
                    
            }

        </style>
    </head>
    <body style="background: rgb(234,255,184); background: linear-gradient(90deg, rgba(234,255,184,1) 7%, rgba(142,196,169,1) 50%, rgba(100,196,189,1) 95%); ">

        <div class="container" class="container" style="background: bottom; margin: 6%; ">
            <h1 style="font-size: 45px; font-family: serif; text-align: center; top:10px; color: white;">FORMULARIO PRODUCTOS</h1>
            <h2 style="font-size: 35px; font-family: serif; text-align: justify; top: 20px; color: #3b5998"><%=(items.getCod_producto() == 0) ? "Nuevo Registro" : "Editar Registro"%></h2>

            <jsp:include page="WEB-INF/menu.jsp">
                <jsp:param name="opcion" value="productos"/>
            </jsp:include>
            <br>
            <form action="ProductoControlador" method="POST" enctype="multipart/form-data">
                <input type="hidden" name="cod_producto" value="${producto.cod_producto}">
                <div class="mb-3">
                    <label for="" class="form-label">Stock</label>
                    <input autofocus type="text" class="form-control" name="stock" value="${producto.stock}" placeholder="Digite el Stock">
                </div>

                <div class="mb-3">
                    <label for="" class="form-label">Tipo</label>
                    <select name="tipo" class="form-select" aria-label="Default select example">
                        <option value="">--Tipo Producto--</option>

                        <option value="cereales" 
                                <c:if test="${producto.tipo=='cereales'}">
                                    selected
                                </c:if>
                                >cereales</option>
                        <option value="frutas" 
                                <c:if test="${producto.tipo=='frutas'}">
                                    selected
                                </c:if>
                                >frutas</option>
                        <option value="lacteos" 
                                <c:if test="${producto.tipo=='lacteos'}">
                                    selected
                                </c:if>
                                >lacteos</option>
                        <option value="licores" 
                                <c:if test="${producto.tipo=='licores'}">
                                    selected
                                </c:if>
                                >licores</option>
                        <option value="pastas" 
                                <c:if test="${producto.tipo=='pastas'}">
                                    selected
                                </c:if>
                                >pastas</option>
                        <option value="refrescos" 
                                <c:if test="${producto.tipo=='refrescos'}">
                                    selected
                                </c:if>
                                >refrescos</option>
                        <option value="snacks" 
                                <c:if test="${producto.tipo=='snacks'}">
                                    selected
                                </c:if>
                                >snacks</option>
                        <option value="verduras" 
                                <c:if test="${producto.tipo=='verduras'}">
                                    selected
                                </c:if>
                                >verduras</option>
                    </select>
                </div>

                <div class="mb-3">
                    <label for="" class="form-label">Fecha Vencimiento</label>
                    <input type="text" class="form-control" name="fecha_vencimiento" value="${producto.fecha_vencimiento}" placeholder="ingrese la fecha de Vencimiento">
                </div>    
                <div class="mb-3">
                    <label for="" class="form-label">Fecha Elaboracion</label>
                    <input type="text" class="form-control" name="fecha_elaboracion" value="${producto.fecha_elaboracion}" placeholder="ingrese la fecha de Elaboracion">
                </div> 

                <div class="mb-3">
                    <label for="" class="form-label">Nombre Personal</label>
                    <select name="id_personal" class="form-select" aria-label="Default select example" >
                        <c:forEach var="item" items="${lista_personal}">
                            <option value="${item.id_personal}" 
                                    <c:if test="${producto.id_personal==item.id_personal}">
                                        selected
                                    </c:if>
                                    >${item.nombres_personal}</option>
                        </c:forEach>
                    </select>
                </div>


                <div class="mb-3">
                    <label for="" class="form-label">Nombre Producto</label>
                    <input type="text" class="form-control" name="nombre_producto" value="${producto.nombre_producto}" placeholder="ingrese el nombre del producto">
                </div>

                <div class="mb-3">
                    <label for="" class="form-label">Imagen del Producto</label>                    
                    <input type="file" class="form-control" name="imagen" value="${producto.imagen}" placeholder="Ingrese una imagen">                                       
                </div>

                <div class="mb-3">
                    <label for="" class="form-label">Estado</label>
                    <select name="estado" class="form-select" aria-label="Default select example">
                        <option value="">--Estado--</option>

                        <option value="activo" 
                                <c:if test="${producto.estado=='activo'}">
                                    selected
                                </c:if>
                                >activo</option>
                        <option value="Inactivo" 
                                <c:if test="${producto.estado=='inactivo'}">
                                    selected
                                </c:if>
                                >inactivo</option>
                    </select>
                </div>
                <button type="submit" class="btn btn-primary" style="margin-left:71%; width: 150px; margin-top: 20px;">Enviar</button>
            </form>
        </div>
        <br>
        <br>

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
    </body>
</html> 


