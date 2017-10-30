package com.project.rest201.seller.servletservice;

import java.util.List;

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
}
