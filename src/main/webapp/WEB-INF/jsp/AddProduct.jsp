<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>update product</title>
</head>
<body>
<form:form commandName="sellerProduct" action="/addnew" method="post">
				
				
					<label style="margin-left:30%;font-size:30px;font-family:cursive; ">Add a new product</label>
					<br><br>
					<table align="center" id="formTable">
					<tr>
						<th style="font-family:cursive;">product ID</th><td><input  type="text" name="productId" width="100px"
						  placeholder="product id"	class="loginFields" required style="font-family:cursive;text-align:center;padding:2px;"></td>
					</tr>
					<tr>
					</tr>
					<tr>
					<th style="font-family:cursive;">Product Name</th>	<td><input  type="text" name="productName" width="100px"
						 placeholder="product name"	class="loginFields" required style="font-family:cursive;text-align:center;padding:2px;"></td>
					</tr>
					
					<tr>
					</tr>
					<tr>
					<th style="font-family:cursive;">Product Price</th>	<td><input  type="text" name="productPrice" width="100px"
						 placeholder="product price"	class="loginFields" required style="font-family:cursive;text-align:center;padding:2px;"></td>
					</tr>
					
					<tr>
					</tr>
					<tr>
					<th style="font-family:cursive;">Product Category</th>	<td><input  type="text" name="productCategory" width="100px"
						 placeholder="product category"	class="loginFields" required style="font-family:cursive;text-align:center;padding:2px;"></td>
					</tr>
					
					<tr>
					</tr>
					<tr>
					<th style="font-family:cursive;">Product Stock</th>	<td><input  type="text" name="productStock" width="100px"
					 placeholder="product stock"	class="loginFields" required style="font-family:cursive;text-align:center;padding:2px;"></td>
					</tr>
					
					<tr>
					</tr>
					<tr>
					<th style="font-family:cursive;">Product Descriptions</th>	<td><input  type="text" name="productDescription" width="100px"
						 placeholder="product description"	class="loginFields" required style="font-family:cursive;text-align:center;padding:2px;"></td>
					</tr>
					
										
				</table>
				<br>
	
					<input style="margin-left:50%;"   type="submit" value="SUBMIT" align="middle">
			</form:form>

					<br><br>
			<label style="font-family: cursive;margin-left:30%">Return to Home<a style="color: blue;"   href="/getproducts"  >Click here</a></label>
				
			
</body>
</html>