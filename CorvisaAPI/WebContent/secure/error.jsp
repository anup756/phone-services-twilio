<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Error Page</title>
<!-- Bootstrap -->
<link href="../rsrc/css/custom_bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" media="screen" href="rsrc/css/intlTelInput.css"/>
<style>
.container input{ margin: 5px;}
</style>
</head>
<body>
<nav class="navbar navbar-inverse">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="#">Dumbsum.com</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
          <!-- <form class="navbar-form navbar-right">
            <div class="form-group">
              <input type="text" placeholder="Email" class="form-control">
            </div>
            <div class="form-group">
              <input type="password" placeholder="Password" class="form-control">
            </div>
            <button type="submit" class="btn btn-success">Sign in</button>
          </form> -->
        </div><!--/.navbar-collapse -->
      </div>
</nav>
<div class="container">
<h1>Error Message Sent</h1>
<a href="/CorvisaAPI/" ><button class="btn btn-default">Go Back</button></a>
<footer>
	<p>&copy; 2015 Company, Inc.</p>
</footer>
</div> <!-- /container -->
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="../rsrc/js/bootstrap.min.js"></script>
<script src="../rsrc/js/intlTelInput.js" data-turbolinks-track="true"></script>
<script src="../rsrc/js/clicktocall.js" data-turbolinks-track="true"></script>
</body>
</html>