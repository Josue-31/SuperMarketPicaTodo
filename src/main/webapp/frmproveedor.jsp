<%
    if (session.getAttribute("login") != "OK") {
        response.sendRedirect("index.jsp");
    }
%>
<%@page import="com.emergentes.modelo.Proveedores"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    Proveedores item = (Proveedores) request.getAttribute("proveedores");
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
    <body style="background: rgb(255,250,171); background: linear-gradient(90deg, rgba(255,250,171,1) 4%, rgba(234,187,112,1) 38%, rgba(114,157,255,1) 87%);">

        <div class="container" class="container" style="background: bottom; margin: 6%; ">
            <h1 style="font-size: 45px; font-family: serif; text-align: center; top:10px; color: white">FORMULARIO PROVEEDOR</h1>
            <h2 style="font-size: 35px; font-family: serif; text-align: justify; top: 20px; color: darkblue"><%=(item.getNit() == 0) ? "Nuevo Registro" : "Editar Registro"%></h2>

            <jsp:include page="WEB-INF/menu.jsp">
                <jsp:param name="opcion" value="proveedores"/>
            </jsp:include>
            <br>
            <form action="ProveedorControlador" method="POST">
                <input type="hidden" name="nit" value="${proveedores.nit}">
                <div class="mb-3">
                    <label for="" class="form-label">Nombres de Proveedor</label>
                    <input type="text" class="form-control" name="nombre" value="${proveedores.nombre}" placeholder="escriba su nombre">

                </div>
                <div class="mb-3">
                    <label for="" class="form-label">Numero de Telefono</label>
                    <input type="text" class="form-control" name="nro_telefono" value="${proveedores.nro_telefono}" placeholder="escriba su numero de telefono">
                </div>

                <div class="mb-3">
                    <label for="" class="form-label">Direccion</label>
                    <input type="text" class="form-control" name="direccion" value="${proveedores.direccion}" placeholder="ingrese su direccion">

                </div>

                <button type="submit" class="btn btn-primary" style="margin-left:71%; width: 150px; margin-top: 20px;">Enviar</button>
            </form>
        </div>

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
    </body>
</html> 
