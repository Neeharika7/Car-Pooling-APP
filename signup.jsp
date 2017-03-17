<!DOCTYPE html>
<html >
  <head>
    <meta charset="UTF-8">
    <title>signUpForm</title>
        <link rel="stylesheet" href="css1/style.css">
     </head>

     <body>

     <body>
    <div class="container">
	<section id="content">
		<form action="addphoto" enctype="multipart/form-data" method = "post" >
			<h1>signUp Form</h1>
			
			<div>
				<input type="text" placeholder="Firstname" required="" name="firstname" />
			</div>
			<div>
				<input type="text" placeholder="Lastname" required="" name="lastname" />
			</div>
             <div>
				<input type="email" placeholder="Email" required="" name ="email" />
			</div>
			 <div>
				<input type="text" placeholder="contact number"  required="" name="contactnumber" />
			</div>     
			<div>
				<input type="text" placeholder="username" required="" name="username" />
			</div>
			<div>
				<input type="password"  placeholder="Password" required="" name="password" />
			</div>
			<div>
 				<input type="file" name="uProperty" /> <br>
 			</div>
			
			     
                        
			<div>
 				<input type="submit" name="goUpload" value="Upload" />			
				
			</div>
		</form><!-- form -->
		<div class="button">
                <a href ="login.jsp">Login</a>
		</div>
		
		
	</section><!-- content -->
</div><!-- container -->
</body>
    
        <script src="js/index.js"></script>

    
    
    
  </body>
</html>
