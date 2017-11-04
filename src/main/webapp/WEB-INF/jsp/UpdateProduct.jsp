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
<form:form commandName="sellerProduct" action="/updateproductdetails/${product.productId}" method="post">
				
				
					<label style="margin-left:30%;font-size:30px;font-family:cursive; ">Update product details</label>
					<br><br>
					<table align="center" id="formTable">
					<tr>
						<th style="font-family:cursive;">product ID</th><td> ${product.productId}</td>
					</tr>
					<tr>
					</tr>
					<tr>
					<th style="font-family:cursive;">Product Name</th>	<td><input  type="text" name="productName" width="700px"
						 value="${product.productName}"	class="loginFields" required style="font-family:cursive;text-align:center;padding:2px;"></td>
					</tr>
					
					<tr>
					</tr>
					<tr>
					<th style="font-family:cursive;">Product Price</th>	<td><input  type="text" name="productPrice" width="700px"
						 value="${product.productPrice}"	class="loginFields" required style="font-family:cursive;text-align:center;padding:2px;"></td>
					</tr>
					
					<tr>
					</tr>
					<tr>
						<th style="font-family:cursive;">Product Category</th>	<td>
					<select name="productCategory" value=${product.productCategory} class="loginFields" required style="font-family:cursive;text-align:center;padding:2px;" width="700px">
					  <option value="Mobiles">Mobiles</option>
  					  <option value="Computers">Computers</option>
					  <option value="Computer Accessories">Computer Accessories</option>
					  <option value="Mobile Accessories">Mobile Accessories</option>
					  <option value="Electronics">Electronics</option>
					  <option value="Health">Health</option>
					  <option value="Kitchen">Kitchen</option>
					  <option value="Books">Books</option>
					</select></td>
					</tr>
					
					<tr>
					</tr>
					<tr>
					<th style="font-family:cursive;">Product Stock</th>	<td><input  type="text" name="productStock" width="700px"
					 value="${product.productStock}"	class="loginFields" required style="font-family:cursive;text-align:center;padding:2px;"></td>
					</tr>
					
					<tr>
					</tr>
					<tr>
					<th style="font-family:cursive;">Product Descriptions</th>	<td><input  type="text" name="productDescription" width="700px"
						 value="${product.productDescription}"	class="loginFields" required style="font-family:cursive;text-align:center;padding:2px;"></td>
					</tr>
					
										
				</table>
				<br>
	
					<input style="margin-left:50%;"   type="submit" value="SUBMIT" align="middle">
			</form:form>

					<br><br>
			<label style="font-family: cursive;margin-left:30%">Return to Home<a style="color: blue;"   href="/getproducts"  >Click here</a></label>
				
			
</body>
</html>