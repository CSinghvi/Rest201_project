package com.project.rest201.buyer.servletcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.project.rest201.buyer.model.BuyerProduct;
import com.project.rest201.buyer.servletservice.BuyerServletService;

@RestController
@RequestMapping("/buyer")
public class BuyerServletController {

	@Autowired
	private BuyerServletService servletService;
	
	@RequestMapping(value ="/buyproduct", method = RequestMethod.POST,produces={MediaType.APPLICATION_JSON_VALUE}
	)
	public ResponseEntity<?> buyProduct(@RequestBody BuyerProduct product){
		boolean flag = false;
		try{
			flag=servletService.buyProduct(product);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		Boolean response=(Boolean)flag;
		return new ResponseEntity<String>(response.toString(), HttpStatus.OK);
		}
		
	
	@RequestMapping(value ="/updateproduct/{id}", method = RequestMethod.PUT,
			produces={MediaType.APPLICATION_JSON_VALUE})
		public  ResponseEntity<?> updateProduct(@RequestBody BuyerProduct product, @PathVariable("id") String productId){
		boolean flag = false;
		try{
			flag=servletService.updateProduct(product, productId);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return new ResponseEntity<String>("update product with id "+product.getProductId(), HttpStatus.OK);
		}
		
	
	@RequestMapping(value ="/deleteproduct/{id}", method = RequestMethod.DELETE
			,produces={MediaType.APPLICATION_JSON_VALUE})
		public ResponseEntity<?> deletProduct(@PathVariable("id") String productId){
		boolean flag = false;
		Boolean  response = null;
		try{
			flag=servletService.deletProduct(productId);
			 response=flag;
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return new ResponseEntity<Boolean>(response,HttpStatus.NO_CONTENT);
		}

	
	@RequestMapping(value ="/getproduct/{id}", method = RequestMethod.GET
			,produces={MediaType.APPLICATION_JSON_VALUE})
		public ResponseEntity<?> getProduct(@PathVariable("id") String orderId){
			BuyerProduct product = null;
			try{
				product=servletService.getProduct(orderId);
			}
			catch(Exception e){
				e.printStackTrace();
			}
			return new ResponseEntity<BuyerProduct>(product, HttpStatus.OK);
			}
			
	
	@RequestMapping(value ="/getallproducts", method = RequestMethod.GET
			,produces={MediaType.APPLICATION_JSON_VALUE})
			public ResponseEntity<List<BuyerProduct>> getAllProducts(){
				List<BuyerProduct> allProducts = null;
			try{
				allProducts=servletService.getAllProducts();
			}
			catch(Exception e){
				e.printStackTrace();
			}
			return new ResponseEntity<List<BuyerProduct>>(allProducts, HttpStatus.OK);
			}
	
}
