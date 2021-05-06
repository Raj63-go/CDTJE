<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<div class="container">

	<div class="row">

		<c:if test="${not empty message}">
			<div class="col-xs-12">
				<div class="alert alert-success alert-dismissable">
					<button type="button" class="close" data-dismiss="alert">&times;</button>
					${message}
				</div>


			</div>

		</c:if>

		<div class="col-md-offset-2 col-md-8">

			<div class="card">
				<div class="card-header bg-primary text-white">
					<h4>Product Management</h4>
				</div>

				<div class="card-block">

					<sf:form class="form-horizontal" modelAttribute="product"
						action="${contextRoot}/manage/products" method="POST"
						enctype="multipart/form-data">

						<div class=" form-group">
							<label class="control-label col-md-4">Name</label>
							<div class="col-md-8">
								<sf:input type="text" id="name" path="name" class="form-control"
									placeholder="Product Name" />

								<sf:errors path="name" cssClass="help-block" element="em" />

							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-md-4">Brand</label>
							<div class="col-md-8">
								<sf:input type="text" id="brand" path="brand"
									class="form-control" placeholder="Product Brand" />

								<sf:errors path="brand" cssClass="help-block" element="em" />


							</div>

						</div>

						<div class="form-group">
							<label class="control-label col-md-4">Description</label>
							<div class="col-md-8">
								<sf:input type="text" id="description" path="description"
									class="form-control" placeholder="Describe about the product" />

								<sf:errors path="description" cssClass="help-block" element="em" />
							</div>

						</div>

						<div class="form-group">
							<label class="control-label col-md-4">Price</label>
							<div class="col-md-8">
								<sf:input type="number" id="unitPrice" path="unitPrice"
									class="form-control" placeholder="Enter Price" />

								<sf:errors path="unitPrice" cssClass="help-block" element="em" />
							</div>

						</div>

						<div class="form-group">
							<label class="control-label col-md-4">Quantity</label>
							<div class="col-md-8">
								<sf:input type="number" id="quantity" path="quantity"
									class="form-control" placeholder="enter the quantity" />

								<sf:errors path="quantity" cssClass="help-block" element="em" />

							</div>

						</div>

						<div class="form-group">
							<label class="control-label col-md-4">Upload Image</label>
							<div class="col-md-8">
								<sf:input type="file" id="file" path="file" class="form-control"
									placeholder="how much quantity" />

								<sf:errors path="file" cssClass="help-block" element="em" />

							</div>

						</div>

						<div class="form-group">
							<label class="control-label col-md-4">Category</label>
							<div class="col-md-8">
								<sf:select path="categoryId" items="${categories}"
									itemLabel="name" itemValue="id" class="form-control" />

							</div>

						</div>



						<div class="text-right">
							<br />
							<sf:hidden path="id" />
							<sf:hidden path="code" />
							<sf:hidden path="supplierId" />
							<sf:hidden path="views" />
							<button type="button" data-toggle="modal"
								data-target="#myCategoryModal" class="btn btn-warning btn-sm">Add
								Category</button>

						</div>

						<div class="form-group">
							<div class="col-md-offset-4 col-md-4">
								<input type="submit" name="submit" value="Save"
									class="btn btn-primary" />
							</div>
						</div>


					</sf:form>
				</div>

			</div>
		</div>

	</div>



	<div class="modal fade" id="myCategoryModal" tabindex="-1"
		role="dialog">

		<div class="modal-dialog" role="document">

			<div class="modal-content">

				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="close">
						<span aria-hidden="true"><&times;/span> 
					</button>
					<h4 class="modal-title" id="myModalLabel">New Category</h4>
				</div>
				<div class="modal-body">
					<sf:form id="categoryForm" class="form-horizontal"
						modelAtrribute="category" action="${contextRoot}/manage/category"
						method="POST"></sf:form>
					<div class="form-group">
						<label class="control-label col-md-4">Name</label>
						<div class="col-md-8 validate">
							<sf:form type="text" path="name" class="form-control"
								placeholder="Category Name"></sf:form>
						</div>
					</div>

					<div class="form-group">
						<label class="control-label col-md-4">Description</label>
						<div class="col-md-8 validate">
							<sf:form type="text" path="name" class="form-control"
								placeholder=" Please give your Category Desription"></sf:form>
						</div>
					</div>

					<div class="form-group">
						<div class="col-md-offset-4 col-md-4">
							<input type="submit" name="submit" value="Save"
								class="btn btn-primary">
						</div>
					</div>

				</div>
			</div>
		</div>


	</div>
</div>