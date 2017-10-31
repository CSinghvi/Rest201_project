package com.project.rest201;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import com.project.rest201.seller.model.SellerProduct;

@Controller
public class WelcomeController {

	// inject via application.properties
	@Value("${welcome.message:test}")
	private String message = "Welcome to online Shopping Web Application";

	public static final String REST_SERVICE_URI = "http://localhost:8080/seller";

	
	@RequestMapping("/")
	public String welcome(Map<String, Object> model) {
		model.put("message", this.message);
		return "welcome";
	}

	@RequestMapping("/getproducts")
	public String getOroducts(Map<String, Object> model) {
		 System.out.println("Testing get all Products API----------");
	        RestTemplate restTemplate = new RestTemplate();
	        ResponseEntity<List> response = restTemplate.getForEntity(REST_SERVICE_URI+"/getallproducts",List.class); 
	        List<SellerProduct> list=new LinkedList<>();
	    	list=response.getBody();
		model.put("products", list);
		return "SellerWelcome";
	}
	
	@RequestMapping("/product/{id}/")
	public String getOroductInfo(Map<String, Object> model,@PathVariable("id") String productId) {
		 System.out.println("Testing get Product API----------"+productId);
	        RestTemplate restTemplate = new RestTemplate();
	        ResponseEntity<SellerProduct> response = restTemplate.getForEntity(REST_SERVICE_URI+"/getproduct/"+productId,SellerProduct.class);
	        SellerProduct product=new SellerProduct();
	        product=response.getBody();
	        model.put("product", product);
	        return "SellerProductInfo";
	}
}