package com.project.rest201.seller.servletcontroller;

import java.util.Base64;
import java.util.List;

import javax.ws.rs.HeaderParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.project.rest201.seller.model.SellerProduct;
import com.project.rest201.seller.servletservice.ServletService;

@RestController
@RequestMapping("/seller")
public class SellerServletController {

	@Autowired
	private ServletService servletService;
	
	
	@RequestMapping(value ="/authenticate", method = RequestMethod.POST,produces={MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}
	)
	public ResponseEntity<?> authenticate(@RequestHeader("Authorization") String authhead){
		boolean flag = false;
		System.out.println("in servlet");
		Base64.Decoder decoder = Base64.getDecoder();
				 if (authhead != null) {
		            byte[] e = decoder.decode(authhead.substring(6));
		            String usernpass = new String(e);
		            String user = usernpass.substring(0, usernpass.indexOf(":"));
		            String password = usernpass.substring(usernpass.indexOf(":") + 1);
		       	 System.out.println("Servlet : - username "+user+" password "+password);		            // check username and password
		            if(!user.equals("admin") || !password.equals("admin")){
		        		flag=false;
		            }
		            else flag=true;
		        }
	Boolean ret=flag;
		return new ResponseEntity<String>(ret.toString(), HttpStatus.OK);
		}
	
	@RequestMapping(value ="/addproduct", method = RequestMethod.POST,produces={MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}
	)
	public ResponseEntity<?> addProduct(@RequestBody SellerProduct product){
		boolean flag = false;
		try{
			flag=servletService.addProduct(product);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return new ResponseEntity<String>("added product with id "+product.getProductId(), HttpStatus.OK);
		}
		
	
	@RequestMapping(value ="/updateproduct/{id}", method = RequestMethod.PUT,
			produces={MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
		public  ResponseEntity<?> updateProduct(@RequestBody SellerProduct product, @PathVariable("id") String productId){
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
			,produces={MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
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
			,produces={MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
		public ResponseEntity<?> getProduct(@PathVariable("id") String productId){
			SellerProduct product = null;
			try{
				product=servletService.getProduct(productId);
			}
			catch(Exception e){
				e.printStackTrace();
			}
			return new ResponseEntity<SellerProduct>(product, HttpStatus.OK);
			}
			
	
	@RequestMapping(value ="/getallproducts", method = RequestMethod.GET
			,produces={MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
			public ResponseEntity<List<SellerProduct>> getAllProducts(){
				List<SellerProduct> allProducts = null;
			try{
				allProducts=servletService.getAllProducts();
			}
			catch(Exception e){
				e.printStackTrace();
			}
			return new ResponseEntity<List<SellerProduct>>(allProducts, HttpStatus.OK);
			}
	
	@RequestMapping(value ="/getallproductsforcategory/{category}", method = RequestMethod.GET
			,produces={MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
			public ResponseEntity<List<SellerProduct>> getAllProductsForCategory(@PathVariable("category") String category){
				System.out.println("In seller servlet controller PathVariable= "+category);
			List<SellerProduct> allProducts = null;
			try{
				allProducts=servletService.getAllProductsCategories(category);
			}
			catch(Exception e){
				e.printStackTrace();
			}
			return new ResponseEntity<List<SellerProduct>>(allProducts, HttpStatus.OK);
			}
	
	@RequestMapping(value ="/getallproductsforprice/{pricerange}", method = RequestMethod.GET
			,produces={MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
			public ResponseEntity<List<SellerProduct>> getAllProductsForPrice(@PathVariable("pricerange") String pricerange){
				System.out.println("In seller servlet controller PathVariable= "+pricerange);
			List<SellerProduct> allProducts = null;
			try{
				allProducts=servletService.getAllProductsPrice(pricerange);
			}
			catch(Exception e){
				e.printStackTrace();
			}
			return new ResponseEntity<List<SellerProduct>>(allProducts, HttpStatus.OK);
			}
	
}
