/**
 * 
 */
package com.project.rest201.seller.model;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonValue;

@XmlRootElement
public class SellerProduct implements Serializable{

	
	private static final long serialVersionUID = 1L;

	
	private String productId;
	private String productName;
	private String productPrice;
	private String productCategory;
	private String productStock;
	private String productDescription;

	
	public SellerProduct() {
		super();
		// TODO Auto-generated constructor stub
	}


	/**
	 * @param productId
	 * @param productName
	 * @param productPrice
	 * @param productCategory
	 * @param productStock
	 * @param productDescription
	 */
	public SellerProduct(String productId, String productName, String productPrice, String productCategory,
			String productStock, String productDescription) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productPrice = productPrice;
		this.productCategory = productCategory;
		this.productStock = productStock;
		this.productDescription = productDescription;
	}


	public String getProductId() {
		return productId;
	}


	public void setProductId(String productId) {
		this.productId = productId;
	}


	public String getProductName() {
		return productName;
	}


	public void setProductName(String productName) {
		this.productName = productName;
	}


	public String getProductPrice() {
		return productPrice;
	}


	public void setProductPrice(String productPrice) {
		this.productPrice = productPrice;
	}


	public String getProductCategory() {
		return productCategory;
	}


	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}


	public String getProductStock() {
		return productStock;
	}


	public void setProductStock(String productStock) {
		this.productStock = productStock;
	}


	public String getProductDescription() {
		return productDescription;
	}


	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	@Override
	public String toString() {
		return "SellerProduct [productId=" + productId + ", productName=" + productName + ", productPrice="
				+ productPrice + ", productCategory=" + productCategory + ", productStock=" + productStock
				+ ", productDescription=" + productDescription + "]";
	}
	
	
	
	
}
