package com.project.rest201.buyer.servletservice;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.project.rest201.buyer.model.BuyerProduct;
import com.project.rest201.buyer.servletdao.BuyerServletDao;
import com.project.rest201.seller.model.SellerProduct;

@Service
public class BuyerServletService {
	
	@Autowired
	private BuyerServletDao servletDao;
	private SellerProduct sellerProduct;
	
	public static final String REST_SERVICE_URI = "http://localhost:8080/seller";
	
	public boolean buyProduct(BuyerProduct product){
		 Random rand = new Random(); 
		 int pickedNumber1 =  rand.nextInt(40);
		 Random rand2 = new Random();
		 int pickedNumber2=rand2.nextInt(40);
		 String orderId=Integer.toString(pickedNumber1).concat(Integer.toString(pickedNumber2));
		 product.setOrderId(orderId);
		 sellerProduct=new SellerProduct();
	boolean flag = false;
	try{
		RestTemplate restTemplate = new RestTemplate();
		  ResponseEntity<SellerProduct> response = restTemplate.getForEntity(REST_SERVICE_URI+"/getproduct/"+product.getProductId(),SellerProduct.class);
		  sellerProduct=response.getBody();
		  int stock=Integer.parseInt(sellerProduct.getProductStock());
		 if(stock<=0){
			flag=false;
			return flag;
		}
		flag=servletDao.buyProduct(product);
		if(flag==true){
		int num=Integer.parseInt(sellerProduct.getProductStock())-1;
			  sellerProduct.setProductStock(Integer.toString(num));
			  restTemplate.put(REST_SERVICE_URI+"/updateproduct/"+sellerProduct.getProductId(), sellerProduct);
		}
	}
	catch(Exception e){
		e.printStackTrace();
	}
	return flag;
	}
	
	
	public boolean updateProduct(BuyerProduct product, String productId){
	boolean flag = false;
	try{
		flag=servletDao.updateProduct(product, productId);
	}
	catch(Exception e){
		e.printStackTrace();
	}
	return flag;
	}
	
	
	public boolean deletProduct(String productId){
	boolean flag = false;
	try{
		flag=servletDao.deletProduct(productId);
	}
	catch(Exception e){
		e.printStackTrace();
	}
	return flag;
	}

	
	public BuyerProduct getProduct(String orderId){
		BuyerProduct product = null;
		try{
			product=servletDao.getProduct(orderId);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return product;
		}
		
				
		public List<BuyerProduct> getAllProducts(){
			List<BuyerProduct> allProducts = null;
		try{
			allProducts=servletDao.getAllProducts();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return allProducts;
		}
}
