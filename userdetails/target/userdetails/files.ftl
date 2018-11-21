<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<#if !Session.user_id?exists>
	
</#if>
<html>
<head>
<title>Files</title>
</head>

<body class="dashboard-page">
	
	<#include "header.ftl" />
	
	<section class="wrapper scrollable">
		<div class="rightside">
		
			<#include "dashboardContent.ftl" />
			
			<div class="table-wrapper table-responsive">
			<#if files??>
			<table id="myTable" class="table table-bordered table-striped table-responsive-md text-center">
				<thead>
					<tr>
						<th>FileId</th>
						<th>File</th>
						<th>Created Time</th>
						
					</tr>
				</thead>
				<tbody>
					<#list files as filedetail>
					<tr>
						<td>${filedetail.file_id }</td>
						<#if filedetail.file_type == 'image'>
							<td><img src="data:image/jpeg;base64,${filedetail.filestring }" height:='100px'; width='100px'></td>
						</#if>
						<td><#--${filedetail.created_time }  --></td>
						
					</tr>
					</#list>
				</tbody>
			</table>
			<#else>
				<h3>No Record Found</h3>
			</#if>
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
		<script src="js/bootstrap.js"></script>
		
		<!--validator js-->
		<script src="js/customvalidate.js"></script>
		<!--//validator js-->
		
		<script src="js/proton.js"></script>
</body>
</html>
			