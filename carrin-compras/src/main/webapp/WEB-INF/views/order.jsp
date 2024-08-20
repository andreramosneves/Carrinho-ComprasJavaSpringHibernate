<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:include page="header.jsp"/> 
	<p style="color:red">${errorMessage}</p>

	<section class="section_product">
		<section class="table-responsive">
			<table class="table">
				<thead>
					<tr>
						<td>Número do Pedido</td>
						<td>Total</td>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${listaPedidos}" var="li">
						<tr>
							<td>
								<a href="visualizar_pedido?id=${li.getId()}">2022-${li.getId()} </a>
							</td>
							<td>
								 ${li.getTotal()}
							</td>
						</tr>
					</c:forEach>
					
				</tbody>		
			</table>
		</section>
	</section>

	

</body>


</html>