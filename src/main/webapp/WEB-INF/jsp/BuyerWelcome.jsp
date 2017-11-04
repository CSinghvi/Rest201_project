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

<div>
<h1><a href="/buyerOrder">YOUR ORDERS</a></h1>
</div>
<br>

			

<div class="productList">
<h1>CHOOSE PRODUCTS FROM VARIOUS CATEGORIES</h1>
<br>
<c:forEach items="${products}" var="ProductList">
    <tr>
        <td></td><td><a href="/getsellerproduct/${ProductList.productId}/"/> <c:out value="${ProductList.productName}"/></a></td>  
    </tr><br>
</c:forEach>

</div>
<br>
<table>
	<th style="font-family:cursive;">Search Product by Category</th>	<td>
					<<select name="productCategory" class="loginFields" onchange="location = this.value;" required style="font-family:cursive;text-align:center;padding:2px;">
					 <option>Select a category</option>
					  <option value="/getproductsfromcategory/Mobiles">Mobiles</option>
  					  <option value="/getproductsfromcategory/Computers">Computers</option>
					  <option value="/getproductsfromcategory/Computer Accessories">Computer Accessories</option>
					  <option value="/getproductsfromcategory/Mobile Accessories">Mobile Accessories</option>
					  <option value="/getproductsfromcategory/Electronics">Electronics</option>
					  <option value="/getproductsfromcategory/Health">Health</option>
					  <option value="/getproductsfromcategory/Kitchen">Kitchen</option>
					  <option value="/getproductsfromcategory/Books">Books</option>
					</select></td>
					</tr>
</table>
<br><br>
<table>
	<th style="font-family:cursive;">Search Product by Price</th>	<td>
					<<select name="productCategory" class="loginFields" onchange="location = this.value;" required style="font-family:cursive;text-align:center;padding:2px;">
					 <option>Select a category</option>
					  <option value="/getproductsfromprice/0-500">Under 500</option>
  					  <option value="/getproductsfromprice/501-1000">Rs500 - Rs1000</option>
					  <option value="/getproductsfromprice/1000-20000">Rs1000 - Rs20000</option>
					  <option value="/getproductsfromprice/20000-99999999">Over Rs20000</option>
					  </select></td>
					</tr>
</table>
<br><br>
<label style="font-family: cursive;margin-left:30%">Return to Main Page<a style="color: blue;"   href="/"  >Click here</a></label>
	
<script type="text/javascript" src="webjars/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</body>

</html>