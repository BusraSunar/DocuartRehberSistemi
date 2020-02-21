<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Personel Ekle</title>
    <meta name="description" content="Ela Admin - HTML5 Admin Template">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link rel="apple-touch-icon" href="https://i.imgur.com/QRAUqs9.png">
    <link rel="shortcut icon" href="https://i.imgur.com/QRAUqs9.png">

    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/normalize.css@8.0.0/normalize.min.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/font-awesome@4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/gh/lykmapipo/themify-icons@0.1.2/css/themify-icons.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/pixeden-stroke-7-icon@1.2.3/pe-icon-7-stroke/dist/pe-icon-7-stroke.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/flag-icon-css/3.2.0/css/flag-icon.min.css">
    <link rel="stylesheet" href="assets/css/cs-skin-elastic.css">
    <link rel="stylesheet" href="assets/css/style.css">
    <link rel="stylesheet" href="assets/css/lib/chosen/chosen.min.css">

    <link href='https://fonts.googleapis.com/css?family=Open+Sans:400,600,700,800' rel='stylesheet' type='text/css'>
</head>
<body>
    <!-- Left Panel -->

    <aside id="left-panel" class="left-panel">
        <nav class="navbar navbar-expand-sm navbar-default">

            <div id="main-menu" class="main-menu collapse navbar-collapse">
                <ul class="nav navbar-nav">


                    <li class="menu-title">Personel</li>
                    <!-- /.menu-title -->

                    <li class="active">
                        <a href="PersonelEkle.html"><i class="menu-icon fa fa-users"></i>Personel Ekle</a>

                    </li>

                    <li class="menu-title">Rehber</li>
                    <!-- /.menu-title -->


                    <li><a href="RehberEkle.html"><i class="menu-icon fa fa-edit"></i>Yeni Kayıt</a></li>
                    <li><a href="Rehber.html"><i class="menu-icon fa fa-book"></i>Rehber</a></li>

                    <!-- Son kullanılacak!-->
                    <!--<li class="menu-title">Ekstra</li>

                 <li class="menu-item-has-children dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"> <i class="menu-icon fa fa-glass"></i>Giriş</a>
                        <ul class="sub-menu children dropdown-menu">
                            <li><i class="menu-icon fa fa-sign-in"></i><a href="page-login.html">Login</a></li>
                            <li><i class="menu-icon fa fa-sign-in"></i><a href="page-register.html">Register</a></li>
                            <li><i class="menu-icon fa fa-paper-plane"></i><a href="pages-forget.html">Forget Pass</a></li>
                        </ul>
                    </li>-->
                    <!-- Son kullanılacak!-->

                </ul>
            </div>
            <!-- /.navbar-collapse -->
        </nav>
    </aside>
    <!-- /#left-panel -->
    <!-- Left Panel -->


    <!-- Right Panel -->
    <div id="right-panel" class="right-panel">

        <!-- Header-->
        <header id="header" class="header">
            <div class="top-left">
                <div class="navbar-header">
                    <a class="navbar-brand" href="Anasayfa.html">
                        <img src="images/doc_tr.png" alt="Logo" style="height: 40px"></a>
                    <a class="navbar-brand hidden" href="./">
                        <img src="images/doc_tr_2.png" alt="Logo"></a>
                    <a id="menuToggle" class="menutoggle"><i class="fa fa-bars"></i></a>
                </div>
            </div>
            <div class="top-right">
                <div class="header-menu">
                    <div class="header-left">
                        <button class="search-trigger"><i class="fa fa-search"></i></button>
                        <div class="form-inline">
                            <form class="search-form">
                                <input class="form-control mr-sm-2" type="text" placeholder="Search ..." aria-label="Search">
                                <button class="search-close" type="submit"><i class="fa fa-close"></i></button>
                            </form>
                        </div>

                        
                    </div>

                    <div class="user-area dropdown float-right">
                        <a href="#" class="dropdown-toggle active" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            <img class="user-avatar rounded-circle" src="images/admin.jpg" alt="User Avatar">
                        </a>

                        <div class="user-menu dropdown-menu">
                            <a class="nav-link" href="#"><i class="fa fa-user"></i>Profilim</a>

                            <a class="nav-link" href="#"><i class="fa fa-bell-o"></i>Notification <span class="count">1</span></a>

                            <a class="nav-link" href="#"><i class="fa fa-cog"></i>Ayarlar</a>

                            <a class="nav-link" href="#"><i class="fa fa-power-off"></i>Çıkış</a>
                        </div>
                    </div>
                </div>
            </div>
        </header>
        <!-- /header -->
        <!-- Header-->

        <div class="breadcrumbs">
            <div class="breadcrumbs-inner">
                <div class="row m-0">
                    <div class="col-sm-4">
                        <div class="page-header float-left">
                            <div class="page-title">
                                <h1>Personel Ekle</h1>
                            </div>
                        </div>
                    </div>
                    <div class="col-sm-8">
                        <div class="page-header float-right">
                            <div class="page-title">
                                <ol class="breadcrumb text-right">
                                    <li><a href="#">Anasayfa</a></li>

                                    <li class="active">Personel Ekle</li>
                                </ol>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <div class="content">
            <div class="animated fadeIn">

                <div class="row">

                    <div class="col-xs-12 col-sm-12">
                        <div class="card">

                            <div class="card-body card-block">
                                <div class="row">
                                    <div class="col-4">
                                        <div class="form-group">

                                            <label class=" form-control-label">Ad</label>
                                            <div class="input-group">
                                                <div class="input-group-addon"><i class="fa fa-smile-o"></i></div>
                                                <input class="form-control">
                                            </div>
                                            <small class="form-text text-muted">örn.</small>
                                        </div>
                                    </div>
                                    <div class="col-4">
                                        <div class="form-group">

                                            <label class=" form-control-label">Soyad</label>
                                            <div class="input-group">
                                                <div class="input-group-addon"><i class="fa fa-smile-o"></i></div>
                                                <input class="form-control">
                                            </div>
                                            <small class="form-text text-muted">örn.</small>
                                        </div>
                                    </div>
                                    <div class="col-4">
                                        <div class="form-group ">

                                            <label class=" form-control-label">Durum</label>
                                            <div class="input-group">
                                                <div class="input-group-addon"><i class="fa fa-unlock-alt"></i></div>
                                                <select name="select" id="select" class="form-control ">
                                                    <option value="0"></option>
                                                    <option value="1">Aktif</option>
                                                    <option value="2">Pasif</option>
                                                </select>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div style="margin-left: 20px; margin-right: 20px">
                                    <hr />
                                </div>

                                <div class="card-body" style="text-align: right">
                                    <button type="button" class="btn btn-outline-success">Kaydet</button>
                                    <button type="button" class="btn btn-outline-primary">Güncelle</button>
                                    <button type="button" class="btn btn-outline-danger">Sil</button>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="col-lg-12">
                        <div class="card">
                            <div class="card-header">
                                <strong class="card-title">Personel</strong>
                            </div>
                            <div class="card-body">
                                <table class="table table-striped">
                                    <thead>
                                        <tr>

                                            <th scope="col">Ad</th>
                                            <th scope="col">Soyad</th>
                                            <th scope="col">Durum</th>
                                            <th scope="col" style="width:15%"></th>

                                        </tr>
                                    </thead>
                                    <tbody>
                                        <tr>
                                            <td>Otto</td>
                                            <td>Otto</td>
                                            <td>Aktif</td>
                                            <td>
                                                <label>
                                                    <a href='#' class="fa fa-times"></a>
                                                    <a href='#' class="fa fa-pencil"></a>
                                                    <a href='#' class="fa fa-check"></a>
                                                </label>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>Otto</td>
                                            <td>Thornton</td>
                                            <td>Aktif</td>
                                            <td>
                                                <label>
                                                    <a href='#' class="fa fa-times"></a>
                                                    <a href='#' class="fa fa-pencil"></a>
                                                    <a href='#' class="fa fa-check"></a>
                                                </label>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>Otto</td>
                                            <td>the Bird</td>
                                            <td>Pasif</td>
                                            <td>
                                                <label>
                                                    <a href='#' class="fa fa-times"></a>
                                                    <a href='#' class="fa fa-pencil"></a>
                                                    <a href='#' class="fa fa-check"></a>
                                                </label>
                                            </td>
                                        </tr>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>



                </div>


            </div>
            <!-- .animated -->
        </div>
        <!-- .content -->
        <div class="clearfix"></div>

        <footer class="site-footer">
            <div class="footer-inner bg-white">
                <div class="row">
                    <div class="col-sm-6">
                        Copyright &copy; 2020 <a href="https://docuart.com.tr">Docuart</a>

                    </div>
                    <div class="col-sm-6 text-right">
                    </div>
                </div>
            </div>
        </footer>


    </div>
    <!-- /#right-panel -->

    <!-- Right Panel -->

    <!-- Scripts -->
    <script src="https://cdn.jsdelivr.net/npm/jquery@2.2.4/dist/jquery.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.4/dist/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/js/bootstrap.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/jquery-match-height@0.7.2/dist/jquery.matchHeight.min.js"></script>
    <script src="assets/js/main.js"></script>
    <script src="assets/js/lib/chosen/chosen.jquery.min.js"></script>

    <script>
        jQuery(document).ready(function () {
            jQuery(".standardSelect").chosen({
                disable_search_threshold: 10,
                no_results_text: "Oops, nothing found!",
                width: "100%"
            });
        });
</script>

</body>
</html>
