<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<!--[if lt IE 7]>      <html class="no-js lt-ie9 lt-ie8 lt-ie7" lang=""> <![endif]-->
<!--[if IE 7]>         <html class="no-js lt-ie9 lt-ie8" lang=""> <![endif]-->
<!--[if IE 8]>         <html class="no-js lt-ie9" lang=""> <![endif]-->
<!--[if gt IE 8]><!--> <html class="no-js" lang=""> <!--<![endif]-->
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Şifremi Değiştir</title>
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
    

    <link href='https://fonts.googleapis.com/css?family=Open+Sans:400,600,700,800' rel='stylesheet' type='text/css'>
</head>
<body class="bg-secondary">
    <div class="sufee-login d-flex align-content-center flex-wrap">
        <div class="container">
            <div class="login-content">
                <div class="login-form">
                    <form method="post" action="sifreYenile">
                        <label>Eski Şifre</label>
                        <div class="input-group">
                            <input type="password" class="form-control" placeholder="Eski Şifre" name="oldPassword" data-toggle="oldPassword">
                            <div class="input-group-append">
     							 <span class="input-group-text"><i class="fa fa-eye"></i></span>
    						</div>
                        </div>
                        <br>
                        <label>Yeni Şifre</label>
                        <div class="input-group">
                            <input id = "password" type="password" class="form-control" placeholder="Yeni Şifre" name = "newPassword" data-toggle="newPassword">
                            <div class="input-group-append">
     							 <span class="input-group-text"><i class="fa fa-eye"></i></span>
    						</div>
                        </div>
                        <div id="divCheckPassword"   class="alert alert-danger" style="display:none"></div>
                        <br>
                        <label>Tekrar Yeni Şifre</label>
                        <div class="input-group">
                            <input id="rePassword" type="password" class="form-control" placeholder="Tekrar Yeni Şifre" name="reNewPassword" data-toggle="reNewPassword" onChange="isPasswordMatch();">
                            <div class="input-group-append">
     							 <span class="input-group-text"><i class="fa fa-eye"></i></span>
    						</div>
                        </div>
                        <br>
                        <button type="submit" class="btn btn-primary btn-flat m-b-30 m-t-30">Şifre Değiştir</button>
                    </form>
                </div>
            </div>
        </div>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/jquery@2.2.4/dist/jquery.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.4/dist/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/js/bootstrap.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/jquery-match-height@0.7.2/dist/jquery.matchHeight.min.js"></script>
    <script src="assets/js/main.js"></script>
     <script src="assets/js/bootstrap-validate.js"></script>
	<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
	<script type="text/javascript">
	 //<![CDATA[

	    window.onload=function(){
			!function(a){a(function(){a('[data-toggle="oldPassword"]').each(function(){var b = a(this); var c = a(this).parent().find(".input-group-text"); c.css("cursor", "pointer").addClass("input-password-hide"); c.on("click", function(){if (c.hasClass("input-password-hide")){c.removeClass("input-password-hide").addClass("input-password-show"); c.find(".fa").removeClass("fa-eye").addClass("fa-eye-slash"); b.attr("type", "text")} else{c.removeClass("input-password-show").addClass("input-password-hide"); c.find(".fa").removeClass("fa-eye-slash").addClass("fa-eye"); b.attr("type", "password")}})})})}(window.jQuery);
			!function(a){a(function(){a('[data-toggle="newPassword"]').each(function(){var b = a(this); var c = a(this).parent().find(".input-group-text"); c.css("cursor", "pointer").addClass("input-password-hide"); c.on("click", function(){if (c.hasClass("input-password-hide")){c.removeClass("input-password-hide").addClass("input-password-show"); c.find(".fa").removeClass("fa-eye").addClass("fa-eye-slash"); b.attr("type", "text")} else{c.removeClass("input-password-show").addClass("input-password-hide"); c.find(".fa").removeClass("fa-eye-slash").addClass("fa-eye"); b.attr("type", "password")}})})})}(window.jQuery);
			!function(a){a(function(){a('[data-toggle="reNewPassword"]').each(function(){var b = a(this); var c = a(this).parent().find(".input-group-text"); c.css("cursor", "pointer").addClass("input-password-hide"); c.on("click", function(){if (c.hasClass("input-password-hide")){c.removeClass("input-password-hide").addClass("input-password-show"); c.find(".fa").removeClass("fa-eye").addClass("fa-eye-slash"); b.attr("type", "text")} else{c.removeClass("input-password-show").addClass("input-password-hide"); c.find(".fa").removeClass("fa-eye-slash").addClass("fa-eye"); b.attr("type", "password")}})})})}(window.jQuery);

	    }

	  //]]></script>
	
	 <script>
		
		function isPasswordMatch() {
		    var password = $("#password").val();
		    var confirmPassword = $("#rePassword").val();
		    var x = document.getElementById("divCheckPassword");

		    if (password != confirmPassword){
		    	x.style.display = "block";
		    	$("#divCheckPassword").html("Şifreler Uyuşmuyor!");
		    }
		    else {
		    	x.style.display = "none";
		    	$("#divCheckPassword").html("Passwords match.");
		    }
		}

		$(document).ready(function () {
		    $("#rePassword").keyup(isPasswordMatch);
		});
	</script>
	
</body>
</html>
