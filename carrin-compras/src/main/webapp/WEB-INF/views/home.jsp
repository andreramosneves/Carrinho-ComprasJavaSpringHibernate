<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:include page="header.jsp"/> 
	<p style="color:red">${errorMessage}</p>
	<p></p>
		<section class="container">
			<section class="row">
				<c:forEach items="${listaProdutos}" var="li">
					<section class="col-sm-4">
							<form action="addItemKart" method="POST">
									<span><b>${li.getNm_produto()} </b></span>
									<span> Preço: ${String.valueOf(li.getValor_produto()).replace(".",",")} reais.</span>
									<img src="${pageContext.request.contextPath}/images/${li.getPhoto()}" class="img-thumbnail" alt="No Photo" width="250px" height="200px">
									<p>
										<label>Quantidade:</label>
									<input type="number" name="quantidade" min="1" max="10" value="1" />
									<input type="hidden" name="product_id" value='${li.getId()}' />
									<input type="hidden" name="valor_produto" value='${li.getValor_produto()}' />
									<input type="submit" class="btn btn-info" value="Add Kart" />
								    </p>
							</form>
						</section>
				</c:forEach>
			</section>
		</section>


	

</body>


</html>