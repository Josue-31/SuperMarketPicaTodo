<%@page import="com.emergentes.modelo.Cliente"%>
<%
    Cliente item = (Cliente) request.getAttribute("cliente");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta charset="utf-8">

        <link rel="canonical" href="https://getbootstrap.com/docs/5.2/examples/sign-in/">

        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.1/css/all.min.css"/>
        <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
        <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>


        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
        <link href="https://getbootstrap.com/docs/5.2/assets/css/docs.css" rel="stylesheet">

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>

        <title>PicaTodo</title>
        <link rel="canonical" href="https://getbootstrap.com/docs/5.2/examples/sign-in/">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.1/css/all.min.css"/>
        <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">

        <title>JSP Page</title>
        <style>
            .body{
                background-image: linear-gradient(#DE6262);
                background-size: 50% 50%;
                background-size: auto;
                height: 100%;

            }
            .header {
                color: navy;
                font-size: 30px;
                padding: 10px;
            }

            .bigicon {
                font-size: 35px;
                color: #36A0FF;
            }
            .container
            {

                width:80%;
                height: 80%;
            }
            bigicon{
                float: right;
            }
            .form-control{

                border-color: black;
                border-spacing: 6px;
            }
            .fa-user{
                color: #1A1A1A;
            }
            .fa-circle-plus{
                color: #1A1A1A;
            }

            .btn-lg:hover{
                background-color: #ED6C4E ;
                color: white;
                border: 0px;
                
            }
            

        </style>

    </head>
    <body style=" background: rgb(255,225,251); background: linear-gradient(90deg, rgba(255,225,251,1) 11%, rgba(224,179,237,1) 44%, rgba(109,143,223,1) 89%); height: 100vh; width: 100%;">
        <h1 align="center" style="color: white; margin-top: 2%; text-transform: uppercase">Formulario de Clientes</h1>        
        <main class="form-signin w-100 m-auto">

            <div class="container" style=" position: relative; left: 5px; top: 25px;">
                <div class="row">
                    <div class="col-md-12">
                        <div class="well well-sm">
                            <form class="form-horizontal" action="ClienteControlador" method="POST">
                                <fieldset>
                                    <legend class=" header" style="font-size: 40px; font-family: serif; text-align: center; color: #FFF">BIENVENIDO PUEDE REGISTRARSE</legend>
                                    <input type="hidden" name="CINIT" value="${cliente.CINIT}">
                                    <div class="form-group" style="align-items: center; position: relative; ">
                                        <span class="col-md-1 col-md-offset-2 text-center" style="left: 90px; right: 0px; "><i class="fa fa-user bigicon"></i></span>
                                        <div class="col-md-8" style="left: 170px; top: -38px">
                                            <input type="text" class="form-control" name="nombres" value="${cliente.nombres}" placeholder="Escriba su nombre">
                                            <!-- comment -->
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <span class="col-md-1 col-md-offset-2 text-center" style="left: 90px; right:0px;"><i class="fa fa-user bigicon"></i></span>
                                        <div class="col-md-8" style="left: 170px; top: -38px">
                                            <input type="text" class="form-control" name="apellido_paterno" value="${cliente.apellido_paterno}" placeholder="Escriba su Apellido Paterno">
                                            <!-- comment -->
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <span class="col-md-1 col-md-offset-2 text-center" style="left: 90px; right:0px;"><i class="fa fa-user bigicon"></i></span>
                                        <div class="col-md-8" style="left: 170px; top: -38px">
                                            <input type="text" class="form-control" name="apellido_materno" value="${cliente.apellido_materno}" placeholder="Escriba su Apellido Materno">
                                            <!-- comment -->
                                        </div>
                                    </div>

                                    <div class="form-group"  style="">
                                        <span class="col-md-1 col-md-offset-2 text-center" style="left: 90px; right:0px;"><i class="fa fa-circle-plus bigicon"></i></span>
                                        <div class="col-md-8" style="left: 170px; top: -38px">
                                            <input type="text" class="form-control" name="direccion" value="${cliente.direccion}" placeholder="Ingrese su direccion">
                                            <!-- comment -->
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <div class="col-md-12 text-center" style="left: 260px ;">
                                            <button type="submit" class="btn btn-primary btn-lg" style="border: 0px" >ENVIAR</button>
                                        </div>
                                    </div>
                                    <br>

                                </fieldset>
                            </form>
                        </div>
                    </div>
                </div>
            </div>         
        </main>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
    </body>
</html>
