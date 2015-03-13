package com.test.supermarket;

public class SuperMarketApp {

	/**
	 * Create our market with the provided products, prices, and discounts.
	 * Executes one checkout and outputs the result.
	 * 
	 * NOTE: For this exercise we are assuming allowed prices and discounts
	 * would be handled elsewhere in the system, therefore we are not checking
	 * for issues such as negative prices.
	 * 
	 * Please also note that the unit tests are written in two styles, one with
	 * only one assert per test, the other with a test covering an entire
	 * concept with multiple tests. Some people feel strongly that one way is
	 * correct, while others prefer the other method, therefore I included one
	 * of each as an example.
	 * 
	 * @param args
	 * @throws InvalidProductException
	 */
	public static void main(String[] args) throws InvalidProductException {
		System.out.println("Running supermarket app");

		SupermarketImpl market = new SupermarketImpl();

		Product A = new Product("A", 20);
		market.addProduct(A);

		Product B = new Product("B", 50);
		B.setDiscount(new QuantityDiscount(5, 3));
		market.addProduct(B);

		Product C = new Product("C", 30);
		market.addProduct(C);

		int total = market.checkout("ABBACBBAB");
		System.out.println("Total : " + total);
	}

}
