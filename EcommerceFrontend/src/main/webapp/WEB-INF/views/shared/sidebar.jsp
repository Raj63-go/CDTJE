

<div class="sidebar-container" >
		<div class="my-4 sidebar-logo">
          Product Category
          </div>
        <c:forEach items="${categories}" var="category">
        
          
        
          <%-- <a href="${contextRoot}/show/category/${category.id}/products" class="list-group-item">${category.name}</a> --%>
          <ul class="sidebar-navigation">
          <li>
          <a href="${contextRoot}/show/category/${category.id}/products">${category.name} </a> 
          </li>
          </ul>
          </c:forEach>
        </div>      


		
		



		
		