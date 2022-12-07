<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
        <meta name="generator" content="Hugo 0.104.2">

        <title>PicaTodo</title>

        <link rel="canonical" href="https://getbootstrap.com/docs/5.2/examples/sign-in/">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.1/css/all.min.css"/>
        <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
        <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>


        <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
        <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>

        <style>


            .login-block{
                background: #DE6262; 
                background: -webkit-linear-gradient(to bottom, #FFB88C, #DE6262);  
                background: linear-gradient(to bottom, #FFB88C, #DE6262); 
                float:left;
                width:100%;
                padding :16vh;
            }
            .banner-sec{background:url(https://static.pexels.com/photos/33972/pexels-photo.jhttps:pg)  no-repeat left bottom; background-size:cover; min-height:350px; border-radius: 0 10px 10px 0; padding:0px; }
            .container{background:#fff; border-radius: 10px; box-shadow:45px 45px 0px rgba(0,0,0,0.1);}
            .carousel-inner{border-radius:0 10px 10px 0;}
            .carousel-caption{text-align:left; left:15%;}
            .login-sec{padding: 15px 30px; position:relative; }
            .login-sec .copy-text{position:absolute; width:100%; bottom:20px; font-size:15px; text-align:center;}
            .login-sec .copy-text i{color:#FEB58A;}
            .login-sec .copy-text a{color:#E36262;}
            .login-sec h2{margin-bottom:15px; font-weight:600; font-size:30px; color: #DE6262;}
            .login-sec h2:after{content:" "; width:100px; height:5px; background:#FEB58A; display:block; margin-top:30px; border-radius:3px; margin-left:auto;margin-right:auto}
            .btn-login{background: #DE6262; color:#fff; font-weight:600;}
            .banner-text{width:70%; position:absolute; bottom:40px; padding-left:10px;}
            .banner-text h2{color:#fff; font-weight:400;}
            .banner-text h2:after{content:" "; width:100%; height:5px; background:#FFF; display:block; margin-top:0px; border-radius:3px;}
            .banner-text p{color:#fff;}
            .text-center{
                margin-top: 55px;
            }

        </style>
    </head>

    <body>
        <main class="form-signin w-100 m-auto">
            
                <section class="login-block">
                    <div class="container">
                        <div class="row">
                            <div class="col-md-4 login-sec">
                                <h2 class="text-center">BIENVENIDO A PICATODO</h2>
                                <form  action="Login" method="POST">
                                    <div class="form-group">
                                        <label for="exampleInputEmail1" class="text-uppercase">USUARIO</label>
                                        <input type="email" class="form-control" placeholder="" name="usuario">

                                    </div>

                                    <div class="form-group">
                                        <label for="exampleInputPassword1" class="text-uppercase">CONTRASEÑA</label>
                                        <input type="password" class="form-control" placeholder="" name="password">
                                    </div>
                                    <br>

                                    <div class="form-check">
                                        <label class="form-check-label">
                                            <input type="checkbox" class="form-check-input">
                                            <small>RECUERDAME</small>
                                        </label>
                                        <button type="submit" class="btn btn-login float-right">INGRESAR</button>
                                    </div>

                                </form>

                            </div>
                            <div class="col-md-8 banner-sec" >
                                <div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel">
                                    <ol class="carousel-indicators">
                                        <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active" ></li>
                                        <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
                                        <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
                                    </ol>
                                    <div class="carousel-inner" role="listbox" >
                                        <div class="carousel-item active" data-interval='3' >
                                            <img class="d-block img-fluid" src="https://images.pexels.com/photos/4090833/pexels-photo-4090833.jpeg?auto=compress&cs=tinysrgb&w=800" alt="First slide">
                                            <div class="carousel-caption d-none d-md-block">
                                                <div class="banner-text">
                                                    <h2>PICATODO</h2>
                                                    <p>INGRESA AL SISTEMA Y SE PARTE DE PICATODO</p>
                                                </div>	
                                            </div>
                                        </div>
                                        <div class="carousel-item" data-interval="3" >
                                            <img class="d-block img-fluid"  src="https://images.pexels.com/photos/264636/pexels-photo-264636.jpeg?auto=compress&cs=tinysrgb&w=800" alt="First slide">
                                            <div class="carousel-caption d-none d-md-block">
                                                <div class="banner-text">

                                                    <p>LA MEJOR CALIDAD A BUENOS PRECIOS</p>
                                                </div>	
                                            </div>
                                        </div>
                                        <div class="carousel-item" data-interval='3'>
                                            <img class="d-block img-fluid" src="https://images.pexels.com/photos/4012966/pexels-photo-4012966.jpeg?auto=compress&cs=tinysrgb&w=800" alt="First slide">
                                            <div class="carousel-caption d-none d-md-block">
                                                <div class="banner-text">
                                                    <h2>PICATODO</h2>
                                                    <p>GRACIAS POR SER PARTE DE NOSOTROS</p>
                                                </div>	
                                            </div>
                                        </div>
                                    </div>	   

                                </div>

                            </div>

                        </div>
                </section>
            </form>
        </main>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
    </body>
</html>
