package com.test.supermarket;

import java.util.HashMap;
import java.util.Map;

public class SupermarketImpl implements Supermarket {

	private Map<String, Product> products = new HashMap<String, Product>();

	/**
	 * Add products to our product catalog
	 * 
	 * @param product
	 */
	public void addProduct(Product product) {
		products.put(product.getId(), product);
	}

	/**
	 * Process a checkout of items as a string of product id chars
	 * 
	 * @param items
	 *            - String list of item id chars
	 */
	@Override
	public int checkout(String items) {
		int total = 0;

		/* Parse incoming products */
		Map<String, Integer> cart = new HashMap<String, Integer>();
		for (char c : items.toCharArray()) {
			String id = String.valueOf(c);
			if (cart.containsKey(id)) {
				cart.put(id, cart.get(id) + 1);
			} else {
				cart.put(id, 1);
			}
		}

		/* Get prices for each item type in the cart, add it to the total */
		for (String id : cart.keySet()) {
			if (!products.containsKey(id)) {
				throw new InvalidProductException(id);
			}
			total += products.get(id).getPriceForCart(cart);
		}

		return total;
	}

}
