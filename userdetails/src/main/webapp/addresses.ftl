<!DOCTYPE html>
<#if !Session.user_id?exists>
	
</#if>
<head>
<title>Address</title>
</head>
<body class="dashboard-page">
	
	<#include "header.ftl" />
	
	<section class="wrapper scrollable">
		<div class="rightside">
			
			<#include "dashboardContent.ftl" />
			
			<div class="table-responsive">
			<#if addresses??>
			Search here :
			<input type="text" id="myInput" class="center-block" onkeyup="myFunction()" placeholder="Search for address.." title="Type in a name">
			<table id="myTable" class="table table-responsive-md table-bordered table-striped text-center" >
				<thead>
					<tr>
						<th>UserId</th>
						<th>AddressLine1</th>
						<th>AddressLine2</th>
						<th>City</th>
						<th>State</th>
						<th>Country</th>
						<th>Pincode</th>
						<th>CreatedTime</th>
						
					</tr>
				</thead>
				<tbody>
					<#list addresses as addressdetail>
					<tr>
						<td>${addressdetail.user_id }</td>
						<td>${addressdetail.address_line1 }</td>
						<td>${addressdetail.address_line2 }</td>
						<td>${addressdetail.city }</td>
						<td>${addressdetail.state }</td>
						<td>${addressdetail.country }</td>
						<td>${addressdetail.pincode?long?c  }</td>
						<td><#--${addressdetail.created_time} --></td>
						
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
	<script>
	function myFunction() {
		  var input, filter, table, tr, td, i, j;
		  input = document.getElementById("myInput");
		  filter = input.value.toUpperCase();
		  table = document.getElementById("myTable");
		  tr = table.getElementsByTagName("tr");
		  for (i = 0; i < tr.length; i++) {
		    for(j = 0; j < 9; j++ ){
				td = tr[i].getElementsByTagName("td")[j];
				if (td) {
			      if (td.innerHTML.toUpperCase().indexOf(filter) > -1) {
			        tr[i].style.display = "";
			        break;
			      } else {
			        tr[i].style.display = "none";
			      }
			   } 
			}
		  }
		}
	</script>
	<!--validator js-->
	<script src="js/customvalidate.js"></script>
	<!--//validator js-->
	
	<script src="js/proton.js"></script>
</body>
</html>
