<!DOCTYPE HTML>
<html lang="pt-br">
<head>
	<title>Login</title>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="/css/bootstrap.min.css" crossorigin="anonymous" /> 
	<link href="/css/app.css" rel="stylesheet">
	<link rel="stylesheet" href="/css/css_login.css" />
	<script src="/js/app.js"></script>
	<script src="/js/bootstrap.min.js"  crossorigin="anonymous"></script> 
	<script src="/js/jquery-3.2.1.min.js" crossorigin="anonymous"></script>
</head>

<body>
	<section>
		<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
		  <ul class="navbar-nav">
		    <li class="nav-item">
		      <a class="nav-link" href="../home">Home</a>
		    </li>
<!-- 
		    @if(session()->get("user") == 'andrecaculinha@yahoo.com.br') 
			    <li class="nav-item">
			      <a class="nav-link" href="../products">Products</a>
			    </li>
		    @endif
 -->		    
		    <li class="nav-item">
		      <a class="nav-link" href=../kart>Kart</a>
		    </li>		    
		    <li class="nav-item">
		      <a class="nav-link" href=../order>Order</a>
		    </li>		    
		    <li class="nav-item active">
		      <a class="nav-link" href="../login">Login</a>
		    </li>
		    <li class="nav-item">
		      <a class="nav-link" href="../logout">Logout</a>
		    </li>
		    
		  </ul>
		</nav>
	</section>

	<section class="head">
		<form method="POST" action="LoginController"> 
  		    @csrf
			<section class="form-group">
			  <label for="user">Email:</label>
			  <input type="email" class="form-control" id="user" name="email">
			</section>
			<section class="form-group">
			  <label for="pwd">Senha:</label>
			  <input type="password" class="form-control" id="pwd" name="password">
			</section>
			<section class="form-check">
			  <label class="form-check-label">
			    <input class="form-check-input" type="checkbox"> Lembre-me
			  </label>
			</section>
			@if(isset($erro)) 
				<p style="color:red">{{$erro}}</p>
		    @endif
			<a class="nav-link" href="../registrar">Registrar</a>
			<button type="submit" class="btn btn-primary">Logar</button>

		</form>
	</section>
	

</body>


</html>