package com.test;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.project.rest201.seller.model.SellerProduct;

public class RestAPITest {

	public static final String REST_SERVICE_URI = "http://localhost:8080/seller";
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		addProduct("105","Moto g5 plus", "16000", "mobile", "1", "mobile phones");
		addProduct("102","keyboard", "1000", "computer acccesories", "3", "gaming keyborad");
		addProduct("103","mouse", "700", "computer acccesories", "3", "gaming mouse");
		addProduct("104","Plastic bottle", "700", "kitchen acccesories", "10", "high quality plastic water bottle");
		getproduct();
		getproducts();
	}

	   /* POST */
    private static void addProduct(String productId, String productName, String productPrice, String productCategory,
			String productStock, String productDescription) {
        System.out.println("Testing add Product API----------");
        RestTemplate restTemplate = new RestTemplate();
        SellerProduct product = new SellerProduct(productId,productName, productPrice, productCategory, productStock, productDescription);
        ResponseEntity<String> response = restTemplate.postForEntity(REST_SERVICE_URI+"/addproduct", product,String.class); 
        System.out.println("response : "+response);
    }
	
    /* GET */
    private static void getproducts() {
        System.out.println("Testing get all Products API----------");
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List> response = restTemplate.getForEntity(REST_SERVICE_URI+"/getallproducts",List.class); 
        System.out.println("response : "+response);
    }
    
    /* POST */
    private static void getproduct() {
        System.out.println("Testing get Product API----------");
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<SellerProduct> response = restTemplate.getForEntity(REST_SERVICE_URI+"/getproduct/102",SellerProduct.class); 
        System.out.println("response : "+response.getBody().toString());
    }
    
}
