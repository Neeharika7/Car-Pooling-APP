
<%@page import="com.bvrit.happyride.beans.UserBeans"%>
<%@page import="com.bvrit.happyride.dao.UserDAO"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@page import="javax.servlet.http.HttpSession"%>

<html>
<head>
<meta charset="UTF-8">
<title>signUpForm</title>
<link rel="stylesheet" href="css1/style.css">
<script src="js/index.js"></script>
<link href="web/css/style.css" rel="stylesheet" type="text/css" media="all" />
<link href='http://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css'>
<link href="web/css/slider.css" rel="stylesheet" type="text/css" media="all" />
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
<script type="text/javascript" src="web/js/jquery.easing.1.3.js"></script>
<script type="text/javascript" src="web/js/camera.min.js"></script>
<script type="text/javascript">
			   jQuery(function(){
				jQuery('#camera_wrap_1').camera({
					height: '500px',
					pagination: false,
				});
			});
		  </script>
		  <style>
.button {
    background-color: #4CAF50;
    border: none;
    color: white;
    padding: 15px 32px;
    text-align: center;
    text-decoration: none;
    display: inline-block;
    font-size: 16px;
    margin: 4px 2px;
    cursor: pointer;
}
</style>
 </head>



<body>
	<div class="wrap">
		<!----start-header----->
		<div class="header" id="top">
			<!----top-header----->
			<div class="top-header">
				<div class="clear"></div>
			</div>
			<!----End-top-header----->
			<!---start-top-nav---->
			<div class="top-nav">
				<div class="top-nav-left">
					<ul>
						<li><a href="welcome.jsp"><img src="images/logo.jpg"
								width=90px; title="logo" /></a></li>
						<li><a href="licence.jsp">offer ride</a></li>
						<li><a href="getride.jsp">take ride</a></li>
						<li class = "active"><a href="ProfileViewController">profile view</a></li>
						<li><a href="startwelcome.jsp">logout</a>


							<div class="clear"></div>
					</ul>
				</div>
				
				<div class="clear"></div>
			</div>
			<!---End-top-nav---->
		</div>
		<!----End-header----->
	</div>
	<!----End-wrap----->
	<div class="container">
		<section id="content">
		
			<form>
				<h1>profile details</h1>
			</form>
			<% 
ArrayList<UserBeans> listOfDetails = (ArrayList<UserBeans>) request.getAttribute("listOfDetails");
for(UserBeans psrBean : listOfDetails) {
 
 %>
			<div style="padding-left: 15px">
				<table>
				<tr>
												
						<td><form action = "changepass.jsp">
						<input type = "submit" value = "change password">
						
						</form></td>	
					</tr>
				
				<tr>
						<th align="right">photo</th>
      					 <td><img width='150' height='200' src=displayphoto?username=<%=psrBean.getUsername()%>></td>
				  
				</tr>
					<tr>
						<th align="right">Name</th>
						<td>: <%=psrBean.getFirstname()%>&nbsp;<%=psrBean.getLastname()%></td>
					</tr>
					<tr>
					
						<th align="right">email</th>
						<td>: <%=psrBean.getEmail()%></td>
					</tr>
					<tr>
					
						<th align="right">Contact Number</th>
						<td>: <%=psrBean.getContactnumber()%></td>
				
					</tr>
						
					
					
				</table>
				</div>
				<div>
				
				<h1>offered rides</h1>
				<%
				String startingpoint = psrBean.getStartingpoint();
				
				if(startingpoint != null){
				%>
				
					
					<tr>
					
						<th align="right">car colour</th>
						<td>: <%=psrBean.getCarcolor()%></td>
					</tr>
					<tr>
					
						<th align="right">journey date</th>
						<td>: <%=psrBean.getjourneydate()%></td>
					</tr>
					
					<tr>
					
						<th align="right">starting point</th>
						<td>: <%=psrBean.getStartingpoint()%></td>
					</tr>
					<tr>
					
						<th align="right">destination point</th>
						<td>: <%=psrBean.getDestinationpoint()%></td>
					</tr>
					<tr>
												
						<td><form action = "delete">
						<input type = "submit" value = "deleteoffered ride">
						
						</form></td>	
					</tr>
								
				</div>
			<% 	
			
			}
			else {
				%>
				<h3>no rides offered</h3>
		<% 		
			}
		

}
%>
			</table>
		</section>
	</div>
</body>
</html>

