package com.project.rest201.seller.servletdao;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.project.rest201.seller.model.SellerProduct;

@Transactional
@Repository
public class ServletDao {
	
	@PersistenceContext	
	private EntityManager entityManager;
	
	private SessionFactory sessionFactory;
	
	/**
	 * @return the sessionFactory
	 */
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	/**
	 * @param sessionFactory the sessionFactory to set
	 */
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public static List<SellerProduct> list;
	private SellerProduct sellerProduct;
	
	public ServletDao() {
		super();
		System.out.println("Enetring Seller servlet dao");
//		list.add(new SellerProduct("101","Moto g5 plus", "16000", "mobile", "1", "mobile phones"));
//		list.add(new SellerProduct("102","keyboard", "1000", "computer acccesories", "3", "gaming keyborad"));
//		list.add(new SellerProduct("103","mouse", "700", "computer acccesories", "3", "gaming mouse"));
//		list.add(new SellerProduct("104","Plastic bottle", "700", "kitchen acccesories", "10", "high quality plastic water bottle"));
		
	}

	public boolean addProduct(SellerProduct product){
		boolean flag=false;
		if(!product.equals(null) && !product.getProductId().equals(null))
		{
//			Session session=sessionFactory.openSession();
//			session.save(product);
//			session.flush(); 
			entityManager.persist(product);
		//list.add(product);
		flag=true;
		System.out.println("Product has been successfully added");
		}
		else{
		System.out.println("Product is null");
		}
	//	sessionFactory.close();
		return flag;
	}
	
		public boolean updateProduct(SellerProduct product, String productId){
			list=new LinkedList<SellerProduct>();
	//		Session session=sessionFactory.openSession();
			boolean flag=false;
			int j=0;
			list=(List<SellerProduct>)entityManager.createQuery("FROM SellerProduct").getResultList();
			if (list.isEmpty()){
			System.out.println("product list is empty");
			}
			else if(!product.equals(null) && !productId.equals(null))
			{
				for(int i=0;i<list.size();i++){
					
					if(list.get(i).getProductId().equals(productId))
						{
//							list.remove(i);
//							list.add(i, product);
//						session.save(product);
//						session.flush(); 
						
						SellerProduct prod=(SellerProduct) entityManager.find(SellerProduct.class, productId);
						prod.setProductName(product.getProductName());
						prod.setProductPrice(product.getProductPrice());
						prod.setProductCategory(product.getProductCategory());
						prod.setProductStock(product.getProductStock());
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
		//	sessionFactory.close();
			return flag;
		}
	

		public boolean deletProduct(String productId){
			list=new LinkedList<SellerProduct>();
			//Session session=sessionFactory.openSession();
			boolean flag=false;
			int j=0;
			list=(List<SellerProduct>)entityManager.createQuery("FROM SellerProduct").getResultList();
			if (list.isEmpty()){
			System.out.println("product list is empty");
			}
			else if(!productId.equals(null))
			{
				for(int i=0;i<list.size();i++){
					
					if(list.get(i).getProductId().equals(productId))
						{
						SellerProduct product = (SellerProduct) entityManager.find(SellerProduct.class, productId);
						entityManager.remove(product);
					//	session.delete(product);
							//list.remove(i);
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
			//sessionFactory.close();

			return flag;
		}
		
		
		public SellerProduct getProduct(String productId){
			//Session session=sessionFactory.openSession();
			SellerProduct getproduct=null;
			int j=0;
		if(!productId.equals(null))
			{
				getproduct=(SellerProduct) entityManager.find(SellerProduct.class, productId);
			if(!getproduct.equals(null)){
				j++;
			System.out.println("successfully fetched the product");
				}
			if(j!=1){
					System.out.println("No product id found in database");
				}
			}
			else{
				System.out.println("something went wrong!! Failed to fetch the product");
			}
		//sessionFactory.close();
			return getproduct;
			
		}
		
		
		public List<SellerProduct> getAllProducts()
		{
	//		Session session=sessionFactory.openSession();
			List<SellerProduct> getAllProducts=new LinkedList<>();
			getAllProducts=(List<SellerProduct>)entityManager.createQuery("FROM SellerProduct").getResultList();
			if(!getAllProducts.equals(null)){
				System.out.println("No products found in database");
			}
			else{
				System.out.println("successfully fetched data from database");
			}
		//	sessionFactory.close();
			return getAllProducts;	
		}

		public List<SellerProduct> getAllProductsCategories(String category) {
			List<SellerProduct> getAllProducts=new LinkedList<>();
			getAllProducts=(List<SellerProduct>)entityManager.createQuery("FROM SellerProduct p where p.productCategory='"+category+ "'").getResultList();
			if(!getAllProducts.equals(null)){
				System.out.println("No products found in database");
			}
			else{
				System.out.println("successfully fetched data from database");
			}
			return getAllProducts;			
			}

		public List<SellerProduct> getAllProductsPrice(String pricerange) {
			List<SellerProduct> getAllProducts=new LinkedList<>();
			String str[]=pricerange.split("-");
			String min=str[0];
			String max=str[1];
			getAllProducts=(List<SellerProduct>)entityManager.createQuery("FROM SellerProduct p where p.productPrice>="+min+ " AND p.productPrice<="+max).getResultList();
			if(!getAllProducts.equals(null)){
				System.out.println("No products found in database");
			}
			else{
				System.out.println("successfully fetched data from database");
			}
			return getAllProducts;		
		}
		
}
