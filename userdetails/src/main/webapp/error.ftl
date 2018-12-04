<!DOCTYPE html>
<head>
<title>404 Error</title>
</head>
<body class="error-body">
	
	<#include "header.ftl" />
	
	<div class="agile-signup">	
		
		<div class="error-page">
			<img src="images/error.png" alt="">
		</div>
		<div class="text-center">
			<h3>Page Can Not Found</h3>
			<h3><#if messages??>${messages}</#if></h3>
		</div><br>
		<div class="go-back">
			<a href="index">Back To Home</a>
		</div>
		
		<div class="copyright">
			<p>� 2018. All Rights Reserved. Design by</p>
		</div>
	</div>
	<script src="js/proton.js"></script>
</body>
</html>
