<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="contextRoot" value="${pageContext.request.contextPath}" />

<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<spring:url var="css" value="/resources/css"></spring:url>
<spring:url var="js" value="/resources/js"></spring:url>
<spring:url var="images" value="/resources/images"></spring:url>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Ecommerce-Webpage --${title}</title>

<script>
	window.menu="${title}"
	window.contextRoot = "${contextRoot}"
</script>

<!--css links-->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

<!--css  -->
<link rel="stylesheet" href="${css}/bootstrap.min.css">
<link rel="stylesheet" href="${css}/styles.css">
<link rel="stylesheet" href="${css}/myApp.css">
<%-- <link rel="stylesheet" href="${css}/style2.css"> --%>
<link rel="stylesheet" href="${css}/style3.css">
<link rel="stylesheet" href="${css}/styleside.css">
<link rel="stylesheet" href="${css}/styleab.css">
 <link rel="stylesheet" href="${css}/stylenav.css">
 <%-- <link rel="stylesheet" href="${css}/styleproduct.css"> --%>
  <link rel="stylesheet" href="${css}/styletable.css">
 

<link rel="stylesheet" href="${css}/jquery.dataTables.css">


</head>
<body>
	<!--navbar-->
	<%@include file="./shared/navbar.jsp"%>


	<!--content Home-->
	<c:if test="${userClickHome==true}">
		<%@include file="home.jsp"%>
	</c:if>

	<!--content About-->
	<c:if test="${userClickAbout==true}">
		<%@include file="about.jsp"%>
	</c:if>

	<!--content Contact-->
	<c:if test="${userClickContact==true}">
		<%@include file="contact.jsp"%>
	</c:if>

	<!--content Register-->
	<c:if test="${userClickRegister==true}">
		<%@include file="register.jsp"%>
	</c:if>

	<!-- product -->
	<c:if test="${userClickProduct==true || userCategoryProduct==true}">
		<%@include file="product.jsp"%>
	</c:if>
	
	<c:if test="${userClickSingleProducts==true}">
		<%@include file="./shared/showSingleproducts.jsp"%>
	</c:if>
	
	
	<c:if test="${userClickManageProducts==true}">
		<%@include file="manageproducts.jsp"%>
	</c:if>


	<!--footer-->
	<%@include file="./shared/footer.jsp"%>


	<!--jquery-->
	<script src="${js}/bootstrap.js"></script>
	<!-- <script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script> -->
	<!-- <script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script> -->
	<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
  <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
	
	<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>

	<script src="${js}/jquery.dataTables.js"></script>
	<script src="${js}/myApp.js"></script>
	 <%-- <script src="${js}/style2.js"></script>  --%>
</body>
</html>

