<html>
<head>
<#import "/spring.ftl" as spring />
<link rel="stylesheet" href="<@spring.url '/css/bootstrap.css' />">
<link href="<@spring.url '/css/style.css' />" rel='stylesheet' type='text/css' />
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
<link href="<@spring.url '/css/font-awesome.css' />" rel="stylesheet"> 
<link href="<@spring.url '/css/customstyle.css' />" rel="stylesheet">
<link href="<@spring.url '/css/detailstyle.css' />" rel='stylesheet' type='text/css' />
</head>
<body>

<nav class="navbar navbar-inverse navbar-fixed-top">
	  <div class="container">
		<div class="navbar-header">
		  <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
			<span class="icon-bar"></span>
			<span class="icon-bar"></span>
			<span class="icon-bar"></span>                        
		  </button>
		  <a class="navbar-brand" href="index.ftl">Logo</a>
		</div>
		
		<div class="collapse navbar-collapse" id="myNavbar">
		  <ul class="nav navbar-nav navbar-right">
		  	<#if Session.user_id?exists>
		  		<li style="padding-top:2%"><h3>Welcome ${Session.first_name}</h3></li>
				<li style="padding-top:2%"><a href="logout" class="btn btn-primary">Logout</a></li>
		  	<#else>
		  		<li style="padding-top:2%"><a href="requestregister" class="btn btn-primary">Sign Up</a></li>
				<li style="padding-top:2%"><a href="index.ftl" class="btn btn-primary">Login</a><li>
		  	</#if>
		    </ul> 
		</div>
	  </div>
	</nav>
	
</body>
</html>