package com.test.supermarket;

import java.util.Map;

public interface Discount {
	public int applyDiscount(Product product, Map<String, Integer> cart);
}
