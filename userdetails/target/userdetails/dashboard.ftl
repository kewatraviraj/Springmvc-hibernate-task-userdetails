<!DOCTYPE html>
<#if !Session.user_id?exists>
	<script language="javascript">
		location.replace("http://localhost:8080/userdetails/index.ftl"); 
	</script>
</#if>
<html>
<head>
<title>Dash Board</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
</head>
<body class="dashboard-page">
	<#include "header.ftl" />
	
	<section class="wrapper scrollable">
		<div class="rightside">
			<div class="text-center"><#--<c:out value="${requestScope.message }" /> --></div>
			<#include "dashboardContent.ftl" />
			
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
