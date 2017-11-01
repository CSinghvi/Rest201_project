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
<h1>PRODUCT INFO</h1>
<br>
    <br><tr><td>PRODUCT ID : </td><td><c:out value="${product.productId}"/></td></tr><br>  
    <br><tr><td>PRODUCT NAME : </td><td><c:out value="${product.productName}"/></td></tr><br>
    <br><tr><td>PRODUCT PRICE : </td><td><c:out value="${product.productPrice}"/></td></tr><br>
    <br><tr><td>PRODUCT CATEGORY : </td><td><c:out value="${product.productCategory}"/></td></tr><br>
    <br><tr><td>PRODUCT DESCRIPTION : </td><td><c:out value="${product.productDescription}"/></td></tr><br>


</div>

<div style="position:absolute; margin-left:30%;top:0%;">
<span><h1><a href="/buyproductconfirm/${product.productId}">BUY Product</a></h1></span>
</div>

<br><br>
<label style="font-family: cursive;margin-left:20%">Return to Home<a style="color: blue;"   href="/buyerpage"  >Click here</a></label>

	<script type="text/javascript" src="webjars/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</body>

</html>