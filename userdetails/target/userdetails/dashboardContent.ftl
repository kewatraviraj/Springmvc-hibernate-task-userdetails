<html>
<head>
<style>
</style>
</head>
<body>
	<div class="shadow-lg p-3 mb-5 bg-white rounded backgroundImage">
		<div class="text-white contentsprofile">
			<h1>Hello <#if Session.user_id??>${Session.first_name}</#if></h1><br>
				<a href="mydetails" class="btn btn-info">view your Details</a>
		</div>
	</div>
	
	<#--<div class="social grid">
		<div class="grid-info">
			<div class="col-md-4 top-comment-grid">
				<a href="display?type=User">
				<div class="comments likes">	
					<div class="comments-info likes-info">
						<h3>Users</h3>	
					</div>
					<div class="clearfix"> </div>
				</div>
				</a>
			</div>
		 	<div class="col-md-4 top-comment-grid">
				<a href="display?type=Address">
				<div class="comments">
					<div class="comments-info">
						<h3>Addresses</h3>
					</div>
					<div class="clearfix"> </div>
				</div>
				</a>
			</div>
			<div class="col-md-4 top-comment-grid">
				<a href="display?type=Files">
				<div class="comments tweets">
					<div class="comments-info tweets-info">
						<h3>Files</h3>
					</div>
					<div class="clearfix"> </div>
				</div>
				</a>
			</div>
		 	<div class="col-md-3 top-comment-grid">
				<a href="">
				<div class="comments views">
					<div class="comments-info views-info">
						<h3></h3>
					</div>
					<div class="clearfix"> </div>
				</div>
				</a>
			</div> 
			<div class="clearfix"> </div>
		</div>
	</div>	 -->
</body>
</html>