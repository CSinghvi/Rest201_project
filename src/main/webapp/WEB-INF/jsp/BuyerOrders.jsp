<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">
<head>

	<!-- Access the bootstrap Css like this,
		Spring boot will handle the resource mapping automcatically -->
	<link rel="stylesheet" type="text/css" href="webjars/bootstrap/3.3.7/css/bootstrap.min.css" />

	<!--
	<spring:url value="/css/main.css" var="springCss" />
	<link href="${springCss}" rel="stylesheet" />
	 -->
	<c:url value="/css/main.css" var="jstlCss" />
	<link href="${jstlCss}" rel="stylesheet" />

</head>


<body>


<div class="productList">
<h1>YOUR ORDERED PRODUCTS</h1>
<br><br>
<c:forEach items="${products}" var="ProductList">
    <tr>
        <td><a href="/orderedproductinfo/${ProductList.orderId}/"/> <c:out value="${ProductList.productName}"/></a></td><td> Date of purchase : <c:out value="${ProductList.purchasedDate}"/></td>  
    </tr><br>
</c:forEach>

</div>

<br><br>
<label style="font-family: cursive;margin-left:30%">Return to Main Page<a style="color: blue;"   href="/buyerpage"  >Click here</a></label>
	
<script type="text/javascript" src="webjars/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</body>

</html>