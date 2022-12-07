<%
    if (session.getAttribute("login") != "OK") {
        response.sendRedirect("index.jsp");
    }
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="com.emergentes.modelo.Personal"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    Personal items = (Personal) request.getAttribute("personal");
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
    <body style="background: rgb(255,250,171);
background: linear-gradient(90deg, rgba(255,250,171,1) 4%, rgba(234,187,112,1) 40%, rgba(255,142,114,1) 87%); height: 100vh">

        <div class="container" class="container" style="background: bottom; margin: 6%; ">
            <h1 style="font-size: 45px; font-family: serif; text-align: center; top:10px; color: white">FORMULARIO PERSONAL</h1>
            <h2  style="font-size: 35px; font-family: serif; text-align: justify; top: 20px; color:  darkred"><%=(items.getId_personal() == 0) ? "Nuevo Registro" : "Editar Registro"%></h2>

            <jsp:include page="WEB-INF/menu.jsp">
                <jsp:param name="opcion" value="personal"/>
            </jsp:include>
            <br>
            <form action="PersonalControlador" method="POST">
                <input type="hidden" name="id_personal" value="${personal.id_personal}">
                <div class="mb-3">
                    <label for="" class="form-label">Nombre Personal</label>
                    <input type="text" class="form-control" name="nombres_personal" value="${personal.nombres_personal}" placeholder="escriba el nombre del personal">
                </div>
                <div class="mb-3">
                    <label for="" class="form-label">Correo</label>
                    <input type="email" class="form-control" name="usuario" value="${personal.usuario}" placeholder="Registre el correo del usuario">
                </div>
                <div class="mb-3">
                    <label for="" class="form-label">Password</label>
                    <input type="password" class="form-control" name="password" value="${personal.password}" placeholder="ingrese la contraseña">
                </div>              
                <div class="mb-3">
                    <label for="" class="form-label">Numero de Celular</label>
                    <input type="text" class="form-control" name="celular" value="${personal.celular}" placeholder="ingrese nurmero de celular">
                </div>
                <div class="mb-3">
                    <label for="" class="form-label">Direccion</label>
                    <input type="text" class="form-control" name="direccion" value="${personal.direccion}" placeholder="ingrese su direccion">
                </div>
                <div class="mb-3">
                    <label for="" class="form-label">Cargo</label>
                    <select name="cod_cargo" class="form-select" aria-label="Default select example">
                        <option value="">--Selecciones el Cargo--</option>
                        <c:forEach var="item" items="${lista_cargo}">
                            <option value="${item.cod_cargo}" 
                                    <c:if test="${personal.cod_cargo==item.cod_cargo}">
                                        selected
                                    </c:if>
                                    >${item.nombre_cargo}</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="mb-3">
                    <label for="" class="form-label">Estado</label>
                    <select name="estado" class="form-select" aria-label="Default select example">
                        <option value="">--Estado--</option>

                        <option value="activo" 
                                <c:if test="${personal.estado=='activo'}">
                                    selected
                                </c:if>
                                >activo</option>
                        <option value="inactivo" 
                                <c:if test="${personal.estado=='inactivo'}">
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

