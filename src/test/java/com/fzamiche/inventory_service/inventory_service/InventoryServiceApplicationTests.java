package com.fzamiche.inventory_service.inventory_service;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class InventoryServiceApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	void sampleTest() {
		assertEquals(2, 1 + 1);
	}

}
