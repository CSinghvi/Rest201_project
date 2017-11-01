package com.project.rest201.buyer.servletdao;

import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.project.rest201.buyer.model.BuyerProduct;


@Repository
public class BuyerServletDao {

	public static List<BuyerProduct> list=new LinkedList<BuyerProduct>();;
	private BuyerProduct buyerProduct;
	
	public BuyerServletDao() {
		super();
		System.out.println("Entering Buyer servlet dao");
		list.add(new BuyerProduct("101","Moto g5 plus", "16000", "mobile", "mobile phones"));
		list.add(new BuyerProduct("102","keyboard", "1000", "computer acccesories", "gaming keyborad"));
		
	}

	public boolean buyProduct(BuyerProduct product){
		boolean flag=false;
		if(!product.equals(null) && !product.getProductId().equals(null))
		{
		list.add(product);
		flag=true;
		System.out.println("buyer successfully purchased the product");
		}
		else{
		System.out.println("Product is null");
		}
		return flag;
	}
	
		public boolean updateProduct(BuyerProduct product, String productId){
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
		
		
		public BuyerProduct getProduct(String productId){
			BuyerProduct getproduct=null;
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
		
		
		public List<BuyerProduct> getAllProducts()
		{
			List<BuyerProduct> getAllProducts=new LinkedList<>();
			if (list.isEmpty()){
				System.out.println("product list is empty");
				}
			else{
				getAllProducts=list;
			}
			
			return getAllProducts;	
		}
		
}
