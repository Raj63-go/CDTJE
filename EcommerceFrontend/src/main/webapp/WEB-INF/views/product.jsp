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
        <li class="breadcrumb-item active">Category</li>
    	<li class="breadcrumb-item active" href="#">Category Products</li>
         </ol>
         </c:if>
  		
  		</div>
  		
  	
  	</div>



</div>
</div>

</body>
</html>


