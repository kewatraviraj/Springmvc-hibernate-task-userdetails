<!DOCTYPE html>
<head>
<title>Forgot</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<!-- bootstrap-css -->
<link rel="stylesheet" href="css/bootstrap.css">
<!-- //bootstrap-css -->
<!-- Custom CSS -->
<link href="css/style.css" rel='stylesheet' type='text/css' />
<link href="css/font-awesome.css" rel="stylesheet"> 
<link href="css/customstyle.css" rel="stylesheet">

</head>

<body class="dashboard-page">
	
	<#include "header.ftl" />
	
	<section class="wrapper scrollable">
		<div class="rightside">
			
			<div class="panel panel-widget login-div agile-validation">
				<div class="text-center">requestScope.message + requestScope.password</div>
				<div class="validation-grids validation-grids-right">
					<div class="widget-shadow login-form-shadow" data-example-id="basic-forms"> 
						<div class="input-info">
							<h3>Enter Details:</h3>
						</div>
						
						<div class="form-body form-body-info">
							<form data-toggle="validator" id="registration-form" novalidate="true" action="forgot" method="post">
								Email* :
								<div class="form-group has-feedback">
									<input type="email" class="form-control" name="email" id="inputEmail" placeholder="Email" data-error="Invalid email address" required="">
									<span class="glyphicon form-control-feedback" aria-hidden="true"></span>
									<span class="help-block with-errors"></span>
								</div>
								<div class="form-group">
									<button type="submit" class="btn btn-primary disabled">Submit</button>
								</div>
							</form>
						</div>
					</div>
				</div>
				</div>
			<!-- footer -->
			<div class="footer">
				<p>© 2018. All Rights Reserved. Design by</p>
			</div>
			<!-- //footer -->
		</div>
	</section>
	
	<script src="js/jquery3.1.1.js"></script>
	<script src="js/modernizr.js"></script>
	<script src="js/jquery.cookie.js"></script>
	<script src="js/bootstrap.js"></script>
	<!-- input-forms -->
		<script type="text/javascript" src="js/valida.2.1.6.min.js"></script>
		<script type="text/javascript" >
			$(document).ready(function() {

				// show Valida's version.
				$('#version').valida( 'version' );

				// Exemple 1
				$('.valida').valida();
						
			});
		</script>
		<!-- //input-forms -->
		<!--validator js-->
		<script src="js/validator.min.js"></script>
		<script src="js/customvalidate.js"></script>
		<!--//validator js-->

		<script src="js/proton.js"></script>
</body>
</html>
