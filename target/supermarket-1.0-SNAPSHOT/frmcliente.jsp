<%
    if (session.getAttribute("login") != "OK") {
        response.sendRedirect("index.jsp");
    }

    Cliente item = (Cliente) request.getAttribute("cliente");
%>
<%@page import="com.emergentes.modelo.Cliente"%>
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
                font-weight: bold;}
            .mb-3{

                margin-left: 70px;
                margin-right: 70px;
                margin-top: 0px;
                margin-bottom: 30px;
            }  


            .form-control{
                border-bottom-left-radius: 15px;
                border-color: red;
                border-spacing: 2px;
            }
            .container
            {

                width:80%;
                height: 80%;
            }

        </style>
    </head>
    <body style=" background: rgb(239,177,230); background: linear-gradient(90deg, rgba(239,177,230,1) 19%, rgba(188,107,201,1) 61%, rgba(87,124,212,1) 100%); height: 100vh; width: 100%;">

        <div class="container" style="background: bottom; margin: 6%;" >
            <h1 style="font-size: 45px; font-family: serif; text-align: center; top:10px;">FORMULARIO CLIENTES</h1>
            <h2 style="font-size: 35px; font-family: serif; text-align: justify; top: 20px;"><%=(item.getCINIT() == 0) ? "Nuevo Registro" : "Editar Registro"%></h2>
            <jsp:include page="WEB-INF/menu.jsp">
                <jsp:param name="opcion" value="clientes"/>
            </jsp:include>
            <br>
            <form action="ClienteControlador" method="POST">  
                <div class="form-group" style="align-items: center; position: relative; margin-left: 300px ">
                    <input type="hidden" name="CINIT" value="${cliente.CINIT}">

                    <div class="col-md-8" style="left: 170px; top: -38px">
                        <div class="mb-3">
                            <label for="" class="form-label">Nombres</label>
                            <input type="text" class="form-control" name="nombres" value="${cliente.nombres}" placeholder="escriba su nombre" >
                        </div>
                        <div class="mb-3">
                            <label for="" class="form-label">Apellido Paterno</label>
                            <input type="text" class="form-control" name="apellido_paterno" value="${cliente.apellido_paterno}" placeholder="escriba su ap. paterno">
                        </div>
                        <div class="mb-3">
                            <label for="" class="form-label">Apellido materno</label>
                            <input type="text" class="form-control" name="apellido_materno" value="${cliente.apellido_materno}" placeholder="escriba su ap. materno">
                        </div>
                        <div class="mb-3">
                            <label for="" class="form-label">Direccion</label>
                            <input type="text" class="form-control" name="direccion" value="${cliente.direccion}" placeholder="ingrese su direccion">

                        </div>
                    </div>
                </div>

                <button type="submit" class="btn btn-primary">Enviar</button>
            </form>
        </div>

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
    </body>
</html> 
