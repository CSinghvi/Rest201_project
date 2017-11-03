/**
 * 
 */
package com.project.rest201.buyer.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
@Entity
@Table(name="buyer_product")
public class BuyerProduct implements Serializable{

	
	private static final long serialVersionUID = 1L;

	
	@Id	
	@Column(name="order_id")
	@NotNull
	private String orderId;
	
	@NotNull
	@Column(name="product_id")
	private String productId;
	
	@Column(name="product_name")
	private String productName;
	
	@Column(name="product_price")
	private String productPrice;
	
	@Column(name="product_category")
	private String productCategory;
	
	@Column(name="product_description")
	private String productDescription;
	
	@Column(name="purchased_date")
	private String purchasedDate;

	
	public BuyerProduct() {
		super();
	}


	/**
	 * @param productId
	 * @param productName
	 * @param productPrice
	 * @param productCategory
	 * @param productDescription
	 */
	public BuyerProduct(String productId, String productName, String productPrice, String productCategory,
			String productDescription,String purchasedDate) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productPrice = productPrice;
		this.productCategory = productCategory;
		this.productDescription = productDescription;
		this.purchasedDate=purchasedDate;
	}

	

	public BuyerProduct(String orderId, String productId, String productName, String productPrice,
			String productCategory, String productDescription, String purchasedDate) {
		super();
		this.orderId = orderId;
		this.productId = productId;
		this.productName = productName;
		this.productPrice = productPrice;
		this.productCategory = productCategory;
		this.productDescription = productDescription;
		this.purchasedDate = purchasedDate;
	}


	
	public String getOrderId() {
		return orderId;
	}


	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}


	public String getPurchasedDate() {
		return purchasedDate;
	}


	public void setPurchasedDate(String purchasedDate) {
		this.purchasedDate = purchasedDate;
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
		return "BuyerProduct [orderId=" + orderId + ", productId=" + productId + ", productName=" + productName
				+ ", productPrice=" + productPrice + ", productCategory=" + productCategory + ", productDescription="
				+ productDescription + ", purchasedDate=" + purchasedDate + "]";
	}

	
}
