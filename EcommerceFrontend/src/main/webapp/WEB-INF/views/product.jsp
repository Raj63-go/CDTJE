<!DOCTYPE html>
<html>
<body>

<div class="slidenav">
<div class="container">
  	<div class="row">
  	
  		<div class="col-md-3">
  		
  		<h1 class=my-4>Shop-Cart</h1>
  		
  		<%@include file="./shared/sidebar.jsp" %>
  		</div>
  		<div class="col-md-9">
  		  <c:if test="${userClickProduct ==true}">
  		  <ol class="breadcrumb">
        <li class="breadcrumb-item"><a href="${contextRoot}/home">Home</a></li>
    	<li class="breadcrumb-item active" href="${contexRoot}/show/all/products">All Products</li>
         </ol>
         </c:if>
         
         <c:if test="${userCategoryProduct ==true}">
  		  <ol class="breadcrumb">
        <li class="breadcrumb-item"><a href="${contextRoot}/Home">Home</a></li>
        <li class="breadcrumb-item">Category</li>
    	<li class="breadcrumb-item active"> <a href="#">${category.name}</a>
         </ol>
         </c:if>
  		
  		</div>
  		
  	
  	</div>
  	
  	<div class="row">
  	
  	<div class="col-xs-12">
  	<table id="productListTables" class="table table-striped table-bordered">
  	<thead>
  		<tr>
  			<th>Name</th>
  			<th>Brand</th>
  			<th>Price</th>
  			
  			<th></th>
  		</tr>
  	</thead>
  	
  	</table>
  	
  	</div>
  	</div>



</div>
</div>

</body>
</html>


