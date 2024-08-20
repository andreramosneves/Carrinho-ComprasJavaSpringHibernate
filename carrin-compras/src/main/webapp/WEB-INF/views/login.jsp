
<jsp:include page="header.jsp"/> 
	<section class="head">
		<form method="POST" action="LoginController"> 
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
			
			<p style="color:red">${errorMessage}</p>
			<a class="nav-link" href="registrar">Registrar</a>
			<button type="submit" class="btn btn-primary">Logar</button>

		</form>
	</section>
	

</body>


</html>