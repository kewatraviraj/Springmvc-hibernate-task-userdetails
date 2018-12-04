<!DOCTYPE html>
<#if !Session.user_id?exists>
	<script language="javascript">
		location.replace("http://localhost:8080/userdetails/index"); 
	</script>
</#if>
<html>
<head>
<title>Dash Board</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<style>
.rightside{
  position: relative;
}
.backgroundImage{
  background-image: url("images/luminfire.jpg"); 
  background-color: #cccccc; 
  height:33em;
  width:100%;
  background-position: center; 
  background-repeat: no-repeat; 
  background-size: cover;
}
.contentsprofile{
	position: absolute;
	left: 3%;
	top:15%;
}
.showUsers{
	position: absolute;
	left: 3%;
	top:38%;
}
</style>
</head>
<body class="dashboard-page">
	<#include "header.ftl" />
	
	<section class="wrapper scrollable">
		<div class="rightside">
			<#if messages??><div class="alert alert-info text-center" role="alert">${messages }</div> </#if>
			<#include "dashboardContent.ftl" />
			<#if Session.user_id?exists>
				<#if Session.role_id == 1>
					<div class="text-white showUsers">
						<a href="display?type=User" class="btn btn-info">Show All Users</a>
					</div>
				</#if>
			</#if>
			<div class="footer">
				<p>� 2018. All Rights Reserved. Design by</p>
			</div>
		</div>
	</section>
	
	<script src="js/jquery3.1.1.js"></script>
	<script src="js/modernizr.js"></script>
	<script src="js/jquery.cookie.js"></script>
	<script src="js/bootstrap.js"></script>

	<script src="js/customvalidate.js"></script>
	<script src="js/proton.js"></script>
</body>
</html>
