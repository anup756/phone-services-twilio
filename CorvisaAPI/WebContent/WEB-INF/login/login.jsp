<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<div class="container">
	<form action="LoginServlet" method="post">
	<div class="row"><div class="col-md-2">Username: </div><div class="col-md-3"><input type="text" name="user"></div></div> 
	<div class="row"><div class="col-md-2">Password: </div><div class="col-md-3"><input type="password" name="pwd"></div></div> 
	<div class="row"><div class="col-md-5 text-center"><input type="submit" class="btn btn-success" value="Login"></div></div>
	</form>
</div>
