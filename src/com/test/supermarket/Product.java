package com.test.supermarket;

import java.util.Map;

/**
 * Class representing a product in our store catalog and any discount associated.
 * Only one discount is allowed per product at this time.
 * 
 * @author blee
 *
 */
public class Product {
	private String id;
	private int price;
	private Discount discount;
	
	Product(String id, int price) {
		this(id, price, null);
	}
	
	Product(String id, int price, Discount discount) {
		this.id = id;
		this.price = price;
		this.discount = discount;
	}
	
	/**
	 * Returns the total price for all the items of this type within the cart with the discount applied.
	 * Passing in the whole cart would allow us to base discounts upon other items in the cart as well,
	 * although that is not required at this time.
	 * 
	 * @param cart
	 * @return
	 */
	public int getPriceForCart(Map<String, Integer> cart) {
		if (discount != null) {
			return discount.applyDiscount(this, cart);
		} else {
			return price * cart.get(id);
		}
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public Discount getDiscount() {
		return discount;
	}

	public void setDiscount(Discount discount) {
		this.discount = discount;
	}
}
