<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:include page="header.jsp"/> 
	<c:if test="${user.getEmail().equalsIgnoreCase('andrecaculinha@yahoo.com.br')}">
		<section class="section_product">
			<form method="POST" action="inseriProduto" enctype="multipart/form-data">
				<section class="form-group">
					<label>Nome do produto: 
						<input type="text" name = "nm_produto" class="form-control" value="${produto.getNm_produto()}" />	
					</label>	
				</section>
				<section class="form-group">
					<label>Valor do produto: 
					    <input type="number" name = "valor_produto" class="form-control"  placeholder="0.00" 
					    pattern="^\d+(?:\.\d{1,2})?$"  value="${produto.getValor_produto()}"
					data-politespace data-grouplength="3" data-delimiter="," data-reverse  />
					</label>
				</section>
	
	
				<section class="form-group">
					<label>Imagem do produto(Envie imagens com tamanhos parecidos): 
						<input type="file" name = "i_product" class="form-control" />
					</label>
					<section class="form-group">
						<input type="submit" value="Add Product" />
					</section>
					<p style="color:red">${errorMessage}</p>
				</section>
	
			</form>
		</section>
		<!-- permission -->
		<section  class="section_production">
			<p>
				<ul class="list-group">
					<c:forEach items="${listaProdutos}" var="li">
					  <li class="list-group-item"> 
					  	<input type="button" class="btn btn-info" value="Finalizar produto"
					  	onclick="location.href='finalizaProduto?id=${li.getId()}' ;"> &nbsp &nbsp <a href='products?id=${li.getId()}'>${li.getNm_produto()}</a> &nbsp  Preço: ${String.valueOf(li.getValor_produto()).replace(".",",")}  &nbsp 
					  </li>
					</c:forEach>
				</ul>
			</p>
		</section>
	</c:if>

	<c:if test="${!user.getEmail().equalsIgnoreCase('andrecaculinha@yahoo.com.br')}">
		<p style="color:red"> Você não tem permissão para acessar essa página </p>
	</c:if>



</body>


</html>