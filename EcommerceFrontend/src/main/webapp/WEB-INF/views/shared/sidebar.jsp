



<div class="row">
<c:forEach items="${categories}" var="category">

  <a href="${contextRoot}/show/category/${category.id}/products" class="list-group-icon">${category.name}</a> 
  
 </c:forEach>
  
</div>




		
		