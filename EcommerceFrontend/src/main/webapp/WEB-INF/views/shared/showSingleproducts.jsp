<div class="container">
	<div class="row">
		<div class="col-xs-12">
			<ol class="breadcrumb">
				<li><a href="${contextRoot}/home">Home</a>
				<li class="active">Category
				<li class="active"><a href="#">${category.name} </a>
			</ol>
		</div>
	</div>
</div>

<div class="row">
	<div class="col-xs-12 col-sm-4">
		<div class="thumbnail">
			<img src="${images}/${product.code}.jpg" class="img img-responsive" />
		</div>
	</div>
	
	<div class="col-xs-12 col-sm-8">
	<h3>${product.name}</h3>
	<hr>
	
	<p>${product.description}</p>
	<hr>
	
	<h4>
	Price: <strong>&#8377; ${product.unitPrice}</strong>
	</h4>
	<hr/>
	
	<c:choose>
		<c:when test="${product.quantity <1}">
		<h6>
		Qty.Avalaible:<span style="color:red "></span>
		</h6>
		</c:when>
		
		<c:otherwise>
		<h6>Qty.Available: ${product.quantity} </h6>
		</c:otherwise>
	
	</c:choose>
	
	<c:choose>
	<c:when test="${product.quantity}">
		<a href="javascript.void(0)" class="btn btn-success disabled"><strike>Add to Cart</strike></a>	
	</c:when>
	
	<c:otherwise>
		<a href="${contextRoot}/cart/add/${product.id}/product" class="btn btn-success">Add to Cart</a>
	</c:otherwise>
	
	</c:choose>
	
	
	<a href="${contextRoot}/show/all/products" class="btn btn-primary">Back</a>
	</div>
</div>