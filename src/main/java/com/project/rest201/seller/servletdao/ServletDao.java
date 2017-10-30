package com.project.rest201.seller.servletdao;

import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.project.rest201.seller.model.SellerProduct;

@Repository
public class ServletDao {

	private List<SellerProduct> list=new LinkedList<SellerProduct>();;
	
	
	public void init(){
		System.out.println("Entring Seller servlet dao");
		
		
	}

	
	public boolean addProduct(SellerProduct product){
		boolean flag=false;
		if(!product.equals(null) && !product.getProductId().equals(null))
		{
		list.add(product);
		flag=true;
		System.out.println("Product has been successfully added");
		}
		else{
		System.out.println("Product is null");
		}
		return flag;
	}
	
		public boolean updateProduct(SellerProduct product, String productId){
			boolean flag=false;
			int j=0;
			if (list.isEmpty()){
			System.out.println("product list is empty");
			}
			else if(!product.equals(null) && !productId.equals(null))
			{
				for(int i=0;i<list.size();i++){
					
					if(list.get(i).getProductId().equals(productId))
						{
							list.remove(i);
							list.add(i, product);
							j++;
							flag=true;
							System.out.println("successfully updated the product");
							break;
						}
					}
				if(j!=1){
					System.out.println("No product id found in database");
				}
			}
			else{
				System.out.println("somethinf went wrong!! Failed to update the product");
			}
				
			return flag;
		}
	

		public boolean deletProduct(String productId){
			boolean flag=false;
			int j=0;
			if (list.isEmpty()){
			System.out.println("product list is empty");
			}
			else if(!productId.equals(null))
			{
				for(int i=0;i<list.size();i++){
					
					if(list.get(i).getProductId().equals(productId))
						{
							list.remove(i);
							j++;
							flag=true;
							System.out.println("successfully deleted the product");
							break;
						}
					}
				if(j!=1){
					System.out.println("No product id found in database");
				}
			}
			else{
				System.out.println("something went wrong!! Failed to delete the product");
			}
			return flag;
		}
		
		
		public SellerProduct getProduct(String productId){
			SellerProduct getproduct=null;
			int j=0;
			if (list.isEmpty()){
			System.out.println("product list is empty");
			}
			else if(!productId.equals(null))
			{
				for(int i=0;i<list.size();i++){
					
					if(list.get(i).getProductId().equals(productId))
						{
						getproduct=list.get(i);
						j++;
						System.out.println("successfully fetched the product");
						break;
						}
					}
				if(j!=1){
					System.out.println("No product id found in database");
				}
			}
			else{
				System.out.println("something went wrong!! Failed to delete the product");
			}
			return getproduct;
			
		}
		
		
		public List<SellerProduct> getAllProducts()
		{
			List<SellerProduct> getAllProducts=null;
			if (list.isEmpty()){
				System.out.println("product list is empty");
				}
			else{
				getAllProducts=list;
			}
			
			return getAllProducts;	
		}
		
}
