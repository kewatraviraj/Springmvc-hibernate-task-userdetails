<html>
<head>
<link rel="stylesheet" href="css/bootstrap.css">
<link href="css/style.css" rel='stylesheet' type='text/css' />
<link href="css/font-awesome.css" rel="stylesheet"> 
<link href="css/customstyle.css" rel="stylesheet">
<title>Login</title>
<style>
.pass-forgot{
	float:right	;
}
</style>
</head>
<body class="dashboard-page">
	<#include "header.ftl" />
	
	<section class="wrapper scrollable">
		<div class="rightside">
			<div class="panel panel-widget login-div agile-validation">
				<div class="validation-grids validation-grids-right">
					<div class="widget-shadow login-form-shadow" data-example-id="basic-forms"> 
						<div class="text-center"><#if messages??>${messages}</#if></div>
						<div class="input-info">
							<h3>Sign In:</h3>
						</div>
						<div class="form-body form-body-info">
							<form data-toggle="validator" novalidate="true" action="login" method="post">
								<div class="form-group has-feedback">
									<input type="email" class="form-control" name="userName" id="inputEmail" placeholder="Enter Your Email" data-error="Bruh, that email address is invalid" required="">
									<span class="glyphicon form-control-feedback" aria-hidden="true"></span>
								</div>
								<div class="form-group">
									<input type="password" data-toggle="validator" data-minlength="6" class="form-control" name="passWord" id="inputPassword" placeholder="Password" required="">
								</div>
								<div class="bottom">
									<div class="form-group">
										<a href="forgot" class="pass-forgot">Forgot your password?</a>
									</div>
									<div class="form-group">
										<button type="submit" class="btn btn-primary disabled">Login</button><br>
										<p class="message">Not registered? <a href="register">Create an account</a></p>
									</div>
									<div class="clearfix"> </div>
								</div>
							</form>
						</div>
					</div>
				</div>
			</div>
			<div class="footer">
				<p>2018. All Rights Reserved. Design by</p>
			</div>
		</div>
	</section>
	
	<script src="js/jquery3.1.1.js"></script>
	<script src="js/modernizr.js"></script>
	<script src="js/jquery.cookie.js"></script>
	<script src="js/bootstrap.js"></script>
		
		<script type="text/javascript" src="js/valida.2.1.6.min.js"></script>
		<script type="text/javascript" >
			$(document).ready(function() {

				$('#version').valida( 'version' );

				$('.valida').valida();
				
			});
		</script>
		<script src="js/validator.min.js"></script>
		<script src="js/customvalidate.js"></script>

		<script src="js/proton.js"></script>
</body>
</html>
