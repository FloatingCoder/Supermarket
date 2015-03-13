package com.test.supermarket;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class CheckoutTest {

	SupermarketImpl market = new SupermarketImpl();
	
	@Before
	public void setUp() {
		Product A = new Product ("A", 1);
		market.addProduct(A);
		
		Product B = new Product ("B", 2);
		market.addProduct(B);
		
		Product C = new Product ("C", 3);
		market.addProduct(C);
    }
	
	@Test
	public void noProductTest() {
		assertEquals (0, market.checkout(""));	
	}
	
	@Test
	public void oneProductTest() {
		assertEquals (1, market.checkout("A"));	
	}
	
	@Test
	public void multiProductTest() {
		assertEquals (7, market.checkout("ABAC"));	
	}
	
	@Test(expected=InvalidProductException.class)
	public void invalidProductTest() {
		assertEquals (7, market.checkout("AD"));	
	}

}
