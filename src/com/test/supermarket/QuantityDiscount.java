package com.test.supermarket;

import java.util.Map;

/**
 * Calculates a discount based on the quantity of a product purchased, by
 * providing the price for a lower quantity.
 * 
 * Example: buy 5 for the price of 3.
 * 
 * Discount is provided for full sets for the purchaseQty only, for instance...
 * 
 * Buy 5 for the price of 3 - 1 discount for 5.
 * 
 * Buy 6 for the price of 4 - 1 discount for 5 + 1 more without a discounted.
 * 
 * Buy 10 for the price of 6 - 2 discounts, 1 for each group of 5
 * 
 * @author blee
 *
 */

public class QuantityDiscount implements Discount {

	private int purchaseQuantity;
	private int priceQuantity;

	/**
	 * Quantity discount, discounts purchase price based on the number of items
	 * purchased.
	 * 
	 * @param purchaseQuantity
	 *            - Quantity purchased to get the discount
	 * @param priceQuantity
	 *            - The quantity the customer will be changed for, for each
	 *            purchaseQuantity set.
	 * 
	 */
	QuantityDiscount(int purchaseQuantity, int priceQuantity) {
		this.purchaseQuantity = purchaseQuantity;
		this.priceQuantity = priceQuantity;
	}

	/**
	 * Calculate the price with the discount for the product provided
	 * based on the quantities within the cart.
	 * 
	 * @param product
	 * @param cart
	 * 
	 */
	@Override
	public int applyDiscount(Product product, Map<String, Integer> cart) {
		int quantity = cart.get(product.getId());
		int price = 0;

		// Get discount sets and extras
		int sets = quantity / purchaseQuantity;
		int extras = quantity % purchaseQuantity;

		// add up discount set price
		price += sets * (priceQuantity * product.getPrice());

		// add on extras prices
		price += extras * product.getPrice();

		return price;
	}

}
