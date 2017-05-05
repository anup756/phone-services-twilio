<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Login Success Page</title>
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
    <div class="row">
        <div class="col-md-12">
            <form id="smsform" role="form" action="#" method="POST">
                <div class="form-group">
                    <h3>Send SMS</h3>
                </div>
                <div class="form-group">
                    <input class="form-control" type="text" name="phoneSMS" id="phoneSMS"
                           placeholder="(402) 222-2222"><br/><br/>
                           <textarea name="testSMS" rows="4" cols="50"></textarea>
                </div>
                <button type="submit" class="btn btn-default"><span class="glyphicon glyphicon-earphone"></span> Click to Send SMS</button>
            </form>
            <!--<hr>
             <form id="errorform" role="form" action="#" method="POST">
                <div class="form-group">
                    <h3>Send System Notification</h3>
                </div>
                <a href="/CorvisaAPI/launch" ><button type="button" class="btn btn-default"><span class="glyphicon glyphicon-earphone"></span> Send System Notification</button></a>
            </form> 
			<hr>-->
        </div>
    </div>
	<hr>
<footer>
	<p>&copy; 2015 Dumbsum.com, Inc.</p>
</footer>
</div> <!-- /container -->
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="rsrc/js/bootstrap.min.js"></script>
<script src="rsrc/js/intlTelInput.js" data-turbolinks-track="true"></script>
<script src="rsrc/js/clicktocall.js" data-turbolinks-track="true"></script>
<script src="rsrc/js/jquery.playSound.js"></script>
<script>
$('#smsform').on('submit', function(e) {
	console.log($('#smsform').serialize());
    // Prevent form submission and repeat clicks
    e.preventDefault();
    $('#smsform input[type=submit]').attr('disabled', 'disabled');

    // Submit the form via ajax
    $.ajax({
        url:'sendsms',
        method:'POST',
        data: $('#smsform').serialize()
    }).done(function(data) {
        //content = JSON.parse(data);
        alert('Message Sent!');
    }).fail(function() {
        alert('There was a problem calling you - please try again later.');
    }).always(function() {
        $('#smsform input[type=submit]').removeAttr('disabled');
    });

});
</script>
<script>
$('#conferenceCall').on('submit', function(e) {
    // Prevent form submission and repeat clicks
    e.preventDefault();
    $('#conferenceCall input[type=submit]').attr('disabled', 'disabled');

    // Submit the form via ajax
    $.ajax({
        url:'conference',
        method:'POST',
        data: $('#conferenceCall').serialize()
    }).done(function(data) {
        //content = JSON.parse(data);
        alert('Starting a Conference Call!');
    }).fail(function() {
        alert('There was a problem initiating call - please try again later.');
    }).always(function() {
        $('#conferenceCall input[type=submit]').removeAttr('disabled');
    });

});
</script>
<script>
$("#img1").on("click", function(){
	if($("#phoneNumber").val().length<=11){
		$("#phoneNumber").val($("#phoneNumber").val()+'1');
	}
	$.playSound('rsrc/img/dial/snd/DTMF1');
});
$("#img2").on("click", function(){
	if($("#phoneNumber").val().length<=11){
		$("#phoneNumber").val($("#phoneNumber").val()+'2');
	}
	$.playSound('rsrc/img/dial/snd/DTMF2');
});
$("#img3").on("click", function(){
	if($("#phoneNumber").val().length<=11){
		$("#phoneNumber").val($("#phoneNumber").val()+'3');
	}
	$.playSound('rsrc/img/dial/snd/DTMF3');
});
$("#img4").on("click", function(){
	if($("#phoneNumber").val().length<=11){
		$("#phoneNumber").val($("#phoneNumber").val()+'4');
	}
	$.playSound('rsrc/img/dial/snd/DTMF4');
});
$("#img5").on("click", function(){
	if($("#phoneNumber").val().length<=11){
	$("#phoneNumber").val($("#phoneNumber").val()+'5');
	}
	$.playSound('rsrc/img/dial/snd/DTMF5');
});
$("#img6").on("click", function(){
	if($("#phoneNumber").val().length<=11){
	$("#phoneNumber").val($("#phoneNumber").val()+'6');
	}
	$.playSound('rsrc/img/dial/snd/DTMF6');
});
$("#img7").on("click", function(){
	if($("#phoneNumber").val().length<=11){
	$("#phoneNumber").val($("#phoneNumber").val()+'7');
	}
	$.playSound('rsrc/img/dial/snd/DTMF7');
});
$("#img8").on("click", function(){
	if($("#phoneNumber").val().length<=11){
	$("#phoneNumber").val($("#phoneNumber").val()+'8');
	}
	$.playSound('rsrc/img/dial/snd/DTMF8');
});
$("#img9").on("click", function(){
	if($("#phoneNumber").val().length<=11){
	$("#phoneNumber").val($("#phoneNumber").val()+'9');
	}
	$.playSound('rsrc/img/dial/snd/DTMF9');
});
$("#img0").on("click", function(){
	if($("#phoneNumber").val().length<=11){
	$("#phoneNumber").val($("#phoneNumber").val()+'0');
	}
	$.playSound('rsrc/img/dial/snd/DTMF0');
});
$("#img10").on("click", function(){
	if($("#phoneNumber").val().length<=11){
	$("#phoneNumber").val($("#phoneNumber").val()+'*');
	}
	$.playSound('rsrc/img/dial/snd/DTMFx');
});
$("#img11").on("click", function(){
	if($("#phoneNumber").val().length<=11){
	$("#phoneNumber").val($("#phoneNumber").val()+'#');
	}
	$.playSound('rsrc/img/dial/snd/DTMFdiez');
});
</script>
</body>
</html>