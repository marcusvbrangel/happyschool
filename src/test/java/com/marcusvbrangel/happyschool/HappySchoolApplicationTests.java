package com.marcusvbrangel.happyschool;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class HappySchoolApplicationTests {

	@Test
    @DisplayName("verifica se true é igual a true")
	void contextLoads() {
        assertTrue(false);
	}

}
