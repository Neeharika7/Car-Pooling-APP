<!DOCTYPE html>
<html >
  <head>
    <meta charset="UTF-8">
    <title>car details</title>
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
		  </script>     </head>

     <body>
<% 
				    String username =(String)session.getAttribute("username");
	%>
     
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
						<li class="active"><a href="licence.jsp">offer ride</a></li>
						<li ><a href="getride.jsp">take ride</a></li>
						<li><a href="profileviewController">profile view</a></li>
						<li><a href="startwelcome.jsp">logout</a>


							<div class="clear"></div>
					</ul>
				</div>
				<div class="top-nav-right">
					<form>
						<input type="text"><input type="submit" value="" />
					</form>
				</div>
				<div class="clear" style="font-style: initial;font-size: 20px;">Welcome <%=username%>!</div>
			</div>
			<!---End-top-nav---->
		</div>
		<!----End-header----->
	</div>
	<!----End-wrap----->
    <div class="container">
	<section id="content">
	
	 
		<form action="cardetails" >
			<h1>Car Details</h1>
			<div>
				<input type="text" placeholder="car number" required="" name="carnumber" />
			</div>
			<div>
				<input type="text" placeholder="car colour" required="" name="carcolor" />
			</div>
				<div>
				<input type="text" placeholder="car model" required="" name="carmodel" />
			</div>
			
			
			     
                        
			<div>
				<input type="submit" value="next" />
				
			</div>
		</form><!-- form -->
	</section><!-- content -->
</div><!-- container -->
</body>
    
        <script src="js/index.js"></script>

    
    
    
  </body>
</html>
