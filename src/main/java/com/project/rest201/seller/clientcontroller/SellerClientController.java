package com.project.rest201.seller.clientcontroller;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Base64;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.project.rest201.seller.model.SellerProduct;

@Controller
public class SellerClientController {

	public static final String REST_SERVICE_URI = "http://localhost:8080/seller";



	@RequestMapping(value="/auth",method = RequestMethod.POST)
	public String authenticate(Map<String, Object> model, HttpServletRequest request) throws RestClientException, UnsupportedEncodingException {
		 System.out.println("Testing authentication API----------");
		 RestTemplate restTemplate = new RestTemplate();
		 String username=request.getParameter("user");
		 String password=request.getParameter("passw");
		 System.out.println("username "+username+" password "+password);
		 System.out.println("check"+createHeaders(username, password));
	        ResponseEntity<String> authResponse = restTemplate.postForEntity(REST_SERVICE_URI+"/authenticate",new HttpEntity<String>(createHeaders(username, password)),String.class); 
	       System.out.println(authResponse.toString());
	        if(authResponse.getBody().equals(Boolean.FALSE.toString())){
	        	model.put("message","Wrong Credentials Entered");
	        	return "LoginErrorMessagePage";
	        }
	        else return "redirect:/getproducts";
	}
	
	@RequestMapping(value="/getproducts")
	public String getProducts(Map<String, Object> model, HttpServletRequest request) throws RestClientException, UnsupportedEncodingException {
		 System.out.println("Testing get all Products API----------");
		 RestTemplate restTemplate = new RestTemplate();
		 String username=request.getParameter("user");
		 String password=request.getParameter("passw");
		 System.out.println("username "+username+" password "+password);

	        ResponseEntity<List> response = restTemplate.getForEntity(REST_SERVICE_URI+"/getallproducts",List.class); 
	        List<SellerProduct> list=new LinkedList<>();
	    	list=response.getBody();
		model.put("products", list);
		return "SellerWelcome";
	}
	
	@RequestMapping("/product/{id}/")
	public String getProductInfo(Map<String, Object> model,@PathVariable("id") String productId) {
		 System.out.println("Testing get Product API----------"+productId);
	        RestTemplate restTemplate = new RestTemplate();
	        ResponseEntity<SellerProduct> response = restTemplate.getForEntity(REST_SERVICE_URI+"/getproduct/"+productId,SellerProduct.class);
	        SellerProduct product=new SellerProduct();
	        product=response.getBody();
	        model.put("product", product);
	        return "SellerProductInfo";
	}
	
	@RequestMapping("/redirectforupdate/{id}")
	public String redirectForUpdateProduct(Map<String, Object> model,@PathVariable("id") String productId) {
		 System.out.println("Testing redirectforupdate Product API----------"+productId);
	        RestTemplate restTemplate = new RestTemplate();
	        ResponseEntity<SellerProduct> response = restTemplate.getForEntity(REST_SERVICE_URI+"/getproduct/"+productId,SellerProduct.class);
	        SellerProduct product=new SellerProduct();
	        product=response.getBody();
	        model.put("product", product);
	        return "UpdateProduct";
	}
	
	@RequestMapping(value="/updateproductdetails/{id}", method = RequestMethod.POST)
	public String updateProductDetails(@ModelAttribute("sellerProduct") SellerProduct product,@PathVariable("id") String productId,Map<String, Object> model) {
		 System.out.println("Testing update  Product API----------"+product.getProductName());
		 product.setProductId(productId);
		 RestTemplate restTemplate = new RestTemplate();
	       // ResponseEntity<String> response =restTemplate.put(REST_SERVICE_URI+"/updateproduct/"+productId, product); //exchange(REST_SERVICE_URI+"/updateproduct/"+productId, HttpMethod.PUT,product,String.class);
	      restTemplate.put(REST_SERVICE_URI+"/updateproduct/"+productId, product);
	      String responseMesssage="succefully updated";
	        model.put("messsage", responseMesssage);
	        return "MessagePage";
	}
	
	@RequestMapping("/delete/{id}")
	public String deleteProduct(Map<String, Object> model,@PathVariable("id") String productId) {
try{
		System.out.println("Testing get Product API----------"+productId);
	        RestTemplate restTemplate = new RestTemplate();
	      //  ResponseEntity<String> response =restTemplate.exchange(REST_SERVICE_URI+"/delete/"+productId, HttpMethod.DELETE,null,String.class);
	        restTemplate.delete(REST_SERVICE_URI+"/deleteproduct/"+productId);//  exchange(REST_SERVICE_URI+"/delete/"+productId, HttpMethod.DELETE,null,String.class);
	        String responseMesssage="deleted product successfully";
	        model.put("messsage", responseMesssage);
}catch(Exception e){
	String responseMesssage="deleted product failed";
    model.put("messsage", responseMesssage);
}
	        return "MessagePage";
	}
	
	@RequestMapping(value="/redirecttoadd")
	public String redirectToAddProduct(Map<String, Object> model) {
		 System.out.println("Testing redirectToAddProduct API----------");
		  return "AddProduct";
	}
	
	@RequestMapping(value="/addnew", method = RequestMethod.POST)
	public String addNewProduct(@ModelAttribute("sellerProduct") SellerProduct product,Map<String, Object> model) {
		 System.out.println("Testing add  Product API----------"+product.getProductName());
		 RestTemplate restTemplate = new RestTemplate();
	       // ResponseEntity<String> response =restTemplate.put(REST_SERVICE_URI+"/updateproduct/"+productId, product); //exchange(REST_SERVICE_URI+"/updateproduct/"+productId, HttpMethod.PUT,product,String.class);
	        ResponseEntity<String> response = restTemplate.postForEntity(REST_SERVICE_URI+"/addproduct", product,String.class); 
	      String responseMesssage=response.getBody();
	        model.put("messsage", responseMesssage);
	        return "MessagePage";
	}
	
	private HttpHeaders createHeaders(String username, String password) throws UnsupportedEncodingException{
		   return new HttpHeaders() {{
		         String auth = username + ":" + password;
//		         byte[] encodedAuth = Base64.encodeBase64( 
//		            auth.getBytes(Charset.forName("US-ASCII")) );
//		         
		         Base64.Encoder encoder = Base64.getEncoder();
		         String base64 = encoder.encodeToString(auth.getBytes("UTF-8"));
		         String authHeader = "Basic " + base64;
		         set( "Authorization", authHeader );
		      }};
		}
	
}