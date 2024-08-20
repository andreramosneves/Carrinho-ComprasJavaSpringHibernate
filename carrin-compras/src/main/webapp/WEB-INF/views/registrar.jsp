<jsp:include page="header.jsp"/> 
	<section class="head">

		<form name="form" method="POST" action="RegisterController" onsubmit="return validateForm()">
			<!-- @csrf -->
			<section class="form-group">
			  <label for="user">Email:</label>
			  <input type="email" class="form-control" id="user" name="email" required>
			</section>
			<section class="form-group">
			  <label for="pwd">Senha:</label>
			  <input type="password" class="form-control" id="pwd" name="password" required>
			  <label for="pwd">Repita a Senha:</label>
			  <input type="password" class="form-control" id="pwd2" name="password2" required>
			</section>
			<section class="form-check">
			</section>
			<input type="submit" class="btn btn-primary" value="Registrar"/>

		</form>
			<p style="color:red">${errorMessage}</p>
		
			<!-- @csrf 
			@if(isset($user)) 
				<p style="color:red">Usuário criado com sucesso! <!--{{$user}} </p>
		    @endif
			-->
		<script type="text/javascript">
		    document.title = "Registrar";
		    function validateForm() {
			    if ($('#pwd').get(0).value != $('#pwd2').get(0).value) {
			        alert("Senhas devem ser iguais! ");
			        return false;
			    }
			}			


		</script>
	</section>
	

</body>


</html>