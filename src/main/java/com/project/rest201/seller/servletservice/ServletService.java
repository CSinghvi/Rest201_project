package com.project.rest201.seller.servletservice;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.rest201.seller.model.SellerProduct;
import com.project.rest201.seller.servletdao.ServletDao;

@Service
public class ServletService {
	
	@Autowired
	ServletDao servletDao;
	
	
	public boolean addProduct(SellerProduct product){
	boolean flag = false;
	 Random rand = new Random(); 
	 int pickedNumber1 =  rand.nextInt(40);
	 String newProductId=product.getProductId().concat(Integer.toString(pickedNumber1));
	 product.setProductId(newProductId);
	try{
		flag=servletDao.addProduct(product);
	}
	catch(Exception e){
		e.printStackTrace();
	}
	return flag;
	}
	
	
	public boolean updateProduct(SellerProduct product, String productId){
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

	
	public SellerProduct getProduct(String productId){
		SellerProduct product = null;
		try{
			product=servletDao.getProduct(productId);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return product;
		}
		
				
		public List<SellerProduct> getAllProducts(){
			List<SellerProduct> allProducts = null;
		try{
			allProducts=servletDao.getAllProducts();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return allProducts;
		}


		public List<SellerProduct> getAllProductsCategories(String category) {
			List<SellerProduct> allProducts = null;
			try{
				allProducts=servletDao.getAllProductsCategories(category);
			}
			catch(Exception e){
				e.printStackTrace();
			}
			return allProducts;
		}


		public List<SellerProduct> getAllProductsPrice(String pricerange) {
			List<SellerProduct> allProducts = null;
			try{
				allProducts=servletDao.getAllProductsPrice(pricerange);
			}
			catch(Exception e){
				e.printStackTrace();
			}
			return allProducts;
		}
}
