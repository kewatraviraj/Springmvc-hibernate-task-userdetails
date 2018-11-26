<<!DOCTYPE html>
<head>
<title>Register</title>
<link rel="stylesheet" href="css/bootstrap.css">
<link rel="stylesheet" href="css/datepicker.css"/>		
<link href="css/style.css" rel='stylesheet' type='text/css' />
<link href="css/font-awesome.css" rel="stylesheet"> 
<link href="css/customstyle.css" rel="stylesheet">

</head>

<body class="dashboard-page">
	<#include "header.ftl" />
	
	<section class="wrapper scrollable">
		<div class="rightside">
			<div class="main-grid">
				<div class="agile-grids">	
					<!-- validation -->
					<div class="grids">
						<div class="progressbar-heading grids-heading text-center">
							<h3 id="notchanges"></h3>
						</div>
						<#if userdetail??>
							<div><a href="dashboard" class="btn btn-large btn-warning">Cancel</a></div>
						</#if>
						<br>
						<div class="w3agile-validation w3ls-validation">
							<div class="panel panel-widget agile-validation">
								<div class="validation-grids widget-shadow" data-example-id="basic-forms">
									<div class="text-center"><h5 id="nochanges"></h5></div> 
									<div class="input-info">
										<h3>Fill the Details :</h3>
									</div>
									<div class="form-body form-body-info">
										<form data-toggle="validator" id="registration-form" novalidate="true" enctype="multipart/form-data" action="save" method="post">
											<#if !files??>
											 	<div class="form-group register-image text-center">
													<img src="images/avatar_2x.png" class="avatar img-circle img-thumbnail" alt="avatar" accept="image/*"><br>
													<h6>Upload Image...*</h6><br>		
													<input type="file" class="text-center file-upload" name="image" required="">
												</div>
											</#if>
											
											<#if userdetail??>
												<input type="hidden" class="form-control" value="update" name="operation" required="">
												<input type="hidden" class="form-control" value="${userdetail.user_id }" name="user_id" required="">
											
												 First Name* :
												<div class="form-group valid-form">
													<input type="text" value="${userdetail.first_name }" class="form-control" name="first_name" id="inputfirstName" placeholder="First name" required="">
												</div>
												Last Name* :
												<div class="form-group valid-form">
													<input type="text" value="${userdetail.last_name }" class="form-control" name="last_name" id="inputlastName" placeholder="Last name" required="">
												</div>
												Email* :
												<div class="form-group has-feedback">
													<input type="email" value="${userdetail.email }" class="form-control" name="email" id="inputEmail" placeholder="Email" data-error="Invalid email address" required="">
													<span class="glyphicon form-control-feedback" aria-hidden="true"></span>
													<span class="help-block with-errors"></span>
												</div>
												Mobile No.* :
												<div class="form-group has-feedback">
													<input type="number" value="${userdetail.mobile_no?long?c }" data-toggle="validator" min="0" data-minlength="10" class="form-control" name="mobile_no" id="inputMobile" placeholder="Mobile No" data-error="Invalid mobile No" required="">
													<span class="glyphicon form-control-feedback" aria-hidden="true"></span>
													<span class="help-block with-errors"></span>
												</div>
												
											<#-- Date of Birth* :
												<div class="form-group">
													<input type="date" value="${userdetail.date_of_birth }" class="form-control" name="date_of_birth" id="inputDate" placeholder="MM/DD/YYY" required="">
												</div>
											 -->
											<#--	<#if Session.user_id?exists || Session.role_id == 1 && userdetail??>
												Password* :
												<div class="form-group">
												  <input type="password" value="${userdetail.password }" data-toggle="validator" data-minlength="6" class="form-control" name="password" id="inputPassword" placeholder="Password" required="">
												  <span class="help-block">Minimum of 6 characters</span>
												</div>Confirm Password* :
												<div class="form-group">
												  <input type="password" value="${userdetail.password }" class="form-control" id="inputPasswordConfirm" data-match="#inputPassword" data-match-error="Whoops, these don't match" placeholder="Confirm password" required="">
												  <div class="help-block with-errors"></div>
												</div>
												</#if>	-->
											<#else>
											
											<#if !userdetail??>
												<input type="hidden" class="form-control" value="insert" name="operation" required="">
											</#if>
											 First Name* :
											<div class="form-group valid-form">
												<input type="text" class="form-control" name="first_name" id="inputfirstName" placeholder="First name" required="">
											</div>
											Last Name* :
											<div class="form-group valid-form">
												<input type="text" class="form-control" name="last_name" id="inputlastName" placeholder="Last name" required="">
											</div>
											Email* :
											<div class="form-group has-feedback">
												<input type="email" class="form-control" name="email" id="inputEmail" placeholder="Email" data-error="Invalid email address" required="">
												<span class="glyphicon form-control-feedback" aria-hidden="true"></span>
												<span class="help-block with-errors"></span>
											</div>
											Mobile No.* :
											<div class="form-group has-feedback">
												<input type="number" data-toggle="validator" min="0" data-minlength="10" class="form-control" name="mobile_no" id="inputMobile" placeholder="Mobile No" data-error="Invalid mobile No" required="">
												<span class="glyphicon form-control-feedback" aria-hidden="true"></span>
												<span class="help-block with-errors"></span>
											</div>
											Date of Birth* :
											<div class="form-group">
												<input type="date" class="form-control" name="date_of_birth" id="inputDate" placeholder="MM/DD/YYY" required="">
											</div>
											Password* :
												<div class="form-group">
												  <input type="password" data-toggle="validator" data-minlength="6" class="form-control" name="password" id="inputPassword" placeholder="Password" required="">
												  <span class="help-block">Minimum of 6 characters</span>
												</div>Confirm Password* :
												<div class="form-group">
												  <input type="password" class="form-control" id="inputPasswordConfirm" data-match="#inputPassword" data-match-error="Whoops, these don't match" placeholder="Confirm password" required="">
												  <div class="help-block with-errors"></div>
												</div>
															
											</#if>
											
											Gender* :
											<div class="form-group">
												<div class="radio">
													<label><input type="radio" name="gender" id="female" value="female" required="">Female</label>
												</div>
												<div class="radio">
													<label><input type="radio" name="gender" id="male" value="male" required="">Male</label>
												</div>
											</div>
											
											<div class="form-group valid-form">
												<input type="hidden" class="form-control" name="deleteFlag" id="deleteFlag" value="no"  required="">
												<input type="hidden" class="form-control" name="deleteaddressIds" id="addressId"  required="">
											 </div>
											<!-- Address -->
										 	<div id="address" class="content" data-mfield-options='{"section": ".group","btnAdd":"#btnAdd-1","btnRemove":".btnRemove"}'>
												<div class="row">
													<div class="col-md-12"><button type="button" id="btnAdd-1" class="btn btn-primary">Add New Address</button></div>
												</div>
												<#if addresses??>
													<#list addresses as addressdetail>
													<div class="row group address">
														<div class="form-group">
															<input  value="${addressdetail.address_id }" class="form-control" type="hidden" name="address_id" required="">
														</div>
														<div class="form-group">
															<input  value="updateAddress" class="form-control" type="hidden" name="operationAddress" required="">
														</div>
														<div class="form-group col-md-6">
															Address line1* :<input  value="${addressdetail.address_line1 }" class="form-control" type="text" name="address_line1" required="">
														</div>
														<div class="form-group col-md-6">
															AddressLine2* :<input  value="${addressdetail.address_line2 }" class="form-control" type="text" name="address_line2" required="">
														</div>
														<div class="form-group col-md-3">
															City* :<input  value="${addressdetail.city }" class="form-control" type="text" name="city" required="">
														</div>
														<div class="form-group col-md-3">
															State* :<input  value="${addressdetail.state }" class="form-control" type="text" name="state" required="">
														</div>
														<div class="form-group col-md-3">
															Country* :<input  value="${addressdetail.country }" class="form-control" type="text" name="country" required="">
														</div>
														<div class="form-group col-md-3">
															Pincode* :<input  value="${addressdetail.pincode?long?c }" class="form-control" data-minlength="6" type="number" min="1" name="pincode" required="">
														</div>
														
														<div class="col-md-3">
															<button type="button" data-target="${addressdetail.address_id }" class="btn btn-danger btnRemove">Remove</button>
														</div>
													</div>
													</#list>
												<#else>
													<div class="row group address">
														<div class="form-group">
															<input  value="insertAddress" class="form-control" type="hidden" name="operationAddress" required="">
														</div>
														<div class="form-group col-md-6">
															Address line1* :<input class="form-control" type="text" name="address_line1" required="">
														</div>
														<div class="form-group col-md-6">
															AddressLine2* :<input class="form-control" type="text" name="address_line2" required="">
														</div>
														<div class="form-group col-md-3">
															City* :<input class="form-control" type="text" name="city" required="">
														</div>
														<div class="form-group col-md-3">
															State* :<input class="form-control" type="text" name="state" required="">
														</div>
														<div class="form-group col-md-3">
															Country* :<input class="form-control" type="text" name="country" required="">
														</div>
														<div class="form-group col-md-3">
															Pincode* :<input class="form-control" data-minlength="6" type="number" min="1" name="pincode" required="">
														</div>
														
														<div class="col-md-3">
															<button type="button" class="btn btn-danger btnRemove">Remove</button>
														</div>
													</div>
												</#if>
												
												
											</div>			
											<!--//Address -->
																						
											<div class="form-group">
												<div class="checkbox">
													<label>
														<input type="checkbox" id="terms" data-error="Before you wreck yourself" required="">
														I agree with all the details.
													</label>
													<div class="help-block with-errors"></div>
												</div>
											</div>
											<div class="form-group">
												<button type="submit" class="btn btn-primary disabled">Submit</button>
											</div>
										</form>
									</div>
								</div>
							</div>
						</div>
					</div>
					<!-- //validation -->
				</div>
			</div>
			<!-- footer -->
			<div class="footer">
				<p>� 2018. All Rights Reserved. Design by</p>
			</div>
			<!-- //footer -->
		</div>
	</section>
	
		<script src="js/jquery3.1.1.js"></script>
		<script src="js/modernizr.js"></script>
		<script src="js/jquery.cookie.js"></script>
		<script type="text/javascript" src="js/bootstrap-datepicker.js"></script>
		<script src="js/bootstrap.js"></script>
	
		<script type="text/javascript" src="js/valida.2.1.6.min.js"></script>
		<script type="text/javascript" >
			$(document).ready(function() {
			<#--  	 $('#inputDate').datepicker({
					 format: 'mm-dd-yyyy'
			        });-->
				$('#version').valida( 'version' );

				$('.valida').valida();
				
				$('#partial-1').on('click', function( ev ) {
					ev.preventDefault();
					$('#res-1').click(); // clear form error msgs
					$('form').valida('partial', '#field-1'); // validate only field-1
					$('form').valida('partial', '#field-1-3'); // validate only field-1-3
				});
				
				<#if userdetail??>	
					var gender=${userdetail.gender };
				<#else>
					var gender="female"
				</#if>
				if( gender == "male"){
					$("#male").prop("checked", true);
				}else{
					$("#female").prop("checked", true);
				}
				
				var deleteaddressIds = [];
				$(".btnRemove").click(function(){
					if($(this).attr("data-target") !=null && $(this).attr("data-target") !=""){
						deleteaddressIds.push($(this).attr("data-target"));
						$("#deleteFlag").val("yes");
					}
					
					$("#addressId").val(deleteaddressIds.toString());
				});
				
				var readURL = function(input) {
					if (input.files && input.files[0]) {
						var reader = new FileReader();
						reader.onload = function (e) {
							$('.avatar').attr('src', e.target.result);
						}
						reader.readAsDataURL(input.files[0]);
					}else{
						$('.avatar').attr('src','images/avatar_2x.png');
					}
				}
				$(".file-upload").on('change', function(){
					readURL(this);
				});				
			})
		</script>
		<script src="js/validator.min.js"></script>
		<script src="js/customvalidate.js"></script>
		
		<script src="js/jquery.multifield.min.js"></script>
		<script>
			$('#address').multifield({section: '.section',
					btnAdd:'.btnAdd',
					btnRemove:'.btnRemove'
			});
			
			$("#registration-form :input[type='text'], :input[type='email'], :input[type='number'], :input[type='radio'], :input[type='date']").change(function() {
				$("#registration-form").data("changed",true);
			});
			
			<#-- function validchange(){
				 if($("#registration-form").data("changed")){
					return true;
				}else{
					$("#nochanges").text("You haven't changed any Detail");
					window.location.hash = '#notchanges';
					return false;
				 } 
			} -->
		</script>

		<script src="js/proton.js"></script>
</body>
</html>
