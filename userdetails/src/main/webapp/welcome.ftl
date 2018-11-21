<html>
<head>
  <title>Welcome!</title>
</head>
<body>
	<#-- ------------------------------------------------------------------------------------------------------------------------------ -->		
		
		<#macro greet title color>
	  	 <#nested>
	  	 <font size="+8" color="${color}">Hello Joe!${title} </font>
	   </#macro>
	
	  <h1>Welcome 
	  	<#if greeting??>
	  		${greeting}<br />
	  		<@greet title="${greeting}" color="blue">${greeting}<br /></@greet><br />
	  	<#else>
	  		No Info about Methods<br />
	  		<@greet title="No Info" color="black">No Data</@greet><br />
	  	</#if>
	  </h1>
  
  
	<#-- ------------------------------------------------------------------------------------------------------------------------------ -->		
  
		<#setting date_format="EEE dd MMM yyyy HH:mm:ss 'GMT'Z">
 		<#setting locale="en_US">
  		<#assign createdOn = '${.now} GMT+0530 (IST)' />
 	 	${createdOn?datetime?date}
	<#-- 
	 <#assign Date_prs = dateUtil.parseDate("yyyy-MM-dd","${"time"}", locale)>       
 		${dateUtil.getDate(Date_prs,"EEE dd MMM, yyyy", locale)}  ${.now?string["HH:mm:ss"]}	
 	 -->
  <br />
	<#-- ------------------------------------------------------------------------------------------------------------------------------ -->		
  
  
	<#macro do_thrice>
	  <#nested>
	  <#nested>
	  <#nested>
	</#macro>
	<@do_thrice>
	  Anything.
	</@do_thrice><br />
  
	<@greet title="Joe" color="black">
		 Anything.
	</@greet>
	<br />
	
	
	<#macro border>
	  <table border=4 cellspacing=0 cellpadding=4><tr><td>
	    <#nested>
	  </tr></td></table>
	</#macro>
	<@border>
	  <ul>
	  <@do_thrice>
	    <li><@greet title="Joe" color=""/>
	  </@do_thrice>
	  </ul>
	</@border><br />
	
	<#macro repeat count>
	  <#local y = "test">
	  <#list 1..count as x>
	    ${y} ${count}/${x}: <#nested>
	  </#list>
	</#macro>
	<@repeat count=3>${y!"?"} ${x!"?"} ${count!"?"} ${a!"?"}</@repeat>

</body>
</html>


<#-- ${rc.getContextPath()}

-->