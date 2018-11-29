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
					<#-- 	<th>Created Time</th> -->
						
					</tr>
				</thead>
				<tbody>
					<#if files?? && filestring??>
					<#assign maxSize = (files?size < filestring?size)?then(files?size, filestring?size)>
				
					<#list 0 ..< maxSize as index>
					<tr>
						<td>${(files[index].file_id)!}</td>
						<#if files[index].file_type == 'image'>
							<td><img src="data:image/jpeg;base64,${(filestring[index])!}" height:='100px'; width='100px'></td>
						</#if>
						<td><#--${filedetail.created_time }  --></td>	
					</tr>
					</#list>
					</#if>
				</tbody>
			</table>
			<#else>
				<h3>No Record Found</h3>
			</#if>
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
		
		<script src="js/customvalidate.js"></script>

		<script src="js/proton.js"></script>
</body>
</html>
			