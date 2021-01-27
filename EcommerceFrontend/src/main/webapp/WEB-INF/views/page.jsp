<%@ page language="java" contentType="text/html; charset=ISO-8859-1" 
 pageEncoding="ISO-8859-1"%>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 
 <c:set var="contextRoot" value="${pageContext.request.contextPath }"/>
 
 <%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
 
 <spring:url var="css" value="/resources/css"></spring:url>
 <spring:url var="js" value="/resources/js"></spring:url>
 <spring:url var="images" value="/resources/images"></spring:url>
 
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!--css-->
    <link rel="stylesheet" href="${css}/bootstrap.min.css">
    <link rel="stylesheet" href="${css}/styles.css">
    
    <title>Ecommerce-Webpage --${title}</title>
</head>
<body>
    <!--navbar-->
    <%@include file="./shared/navbar.jsp" %>
    
   
    <!--content Home-->
    <c:if test="${userClickHome==true}">
    <%@include file="home.jsp" %>
    </c:if>
    
    <!--content About-->
    <c:if test="${userClickAbout==true}">
    <%@include file="about.jsp" %>
    </c:if>
    
    <!--content Contact-->
    <c:if test="${userClickContact==true}">
    <%@include file="contact.jsp" %>
    </c:if>
    
    <!--content Register-->
    <c:if test="${userClickRegister==true}">
    <%@include file="register.jsp" %>
    </c:if>
    
    <!-- product -->
    <c:if test="${userClickProduct==true || userCategoryProduct==true}">
    <%@include file="product.jsp" %>
    </c:if>
    
    
	
	<!--footer-->
    <%@include file="./shared/footer.jsp" %>


    <!--jquery-->
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
    <script src="${js}/bootstrap.js"></script>
</body>
</html>
 
 