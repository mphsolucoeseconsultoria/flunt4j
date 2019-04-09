package br.com.mph.flunt4j.validations;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CustomerTest {

	private Customer customer;

	@Before
	public void setUp() throws Exception {
		this.customer = new Customer("Milton", "O");
	}

	@Test
	public final void testValidate() {
		customer.validate();
		assertTrue(customer.getNotifications().size() == 1);
	}

}
