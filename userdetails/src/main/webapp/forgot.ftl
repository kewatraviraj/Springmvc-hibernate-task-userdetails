<!DOCTYPE html>
<head>
<title>Forgot</title>
</head>

<body class="dashboard-page">
	
	<#include "header.ftl" />
	
	<section class="wrapper scrollable">
		<div class="rightside">
			
			<div class="panel panel-widget login-div agile-validation">
				<div class="text-center"><#if forgotmsg??>${forgotmsg}</#if></div>
				<div class="validation-grids validation-grids-right">
					<div class="widget-shadow login-form-shadow" data-example-id="basic-forms"> 
						<div class="input-info">
							<h3>Enter Details:</h3>
						</div>
						
						<div class="form-body form-body-info">
							<form data-toggle="validator" id="registration-form" novalidate="true" action="forgotpass" method="post">
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
			<div class="footer">
				<p>� 2018. All Rights Reserved. Design by</p>
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
