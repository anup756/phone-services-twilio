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
    <!-- <h1>Corvisa API</h1>
    <h3>Hi ${FirstName} ${LastName}, Login successful.</h3>
    <!-- <p><a class="btn btn-success btn-md" href="index.jsp" role="button">Login Page &raquo;</a></p> -->
    <!-- <form>
		<div class="row"><div class="col-md-2">Server Address:</div><div class="col-md-3"><input type="text" name="server"></div></div>
		<div class="row"><div class="col-md-2">Username:</div><div class="col-md-3"><input type="text" name="user"></div></div>
		<div class="row"><div class="col-md-2">Password: </div><div class="col-md-3"><input type="text" name="pass"></div></div>
		<div class="row"><div class="col-md-2">Call To: </div><div class="col-md-3"><input type="text" name="callto"></div></div>
		<button type="button" class="btn btn-success"><span class="glyphicon glyphicon-earphone"></span> Click to Call</button>
	</form>    
      <hr> -->
      <div class="row">
	      <!--  <input class="form-control" type="text" name="dialNumber" id="dialNow" placeholder="(402) 222-2222" width="100px;">
	      <img src="rsrc/img/dial/btn_chat.jpg" id="imgChat"/>
	      <img src="rsrc/img/dial/btn_conference.jpg" id="imgConf"/>-->
	      <!-- <img src="rsrc/img/dial/microphone.jpg" id="imgChat"/>
	      <img src="rsrc/img/dial/speaker.jpg" id="imgChat"/> -->
      <a href="secure/webphone.jsp"><button class="btn btn-danger">WebPhone</button></a>
      <a href="SMS"><button class="btn btn-primary">Send SMS</button></a>
      <a href="alertme"><button class="btn btn-success">Lead Alert</button></a>
      <a href="secure/authenticate"><button class="btn btn-danger">User Verify</button></a>
      </div>
      <div class="row">
        <div class="col-md-12">
            <form id="contactform" role="form" action="#" method="POST">
                <div class="form-group">
                    <h1>Twilio API</h1>
                    <h3>Click to Call</h3>
                </div>
                <div class="checkbox">
    				<label><input type="checkbox" name="record" value="checked" checked="checked"> Record Call</label>
                </div>
                <div class="form-group">
                    <input class="form-control" type="text" name="phone" id="phoneNumber"
                           placeholder="(402) 222-2222">
                </div>
          <img src="rsrc/img/dial/btn_1.jpg" style="cursor:pointer;" id="img1"/>
	      <img src="rsrc/img/dial/btn_2.jpg" style="cursor:pointer;" id="img2"/>
	      <img src="rsrc/img/dial/btn_3.jpg" style="cursor:pointer;" id="img3"/>
	      <br/>
	      <img src="rsrc/img/dial/btn_4.jpg" style="cursor:pointer;" id="img4"/>
	      <img src="rsrc/img/dial/btn_5.jpg" style="cursor:pointer;" id="img5"/>
	      <img src="rsrc/img/dial/btn_6.jpg" style="cursor:pointer;" id="img6"/>
	      <br/>
	      <img src="rsrc/img/dial/btn_7.jpg" style="cursor:pointer;" id="img7"/>
	      <img src="rsrc/img/dial/btn_8.jpg" style="cursor:pointer;" id="img8"/>
	      <img src="rsrc/img/dial/btn_9.jpg" style="cursor:pointer;" id="img9"/>
	      <br/>
	      <img src="rsrc/img/dial/btn_10.jpg" style="cursor:pointer;" id="img10"/>
	      <img src="rsrc/img/dial/btn_0.jpg" style="cursor:pointer;" id="img0"/>
	      <img src="rsrc/img/dial/btn_11.jpg" style="cursor:pointer;" id="img11"/><br/>
		  <!-- <br/>
		  <img src="rsrc/img/dial/btn_redial.jpg" id="imgRedial"/>
		  <img src="rsrc/img/dial/btn_hold.jpg" id="imgRedial"/>
		  <img src="rsrc/img/dial/btn_transfer.jpg" id="imgVoicemail"/>
	      <img src="rsrc/img/dial/btn_voicemail.jpg" id="imgVoicemail"/>
	      <br/> -->
	      <!-- <img src="rsrc/img/dial/btn_call.jpg" id="imgcall"/>
	      <img src="rsrc/img/dial/btn_hangup.jpg" id="imghangup"/>
	       --><br/>
                 
                <button type="submit" class="btn btn-default"><span class="glyphicon glyphicon-earphone"></span> Click to Call</button>
            </form>
        </div>
    </div>
    <hr>
<footer>
	<p>&copy; 2017 Dumbsum.com</p>
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