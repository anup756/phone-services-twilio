<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Lead Alert</title>
<!-- Bootstrap -->
<link href="rsrc/css/custom_bootstrap.min.css" rel="stylesheet">
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
          <img class="img-responsive" src="rsrc/img/logo.svg" style="height: 60px;">
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
<h2>Lead Alert</h2>
<hr>
<core:if test="${not empty success}">
            <div class="alert alert-success" role="alert">
                <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                  <span aria-hidden="true">&times;</span>
                </button>
                ${success}
            </div>
        </core:if>
        <core:if test="${not empty error}">
            <div class="alert alert-danger" role="alert">
                <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                  <span aria-hidden="true">&times;</span>
                </button>
                ${error}
            </div>
        </core:if>
        <div class="row">
            <div class="col-sm-7">
                <h3>${houseTitle} - ${housePrice}</h3>
                <img src="rsrc/img/leads.jpg" class="img-responsive" alt="House" />
                <p>${houseDescription}</p>
            </div>
            <div class="col-sm-3 demo">
                <h3>Talk To An Agent</h3>
                <p>
                    A trained sales lead professional is standing by to answer any
                    questions you might have about this property. Fill out the form below
                    with your contact information, and an agent will reach out soon.
                </p>
                <form action="/CorvisaAPI/notifications" method="POST">
                    <input type="hidden" name="houseTitle" value="${houseTitle}" />
                    <div class="form-group">
                        <label for="name">Your Name</label>
                        <input type="text" id="name" name="name" class="form-control" placeholder="John Appleseed" />
                    </div>
                    <div class="form-group">
                        <label for="phone">Your Phone Number</label>
                        <input type="text" id="phone" name="phone" class="form-control" placeholder="+16512229988" />
                    </div>
                    <div class="form-group">
                        <label for="message">How can we help?</label>
                        <input type="text" id="message" name="message" class="form-control" />
                    </div>
                    <button type="submit" class="btn btn-success">Request Info</button>
                </form>
            </div>
        </div>
<hr>
	<footer>
		<p>&copy; 2017 Dumbsum.com, Inc.</p>
	</footer>
</div> <!-- /container -->
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="rsrc/js/bootstrap.min.js"></script>
<script type="text/javascript" src="https://static.twilio.com/libs/twiliojs/1.2/twilio.js"></script>
<script src="rsrc/js/intlTelInput.js" data-turbolinks-track="true"></script>
<script src="rsrc/js/clicktocall.js" data-turbolinks-track="true"></script>
</body>
</html>