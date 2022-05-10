<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:include page="header.jsp"/> 

	<p style="color:red">${errorMessage}</p>

	<section class="section_product">
		<section class="table-responsive">
			<table class="table">
				<thead>
					<tr>
						<td>Código</td>
						<td>Nome do Produto</td>
						<td>Quantidade</td>
						<td>Valor do Produto</td>
					</tr>

				</thead>
				<tbody>
					<c:forEach items="${listaKart}" var="li">
						<tr>
							<td>
								${li.getProduct().getId()}
							</td>
							<td>
								${li.getProduct().getNm_produto()}
							</td>
							<td>
								${li.getQuantidade()}
							</td>
							<td>
								${li.getValor_produto()}
							</td>
						</tr>
					</c:forEach>
				</tbody>		
				<tfoot>
					<tr>
						<td>
							Total:
						</td>
						<td>
							
						</td>
						<td>
							${soma}
						</td>
					</tr>
					
				</tfoot>
			</table>
		</section>
		<form action="finalizarPedido" method="POST">
			<input type="submit" value="Finalizar Pedido" />
			
		</form>
	</section>


	
</body>


</html>