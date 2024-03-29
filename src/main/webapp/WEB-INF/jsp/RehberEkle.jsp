<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Rehber Ekle</title>
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
    <style>
        .orta {
        text-align:center;

        }
    </style>


    <body>
        <!-- Left Panel -->

        <aside id="left-panel" class="left-panel">
            <nav class="navbar navbar-expand-sm navbar-default">

                <div id="main-menu" class="main-menu collapse navbar-collapse">
                <ul class="nav navbar-nav">
                    <li class="menu-title">Personel</li>
                    <!-- /.menu-title -->
                    <li>
                        <a href="listele"><i class="menu-icon fa fa-users"></i>Personel Ekle</a>
                    </li>
                    <li class="menu-title">Rehber</li>
                    <!-- /.menu-title -->
                    <li class="active"><a href="rehberEkleSayfasi"><i class="menu-icon fa fa-edit"></i>Yeni Kayıt</a></li>
                    <li><a href="ara"><i class="menu-icon fa fa-book"></i>Rehber</a></li>
                    <!-- Son kullanılacak!-->
                    
                    <li class="menu-title">Parametreler</li>
                    <!-- /.menu-title -->


                    <li><a href="bolumListele"><i class="menu-icon fa fa-list-ol"></i>Parametre Listesi</a></li>
                    <li><a href="listeleFirma"><i class="menu-icon fa fa-suitcase"></i>Firma Ekle</a></li>

                    <c:if test = "${department == 'Muhasebe'}">
	                    <li class="menu-title">Muhasebe</li>
	                    <!-- /.menu-title -->
	
	                    <li ><a href="buttonsSorgula"><i class="menu-icon fa fa-search"></i>Detaylı Sorgulama</a></li>
	
	                    <li><a href="listeleExcel"><i class="menu-icon fa fa-keyboard-o"></i>Veri Girişi</a></li>
                    </c:if>
                    
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
                    <a class="navbar-brand" href="Anasayfa.html"><img src="images/doc_tr.png" alt="Logo" style="height:40px"></a>
                    <a class="navbar-brand hidden" href="./"><img src="images/doc_tr_2.png" alt="Logo"></a>
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
                            <div class="dropdown for-notification">
                                <button class="btn btn-secondary dropdown-toggle" type="button" id="notification" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                    <i class="fa fa-bell"></i>
                                    <span class="count bg-danger">3</span>
                                </button>
                                <div class="dropdown-menu" aria-labelledby="notification">
                                    <p class="red">You have 3 Notification</p>
                                    <a class="dropdown-item media" href="#">
                                        <i class="fa fa-check"></i>
                                        <p>Server #1 overloaded.</p>
                                    </a>
                                    <a class="dropdown-item media" href="#">
                                        <i class="fa fa-info"></i>
                                        <p>Server #2 overloaded.</p>
                                    </a>
                                    <a class="dropdown-item media" href="#">
                                        <i class="fa fa-warning"></i>
                                        <p>Server #3 overloaded.</p>
                                    </a>
                                </div>
                            </div>

                            <div class="dropdown for-message">
                                <button class="btn btn-secondary dropdown-toggle" type="button" id="message" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                    <i class="fa fa-envelope"></i>
                                    <span class="count bg-primary">4</span>
                                </button>
                                <div class="dropdown-menu" aria-labelledby="message">
                                    <p class="red">You have 4 Mails</p>
                                    <a class="dropdown-item media" href="#">
                                        <span class="photo media-left">
                                            <img alt="avatar" src="images/avatar/1.jpg"></span>
                                        <div class="message media-body">
                                            <span class="name float-left">Jonathan Smith</span>
                                            <span class="time float-right">Just now</span>
                                            <p>Hello, this is an example msg</p>
                                        </div>
                                    </a>
                                    <a class="dropdown-item media" href="#">
                                        <span class="photo media-left">
                                            <img alt="avatar" src="images/avatar/2.jpg"></span>
                                        <div class="message media-body">
                                            <span class="name float-left">Jack Sanders</span>
                                            <span class="time float-right">5 minutes ago</span>
                                            <p>Lorem ipsum dolor sit amet, consectetur</p>
                                        </div>
                                    </a>
                                    <a class="dropdown-item media" href="#">
                                        <span class="photo media-left">
                                            <img alt="avatar" src="images/avatar/3.jpg"></span>
                                        <div class="message media-body">
                                            <span class="name float-left">Cheryl Wheeler</span>
                                            <span class="time float-right">10 minutes ago</span>
                                            <p>Hello, this is an example msg</p>
                                        </div>
                                    </a>
                                    <a class="dropdown-item media" href="#">
                                        <span class="photo media-left">
                                            <img alt="avatar" src="images/avatar/4.jpg"></span>
                                        <div class="message media-body">
                                            <span class="name float-left">Rachel Santos</span>
                                            <span class="time float-right">15 minutes ago</span>
                                            <p>Lorem ipsum dolor sit amet, consectetur</p>
                                        </div>
                                    </a>
                                </div>
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
                                <a class="nav-link" href="sifreDegistir"><i class="fa fa-lock"></i>Şifremi Değiştir</a>
                                <a class="nav-link" href="logout"><i class="fa fa-power-off"></i>Çıkış</a>
                                
                                
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
                                    <h1>Kişi Ekle</h1>
                                </div>
                            </div>
                        </div>
                        <div class="col-sm-8">
                            <div class="page-header float-right">
                                <div class="page-title">
                                    <ol class="breadcrumb text-right">
                                        <li><a href="#">Anasayfa</a></li>
                                        <li class="active">Kişi Ekle</li>
                                    </ol>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="content">
                <div class="animated fadeIn">
                    <form id="rehberekle" runat="server" method="post" action="rehberEkleButtons">
                        <div class="row">
                            <div class="col-xs-6 col-sm-6">
                                <div class="card">
                                    <div class="card-body card-block">
                                        <div class="row">
                                            <div class="col-6">
                                                <div class="form-group">
                                                    <label class=" form-control-label">Ad</label>
                                                    <div class="input-group">
                                                        <div class="input-group-addon"><i class="fa fa-user"></i></div>
                                                        <input class="form-control" name = "ad" value="${adBox}">
                                                    </div>
                                                    <small class="form-text text-muted">örn. xxxxx</small>
                                                </div>
                                            </div>
                                            <div class="col-6">
                                                <div class="form-group">
                                                    <label class=" form-control-label">Soyad</label>
                                                    <div class="input-group">
                                                        <div class="input-group-addon"><i class="fa fa-user"></i></div>
                                                        <input class="form-control" name = "soyad"  value="${soyadBox}">
                                                    </div>
                                                    <small class="form-text text-muted">örn. xxxxx</small>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col-6">
                                                <div class="form-group">
                                                    <label class=" form-control-label">Firma Adı</label>
                                                    <div class="input-group">
                                                        <div class="input-group-addon"><i class="fa fa-building-o"></i></div>
                                                        <input class="form-control" name="firmaAdi"  value="${firmaAdiBox}">
                                                    </div>
                                                    <small class="form-text text-muted">örn. xxxxx xxxx xxx</small>
                                                </div>
                                            </div>
                                            <div class="col-6">
                                                <div class="form-group">
                                                    <label class=" form-control-label">Şube</label>
                                                    <div class="input-group">
                                                        <div class="input-group-addon"><i class="fa fa-map-marker"></i></div>
                                                        <input class="form-control" name="sube"  value="${subeBox}">
                                                    </div>
                                                    <small class="form-text text-muted">örn. xxxxx</small>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class=" form-control-label">Görevi</label>
                                            <div class="input-group">
                                                <div class="input-group-addon"><i class="fa fa-suitcase"></i></div>
                                                <input class="form-control" name ="gorevi"  value="${goreviBox}">
                                            </div>
                                            <small class="form-text text-muted">örn. xxxxx xxxxxxx</small>
                                        </div>
                                        <div class="form-group">
                                            <label class=" form-control-label">E- mail</label>
                                            <div class="input-group">
                                                <div class="input-group-addon"><i class="fa fa-envelope"></i></div>
                                                <input class="form-control" name ="email"  value="${emailBox}">
                                            </div>
                                            <small class="form-text text-muted">örn. xxxxx@xxxx.com</small>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="col-xs-6 col-sm-6">
                                <div class="card">
                                    <div class="card-body card-block">
                                        <div class="form-group">
                                            <label class=" form-control-label">Cep Telefonu</label>
                                            <div class="input-group">
                                                <div class="input-group-addon"><i class="fa fa-mobile"></i></div>
                                                <input class="form-control" name="cepTelefonu"  value="${cepTelefonuBox}">
                                            </div>
                                            <small class="form-text text-muted">örn. 0 5xx xxx xx xx</small>
                                        </div>
                                        <div class="form-group">
                                            <div class="row">
                                                <div class="col-8">
                                                    <label class=" form-control-label">İş Telefonu</label>
                                                    <div class="input-group">
                                                        <div class="input-group-addon"><i class="fa fa-phone"></i></div>
                                                        <input class="form-control" name="isTelefonu"  value="${isTelefonuBox}">
                                                    </div>
                                                    <small class="form-text text-muted">örn. 0 (xxx) xxx xx xx</small>
                                                </div>
                                                <div class="col-4">
                                                    <label class=" form-control-label">Dahili - 1</label>
                                                    <div class="input-group">
                                                        <div class="input-group-addon"><i class="fa fa-plus"></i></div>
                                                        <input class="form-control" name = "dahili"  value="${dahiliBox}">
                                                    </div>
                                                    <small class="form-text text-muted">örn. xxxxx</small>
                                                </div>
                                            </div>
                                        </div>
										<div class="row">
											<div class="col-8">
		                                        <div class="form-group ">
		                                            <label class=" form-control-label">Personel</label>
		                                                 <div class="input-group">
		                                             <div class="input-group-addon"><i class="fa fa-smile-o"></i></div>
		                                            <select name="kim" id="select" class="form-control col-12">
		                                                <option value="Genel">Genel</option>
		                                           		<c:forEach items="${adSoyad}" var="list">
		                                               		<option value="${list}">${list}</option>
		                                       			</c:forEach>
		                                            </select>
		                                           </div>
		                                        </div>
	                                         </div>
	                                        <div class="col-4">
		                                        <div class="form-group ">
		                                            <label class=" form-control-label">Durum</label>
		                                            <div class="input-group">
		                                                <div class="input-group-addon"><i class="fa fa-unlock-alt"></i></div>
		                                                <select name="durumRehber" id="select" class="form-control " >
		                                                    <option value="${dropdownRehber}"></option>
		                                                    <option value="Aktif">Aktif</option>
		                                                    <option value="Pasif">Pasif</option>
		                                                </select>
		                                            </div>
		                                        </div>
		                                    </div>
                                        </div>                              
                                        <div style="margin-left: 20px; margin-right: 20px;margin-top:57px">
                                            <hr />
                                        </div>
                                        <div class="card-body" style="text-align: right">                                       
                                           <input type="submit" class="btn btn-outline-success" name="KaydetRehber" value="Kaydet" <c:if test="${kaydetRehber == true}"><c:out value="disabled='disabled'"/></c:if>/>
	                                    	<input type="submit" class="btn btn-outline-primary" name="GüncelleRehber" value = "Güncelle" <c:if test="${guncelleRehber == true}"><c:out value="disabled='disabled'"/></c:if>/>
	                                    	<input type="submit" class="btn btn-outline-danger" name="TemizleRehber" value = "Temizle"/>
                                        </div>
                                    </div>
                                    <!--</div>
			                             <div class="card" style="text-align: right">
			                                <div class="card-body">
			                                    <button type="button" class="btn btn-outline-success">Kaydet</button>
			                                    <button type="button" class="btn btn-outline-primary">Güncelle</button>
			                                    <button type="button" class="btn btn-outline-danger">Sil</button>
			                                </div>
		                            </div>-->
                                </div>
                    </form>
                </div>
            </div>
        </div>
         </div>
        <!-- .animated -->
        <div class="content">
            <div class="animated fadeIn">
                <div class="row">
                    <div class="col-md-12">
                        <div class="card">
                            <div class="card-header">
                                <strong class="card-title">Rehber</strong>
                            </div>
                            <div class="card-body">
                                <table id="bootstrap-data-table" class="table table-striped table-bordered">
                                    <thead>
                                        <tr>
                                            <th>Firma Adı</th>
                                            <th>Ad</th>
                                            <th>Soyad</th>
                                            <th>E-mail</th>
                                            <th>Cep Telefonu</th>
                                            <th>İş Telefonu</th>
                                            <th>Durum</th>
                                            <th></th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                    	<c:forEach items="${listRehber}" var="list">
	                                        <tr>
	                                            <td>${list.firmaAdi }</td>
	                                            <td>${list.ad }</td>
	                                            <td>${list.soyad }</td>
	                                            <td>${list.email }</td>
	                                            <td>${list.cepTelefonu }</td>
	                                            <td>${list.isTelefonu }</td>
	                                            <td>${list.durum}</td>
	                                            <td class="orta">
	                                                <label>
	                                                    <!-- <a href="deleteRehber?id=${list.id}" class="fa fa-times"></a> -->
	                                                    <a href="fillRehber?id=${list.id}" class="fa fa-pencil"></a>
	                                                    <!-- <a href="fillTextBox?id=${list.id}" class="fa fa-check"></a> --><!-- dont know what this is for -->
	                                                </label>
	                                            </td>
	                                        </tr>
                                        </c:forEach>
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
        <!-- /#right-panel -->
        <!-- Right Panel -->
        <!-- Scripts -->
        <script src="https://cdn.jsdelivr.net/npm/jquery@2.2.4/dist/jquery.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.4/dist/umd/popper.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/js/bootstrap.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/jquery-match-height@0.7.2/dist/jquery.matchHeight.min.js"></script>
        <script src="assets/js/main.js"></script>
        <script src="assets/js/lib/chosen/chosen.jquery.min.js"></script>
        <script src="assets/js/lib/data-table/datatables.min.js"></script>
        <script src="assets/js/lib/data-table/dataTables.bootstrap.min.js"></script>
        <script src="assets/js/lib/data-table/dataTables.buttons.min.js"></script>
        <script src="assets/js/lib/data-table/buttons.bootstrap.min.js"></script>
        <script src="assets/js/lib/data-table/jszip.min.js"></script>
        <script src="assets/js/lib/data-table/vfs_fonts.js"></script>
        <script src="assets/js/lib/data-table/buttons.html5.min.js"></script>
        <script src="assets/js/lib/data-table/buttons.print.min.js"></script>
        <script src="assets/js/lib/data-table/buttons.colVis.min.js"></script>
        <!--<script src="assets/js/init/datatables-init.js"></script>-->
        <!-- search box ve görüntülenecek satır sayısı için gerekli js-->

        <script>
            jQuery(document).ready(function () {
                jQuery(".standardSelect").chosen({
                    disable_search_threshold: 10,
                    no_results_text: "Oops, nothing found!",
                    width: "100%"
                });
            });
		</script>
        <script type="text/javascript">
            $(document).ready(function () {
                $('#bootstrap-data-table-export').DataTable();
            });
 		 </script>
    </body>
</html>
