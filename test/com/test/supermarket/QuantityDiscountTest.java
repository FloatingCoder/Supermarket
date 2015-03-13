package com.test.supermarket;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class QuantityDiscountTest {

	@Test
	public void calculateDiscountTest() {
		
		Product product = new Product("A", 1);
		product.setDiscount(new QuantityDiscount(5, 3));
		
		int result;
		Map<String, Integer> cart = new HashMap<String, Integer>();
		
		//Quantity 0
		cart.put(product.getId(), 0);
		result = product.getDiscount().applyDiscount(product, cart);
		assertEquals (0, result);
		
		//Less then one discount set
		cart.clear();
		cart.put(product.getId(), 2);
		result = product.getDiscount().applyDiscount(product, cart);
		assertEquals (2, result);
		
		//One discount set
		cart.clear();
		cart.put(product.getId(), 5);
		result = product.getDiscount().applyDiscount(product, cart);
		assertEquals (3, result);
		
		//between one and two discount sets
		cart.clear();
		cart.put(product.getId(), 7);
		result = product.getDiscount().applyDiscount(product, cart);
		assertEquals (5, result);
		
		//Two discount sets
		cart.clear();
		cart.put(product.getId(), 10);
		result = product.getDiscount().applyDiscount(product, cart);
		assertEquals (6, result);
		
	}

}
