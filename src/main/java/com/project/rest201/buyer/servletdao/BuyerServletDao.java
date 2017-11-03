package com.project.rest201.buyer.servletdao;

import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.project.rest201.buyer.model.BuyerProduct;
import com.project.rest201.seller.model.SellerProduct;

@Transactional
@Repository
public class BuyerServletDao {

	@PersistenceContext	
	private EntityManager entityManager;
	
	public static List<BuyerProduct> list=new LinkedList<BuyerProduct>();;
	private BuyerProduct buyerProduct;
	
	public BuyerServletDao() {
		super();
		System.out.println("Entering Buyer servlet dao");
	}

	public boolean buyProduct(BuyerProduct product){
		boolean flag=false;
		if(!product.equals(null) && !product.getProductId().equals(null))
		{
			entityManager.persist(product);
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
			list=(List<BuyerProduct>)entityManager.createQuery("FROM BuyerProduct").getResultList();
			if (list.isEmpty()){
			System.out.println("product list is empty");
			}
			else if(!product.equals(null) && !productId.equals(null))
			{
				for(int i=0;i<list.size();i++){
					
					if(list.get(i).getProductId().equals(productId))
						{
						BuyerProduct prod=(BuyerProduct) entityManager.find(BuyerProduct.class, productId);
						prod.setProductName(product.getProductName());
						prod.setProductPrice(product.getProductPrice());
						prod.setProductCategory(product.getProductCategory());
						prod.setProductDescription(product.getProductDescription());
						entityManager.flush();
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
			list=(List<BuyerProduct>)entityManager.createQuery("FROM BuyerProduct").getResultList();
			if (list.isEmpty()){
			System.out.println("product list is empty");
			}
			else if(!productId.equals(null))
			{
				for(int i=0;i<list.size();i++){
					
					if(list.get(i).getProductId().equals(productId))
						{
						BuyerProduct product = (BuyerProduct) entityManager.find(BuyerProduct.class, productId);
						entityManager.remove(product);
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
		
		
		public BuyerProduct getProduct(String orderId){
			BuyerProduct getproduct=null;
			int j=0;
			list=(List<BuyerProduct>)entityManager.createQuery("FROM BuyerProduct").getResultList();
			if (list.isEmpty()){
			System.out.println("product list is empty");
			}
			else if(!orderId.equals(null))
			{
				for(int i=0;i<list.size();i++){
					
					if(list.get(i).getOrderId().equals(orderId))
						{
						getproduct=(BuyerProduct) entityManager.find(BuyerProduct.class, orderId);
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
			List<BuyerProduct> getAllProducts=null;
			getAllProducts=(List<BuyerProduct>)entityManager.createQuery("FROM BuyerProduct").getResultList();
			if(getAllProducts.equals(null)){
				System.out.println("No products found in database");
			}
			else{
				System.out.println("successfully fetched products data from database");
			}
			return getAllProducts;	
		}
		
}
