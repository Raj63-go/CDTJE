<div class="container">

	<div class="row">

		<div class="col-md-3">
			<h1 class="my-4">Product Category</h1>

			<!--<h1 class="my-4">Shop Name</h1> -->
			<%@include file="./shared/sidebar.jsp"%>

		</div>

		<div class="col-md-9">
			<div class="row">
				<div class="col-lg-12">

					<c:if test="${userClickProduct ==true}">
						<script>
							window.categoryId = '';
						</script>

						<ol class="breadcrumb">
							<li class="breadcrumb-item"><a href="${contextRoot}/home">Home</a>
							<li class="active" class="breadcrumb-item"><a
								href="${contextRoot}/show/all/products">All Products</a>
						</ol>
					</c:if>

					<c:if test="${userClickCategoryProduct ==true}">

						<script>
							window.categoryId = '${category.id}';
						</script>


						<ol class="breadcrumb">
							<li><a href="${contextRoot}/home">Home</a>
							<li class="active">Category
							<li class="active"><a href="#">${category.name} </a>
						</ol>
					</c:if>
				</div>
			</div>


			<div class="row">

				<div class="col-xs-12">
					<table id="productListTables"
						class="table table-striped table-bordered">
						<thead>
							<tr>
								<th></th>
								<th>Name</th>
								<th>Brand</th>
								<th>Price</th>
								<th>Quantity</th>
								<th></th>
								
							</tr>
						</thead>

						<tfoot>
							<tr>
								<th></th>
								<th>Name</th>
								<th>Brand</th>
								<th>Price</th>
								<th>Quantity</th>
								<th></th>
							</tr>
						</tfoot>
					</table>

				</div>
			</div>

		</div>

	</div>