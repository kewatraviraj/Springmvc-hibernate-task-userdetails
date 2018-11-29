<!DOCTYPE html>
<#if !Session.user_id?exists>
	
</#if>
<head>
<title>Details</title>
</head>
<body class="dashboard-page">
	
	<#include "header.ftl" />
	
	<section class="wrapper scrollable">
	   <div class="rightside">
			
			<#include "dashboardContent.ftl" />
			  
			  <div class="table-title">
                <div class="row">
                    <div class="col-sm-8">
						<h5>All	 <b>Users</b></h5>
					</div>

					<div class="col-sm-4">
						<a href="register" class="btn btn-success"><i class="material-icons">&#xE147;</i> <span>Add User</span></a>						
					</div>
                </div>
            </div>
            <#if users?exists>
			<#-- Search here :
			<input type="text" id="myInput" class="center-block" onkeyup="myFunction()" placeholder="Search for users.." title="Type in a name">
			 -->
			<div class="table-wrapper table-responsive">
				<table id="myTable" class="table table-bordered table-striped table-responsive-md text-center" style="width:100%; overflow:scroll; ">
				<thead>
	                    <tr>
	                        <th>Name</th>
							<th>Email</th>
							<th>Created Time</th>
	                        <th>Actions</th>
	                    </tr>
	                </thead>
	                <tbody>
	                	<#list users as userdetail>
	                    <tr>
	                        <td>${userdetail.first_name } ${userdetail.last_name }</td>
							<td>${userdetail.email }</td>
							<td>${userdetail.user_created_time }</td>
	                        <td>
								<a href="userdetails?user_id=${userdetail.user_id }" class="btn btn-lg label-warning hidden-xs">Edit</a>
								<a href="userdetails?user_id=${userdetail.user_id }" class="edit visible-xs" data-toggle="modal"><i class="glyphicon glyphicon-edit" title="Edit"></i></a>
						
								<#if Session.role_id == 1>							
									<button data-for="${userdetail.user_id }" type="Submit" class="btn btn-lg label-danger delete hidden-xs">Delete</button>
									<button data-for="${userdetail.user_id }" class="delete visible-xs" data-toggle="modal"><i class="material-icons" title="Delete">&#xE872;</i></button>
								</#if>
							</td>
	                    </tr>
	                    </#list>
	                </tbody>
	            </table>
			</div>
			<#else>
				<h3>No Record Found</h3>
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
	<script>
	function myFunction() {
	  var input, filter, table, tr, td, i;
	  input = document.getElementById("myInput");
	  filter = input.value.toUpperCase();
	  table = document.getElementById("myTable");
	  tr = table.getElementsByTagName("tr");
	  for (i = 0; i < tr.length; i++) {
	    td = tr[i].getElementsByTagName("td")[0];
		td1 = tr[i].getElementsByTagName("td")[1];
	    if (td || td1) {
	      if (td.innerHTML.toUpperCase().indexOf(filter) > -1 || td1.innerHTML.toUpperCase().indexOf(filter) > -1) {
	        tr[i].style.display = "";
	      } else {
	        tr[i].style.display = "none";
	      }
	    } 
	  }
	}
	</script>
	
	<script src="js/customvalidate.js"></script>
	<script>
	$(".delete").click(function(){
		$.ajax({
		       type: 'get',
		 	   url : 'deleteUser',
		 	   data:{
		 		  user_id : $(this).attr("data-for"),  
		 	   },	   
		 	   success: function(responseText){
		 		  if(responseText!="fail"){
		 			 $('.delete[data-for="'+ responseText + '"]').parents("tr").remove();
		 		  }
		 	   }  
		    });
	});
	</script>
	<script src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.min.js"></script>
	<script>
	$(document).ready(function() {
	    $('#myTable').DataTable( {
	        "language": {
	            "lengthMenu": "Display _MENU_ records per page",
	            "zeroRecords": "Nothing found - sorry",
	            "info": "Showing page _PAGE_ of _PAGES_",
	            "infoEmpty": "No records available",
	            "infoFiltered": "(filtered from _MAX_ total records)"
	        }
    	} );
	} );
	</script>
	<script src="js/proton.js"></script>
</body>
</html>