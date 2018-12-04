<!DOCTYPE html>
<#if !Session.user?exists>
</#if>
<head>
<title>Forgot</title>
</head>

<body class="dashboard-page">
	
	<#include "header.ftl" />
	
	<section class="wrapper scrollable">
		<div class="rightside">
			
			<div class="panel panel-widget login-div agile-validation">
				
				<div class="validation-grids validation-grids-right">
					<div class="widget-shadow login-form-shadow" data-example-id="basic-forms"> 
					<#if forgotmsg??><div class="alert alert-info text-center" role="alert"><h4>${forgotmsg}</h4></div></#if>
						<div class="input-info">
							<h3>Enter Details:</h3>
						</div>
						
						<div class="form-body form-body-info">
							<form data-toggle="validator" id="forgotpass-form" novalidate="true" action="forgotpass" method="post">
								Email* :
								<div class="form-group has-feedback">
									<input type="email" class="form-control" name="email" id="inputEmail" placeholder="Email" data-error="Invalid email address" required="">
									<span class="glyphicon form-control-feedback" aria-hidden="true"></span>
									<span class="help-block with-errors"></span>
								</div>
								<div class="form-group">
									<button type="submit" id="forgotpwdSubmit" class="btn btn-primary disabled">Submit</button>
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
	<!--
	<#-- <script>
		function getForgotPass(event){
		event.preventDefault();
		
		var formData = $("#forgotpass-form").serialize();
		
			$.ajax({
			       type: 'post',
			 	   url : $("#forgotpass-form").attr('action'),
			 	   dataType : 'json',
		           data : JSON.stringify(formData),   
			 	   success: function(response){
					    $('#inputEmail').val('');
			 			$('#forgotpassResponse').text(JSON.stringify(response)); 
			       }
			    })		  
		return false;
		}
	</script>	-->-->
</body>
</html>
