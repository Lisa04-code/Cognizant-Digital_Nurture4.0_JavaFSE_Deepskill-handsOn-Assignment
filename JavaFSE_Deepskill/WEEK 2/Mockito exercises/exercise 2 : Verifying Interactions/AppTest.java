package com.example1.Mockito1;  // Fixed typo in package name (MockItol → Mockito1)

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for simple App
 */
public class AppTest {

    @BeforeAll
    static void initAll() {
        // Initialization code here (runs once before all tests)
    }

    @BeforeEach
    void init() {
        // Setup code here (runs before each test)
    }

    @Test
    @DisplayName("Basic functionality test")
    void testBasicFunctionality() {
        assertTrue(true, "Basic assertion should pass");
    }

    @Test
    @DisplayName("Advanced functionality test")
    void testAdvancedFunctionality() {
        int result = 2 + 2;
        assertEquals(4, result, "2 + 2 should equal 4");
    }

    @AfterEach
    void tearDown() {
        // Cleanup code here (runs after each test)
    }

    @AfterAll
    static void tearDownAll() {
        // Final cleanup code here (runs once after all tests)
    }
}
