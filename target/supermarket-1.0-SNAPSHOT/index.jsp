<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">

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
        <style>
            body {
                background: #DE6262;
                background: -webkit-linear-gradient(to bottom, #FFB88C, #DE6262);  
                background: linear-gradient(to bottom, #FFB88C, #DE6262); 
                float:left;
                width:110%;
                height: 80%;
            }
            code {
                background:#FFF ;
                padding: 0.2rem;
                border-radius: 0.2rem;
                margin: 0 0.3rem;
            }

            .text {font-family: Tahoma;
                   font-size: 35px; 
                   color:#FEB58A;       
            }
            .menu-fixed{
                position: fixed;
                z-index: 1000;
                top:0;
                width: 100%;
                max-width: 100%;
            }

            .slider-container {
                display: flex;
                width: 70%;
                height: 70vh;
                overflow-y: auto;
                margin-left: 155px;
                margin-top: 130px;
            }
            .galeria{
                padding: 16px;
            }

            .slider-container img {
                flex: 0 0 100%;
                width: 60%;
                object-fit: cover;
            }
            .footer {
                background-color:#1A1A1A;
                height: 40%;
                color: white;
                padding: 15px;

            }
            .container1{

                width: 100%;

            }
            .main1 { 
                display:flex;
                margin:0 auto;
            }

        </style>
    </head>
    <body>
        <main class="form-signin w-100 m-auto">
            <form action="Menu" method="POST">
                <nav class="navbar navbar-expand-lg py-3 navbar-dark bg-dark shadow-sm menu-fixed">
                    <div class="container" style="bottom: 30px;">
                        <a href="#" class="navbar-brand">
                            <!-- Logo Image -->
                            <img src="img/log.png" width="55" alt="" class="img-thumbnail d-inline-block align-middle mr-2 " style=" display: none">
                            <!-- Logo Text -->
                            <span class="text-uppercase font-weight-bold copy-text text"  style="font-family: serif; font-size: 50px; align-items: center;"><b>PICATODO</b> </span>
                        </a>

                        <button type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation" class="navbar-toggler"><span class="navbar-toggler-icon"></span></button>

                        <div id="navbarSupportedContent" class="collapse navbar-collapse">
                            <ul class="navbar-nav ml-auto">
                                <li class="nav-item"><a class="nav-link active" aria-current="page" href="https://api.whatsapp.com/send?phone=59173255856&text=Hola, Nececito mas informacion!">CONTACTOS</a></li>
                                <li class="nav-item"><a href="ClienteControlador?action=add" class="nav-link">REGISTRO CLIENTE</a></li>

                                <li class="nav-item"><a class="nav-link " href="login.jsp">INICIO SESION</a></li>
                            </ul>
                        </div>
                    </div>
                </nav>

                <h2 style="font-size: 45px; font-family: serif; color: #1A1A1A; text-align: center; margin-top:150px; margin-left: 50px" >P R O M O C I O N E S</h2>
                <div class="slider-container" style="margin-top: 50px; margin-left: 200px">  
                    
                    <br>
                    <br>
                    <img
                        class="slider-item" style=""
                        src="https://pbs.twimg.com/media/CR8ErMEWEAAgLIe.png" alt="img-principal"/>
                    <img
                        class="slider-item" style=""
                        src="https://thumbs.dreamstime.com/z/etiqueta-de-yogurt-ar%C3%A1ndano-para-el-dise%C3%B1o-del-yogur-azul-bayas-naturales-y-frescas-en-salpicaduras-leche-su-marca-logotipo-173158236.jpg" alt="img-principal"/>
                    <img
                        class="slider-item" style=""
                        src="https://i0.wp.com/www.ofertasahora.com/wp-content/uploads/2017/04/ofertas-en-papel-higienico-scott-24-rollos.jpg?ssl=1" alt="img-principal"/>
                    <img
                        class="slider-item" style=""
                        src="https://http2.mlstatic.com/D_NQ_NP_735293-MCO31544095436_072019-O.jpg" alt="img-principal"/>
                    <img
                        class="slider-item" style=""
                        src="https://www.shutterstock.com/image-vector/merry-christmas-gift-promotion-coupon-260nw-2071477364.jpg" alt="img-principal"/>
                </div> 

                <h2 style="font-size: 45px; font-family: serif; color: #1A1A1A; text-align: center; margin-top:50px; margin-left: 50px" >O F E R T A S</h2>
                <div class="slider-container" style="margin-top: 30px; margin-left: 200px"  >  
                    
                    <img
                        class="slider-item" style=" " 
                        src="https://www.supermaxi.com/wp-content/uploads/2022/11/Maxicombo-3x2-7nov-11.jpg" alt="img-principal"/>
                    <img
                        class="slider-item" style=""
                        src="https://static.cordiez.com.ar/assets/cordiez_descuentazo_juev_dom_1200_457x260_01_b79d18addb.jpg" alt="img-principal"/>
                    <img
                        class="slider-item" style="margin: auto"
                        src="https://static.cordiez.com.ar/assets/cordiez_descuentazo_juev_dom_1200_457x260_02_4fd2620dda.jpg" alt="img-principal"/>
                    <img
                        class="slider-item" style="margin: auto"
                        src="https://d50xhnwqnrbqk.cloudfront.net/featured/web/48aaea0a6248f35131a13fcc7873a96d.jpg" alt="img-principal"/>
                    <img
                        class="slider-item" style="margin: auto"
                        src="https://static.cordiez.com.ar/assets/cordiez_exclusivo_online_b1_1200_457x260_01_a9ef5a17c8.jpg" alt="img-principal"/>
                </div> 
            </form>
            <div class="container my-5 " style="width: 150%;  height: 290px; margin-top: 100%; position: relative; bottom: 0px; left: 0px;  right: 200px;">
                <footer
                    class="text-center text-lg-start text-white"
                    style="background-color: #FFB88C; width: 145%; height: 290px; margin-top: 100px; position: relative; bottom: -78px; left: -290px;   "
                    >
                    <div class="container p-4 pb-0">
                        <section class="">

                            <div class="row" style="width:120%; margin-left: -100px; font-size: 10px;">
                                <div class="col-md-3 col-lg-3 col-xl-3 mx-auto mt-3" style="margin: 0px;">
                                    <h6 class="text-uppercase mb-4 font-weight-bold" style="font-size: 18px;">
                                        SUMERMARKET PICATODO
                                    </h6>
                                    <p>
                                        SI DESEA SER PARTE DE NUESTROS CLIENTES FRRECUENTES
                                        PUEDE REGISTRARSE EN REGISTRO CLIENTE 
                                        Y POR SU PRIMERA COMPRA RECIBIRA EN 10% DE DESCUENTO 
                                    </p>

                                    <p>
                                        "Satisfacción y calidad todo en el mismo lugar"
                                    </p>
                                </div>
                                <hr class="w-100 clearfix d-md-none" />
                                <div class="col-md-2 col-lg-2 col-xl-2 mx-auto mt-3" style="text-align: left;">
                                    <h6 class="text-uppercase mb-4 font-weight-bold" style="text-align: center; font-size: 18px">PRODUCTOS</h6>
                                    <p>
                                        <a class="text-white">Frutas y Verduras</a>
                                    </p>
                                    <p>
                                        <a class="text-white">Articulos de Cocina y Micelanea</a>
                                    </p>
                                    <p>
                                        <a class="text-white">Lacteos</a>
                                    </p>
                                    <p>
                                        <a class="text-white">Cereales</a>
                                    </p>

                                    <p>
                                        <a class="text-white">Articulos de Limpieza</a>
                                    </p>

                                    <p>
                                        <a class="text-white">Higene y Uso Personal </a>
                                    </p>
                                </div>
                                <hr class="w-100 clearfix d-md-none" />
                                <hr class="w-100 clearfix d-md-none" />
                                <div class="col-md-4 col-lg-3 col-xl-3 mx-auto mt-3" style="text-align: lef;">
                                    <h6 class="text-uppercase mb-4 font-weight-bold" style="text-align: center; font-size: 18px;">CONTACTANOS</h6>
                                    <p><i class="fas fa-home mr-3"></i> Villa Dolores I, entre Calle 2, Avenida Tiahuanacu y Antofagasta, Nº 777, Piso 1</p>
                                    <p><i class="fas fa-envelope mr-3"></i> liliansonia777@gmail.com</p>
                                    <p><i class="fas fa-phone mr-3"></i> + 591 732 558 56</p>
                                    <p><i class="fas fa-print mr-3"></i> + 591 740 595 27</p>
                                </div>
                                <div class="col-md-3 col-lg-2 col-xl-2 mx-auto mt-3">
                                    <br>
                                    <h6 class="text-uppercase mb-4 font-weight-bold" style="font-size: 18px;">PAGINAS WEB</h6>

                                    <a
                                        class="btn btn-primary btn-floating m-1"
                                        style="background-color: #3b5998"
                                        href="https://www.facebook.com/facebolsrl/"
                                        role="button"
                                        ><i class="fab fa-facebook-f"></i
                                        ></a>
                                    <a
                                        class="btn btn-primary btn-floating m-1"
                                        style="background-color: #55acee"
                                        href="https://mobile.twitter.com/Miriam30600039"
                                        role="button"
                                        ><i class="fab fa-twitter"></i
                                        ></a>
                                    <a
                                        class="btn btn-primary btn-floating m-1"
                                        style="background-color: #dd4b39"
                                        href="https://www.facebolsrl.com/"
                                        role="button"
                                        ><i class="fab fa-google"></i
                                        ></a>
                                    <a
                                        class="btn btn-primary btn-floating m-1"
                                        style="background-color: #ac2bac"
                                        href="https://instagram.com/neckmerry?igshid=ZDdkNTZiNTM="
                                        role="button"
                                        ><i class="fab fa-instagram"></i
                                        ></a>

                                    <a
                                        class="btn btn-primary btn-floating m-1"
                                        style="background-color: #1A1A1A"
                                        href="https://m.youtube.com/channel/UCS9hzA45uHX2tC1NQNgtV8A"
                                        role="button"
                                        ><i class="fab fa-youtube"></i
                                        ></a>
                                    <a
                                        class="btn btn-primary btn-floating m-1"
                                        style="background-color: #E5BE01"
                                        href="https://goo.gl/maps/SWK7bhiyvi5vmm439"
                                        role="button"
                                        ><i class="fab fa-google">maps</i
                                        ></a>
                                </div>
                            </div>

                        </section>

                    </div>

                    <div
                        class="text-center p-3"
                        style="background-color: rgba(0, 0, 0, 0.2)"
                        >
                        © 2020 Copyright:
                        <a class="text-white" href="https://www.facebolsrl.com/"
                           >PicaTodo.com</a
                        >
                    </div>

                </footer>

            </div>

        </main>

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>

    </body>
</html>
