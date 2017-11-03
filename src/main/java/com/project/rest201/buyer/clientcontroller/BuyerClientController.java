package com.project.rest201.buyer.clientcontroller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

import com.project.rest201.buyer.model.BuyerProduct;
import com.project.rest201.seller.model.SellerProduct;

@Controller
public class BuyerClientController {


	public static final String REST_SERVICE_URI = "http://localhost:8080/seller";
	public static final String REST_SERVICE_URI_Buyer = "http://localhost:8080/buyer";
	

	@RequestMapping("/buyerpage")
	public String getProducts(Map<String, Object> model) {
		 System.out.println("Testing get all Products API----------");
	        RestTemplate restTemplate = new RestTemplate();
	        ResponseEntity<List> response = restTemplate.getForEntity(REST_SERVICE_URI+"/getallproducts",List.class); 
	        List<SellerProduct> list=new LinkedList<>();
	    	list=response.getBody();
		model.put("products", list);
		return "BuyerWelcome";
	}
	
	@RequestMapping("/getsellerproduct/{id}/")
	public String getProductInfo(Map<String, Object> model,@PathVariable("id") String productId) {
		 System.out.println("Testing get Product API----------"+productId);
	        RestTemplate restTemplate = new RestTemplate();
	        ResponseEntity<SellerProduct> response = restTemplate.getForEntity(REST_SERVICE_URI+"/getproduct/"+productId,SellerProduct.class);
	        SellerProduct product=new SellerProduct();
	        product=response.getBody();
	        model.put("product", product);
	        return "SellerProductInfoForBuyer";
	}
	
	@RequestMapping("/buyproductconfirm/{id}")
	public String redirectForUpdateProduct(Map<String, Object> model,@PathVariable("id") String productId) {
		 System.out.println("Testing redirectforupdate Product API----------"+productId);
	        RestTemplate restTemplate = new RestTemplate();
	        ResponseEntity<SellerProduct> response = restTemplate.getForEntity(REST_SERVICE_URI+"/getproduct/"+productId,SellerProduct.class);
	        SellerProduct product=new SellerProduct();
	        product=response.getBody();
	        Date currentDate=new Date();
	        String purchasedDate =  DateFormat.getInstance().format(currentDate);  
	        BuyerProduct buyerProduct=new BuyerProduct(product.getProductId(),product.getProductName(),
	        		product.getProductPrice(),product.getProductCategory(),product.getProductDescription(),purchasedDate);
	         ResponseEntity<String> buyResponse = restTemplate.postForEntity(REST_SERVICE_URI_Buyer+"/buyproduct", buyerProduct,String.class); 
              String responseMesssage=buyResponse.getBody();
	         if(responseMesssage.equals(Boolean.FALSE.toString())){
			        model.put("messsage", "Product is out of stock");
	         }
	         else{
	        	 model.put("messsage", "Your order "+product.getProductName()+" is successfully placed");
	         }
	         return "MessagePageForBuyer";
	}
	
	@RequestMapping("/buyerOrder")
	public String getBuyerOrders(Map<String, Object> model) {
		 System.out.println("Testing get all  buyer order Products API----------");
	        RestTemplate restTemplate = new RestTemplate();
	        ResponseEntity<List> response = restTemplate.getForEntity(REST_SERVICE_URI_Buyer+"/getallproducts",List.class); 
	        List<BuyerProduct> list=new LinkedList<>();
	    	list=response.getBody();
		model.put("products", list);
		return "BuyerOrders";
	}
	
	@RequestMapping("/orderedproductinfo/{id}/")
	public String getOrderedProductInfo(Map<String, Object> model,@PathVariable("id") String orderId) {
		 System.out.println("Testing get Product API----------"+orderId);
	        RestTemplate restTemplate = new RestTemplate();
	        ResponseEntity<BuyerProduct> response = restTemplate.getForEntity(REST_SERVICE_URI_Buyer+"/getproduct/"+orderId,BuyerProduct.class);
	        BuyerProduct product=new BuyerProduct();
	        product=response.getBody();
	        model.put("product", product);
	        return "BuyerOrderedProductInfo";
	}
	
//	@RequestMapping(value="/updateproductdetails/{id}", method = RequestMethod.POST)
//	public String updateProductDetails(@ModelAttribute("sellerProduct") SellerProduct product,@PathVariable("id") String productId,Map<String, Object> model) {
//		 System.out.println("Testing update  Product API----------"+product.getProductName());
//		 product.setProductId(productId);
//		 RestTemplate restTemplate = new RestTemplate();
//	       // ResponseEntity<String> response =restTemplate.put(REST_SERVICE_URI+"/updateproduct/"+productId, product); //exchange(REST_SERVICE_URI+"/updateproduct/"+productId, HttpMethod.PUT,product,String.class);
//	      restTemplate.put(REST_SERVICE_URI+"/updateproduct/"+productId, product);
//	      String responseMesssage="succefully updated";
//	        model.put("messsage", responseMesssage);
//	        return "MessagePage";
//	}
//	
//	@RequestMapping("/delete/{id}")
//	public String deleteProduct(Map<String, Object> model,@PathVariable("id") String productId) {
//try{
//		System.out.println("Testing get Product API----------"+productId);
//	        RestTemplate restTemplate = new RestTemplate();
//	      //  ResponseEntity<String> response =restTemplate.exchange(REST_SERVICE_URI+"/delete/"+productId, HttpMethod.DELETE,null,String.class);
//	        restTemplate.delete(REST_SERVICE_URI+"/deleteproduct/"+productId);//  exchange(REST_SERVICE_URI+"/delete/"+productId, HttpMethod.DELETE,null,String.class);
//	        String responseMesssage="deleted product successfully";
//	        model.put("messsage", responseMesssage);
//}catch(Exception e){
//	String responseMesssage="deleted product failed";
//    model.put("messsage", responseMesssage);
//}
//	        return "MessagePage";
//	}
//	
//	@RequestMapping(value="/redirecttoadd")
//	public String redirectToAddProduct(Map<String, Object> model) {
//		 System.out.println("Testing redirectToAddProduct API----------");
//		  return "AddProduct";
//	}
//	
//	@RequestMapping(value="/addnew", method = RequestMethod.POST)
//	public String addNewProduct(@ModelAttribute("sellerProduct") SellerProduct product,Map<String, Object> model) {
//		 System.out.println("Testing add  Product API----------"+product.getProductName());
//		 RestTemplate restTemplate = new RestTemplate();
//	       // ResponseEntity<String> response =restTemplate.put(REST_SERVICE_URI+"/updateproduct/"+productId, product); //exchange(REST_SERVICE_URI+"/updateproduct/"+productId, HttpMethod.PUT,product,String.class);
//	        ResponseEntity<String> response = restTemplate.postForEntity(REST_SERVICE_URI+"/addproduct", product,String.class); 
//	      String responseMesssage=response.getBody();
//	        model.put("messsage", responseMesssage);
//	        return "MessagePage";
//	}
	
}